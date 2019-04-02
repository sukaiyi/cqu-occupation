package com.cqu.occupation.userinfo.repository;

import com.cqu.occupation.userinfo.entity.UserInfo;
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
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    /**
     * 通过id获取
     *
     * @param id id
     * @return UserInfo
     */
    @Override
    @Query("select t from UserInfo t where t.id = ?1")
    Optional<UserInfo> findById(Integer id);

    /**
     * 查询全部
     *
     * @param pageable 分页信息
     * @return UserInfo
     */
    @Override
    @Query("select t from UserInfo t")
    Page<UserInfo> findAll(Pageable pageable);

    /**
     * 按ID删除
     * @param ids id
     */
    @Modifying
    @Query("delete from UserInfo t where t.id in (?1)")
    void delete(List<Integer> ids);
}
