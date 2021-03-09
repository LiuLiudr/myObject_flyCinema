package com.cn.flyCinema.dao;

import com.cn.flyCinema.entity.Indent;

import java.util.List;

public interface IndentDao {
    List<Indent> findUid(String uid);
}
