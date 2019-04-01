package com.cqu.occupation.crawleraccountconn.service;

import com.cqu.occupation.crawleraccountconn.vo.CrawlerAccountConnVO;

import java.util.List;
import java.util.Map;

/**
 * @author sukaiyi
 */
public interface CrawlerAccountConnService {

    /**
     * 删除全部
     */
    void clear();

    /**
     * 列表查询全部
     *
     * @return CrawlerAccountConnVO
     */
    Map<String, Object> findAll();

    /**
     * 新增一条
     *
     * @param vo user
     * @return 新增后的user
     */
    CrawlerAccountConnVO insert(CrawlerAccountConnVO vo);

    /**
     * 批量的新增
     *
     * @param vos users
     * @return users
     */
    List<CrawlerAccountConnVO> insert(List<CrawlerAccountConnVO> vos);

    /**
     * 按照id删除
     * @param ids id
     */
    void delete(List<Integer> ids);

    /**
     * 关联/取消关联
     * @param accountId 账号ID
     * @param crawlId 爬虫ID
     */
    void toggle(Integer accountId, Integer crawlId);
}
