package com.chungfung.enums;

/**
 * @Description
 * @Author chungfung
 * @Date 2019/6/20 13:58
 * @Version 1.0
 */
public enum DataSourceEnum {

    DB1("db1"),DB2("db2");

    private String value;

    DataSourceEnum(String value){this.value=value;}

    public String getValue() {
        return value;
    }
}