package com.zhangyiming.pojo;

import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    private Integer id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String userid;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return username - 姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置姓名
     *
     * @param username 姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户名
     *
     * @return userid - 用户名
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户名
     *
     * @param userid 用户名
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public User(String username, String password, String userid) {
        this.username = username;
        this.password = password;
        this.userid = userid;
    }

    public User(Integer id, String username, String password, String userid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userid = userid;
    }

    public User() {
    }
}