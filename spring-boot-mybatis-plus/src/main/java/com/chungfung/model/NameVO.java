package com.chungfung.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_teacher")
public class NameVO extends Model<NameVO> implements Serializable{

    private Long id;

    private String name;
}