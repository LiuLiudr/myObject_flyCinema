package com.cn.flyCinema.dao;

import com.cn.flyCinema.entity.Cinema;

import java.util.List;

public interface CinemaDao {
    List<Cinema> findCinemaByAid(int aid);

    List<Cinema> findCinema(int aid);
    Cinema findOneCinema(int cid);
    Cinema fingCinemaByCid(Integer cid);
}
