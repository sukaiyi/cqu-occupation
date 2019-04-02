package com.cqu.occupation.eduexp.service.impl;

import com.cqu.occupation.common.utils.EntityVoUtils;
import com.cqu.occupation.eduexp.entity.EduExp;
import com.cqu.occupation.eduexp.repository.EduExpRepository;
import com.cqu.occupation.eduexp.service.EduExpService;
import com.cqu.occupation.eduexp.vo.EduExpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author sukaiyi
 */
@Service
public class EduExpServiceImpl implements EduExpService {

    private final EduExpRepository repository;

    @Autowired
    public EduExpServiceImpl(EduExpRepository repository) {
        this.repository = repository;
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }

    @Override
    public EduExpVO insert(EduExpVO vo) {
        EduExp entity = EntityVoUtils.convert(vo, EduExp.class);
        EduExp savedEntity = repository.save(entity);
        return EntityVoUtils.convert(savedEntity, EduExpVO.class);
    }

    @Override
    public List<EduExpVO> insert(List<EduExpVO> vos) {
        List<EduExp> entities = EntityVoUtils.convert(vos, EduExp.class);
        List<EduExp> savedEntities = repository.saveAll(entities);
        return EntityVoUtils.convert(savedEntities, EduExpVO.class);
    }

    @Override
    public List<EduExpVO> findByUserInfo(Integer userInfoId) {
        List<EduExp> ens = repository.findByUserInfoId(BigInteger.valueOf(userInfoId.longValue()));
        return EntityVoUtils.convert(ens, EduExpVO.class);
    }
}
