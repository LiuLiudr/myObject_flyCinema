package com.cn.flyCinema.service;

import com.cn.flyCinema.entity.Cinema;
import com.cn.flyCinema.entity.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> findScheduleByCid(int cid,int mid);

    Schedule findScheduleBySid(int sid);

    List<Schedule> findScheduleByCidDateMid(int cid, int mid, String dateget);

    Cinema findCinemaByCid(int cid);

    List<Schedule> findScheduleByCidMid(int cid, int mid);
}
