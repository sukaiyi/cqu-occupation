package com.cqu.occupation.crawler.service.impl;

import com.cqu.occupation.common.utils.EntityVoUtils;
import com.cqu.occupation.crawler.entity.Crawler;
import com.cqu.occupation.crawler.repository.CrawlerRepository;
import com.cqu.occupation.crawler.service.CrawlerService;
import com.cqu.occupation.crawler.vo.CrawlerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sukaiyi
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CrawlerServiceImpl implements CrawlerService {

    private final CrawlerRepository repository;

    @Autowired
    public CrawlerServiceImpl(CrawlerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }

    @Override
    public List<CrawlerVO> findAll() {
        List<Crawler> entities = repository.findAll();
        return EntityVoUtils.convert(entities, CrawlerVO.class);
    }

    @Override
    public CrawlerVO insert(CrawlerVO vo) {
        Crawler entity = EntityVoUtils.convert(vo, Crawler.class);
        Crawler savedEntity = repository.save(entity);
        return EntityVoUtils.convert(savedEntity, CrawlerVO.class);
    }

    @Override
    public List<CrawlerVO> insert(List<CrawlerVO> vos) {
        List<Crawler> entities = EntityVoUtils.convert(vos, Crawler.class);
        List<Crawler> savedEntities = repository.saveAll(entities);
        return EntityVoUtils.convert(savedEntities, CrawlerVO.class);
    }

    @Override
    public void delete(List<Integer> ids) {
        repository.delete(ids);
    }
}
