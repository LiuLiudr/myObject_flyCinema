package com.cn.flyCinema.service;

import com.cn.flyCinema.entity.IndentBean;
import com.cn.flyCinema.entity.Seating;

import java.util.List;

public interface SeatsService {
    List<Seating> getAllSeats(Integer sid);

    void addIndent(Integer uid, Integer sid, String[] choosingList);

    void ySeat(Integer sid, String[] choosingList);

    IndentBean findBySid(Integer sid);
}
