package com.cqu.occupation.workexp.service.impl;

import com.cqu.occupation.common.utils.EntityVoUtils;
import com.cqu.occupation.workexp.entity.WorkExp;
import com.cqu.occupation.workexp.repository.WorkExpRepository;
import com.cqu.occupation.workexp.service.WorkExpService;
import com.cqu.occupation.workexp.vo.WorkExpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

/**
 * @author sukaiyi
 */
@Service
public class WorkExpServiceImpl implements WorkExpService {

    private final WorkExpRepository repository;

    @Autowired
    public WorkExpServiceImpl(WorkExpRepository repository) {
        this.repository = repository;
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }

    @Override
    public WorkExpVO insert(WorkExpVO vo) {
        WorkExp entity = EntityVoUtils.convert(vo, WorkExp.class);
        WorkExp savedEntity = repository.save(entity);
        return EntityVoUtils.convert(savedEntity, WorkExpVO.class);
    }

    @Override
    public List<WorkExpVO> insert(List<WorkExpVO> vos) {
        List<WorkExp> entities = EntityVoUtils.convert(vos, WorkExp.class);
        List<WorkExp> savedEntities = repository.saveAll(entities);
        return EntityVoUtils.convert(savedEntities, WorkExpVO.class);
    }

    @Override
    public List<WorkExpVO> findByUserInfo(Integer userInfoId) {
        List<WorkExp> ens = repository.findByUserInfoId(BigInteger.valueOf(userInfoId.longValue()));
        return EntityVoUtils.convert(ens, WorkExpVO.class);
    }
}
