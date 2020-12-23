package com.chungfung.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.chungfung.model.NameVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NameMapper extends BaseMapper<NameVO>{

    List<NameVO> getAllExt(@Param(Constants.WRAPPER) QueryWrapper<NameVO> wrapper);
}