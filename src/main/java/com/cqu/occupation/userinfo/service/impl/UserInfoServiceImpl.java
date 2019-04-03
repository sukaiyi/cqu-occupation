package com.cqu.occupation.userinfo.service.impl;

import cn.hutool.core.convert.Convert;
import com.cqu.occupation.common.query.AdvancedQuery;
import com.cqu.occupation.common.utils.EntityVoUtils;
import com.cqu.occupation.common.vo.QueryScheme;
import com.cqu.occupation.eduexp.entity.EduExp;
import com.cqu.occupation.eduexp.service.EduExpService;
import com.cqu.occupation.global.exception.exceptions.BusinessException;
import com.cqu.occupation.userinfo.entity.UserInfo;
import com.cqu.occupation.userinfo.repository.UserInfoRepository;
import com.cqu.occupation.userinfo.service.UserInfoService;
import com.cqu.occupation.userinfo.vo.UserInfoVO;
import com.cqu.occupation.workexp.service.WorkExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sukaiyi
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository repository;
    @Autowired
    private AdvancedQuery<UserInfo> query;
    @Autowired
    private WorkExpService workExpService;
    @Autowired
    private EduExpService eduExpService;

    @Autowired
    public UserInfoServiceImpl(UserInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }

    @Override
    public Page<UserInfoVO> findAll(QueryScheme queryScheme) {
        Page<UserInfo> page = query.query(UserInfo.class, repository, queryScheme);
        List<UserInfo> entities = page.getContent();
        List<UserInfoVO> vos = EntityVoUtils.convert(entities, UserInfoVO.class);
        Pageable pageable = PageRequest.of(queryScheme.getPageNum(), queryScheme.getPageSize());
        return new PageImpl<>(vos, pageable, page.getTotalElements());
    }

    @Override
    public UserInfoVO insert(UserInfoVO vo) {
        UserInfo entity = EntityVoUtils.convert(vo, UserInfo.class);
        UserInfo savedEntity = repository.save(entity);
        return EntityVoUtils.convert(savedEntity, UserInfoVO.class);
    }

    @Override
    public List<UserInfoVO> insert(List<UserInfoVO> vos) {
        List<UserInfo> entities = EntityVoUtils.convert(vos, UserInfo.class);
        List<UserInfo> savedEntities = repository.saveAll(entities);
        return EntityVoUtils.convert(savedEntities, UserInfoVO.class);
    }

    @Override
    public void delete(List<Integer> ids) {
        repository.delete(ids);
    }

    @Override
    public UserInfoVO detail(Integer id) {
        UserInfo info = repository.findById(id).orElse(null);
        if (info == null) {
            throw new BusinessException("信息不存在");
        }
        UserInfoVO vo = EntityVoUtils.convert(info, UserInfoVO.class);
        String impTags = vo.getImpTags();
        vo.setImpTagList(Arrays.stream(impTags.split(";")).collect(Collectors.toList()));
        String proTags = vo.getProTags();
        vo.setProTagList(Arrays.stream(proTags.split(";"))
                .map(e -> e.split(" "))
                .filter(e -> e.length == 2)
                .map(e -> e[0])
                .collect(Collectors.toList()));
        vo.setEduExp(eduExpService.findByUserInfo(vo.getId()));
        vo.setWorkExp(workExpService.findByUserInfo(vo.getId()));
        return vo;
    }

    @Override
    public UserInfoVO update(UserInfoVO vo) {
        UserInfo userInfo = EntityVoUtils.convert(vo, UserInfo.class);
        UserInfo info = repository.findById(userInfo.getId()).orElse(null);
        if (info == null) {
            throw new BusinessException("信息不存在");
        }
        UserInfo retInfo = repository.save(userInfo);
        return detail(retInfo.getId());
    }

    private List<Object[]> statisticsField() {
        List<Object> objs = repository.statisticsField();
        return objs.stream()
                .map(e -> (Object[]) e)
                .collect(Collectors.toList());
    }

    private List<Object[]> statisticsProfession() {
        List<Object> objs = repository.statisticsProfession();
        return objs.stream()
                .map(e -> (Object[]) e)
                .collect(Collectors.toList());
    }

    private List<Object[]> statisticsGender() {
        List<Object> objs = repository.statisticsGender();
        return objs.stream()
                .map(e -> (Object[]) e)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Object> statistics(Integer id) {
        List<EduExp> eduExps = eduExpService.findHighestDegree();
        List<Object[]> fieldStatistics = this.statisticsField();
        List<Object[]> professionStatistics = this.statisticsProfession();
        List<Object[]> genderStatistics = this.statisticsGender();
        return new HashMap<String, Object>(3) {{
            put("eduDistribution", calcEduDistribution(eduExps));
            put("fieldDistribution", calcFieldDistribution(fieldStatistics));
            put("professionDistribution", calcProfessionDistribution(professionStatistics));
            put("genderDistribution", calcGenderDistribution(genderStatistics));
            if (id != null) {
                put("thisDegree", eduExps.stream()
                        .filter(e -> e.getUserInfoId().intValue() == id)
                        .map(EduExp::getDegree)
                        .findFirst()
                        .orElse(null)
                );
            }
        }};
    }

    private  Map<String, Integer> calcProfessionDistribution(List<Object[]> professionStatistics) {
        Map<String, Integer> ret = new LinkedHashMap<>(9);
        Integer other = 0;
        for (int i = 0; i < professionStatistics.size(); i++) {
            Object[] objs = professionStatistics.get(i);
            if (i < 8) {
                ret.put(Convert.toStr(objs[0]), Convert.convert(Integer.class, objs[1]));
            } else {
                other += Convert.convert(Integer.class, objs[1]);
            }
        }
        ret.put("其他", other);
        return ret;
    }

    private Map<Integer, Integer> calcGenderDistribution(List<Object[]> genderStatistics) {
        Map<Integer, Integer> ret = new LinkedHashMap<>(6);
        for (Object[] objs : genderStatistics) {
            ret.put(Convert.convert(Integer.class, objs[0]), Convert.convert(Integer.class, objs[1]));
        }
        return ret;
    }

    private Map<Integer, Integer> calcEduDistribution(List<EduExp> eduExps) {
        Map<Integer, List<EduExp>> group = eduExps.stream().collect(Collectors.groupingBy(EduExp::getDegree));
        Map<Integer, Integer> eduDistribution = new HashMap<>(group.size());
        for (Integer key : group.keySet()) {
            eduDistribution.put(key, group.get(key).size());
        }
        return eduDistribution;
    }

    private Map<String, Integer> calcFieldDistribution(List<Object[]> fieldStatistics) {
        Map<String, Integer> ret = new LinkedHashMap<>(6);
        Integer other = 0;
        for (int i = 0; i < fieldStatistics.size(); i++) {
            Object[] objs = fieldStatistics.get(i);
            if (i < 5) {
                ret.put(Convert.toStr(objs[0]), Convert.convert(Integer.class, objs[1]));
            } else {
                other += Convert.convert(Integer.class, objs[1]);
            }
        }
        ret.put("其他", other);
        return ret;
    }
}
