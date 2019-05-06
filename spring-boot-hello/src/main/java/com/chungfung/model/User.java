package com.chungfung.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Author 丰涌
 * @Date 2019/5/6 14:33
 * @Version 1.0
 */
@Data
public class User {

    private String name;

    private int age;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    private String address;
}
