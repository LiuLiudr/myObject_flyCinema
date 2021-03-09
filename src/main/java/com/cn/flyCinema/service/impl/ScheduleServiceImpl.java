package com.cn.flyCinema.service.impl;

import com.cn.flyCinema.dao.ScheduleDao;
import com.cn.flyCinema.dao.SeatsDao;
import com.cn.flyCinema.dao.impl.ScheduleDaoImpl;
import com.cn.flyCinema.dao.impl.SeatsDaoImpl;
import com.cn.flyCinema.entity.Cinema;
import com.cn.flyCinema.entity.Schedule;
import com.cn.flyCinema.service.ScheduleService;

import java.util.List;

public class ScheduleServiceImpl  implements ScheduleService {
    private ScheduleDao scheduleDao = new ScheduleDaoImpl();
    private SeatsDao seatsDao = new SeatsDaoImpl();
    @Override
    public List<Schedule> findScheduleByCid(int cid,int mid) {
        List<Schedule> list = scheduleDao.findScheduleCid(cid,mid);
        return list;
    }

    @Override
    public Schedule findScheduleBySid(int sid) {
        Schedule schedule = scheduleDao.findScheduleBySid(sid);
        return schedule;
    }

    @Override
    public List<Schedule> findScheduleByCidDateMid(int cid, int mid, String dateget) {
        List<Schedule> list = scheduleDao.findScheduleByCidDateMid(cid,mid,dateget);
        if (list!=null){
            for (int i = 0; i <list.size() ; i++) {
                int count = seatsDao.findYCount(list.get(i).getSid());
                list.get(i).setCount(count);
            }
        }
        return list;
    }

    @Override
    public Cinema findCinemaByCid(int cid) {
        Cinema cinema = scheduleDao.findCinemaByCid(cid);
        return cinema;
    }

    @Override
    public List<Schedule> findScheduleByCidMid(int cid, int mid) {
        List<Schedule>  list = scheduleDao.findScheduleByCidMid(cid,mid);
        return list;
    }
}
