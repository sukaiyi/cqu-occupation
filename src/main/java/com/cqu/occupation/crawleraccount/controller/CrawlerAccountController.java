package com.cqu.occupation.crawleraccount.controller;

import com.cqu.occupation.common.vo.ResultVO;
import com.cqu.occupation.crawleraccount.service.CrawlerAccountService;
import com.cqu.occupation.crawleraccount.vo.CrawlerAccountVO;
import com.cqu.occupation.global.annotation.AuthorityRequired;
import com.cqu.occupation.global.constants.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sukaiyi
 */
@RestController
@RequestMapping("/crawlerAccount")
public class CrawlerAccountController {

    @Autowired
    private CrawlerAccountService crawlerAccountService;

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultVO delete(@RequestBody List<Integer> ids) {
        crawlerAccountService.delete(ids);
        return ResultVO.ok("操作成功", null);
    }

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVO add(@RequestBody CrawlerAccountVO crawler) {
        return ResultVO.ok("操作成功", crawlerAccountService.insert(crawler));
    }

    @AuthorityRequired(allow = {UserType.ADMINISTRATOR, UserType.MANAGER, UserType.COMMONALTY})
    @RequestMapping(value = "all")
    public ResultVO findAll() {
        return ResultVO.ok("查询成功", crawlerAccountService.findAll());
    }
}
