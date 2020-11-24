package com.chungfung.service;

import com.chungfung.model.UserEnum;
import com.chungfung.model.UserVO;
import com.chungfung.page.PageBean;
import com.chungfung.page.PageParam;

import java.util.List;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/7 10:19
 * @Version 1.0
 */
public interface UserService {

    List<UserVO> getNameUserEnum(UserEnum userEnum);

    PageBean<UserVO> queryNameList(PageParam pageParam);
}
