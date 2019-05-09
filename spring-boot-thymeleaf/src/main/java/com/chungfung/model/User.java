package com.chungfung.model;

import lombok.Data;

@Data
public class User {

    private String name;
    private int age;
    private String pass;

    public User() {
    }

    public User(String name, int age, String pass) {
        this.name = name;
        this.age = age;
        this.pass = pass;
    }

}
