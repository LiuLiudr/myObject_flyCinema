package com.cn.flyCinema.service;

import com.cn.flyCinema.entity.Movie;
import com.cn.flyCinema.entity.PageBean;

import java.util.List;

public interface FilmsService {
    List<Movie> findHottestFilms();

    List<Movie> findWillShowFilms();

    List<Movie> findFilmsByScore();

    List<Movie> findNewestFilmsByDate();
    PageBean<Movie> findAll(int currentPage, int pageSize,String mname);

    PageBean<Movie> findAllHot(int currentPage, int pageSize);

    PageBean<Movie> findAllNext(int currentPage, int pageSize);
    Movie findFilmsByMid(String mid);
}
