package com.cqu.occupation.user.controller;

import com.cqu.occupation.common.vo.ResultVO;
import com.cqu.occupation.global.constants.UserType;
import com.cqu.occupation.user.service.UserService;
import com.cqu.occupation.user.vo.UserVO;
import com.cqu.occupation.global.annotation.AuthorityRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sukaiyi
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "clear", method = RequestMethod.POST)
    public ResultVO clear() {
        userService.clear();
        return ResultVO.ok("操作成功", null);
    }

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVO add(@RequestBody List<UserVO> factories) {
        return ResultVO.ok("操作成功", userService.insert(factories));
    }

    @AuthorityRequired(allow = {UserType.ADMINISTRATOR, UserType.MANAGER, UserType.COMMONALTY})
    @RequestMapping(value = "all")
    public ResultVO findAll(@PageableDefault() Pageable pageable) {
        return ResultVO.ok("查询成功", userService.findAll(pageable));
    }

    @AuthorityRequired(allow = {UserType.TOURIST})
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultVO login(@RequestBody UserVO user) {
        return ResultVO.ok("操作成功", userService.login(user));
    }

}
