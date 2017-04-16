package com.marissaman.model;

/**
 * Created by saras on 2017/3/14.
 */
public class User {
    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    private String password;

    private String salt;

    private String headUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }
    public String getHeadUrl() {
        return headUrl;
    }
}