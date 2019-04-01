package com.cqu.occupation.crawler.service;

import com.cqu.occupation.crawler.vo.CrawlerVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author sukaiyi
 */
public interface CrawlerService {

    /**
     * 删除全部
     */
    void clear();

    /**
     * 列表查询全部
     *
     * @return CrawlerVO
     */
    List<CrawlerVO> findAll();

    /**
     * 新增一条
     *
     * @param vo user
     * @return 新增后的user
     */
    CrawlerVO insert(CrawlerVO vo);

    /**
     * 批量的新增
     *
     * @param vos users
     * @return users
     */
    List<CrawlerVO> insert(List<CrawlerVO> vos);

    /**
     * 按照id删除
     * @param ids id
     */
    void delete(List<Integer> ids);
}
