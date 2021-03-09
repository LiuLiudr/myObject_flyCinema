package com.cn.flyCinema.dao;

import com.cn.flyCinema.entity.Cinema;
import com.cn.flyCinema.entity.Schedule;

import java.util.List;

public interface ScheduleDao {
    List<Schedule> findScheduleCid(int cid,int mid);
    Schedule findScheduleBySid(Integer sid);

    Schedule findScheduleDaoBySid(Integer sid);

    List<Schedule> findScheduleByCidDateMid(int cid, int mid, String dateget);

    Cinema findCinemaByCid(int cid);

    List<Schedule> findScheduleByCidMid(int cid, int mid);
}
