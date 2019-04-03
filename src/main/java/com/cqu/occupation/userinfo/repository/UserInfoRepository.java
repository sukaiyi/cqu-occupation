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
     * 统计行业
     * @return 行业
     */
    @Query("select t.field,count(t) as num from UserInfo t group by t.field order by num desc")
    List<Object> statisticsField();

    /**
     * 统计职业
     * @return 职业
     */
    @Query("select t.profession,count(t) as num from UserInfo t group by t.profession order by num desc")
    List<Object> statisticsProfession();

    /**
     * 统计性别
     * @return 性别
     */
    @Query("select t.gender, count(t) as num from UserInfo t group by t.gender order by num desc")
    List<Object> statisticsGender();

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
