package com.cn.flyCinema.dao.impl;

import com.cn.flyCinema.dao.BackgroundDao;
import com.cn.flyCinema.entity.Cinema;
import com.cn.flyCinema.entity.Movie;
import com.cn.flyCinema.entity.Schedule;
import com.cn.flyCinema.service.BackgroundService;
import com.cn.flyCinema.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class BackgroundDaoImpl  implements BackgroundDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int InsertMovie(Movie movie) {
        String sql = "insert into table_movie values(null,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, movie.getName(), movie.getDirector(), movie.getProtagonist(), movie.getType(), movie.getRegion(),
                movie.getShowtime(), movie.getIntroduction(), movie.getScore(), movie.getImg(), movie.getDate());

        String sql02 = "select * from table_movie where name = ?";
        List<Movie> list = jdbcTemplate.query(sql02, new BeanPropertyRowMapper<>(Movie.class), movie.getName());
        return list.get(0).getMid();
    }

    @Override
    public int InsertSchedule(Schedule schedule) {
        String sql = "insert into table_schedule values(null,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,schedule.getCid(),schedule.getMid(),schedule.getDate(),schedule.getTime(),schedule.getName(),
                schedule.getPrice(),schedule.getLanguage());
        return 0;
    }

    @Override
    public List<Cinema> findAllCid() {
        String sql = "select * from table_cinema";
        List<Cinema> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cinema.class));
        return list;
    }

    @Override
    public int deleteMovieByMid(Integer mid) {
        String sql01 = "delete from table_movie where mid = ?";
        String sql02 = "delete from table_schedule where mid = ?";

        jdbcTemplate.update(sql02, mid);
        int back = jdbcTemplate.update(sql01, mid);
        return back;
    }
}
