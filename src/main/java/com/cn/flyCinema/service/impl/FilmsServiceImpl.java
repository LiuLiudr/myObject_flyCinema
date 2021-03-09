package com.cn.flyCinema.service.impl;

import com.cn.flyCinema.dao.FilmsDao;
import com.cn.flyCinema.dao.impl.FilmsDaoImpl;
import com.cn.flyCinema.entity.Movie;
import com.cn.flyCinema.entity.PageBean;
import com.cn.flyCinema.service.FilmsService;

import java.util.List;

public class  FilmsServiceImpl implements FilmsService {
    private FilmsDao filmsDao = new FilmsDaoImpl();

    @Override
    public List<Movie> findHottestFilms() {
        List<Movie> list = filmsDao.findHottestFilms();
        return list;
    }

    @Override
    public List<Movie> findWillShowFilms() {
        List<Movie> list = filmsDao.findWillShowFilms();
        return list;
    }

    @Override
    public Movie findFilmsByMid(String mid) {
        int _mid = Integer.parseInt(mid);
        Movie movie =  filmsDao.findFilmsByMid(_mid);
        return movie;
    }

    @Override
    public List<Movie> findFilmsByScore() {
        List<Movie> list = filmsDao.findFilmsByScore();
        return list;
    }

    @Override
    public List<Movie> findNewestFilmsByDate() {
        List<Movie> list = filmsDao.findNewestFilmsByDate();
        return list;
    }

    @Override
    public PageBean<Movie> findAll(int currentPage, int pageSize,String mname) {
        int count = filmsDao.Count(mname);
        List<Movie> filmslist= filmsDao.findByCP(currentPage,pageSize,mname);
        PageBean<Movie> pageBean = new PageBean<>();
        pageBean.setList(filmslist);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(count);
        pageBean.setTotalPage((count+pageSize-1)/pageSize);
        return pageBean;
    }

    @Override
    public PageBean<Movie> findAllHot(int currentPage, int pageSize) {
        int count = filmsDao.HotCount();
        List<Movie> filmslist= filmsDao.findHotByCP(currentPage,pageSize);
        PageBean<Movie> pageBean = new PageBean<>();
        pageBean.setList(filmslist);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(count);
        pageBean.setTotalPage((count+pageSize-1)/pageSize);
        return pageBean;
    }

    @Override
    public PageBean<Movie> findAllNext(int currentPage, int pageSize) {
        int count = filmsDao.NextCount();
        List<Movie> filmslist= filmsDao.findNextByCP(currentPage,pageSize);
        PageBean<Movie> pageBean = new PageBean<>();
        pageBean.setList(filmslist);
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(count);
        pageBean.setTotalPage((count+pageSize-1)/pageSize);
        return pageBean;
    }
}
