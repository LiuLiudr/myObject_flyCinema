package com.cn.flyCinema.dao;

import com.cn.flyCinema.entity.Area;

import java.util.List;

public interface AreaDao {
    List<Area> findAreaByCid(int cid);
    List<Area> findArea(int cid);
}
