package com.chungfung.controller;

import com.chungfung.model.NameVO;
import com.chungfung.page.PageBean;
import com.chungfung.page.PageParam;
import com.chungfung.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/7 10:22
 * @Version 1.0
 */
@Controller
@RequestMapping("name")
public class NameController {

    @Autowired
    private NameService nameService;

    @RequestMapping("/getName")
    @ResponseBody
    public NameVO getName(@RequestParam("id") Long id) {
        return nameService.getNameById(id);
    }

    @RequestMapping("/getNameList")
    @ResponseBody
    public PageBean<NameVO> getNameList(PageParam pageParam) {
        PageBean<NameVO> pageBean = nameService.queryNameList(pageParam);
        return pageBean;
    }
}
