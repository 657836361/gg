package com.example.demo.model;


import java.io.Serializable;

public class User implements Serializable {


    private static final long serialVersionUID = -1212779626642467180L;
    private String name;
    private String id;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

