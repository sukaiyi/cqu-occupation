package com.cqu.occupation.crawleraccountconn.controller;

import com.cqu.occupation.common.vo.ResultVO;
import com.cqu.occupation.crawleraccountconn.service.CrawlerAccountConnService;
import com.cqu.occupation.crawleraccountconn.vo.CrawlerAccountConnVO;
import com.cqu.occupation.global.annotation.AuthorityRequired;
import com.cqu.occupation.global.constants.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sukaiyi
 */
@RestController
@RequestMapping("/crawlerAccountConn")
public class CrawlerAccountConnController {

    @Autowired
    private CrawlerAccountConnService crawlerAccountConnService;

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "toggle", method = RequestMethod.GET)
    public ResultVO delete(@RequestParam Integer accountId, @RequestParam Integer crawlId) {
        crawlerAccountConnService.toggle(accountId, crawlId);
        return ResultVO.ok("操作成功", null);
    }

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVO add(@RequestBody CrawlerAccountConnVO crawler) {
        return ResultVO.ok("操作成功", crawlerAccountConnService.insert(crawler));
    }

    @AuthorityRequired(allow = {UserType.ADMINISTRATOR, UserType.MANAGER, UserType.COMMONALTY})
    @RequestMapping(value = "all")
    public ResultVO findAll() {
        return ResultVO.ok("查询成功", crawlerAccountConnService.findAll());
    }
}
