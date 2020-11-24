package com.chungfung.controller;

import com.chungfung.model.UserEnum;
import com.chungfung.model.UserVO;
import com.chungfung.page.PageBean;
import com.chungfung.page.PageParam;
import com.chungfung.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getName")
    @ResponseBody
    public List<UserVO> getName() {
        return userService.getNameUserEnum(UserEnum.Man);
    }

    @RequestMapping("/getNameList")
    @ResponseBody
    public PageBean<UserVO> getNameList(PageParam pageParam) {
        PageBean<UserVO> pageBean = userService.queryNameList(pageParam);
        return pageBean;
    }
}
