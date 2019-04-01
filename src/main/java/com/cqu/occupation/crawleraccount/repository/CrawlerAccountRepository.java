package com.cqu.occupation.crawleraccount.repository;

import com.cqu.occupation.crawleraccount.entity.CrawlerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author sukaiyi
 */
public interface CrawlerAccountRepository extends JpaRepository<CrawlerAccount, Integer> {

    /**
     * 通过id获取
     *
     * @param id id
     * @return CrawlerAccountConn
     */
    @Override
    @Query("select t from CrawlerAccount t where t.id = ?1")
    Optional<CrawlerAccount> findById(Integer id);

    /**
     * 查询全部
     *
     * @return Crawlers
     */
    @Override
    @Query("select t from CrawlerAccount t")
    List<CrawlerAccount> findAll();

    /**
     * 按ID删除
     * @param ids id
     */
    @Modifying
    @Query("delete from CrawlerAccount t where t.id in (?1)")
    void delete(List<Integer> ids);
}
