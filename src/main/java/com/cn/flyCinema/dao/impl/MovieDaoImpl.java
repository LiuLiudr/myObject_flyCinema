package com.cn.flyCinema.dao.impl;

import com.cn.flyCinema.dao.MovieDao;
import com.cn.flyCinema.entity.Movie;
import com.cn.flyCinema.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MovieDaoImpl implements MovieDao {
    private JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Movie findMovieByMid(Integer mid) {
        String sql = "select * from table_movie where mid = ?";
        List<Movie> movies = jt.query(sql, new BeanPropertyRowMapper<>(Movie.class), mid);
        return movies.isEmpty()?null:movies.get(0);
    }
}
