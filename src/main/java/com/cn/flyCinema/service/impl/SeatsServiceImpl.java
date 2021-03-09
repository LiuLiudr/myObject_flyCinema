package com.cn.flyCinema.service.impl;

import com.cn.flyCinema.dao.ScheduleDao;
import com.cn.flyCinema.dao.SeatsDao;
import com.cn.flyCinema.dao.impl.MovieDaoImpl;
import com.cn.flyCinema.dao.impl.ScheduleDaoImpl;
import com.cn.flyCinema.dao.impl.SeatsDaoImpl;
import com.cn.flyCinema.entity.*;
import com.cn.flyCinema.service.SeatsService;

import java.util.List;

public class SeatsServiceImpl implements SeatsService {
    private SeatsDao seatsDao = new SeatsDaoImpl();
    @Override
    public List<Seating> getAllSeats(Integer sid) {
        List<Seating> list = seatsDao.getAllSeats(sid);
        return list;
    }

    @Override
    public void addIndent(Integer uid, Integer sid, String[] choosingList) {
        seatsDao.addIndent(uid, sid, choosingList);
    }

    @Override
    public void ySeat(Integer sid, String[] choosingList) {
        seatsDao.ySeat(sid, choosingList);
    }

    @Override
    public IndentBean findBySid(Integer sid) {
        IndentBean indentBean = new IndentBean();
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        Schedule schedule = scheduleDao.findScheduleBySid(sid);
        Movie movie = new MovieDaoImpl().findMovieByMid(schedule.getMid());
        Cinema cinema = new CityServiceImpl().findOneCinema(schedule.getCid());

        indentBean.setCinema(cinema);
        indentBean.setMovie(movie);
        indentBean.setSchedule(schedule);

        return indentBean;
    }
}
