package com.cqu.occupation.crawler.controller;

import com.cqu.occupation.common.vo.ResultVO;
import com.cqu.occupation.crawler.service.CrawlerService;
import com.cqu.occupation.crawler.vo.CrawlerVO;
import com.cqu.occupation.global.annotation.AuthorityRequired;
import com.cqu.occupation.global.constants.UserType;
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
@RequestMapping("/crawler")
public class CrawlerController {

    @Autowired
    private CrawlerService crawlerService;

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResultVO delete(@RequestBody List<Integer> ids) {
        crawlerService.delete(ids);
        return ResultVO.ok("操作成功", null);
    }

    @AuthorityRequired(allow = UserType.ADMINISTRATOR)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResultVO add(@RequestBody CrawlerVO crawler) {
        return ResultVO.ok("操作成功", crawlerService.insert(crawler));
    }

    @AuthorityRequired(allow = {UserType.ADMINISTRATOR, UserType.MANAGER, UserType.COMMONALTY})
    @RequestMapping(value = "all")
    public ResultVO findAll() {
        return ResultVO.ok("查询成功", crawlerService.findAll());
    }
}
