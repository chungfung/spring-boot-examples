package com.chungfung.controller;

import com.chungfung.model.Tree;
import com.chungfung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/9 10:03
 * @Version 1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/string")
    public String string(ModelMap map) {
        map.addAttribute("userName", "chungfung");
        return "string";
    }

    @RequestMapping("/if")
    public String ifunless(ModelMap map) {
        map.addAttribute("flag", "yes");
        map.addAttribute("number",2);
        map.addAttribute("label",true);
        return "if";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("users", userService.getUserList());
        return "list";
    }

    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "springcloud/2017/09/11/");
        map.addAttribute("img", "http://www.ityouknow.com/assets/images/neo.jpg");
        return "url";
    }

    @RequestMapping("/eq")
    public String eq(ModelMap map) {
        map.addAttribute("name", "neo");
        map.addAttribute("age", 30);
        map.addAttribute("flag", "yes");
        return "eq";
    }

    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("sex", "woman");
        return "switch";
    }

    @RequestMapping("/table")
    public String table(ModelMap map) {
        Tree root = new Tree();
        root.setId("1");
        root.setName("跟目录");
        root.setPid("0");

        Tree level1 = new Tree();
        level1.setId("2");
        level1.setName("子目录1");
        level1.setPid("1");

        Tree level2 = new Tree();
        level2.setId("3");
        level2.setName("子目录2");
        level2.setPid("1");

        Tree level11 = new Tree();
        level11.setId("4");
        level11.setName("层级三1");
        level11.setPid("2");

        Tree level12 = new Tree();
        level12.setId("5");
        level12.setName("层级三2");
        level12.setPid("2");

        List<Tree> list = new ArrayList<>();
        list.add(root);
        list.add(level1);
        list.add(level2);
        list.add(level11);
        list.add(level12);

        map.put("list",list);

        return "table";
    }
}
