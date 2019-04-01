package com.cqu.occupation.crawleraccount.service.impl;

import com.cqu.occupation.common.utils.EntityVoUtils;
import com.cqu.occupation.crawleraccount.entity.CrawlerAccount;
import com.cqu.occupation.crawleraccount.repository.CrawlerAccountRepository;
import com.cqu.occupation.crawleraccount.service.CrawlerAccountService;
import com.cqu.occupation.crawleraccount.vo.CrawlerAccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sukaiyi
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CrawlerAccountServiceImpl implements CrawlerAccountService {

    private final CrawlerAccountRepository repository;

    @Autowired
    public CrawlerAccountServiceImpl(CrawlerAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }

    @Override
    public List<CrawlerAccountVO> findAll() {
        List<CrawlerAccount> entities = repository.findAll();
        return EntityVoUtils.convert(entities, CrawlerAccountVO.class);
    }

    @Override
    public CrawlerAccountVO insert(CrawlerAccountVO vo) {
        CrawlerAccount entity = EntityVoUtils.convert(vo, CrawlerAccount.class);
        CrawlerAccount savedEntity = repository.save(entity);
        return EntityVoUtils.convert(savedEntity, CrawlerAccountVO.class);
    }

    @Override
    public List<CrawlerAccountVO> insert(List<CrawlerAccountVO> vos) {
        List<CrawlerAccount> entities = EntityVoUtils.convert(vos, CrawlerAccount.class);
        List<CrawlerAccount> savedEntities = repository.saveAll(entities);
        return EntityVoUtils.convert(savedEntities, CrawlerAccountVO.class);
    }

    @Override
    public void delete(List<Integer> ids) {
        repository.delete(ids);
    }
}
