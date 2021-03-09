package com.cn.flyCinema.dao.impl;

import com.cn.flyCinema.dao.CinemaDao;
import com.cn.flyCinema.entity.Cinema;
import com.cn.flyCinema.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

public class CinemaDaoImpl implements CinemaDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Cinema> findCinemaByAid(int aid) {

        String sql = "select * from table_cinema where aid =?";


        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Cinema.class),aid);
    }

    @Override
    public Cinema findOneCinema(int cid) {
        String sql = "select * from  table_cinema  where cid =?";
        List<Cinema> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cinema.class), cid);
        return list.size() == 0 ?null :list.get(0);
    }

    @Override
    public Cinema fingCinemaByCid(Integer cid) {
        String sql = "select * from table_cinema where cid = ?";
        List<Cinema> cinemas = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cinema.class), cid);
        return cinemas.isEmpty()?null:cinemas.get(0);
    }
    @Override
    public List<Cinema> findCinema(int aid) {

        String sql = "select * from table_cinema where aid =?";


        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Cinema.class),aid);
    }

}
