package com.cn.flyCinema.dao;

import com.cn.flyCinema.entity.Seating;

import java.util.List;

public interface SeatingDao {
    List<Seating> findSeatingBySid(Integer sid);
}
