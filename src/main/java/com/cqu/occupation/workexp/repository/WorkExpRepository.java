package com.cqu.occupation.workexp.repository;

import com.cqu.occupation.workexp.entity.WorkExp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * @author sukaiyi
 */
public interface WorkExpRepository extends JpaRepository<WorkExp, Integer> {

    /**
     * 通过id获取
     *
     * @param id id
     * @return WorkExp
     */
    @Override
    @Query("select t from WorkExp t where t.no = ?1")
    Optional<WorkExp> findById(Integer id);

    /**
     * 通过用户名ID
     *
     * @param userInfoId 用户名
     * @return user
     */
    @Query("select t from WorkExp t where t.userInfoId = ?1")
    List<WorkExp> findByUserInfoId(BigInteger userInfoId);

    /**
     * 通过ID删除
     *
     * @param ids id
     * @return 删除个数
     */
    @Modifying
    @Query("delete from WorkExp t where t.id in (?1)")
    int deleteByIds(List<Integer> ids);

}
