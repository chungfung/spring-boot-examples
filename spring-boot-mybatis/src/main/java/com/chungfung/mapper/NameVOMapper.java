package com.chungfung.mapper;

import com.chungfung.model.NameVO;
import com.chungfung.model.NameVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NameVOMapper {
    int countByExample(NameVOExample example);

    int deleteByExample(NameVOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NameVO record);

    int insertSelective(NameVO record);

    List<NameVO> selectByExample(NameVOExample example);

    NameVO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NameVO record, @Param("example") NameVOExample example);

    int updateByExample(@Param("record") NameVO record, @Param("example") NameVOExample example);

    int updateByPrimaryKeySelective(NameVO record);

    int updateByPrimaryKey(NameVO record);
}