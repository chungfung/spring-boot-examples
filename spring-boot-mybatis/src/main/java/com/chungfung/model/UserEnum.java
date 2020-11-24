package com.chungfung.model;/**
 * Created by chungfung on 2020/11/11.
 */

/**
 * @author 丰涌
 * @ClassName UserEnum
 * @Description TODO
 * @Date 2020/11/11 10:12
 * @Version 1.0
 **/
public enum UserEnum {

    Man(1,"男"),

    Women(2,"女");

    private Integer code;

    private String desc;

    UserEnum(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }
}
