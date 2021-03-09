package com.cn.flyCinema.dao.impl;

import com.cn.flyCinema.dao.UserDao;
import com.cn.flyCinema.entity.User;
import com.cn.flyCinema.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findUserByUP(String username, String password) {
        String sql = "select * from table_user where username = ? and password = ?";
        List<User> user = jt.query(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        return user.isEmpty()?null:user.get(0);
    }

    @Override
    public int addUser(User user) {
        String birthday = user.getBirthday();
        if (birthday.equals("null") ||birthday.equals("")){
            birthday = null;
        }
        user.setBirthday(birthday);
        String sql = "insert into table_user values(null,?,?,?,?,?,?,?,?,null)";
        int count = jt.update(sql,user.getUsername(),user.getPassword(),user.getAge(),user.getBirthday(),user.getEmail(),user.getStatus(),
                user.getCode(),user.getPayment());
        return count;
    }

    @Override
    public User findUserByName(String username) {
        String sql = "select * from table_user where username = ?";
        User user = jt.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update table_user set username = ?, age = ?,birthday = ?,password = ?,email = ? where uid = ?";
        jt.update(sql,user.getUsername(),user.getAge(),user.getBirthday(),user.getPassword(),user.getEmail(),user.getUid());
    }

    @Override
    public int active(String code) {
        String sql = "update table_user set status = 'Y' where code = ?";
        int count = jt.update(sql, code);
        return count;
    }
    @Override
    public int updateUser(int uid, int age, String email, String birthday) {
        if (birthday.equals("null") ||birthday.equals("")){
            birthday = null;
        }
        String sql = "update table_user set age = ? , birthday = ? , email = ? where uid = ?";
        int i = jt.update(sql, age, birthday, email, uid);
        return i;
    }
    @Override
    public void updatePwd(String uid, String password,String payment) {
        String sql = "update table_user set password = ?,payment = ? where uid = ?";
        jt.update(sql,password,payment,uid);
    }
}
