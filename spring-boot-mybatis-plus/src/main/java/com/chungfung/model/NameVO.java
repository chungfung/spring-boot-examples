package com.chungfung.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_teacher")
public class NameVO {

    private Long id;

    private String name;
}