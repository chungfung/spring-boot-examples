package com.chungfung.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chungfung.mapper.NameMapper;
import com.chungfung.model.NameVO;
import com.chungfung.service.NameService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/5/7 10:21
 * @Version 1.0
 */
@Service
public class NameServiceImpl extends ServiceImpl<NameMapper, NameVO> implements NameService{

}
