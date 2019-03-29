package com.cqu.occupation.crawler.repository;

import com.cqu.occupation.crawler.entity.Crawler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author sukaiyi
 */
public interface CrawlerRepository extends JpaRepository<Crawler, String> {

    /**
     * 通过id获取
     *
     * @param id id
     * @return Crawler
     */
    @Override
    @Query("select t from Crawler t where t.crawlId = ?1")
    Optional<Crawler> findById(String id);

    /**
     * 查询全部
     *
     * @param pageable 分页信息
     * @return Crawlers
     */
    @Override
    @Query("select t from Crawler t")
    List<Crawler> findAll();
}
