package com.cqu.occupation.crawleraccountconn.service.impl;

import com.cqu.occupation.common.utils.EntityVoUtils;
import com.cqu.occupation.crawler.service.CrawlerService;
import com.cqu.occupation.crawler.vo.CrawlerVO;
import com.cqu.occupation.crawleraccount.service.CrawlerAccountService;
import com.cqu.occupation.crawleraccount.vo.CrawlerAccountVO;
import com.cqu.occupation.crawleraccountconn.entity.CrawlerAccountConn;
import com.cqu.occupation.crawleraccountconn.repository.CrawlerAccountConnRepository;
import com.cqu.occupation.crawleraccountconn.service.CrawlerAccountConnService;
import com.cqu.occupation.crawleraccountconn.vo.CrawlerAccountConnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sukaiyi
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CrawlerAccountConnServiceImpl implements CrawlerAccountConnService {

    private final CrawlerAccountConnRepository repository;
    @Autowired
    private CrawlerService crawlerService;
    @Autowired
    private CrawlerAccountService crawlerAccountService;

    @Autowired
    public CrawlerAccountConnServiceImpl(CrawlerAccountConnRepository repository) {
        this.repository = repository;
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }

    @Override
    public Map<String, Object> findAll() {
        List<CrawlerAccountConn> entities = repository.findAll();
        List<CrawlerAccountConnVO> conns = EntityVoUtils.convert(entities, CrawlerAccountConnVO.class);
        List<CrawlerVO> crawlers = crawlerService.findAll();
        List<CrawlerAccountVO> crawlerAccounts = crawlerAccountService.findAll();
        return new HashMap<String, Object>(3) {{
            put("crawlers", crawlers);
            put("crawlerAccounts", crawlerAccounts);
            put("conns", conns);
        }};
    }

    @Override
    public CrawlerAccountConnVO insert(CrawlerAccountConnVO vo) {
        CrawlerAccountConn entity = EntityVoUtils.convert(vo, CrawlerAccountConn.class);
        CrawlerAccountConn savedEntity = repository.save(entity);
        return EntityVoUtils.convert(savedEntity, CrawlerAccountConnVO.class);
    }

    @Override
    public List<CrawlerAccountConnVO> insert(List<CrawlerAccountConnVO> vos) {
        List<CrawlerAccountConn> entities = EntityVoUtils.convert(vos, CrawlerAccountConn.class);
        List<CrawlerAccountConn> savedEntities = repository.saveAll(entities);
        return EntityVoUtils.convert(savedEntities, CrawlerAccountConnVO.class);
    }

    @Override
    public void delete(List<Integer> ids) {
        repository.delete(ids);
    }

    @Override
    public void toggle(Integer accountId, Integer crawlId) {
        List<CrawlerAccountConn> conns = repository.findByAccountId(accountId);
        List<Integer> toDelete = conns.stream()
                .filter(e -> e.getCrawlerId().equals(crawlId))
                .map(CrawlerAccountConn::getId)
                .collect(Collectors.toList());
        if (toDelete.size() > 0) {
            repository.delete(toDelete);
        } else {
            CrawlerAccountConn conn = new CrawlerAccountConn();
            conn.setAccountId(accountId);
            conn.setCrawlerId(crawlId);
            repository.save(conn);
        }
    }
}
