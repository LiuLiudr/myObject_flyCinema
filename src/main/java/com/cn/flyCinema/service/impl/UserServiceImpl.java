package com.cn.flyCinema.service.impl;

import com.cn.flyCinema.dao.UserDao;
import com.cn.flyCinema.dao.impl.UserDaoImpl;
import com.cn.flyCinema.entity.User;
import com.cn.flyCinema.service.UserService;
import com.cn.flyCinema.util.MailUtils;
import com.cn.flyCinema.util.Md5Util;
import com.cn.flyCinema.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();
    @Override
    public User findUser(String username, String password) {
        User user =ud.findUserByUP(username,password);
        return user;
    }

    @Override
    public boolean reg(User user) {
        user.setStatus("N");
        user.setCode(UuidUtil.getUuid());

        String pass= null;
        try {
            pass = Md5Util.encodeByMd5(user.getPassword());
            user.setPassword(pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int count = ud.addUser(user);
        String text="<a href='http://120.55.52.169:8080/flyCinema/user/active?code="+user.getCode()+"'>你好呀。亲爱的世界</a>";
        MailUtils.sendMail(user.getEmail(),text,"亲爱的世界");
        return count!=0;
    }



    @Override
    public boolean findUserByUname(String username) {
        try {
            User user = ud.findUserByName(username);
            if(user == null){
                return false;
            }else {
                return true;//库有返回true
            }
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void update(User user) {
        ud.updateUser(user);
    }

    @Override
    public boolean active(String code) {
        int count= ud.active(code);
        return count!=0;
    }

    @Override
    public boolean update(int uid, int age, String email, String birthday) {
        int count = ud.updateUser(uid,age,email,birthday);
        return count!=0;
    }

    @Override
    public void changePwdById(String uid, String password,String payment) {
        ud.updatePwd(uid,password,payment);
    }
}
