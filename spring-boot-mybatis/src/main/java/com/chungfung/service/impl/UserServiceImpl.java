package com.chungfung.service.impl;

import com.chungfung.annotation.UserAccess;
import com.chungfung.mapper.UserMapper;
import com.chungfung.model.UserEnum;
import com.chungfung.model.UserVO;
import com.chungfung.page.PageBean;
import com.chungfung.page.PageParam;
import com.chungfung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    @UserAccess
    public List<UserVO> getNameUserEnum(UserEnum userEnum,
                                        Map<String,Object> param) {
        return userMapper.selectByCondition(userEnum,param);
    }

    @Override
    public PageBean<UserVO> queryNameList(PageParam pageParam) {
       return null;
    }
}
