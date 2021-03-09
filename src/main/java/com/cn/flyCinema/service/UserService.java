package com.cn.flyCinema.service;

import com.cn.flyCinema.entity.User;

public interface UserService {
    User findUser(String username, String password);

    boolean reg(User user);

    boolean findUserByUname(String username);

    void update(User user);

    boolean active(String code);

    boolean update(int uid,int age,String email,String birthday);

    void changePwdById(String uid, String password,String payment);

}
