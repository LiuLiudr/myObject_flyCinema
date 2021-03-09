package com.cn.flyCinema.service;

import com.cn.flyCinema.entity.Indent;

import java.util.List;

public interface IndentService {
    List<Indent> findByUid(String uid);
}
