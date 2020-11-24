package com.chungfung.service.impl;

import com.chungfung.mapper.UserMapper;
import com.chungfung.model.UserEnum;
import com.chungfung.model.UserVO;
import com.chungfung.page.PageBean;
import com.chungfung.page.PageParam;
import com.chungfung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/7 10:21
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserVO> getNameUserEnum(UserEnum userEnum) {
        return userMapper.selectByCondition(userEnum);
    }

    @Override
    public PageBean<UserVO> queryNameList(PageParam pageParam) {
       return null;
    }
}
