package com.cn.flyCinema.dao.impl;

import com.cn.flyCinema.dao.AreaDao;
import com.cn.flyCinema.entity.Area;
import com.cn.flyCinema.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AreaDaoImpl implements AreaDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Area> findAreaByCid(int cid) {
        String sql = "select * from  table_area where cid=?";


        return  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Area.class),cid);
    }
    @Override
    public List<Area> findArea(int cid) {
        String sql = "select * from  table_area where cid=?";


        return  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Area.class),cid);
    }
}
