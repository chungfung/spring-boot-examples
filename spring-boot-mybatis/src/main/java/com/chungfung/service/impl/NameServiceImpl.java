package com.chungfung.service.impl;

import com.chungfung.mapper.NameVOMapper;
import com.chungfung.model.NameVO;
import com.chungfung.page.PageBean;
import com.chungfung.page.PageParam;
import com.chungfung.service.NameService;
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
public class NameServiceImpl implements NameService{

    @Autowired
    private NameVOMapper nameVOMapper;

    @Override
    public NameVO getNameById(Long id) {
        return nameVOMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageBean<NameVO> queryNameList(PageParam pageParam) {
        pageParam.startPage();
        List<NameVO> nameVOS = nameVOMapper.selectByExample(null);
        return new PageBean<>(nameVOS);
    }
}
