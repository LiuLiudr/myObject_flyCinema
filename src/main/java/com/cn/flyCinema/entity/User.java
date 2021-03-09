package com.cn.flyCinema.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private Integer age;
    private String birthday;
    private String email;
    private String status;
    private String code;
    private String payment;
    private Integer admin;

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public User() {

    }

    public User(Integer uid, String username, String password, Integer age, String birthday, String email, String status, String code, String payment) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
        this.status = status;
        this.code = code;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", payment='" + payment + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
