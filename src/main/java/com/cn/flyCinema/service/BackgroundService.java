package com.cn.flyCinema.service;

import com.cn.flyCinema.entity.Cinema;
import com.cn.flyCinema.entity.Movie;
import com.cn.flyCinema.entity.Schedule;

import java.util.List;

public interface BackgroundService {
    int InsertMovie(Movie movie);

    boolean InsertSchedule(Schedule schedule);

    List<Cinema> findAllCid();

    boolean deleteMovieByMid(Integer mid);
}
