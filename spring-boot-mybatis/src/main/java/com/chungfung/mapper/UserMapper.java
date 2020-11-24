package com.chungfung.mapper;

import com.chungfung.model.UserEnum;
import com.chungfung.model.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<UserVO> selectByCondition(@Param("userEnum") UserEnum userEnum);
}