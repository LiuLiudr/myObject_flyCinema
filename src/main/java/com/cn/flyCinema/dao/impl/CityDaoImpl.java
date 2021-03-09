package com.cn.flyCinema.dao.impl;

import com.cn.flyCinema.dao.CityDao;
import com.cn.flyCinema.entity.City;

import com.cn.flyCinema.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CityDaoImpl implements CityDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<City> findAllCity() {

        String sql = "select * from table_city ";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(City.class));
    }
}
