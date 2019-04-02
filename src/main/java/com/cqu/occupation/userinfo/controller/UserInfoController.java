package com.cqu.occupation.userinfo.controller;

import com.cqu.occupation.common.vo.QueryScheme;
import com.cqu.occupation.common.vo.ResultVO;
import com.cqu.occupation.global.annotation.AuthorityRequired;
import com.cqu.occupation.global.constants.UserType;
import com.cqu.occupation.userinfo.service.UserInfoService;
import com.cqu.occupation.userinfo.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sukaiyi
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultVO delete(@RequestBody List<Integer> ids) {
        userInfoService.delete(ids);
        return ResultVO.ok("操作成功", null);
    }

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVO add(@RequestBody UserInfoVO crawler) {
        return ResultVO.ok("操作成功", userInfoService.insert(crawler));
    }

    @AuthorityRequired(allow = {UserType.ADMINISTRATOR, UserType.MANAGER, UserType.COMMONALTY})
    @RequestMapping(value = "all", method = RequestMethod.POST)
    public ResultVO findAll(@RequestBody QueryScheme queryScheme) {
        return ResultVO.ok("查询成功", userInfoService.findAll(queryScheme));
    }

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public ResultVO detail(@RequestParam Integer id) {
        return ResultVO.ok("操作成功",  userInfoService.detail(id));
    }
}
