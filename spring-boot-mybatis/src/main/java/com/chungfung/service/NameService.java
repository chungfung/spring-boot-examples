package com.chungfung.service;

import com.chungfung.model.NameVO;
import com.chungfung.page.PageBean;
import com.chungfung.page.PageParam;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/7 10:19
 * @Version 1.0
 */
public interface NameService {

    NameVO getNameById(Long id);

    PageBean<NameVO> queryNameList(PageParam pageParam);
}
