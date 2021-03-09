package com.cn.flyCinema.dao;

import com.cn.flyCinema.entity.Cinema;
import com.cn.flyCinema.entity.Movie;
import com.cn.flyCinema.entity.Schedule;

import java.util.List;

public interface BackgroundDao {
    int InsertMovie(Movie movie);

    int InsertSchedule(Schedule schedule);

    List<Cinema> findAllCid();

    int deleteMovieByMid(Integer mid);
}
