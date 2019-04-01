package com.cqu.occupation.user.repository;

import com.cqu.occupation.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author sukaiyi
 */
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * 通过id获取
     *
     * @param id id
     * @return CrawlerAccount
     */
    @Override
    @Query("select t from User t where t.id = ?1")
    Optional<User> findById(String id);

    /**
     * 通过用户名查找
     *
     * @param username 用户名
     * @return user
     */
    @Query("select t from User t where t.username = ?1")
    Optional<User> findByUsername(String username);


    /**
     * 查询全部
     *
     * @param pageable 分页信息
     * @return users
     */
    @Override
    @Query("select t from User t")
    Page<User> findAll(Pageable pageable);

    /**
     * 通过ID删除
     *
     * @param ids id
     * @return 删除个数
     */
    @Modifying
    @Query("delete from User t where t.id in (?1)")
    int deleteByIds(List<String> ids);

}
