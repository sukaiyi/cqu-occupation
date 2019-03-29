package com.cqu.occupation.user.service;

import com.cqu.occupation.user.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author sukaiyi
 */
public interface UserService {

    /**
     * 删除全部
     */
    void clear();

    /**
     * 列表查询全部
     *
     * @param pageable 分页参数
     * @return UserVOs
     */
    Page<UserVO> findAll(Pageable pageable);

    /**
     * 新增一条
     *
     * @param vo user
     * @return 新增后的user
     */
    UserVO insert(UserVO vo);

    /**
     * 批量的新增
     *
     * @param vos users
     * @return users
     */
    List<UserVO> insert(List<UserVO> vos);

    /**
     * 登陆验证，并返回token
     *
     * @param user 登陆的信息（用户名、密码）
     * @return 带有token的信息
     */
    Map<String, Object> login(UserVO user);
}
