package com.cn.flyCinema.web.servlet;

import com.cn.flyCinema.entity.Movie;
import com.cn.flyCinema.entity.PageBean;
import com.cn.flyCinema.entity.ResultInfo;
import com.cn.flyCinema.service.FilmsService;
import com.cn.flyCinema.service.impl.FilmsServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(value = "/films/*")
public class FilmsServlet extends BaseServlet {
    ResultInfo resultInfo = new ResultInfo();
    FilmsService filmsService = new FilmsServiceImpl();

    public void findHottestFilms(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Movie> list = filmsService.findHottestFilms();

        resultInfo.setData(list);

        writeValue(response, resultInfo);
    }

    public void findWillShowFilms(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Movie> list = filmsService.findWillShowFilms();

        resultInfo.setData(list);

        writeValue(response, resultInfo);
    }

    public void dateFormat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String date = request.getParameter("date");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH);
        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年M月d日");
        String date2 = simpleDateFormat1.format(date1);

        resultInfo.setData(date2);
        writeValue(response, resultInfo);
    }

    public void findFilmsByScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Movie> list = filmsService.findFilmsByScore();
        resultInfo.setData(list);
        writeValue(response, resultInfo);
    }

    public void findNewestFilmsByDate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Movie> list = filmsService.findNewestFilmsByDate();
        resultInfo.setData(list);
        writeValue(response, resultInfo);
    }

    public void findFilmsByMid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mid = request.getParameter("mid");
        Movie movie = filmsService.findFilmsByMid(mid);
        writeValue(response, movie);
    }

    //查所有movie
    public void findAllFilms(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String mname = "";
        if (request.getParameter("mname") != null && request.getParameter("mname").length() > 0 && !request.getParameter("mname").equals("null")) {
            mname = request.getParameter("mname");

        }
        if ("".equals(currentPage) || currentPage == null) {
            currentPage = "1";
        }
        if ("".equals(pageSize) || pageSize == null) {
            pageSize = "8";
        }
        PageBean<Movie> pageBean = filmsService.findAll(Integer.parseInt(currentPage), Integer.parseInt(pageSize),mname);
        writeValue(response, pageBean);
    }

    //查找正在热映
    public void findAllHotFilms(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        if ("".equals(currentPage) || currentPage == null) {
            currentPage = "1";
        }
        if ("".equals(pageSize) || pageSize == null) {
            pageSize = "8";
        }
        PageBean<Movie> pageBean = filmsService.findAllHot(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
        writeValue(response, pageBean);
    }

    //查找正在热映
    public void findAllNextFilms(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        if ("".equals(currentPage) || currentPage == null) {
            currentPage = "1";
        }
        if ("".equals(pageSize) || pageSize == null) {
            pageSize = "8";
        }
        PageBean<Movie> pageBean = filmsService.findAllNext(Integer.parseInt(currentPage), Integer.parseInt(pageSize));
        writeValue(response, pageBean);
    }


}