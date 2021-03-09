package com.cn.flyCinema.service.impl;

import com.cn.flyCinema.dao.*;
import com.cn.flyCinema.dao.impl.*;
import com.cn.flyCinema.entity.*;
import com.cn.flyCinema.service.IndentService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class IndentServiceImpl implements IndentService {
    private IndentDao id = new IndentDaoImpl();
    private ScheduleDao sd = new ScheduleDaoImpl();
    private MovieDao md = new MovieDaoImpl();
    private SeatingDao sDao = new SeatingDaoImpl();
    private CinemaDao cd = new CinemaDaoImpl();
    @Override
    public List<Indent> findByUid(String uid) {
        List<Indent> indentList = id.findUid(uid);
        if (indentList!=null){
            for (Indent indent:indentList) {
                Schedule schedule = sd.findScheduleDaoBySid(indent.getSid());
                Movie movie = md.findMovieByMid(schedule.getMid());
//                List<Seating> seatings = sDao.findSeatingBySid(indent.getSid());
//                for (Seating seating:seatings) {
//                    indent.setCoord(seating.getCoord());
//                }
                Cinema cinema = cd.fingCinemaByCid(schedule.getCid());
                schedule.setCinema(cinema);
                indent.setSchedule(schedule);
                indent.setMovie(movie);
            }
            System.out.println(indentList);
            return indentList;
        }else {
            return null;
        }
    }
}
