package com.cqu.occupation.userinfo.service;

import com.cqu.occupation.common.vo.QueryScheme;
import com.cqu.occupation.user.vo.UserVO;
import com.cqu.occupation.userinfo.vo.UserInfoVO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @author sukaiyi
 */
public interface UserInfoService {

    /**
     * 删除全部
     */
    void clear();

    /**
     * 列表查询全部
     *
     * @return CrawlerAccountConnVO
     * @param queryScheme
     */
    Page<UserInfoVO> findAll(QueryScheme queryScheme);

    /**
     * 新增一条
     *
     * @param vo user
     * @return 新增后的user
     */
    UserInfoVO insert(UserInfoVO vo);

    /**
     * 批量的新增
     *
     * @param vos users
     * @return users
     */
    List<UserInfoVO> insert(List<UserInfoVO> vos);

    /**
     * 按照id删除
     * @param ids id
     */
    void delete(List<Integer> ids);

    /**
     * 查询详情
     * @param id id
     * @return UserInfoVO
     */
    UserInfoVO detail(Integer id);

    /**
     * 更新
     * @param vo userInfo
     * @return userInfo
     */
    UserInfoVO update(UserInfoVO vo);

    /**
     * 查询学历分布
     * @param id 用户ID
     * @return 学历分布
     */
    Map<String,Object> statistics(Integer id);
}
