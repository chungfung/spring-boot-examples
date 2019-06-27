package com.chungfung.service.impl;

import com.chungfung.model.User;
import com.chungfung.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/9 10:04
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUserList() {
        List<User> list=new ArrayList<User>();
        User user1=new User("法拉利",12,"123456");
        User user2=new User("兰博基尼",6,"123563");
        User user3=new User("迈凯伦",66,"666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return  list;
    }
}
