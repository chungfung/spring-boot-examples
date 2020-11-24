package com.chungfung.model;

import lombok.Data;

@Data
public class UserVO {

    private Long id;

    private String name;

    private Integer sex;

    public UserVO() {
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}