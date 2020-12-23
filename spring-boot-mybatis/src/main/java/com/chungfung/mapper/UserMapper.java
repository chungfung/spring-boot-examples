package com.chungfung.mapper;

import com.chungfung.annotation.UserAccess;
import com.chungfung.model.UserEnum;
import com.chungfung.model.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<UserVO> selectByCondition(@Param("userEnum") UserEnum userEnum,
                                   @Param("extParam") Map<String,Object> param);
}