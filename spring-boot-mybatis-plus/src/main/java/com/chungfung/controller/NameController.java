package com.chungfung.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chungfung.model.NameVO;
import com.chungfung.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author chungfung
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
        return nameService.getById(id);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<NameVO> getAll() {
        return nameService.getAllExt();
    }

    @RequestMapping("/getNameList")
    @ResponseBody
    public IPage<NameVO> getNameList(Page<NameVO> page) {
        IPage<NameVO> p = nameService.page(page);
        return p;
    }

    @RequestMapping("/getName2")
    @ResponseBody
    public NameVO getName2() {
        return new NameVO().selectOne(null);
    }
}
