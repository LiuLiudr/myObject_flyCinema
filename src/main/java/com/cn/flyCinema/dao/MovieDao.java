package com.cn.flyCinema.dao;

import com.cn.flyCinema.entity.Movie;

public interface MovieDao {
    Movie findMovieByMid(Integer mid);
}
