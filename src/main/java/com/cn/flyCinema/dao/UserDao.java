package com.cn.flyCinema.dao;

import com.cn.flyCinema.entity.User;

public interface UserDao {
    User findUserByUP(String username, String password);

    int addUser(User user);

    User findUserByName(String username);

    void updateUser(User user);

    int updateUser(int uid, int age, String email, String birthday);
    int active(String code);
    void updatePwd(String uid, String password,String payment);
}
