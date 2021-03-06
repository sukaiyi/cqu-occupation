package com.cqu.occupation.user.controller;

import com.cqu.occupation.common.vo.QueryScheme;
import com.cqu.occupation.common.vo.ResultVO;
import com.cqu.occupation.global.constants.UserType;
import com.cqu.occupation.user.service.UserService;
import com.cqu.occupation.user.vo.UserVO;
import com.cqu.occupation.global.annotation.AuthorityRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
    public ResultVO add(@RequestBody UserVO user) {
        return ResultVO.ok("操作成功", userService.insert(user));
    }

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ResultVO update(@RequestBody UserVO user) {
        return ResultVO.ok("操作成功", userService.update(user));
    }

    @AuthorityRequired(allow = {UserType.ADMINISTRATOR, UserType.MANAGER, UserType.COMMONALTY})
    @RequestMapping(value = "all")
    public ResultVO findAll(@RequestBody QueryScheme queryScheme) {
        return ResultVO.ok("查询成功", userService.findAll(queryScheme));
    }

    @AuthorityRequired(allow = {UserType.TOURIST})
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResultVO login(@RequestBody UserVO user) {
        return ResultVO.ok("操作成功", userService.login(user));
    }

    @AuthorityRequired(allow = {UserType.ADMINISTRATOR, UserType.MANAGER, UserType.COMMONALTY})
    @RequestMapping(value = "currentUser", method = RequestMethod.GET)
    public ResultVO login(@RequestHeader("token") String token) {
        return ResultVO.ok("操作成功", userService.currentUser(token));
    }

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultVO delete(@RequestBody List<Integer> ids) {
        userService.delete(ids);
        return ResultVO.ok("操作成功", null);
    }



}
