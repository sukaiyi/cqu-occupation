package com.cqu.occupation.crawleraccountconn.repository;

import com.cqu.occupation.crawleraccountconn.entity.CrawlerAccountConn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author sukaiyi
 */
public interface CrawlerAccountConnRepository extends JpaRepository<CrawlerAccountConn, Integer> {

    /**
     * 通过id获取
     *
     * @param id id
     * @return CrawlerAccountConn
     */
    @Override
    @Query("select t from CrawlerAccountConn t where t.id = ?1")
    Optional<CrawlerAccountConn> findById(Integer id);

    /**
     * 通过accountId获取
     *
     * @param id accountId
     * @return CrawlerAccountConn
     */
    @Query("select t from CrawlerAccountConn t where t.accountId = ?1")
    List<CrawlerAccountConn> findByAccountId(Integer id);

    /**
     * 查询全部
     *
     * @return Crawlers
     */
    @Override
    @Query("select t from CrawlerAccountConn t")
    List<CrawlerAccountConn> findAll();

    /**
     * 按ID删除
     * @param ids id
     */
    @Modifying
    @Query("delete from CrawlerAccountConn t where t.id in (?1)")
    void delete(List<Integer> ids);
}
