package com.cn.flyCinema.service.impl;

import com.cn.flyCinema.dao.BackgroundDao;
import com.cn.flyCinema.dao.impl.BackgroundDaoImpl;
import com.cn.flyCinema.entity.Cinema;
import com.cn.flyCinema.entity.Movie;
import com.cn.flyCinema.entity.Schedule;
import com.cn.flyCinema.service.BackgroundService;

import java.util.List;

public class BackgroundServiceImpl  implements BackgroundService {
    private BackgroundDao backgroundDao = new BackgroundDaoImpl();
    @Override
    public int InsertMovie(Movie movie) {
        int mid = backgroundDao.InsertMovie(movie);
        return mid;
    }

    @Override
    public boolean InsertSchedule(Schedule schedule) {
        int count = backgroundDao.InsertSchedule(schedule);
        return count != 0;
    }

    @Override
    public List<Cinema> findAllCid() {

        return backgroundDao.findAllCid();
    }

    @Override
    public boolean deleteMovieByMid(Integer mid) {
        return backgroundDao.deleteMovieByMid(mid) != 0;
    }
}
