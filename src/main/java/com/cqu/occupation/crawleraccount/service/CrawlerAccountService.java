package com.cqu.occupation.crawleraccount.service;

import com.cqu.occupation.crawleraccount.vo.CrawlerAccountVO;

import java.util.List;

/**
 * @author sukaiyi
 */
public interface CrawlerAccountService {

    /**
     * 删除全部
     */
    void clear();

    /**
     * 列表查询全部
     *
     * @return CrawlerAccountVO
     */
    List<CrawlerAccountVO> findAll();

    /**
     * 新增一条
     *
     * @param vo user
     * @return 新增后的user
     */
    CrawlerAccountVO insert(CrawlerAccountVO vo);

    /**
     * 批量的新增
     *
     * @param vos users
     * @return users
     */
    List<CrawlerAccountVO> insert(List<CrawlerAccountVO> vos);

    /**
     * 按照id删除
     * @param ids id
     */
    void delete(List<Integer> ids);
}
