package com.cn.flyCinema.dao.impl;

import com.cn.flyCinema.dao.FilmsDao;
import com.cn.flyCinema.entity.Movie;
import com.cn.flyCinema.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class FilmsDaoImpl implements FilmsDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Movie> findHottestFilms() {
        String sql = "select * from table_movie where date <= ? order by mid";

        List<Movie> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Movie.class), "2020-9-15");
        return list;
    }

    @Override
    public List<Movie> findWillShowFilms() {
        String sql = "select * from table_movie where date > ? order by date asc";

        List<Movie> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Movie.class), "2020-9-15");
        return list;
    }

    @Override
    public List<Movie> findFilmsByScore() {
        String sql = "select * from table_movie order by score desc";
        List<Movie> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Movie.class));
        return list;
    }

    @Override
    public List<Movie> findNewestFilmsByDate() {
        String sql = "select * from table_movie where date <= ? order by date desc";

        List<Movie> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Movie.class), "2020-9-15");
        return list;
    }

    @Override
    public int Count(String mname) {
        StringBuilder  sql = new StringBuilder("select count(*) from table_movie");
        List<Object> params = new ArrayList<>();
        if (mname != null && mname.length() > 0) {
            sql.append(" where name like ?   ");
            params.add("%" + mname + "%");

        }
        Integer count = jdbcTemplate.queryForObject(sql.toString(), Integer.class,params.toArray());
        return count;
    }

    @Override
    public List<Movie> findByCP(int currentPage, int pageSize,String mname) {
        StringBuilder sql = new StringBuilder("select * from table_movie where 1=1  ");

        List<Object> params = new ArrayList<>();
        if (mname != null && mname.length() > 0) {
            sql.append(" and name like ?   ");
            params.add("%" + mname + "%");
        }
        sql.append("  limit ?,?");
        int start = (currentPage-1)*pageSize;
        params.add(start);
        params.add(pageSize);

        List<Movie> movieList = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Movie.class), params.toArray());
        return movieList;



    }

    @Override
    public List<Movie> findHotByCP(int currentPage, int pageSize) {
        String sql = "select * from table_movie where date <= curdate() limit ?,?";
        int start = (currentPage-1)*pageSize;
        List<Movie> movieList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Movie.class), start, pageSize);
        return movieList;
    }

    @Override
    public int HotCount() {
        String sql = "select count(*) from table_movie where date <= curdate()";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public int NextCount() {
        String sql = "select count(*) from table_movie where date > curdate()";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<Movie> findNextByCP(int currentPage, int pageSize) {
        String sql = "select * from table_movie where date > curdate() limit ?,?";
        int start = (currentPage-1)*pageSize;
        List<Movie> movieList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Movie.class), start, pageSize);
        return movieList;
    }

    @Override
    public Movie findFilmsByMid(int mid) {
        String sql = "select * from table_movie where mid = ? ";
        try {
            Movie movie = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Movie.class), mid);
            return movie;
        }catch (Exception e){
            return null;
        }
    }
}
