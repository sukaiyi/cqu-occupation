package com.cqu.occupation.userinfo.service.impl;

import com.cqu.occupation.common.query.AdvancedQuery;
import com.cqu.occupation.common.utils.EntityVoUtils;
import com.cqu.occupation.common.vo.QueryScheme;
import com.cqu.occupation.eduexp.service.EduExpService;
import com.cqu.occupation.global.exception.exceptions.BusinessException;
import com.cqu.occupation.user.vo.UserVO;
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

import java.util.Arrays;
import java.util.List;
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
}
