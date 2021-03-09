package com.cn.flyCinema.dao.impl;

import com.cn.flyCinema.dao.IndentDao;
import com.cn.flyCinema.entity.Indent;
import com.cn.flyCinema.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class IndentDaoImpl implements IndentDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Indent> findUid(String uid) {
        String sql = "select * from table_indent where uid = ?";
        List<Indent> indents = jt.query(sql, new BeanPropertyRowMapper<>(Indent.class), Integer.parseInt(uid));
        return indents.isEmpty()?null:indents;
    }
}
