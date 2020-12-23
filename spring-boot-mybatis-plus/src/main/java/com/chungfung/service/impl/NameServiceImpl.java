package com.chungfung.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chungfung.mapper.NameMapper;
import com.chungfung.model.NameVO;
import com.chungfung.service.NameService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/7 10:21
 * @Version 1.0
 */
@Service
public class NameServiceImpl extends ServiceImpl<NameMapper, NameVO> implements NameService{

    @Override
    public List<NameVO> getAllExt() {
        QueryWrapper<NameVO> queryWrapper = new QueryWrapper<>(new NameVO());
        queryWrapper.eq("name","李四");
        queryWrapper.eq("age",12);
        System.out.println("custSQL:" + queryWrapper.getCustomSqlSegment().toString());
        return this.baseMapper.getAllExt(queryWrapper);
    }
}
