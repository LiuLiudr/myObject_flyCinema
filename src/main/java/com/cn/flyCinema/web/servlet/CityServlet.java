package com.cn.flyCinema.web.servlet;


import com.cn.flyCinema.entity.Area;
import com.cn.flyCinema.entity.Cinema;
import com.cn.flyCinema.entity.City;
import com.cn.flyCinema.service.CityService;
import com.cn.flyCinema.service.impl.CityServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/city/*")
public class CityServlet extends BaseServlet {
    private CityService cityService = new CityServiceImpl();
    public void findAllCity(HttpServletRequest request,HttpServletResponse response) throws IOException {

        List<City> cityList = cityService.findAllCity();

       writeValue(response,cityList);

    }

    public void findAreaByCid(HttpServletRequest request,HttpServletResponse response) throws IOException {

        int cid = Integer.parseInt(request.getParameter("cid"));

        List<Area> list = cityService.findAreaByCid(cid);


        writeValue(response,list);
    }
    public void findCinemaByAid(HttpServletRequest request,HttpServletResponse response) throws IOException {

        int aid = Integer.parseInt(request.getParameter("aid"));
        List<Cinema> list = cityService.findCinemaByAid(aid);

        writeValue(response,list);

    }
    public void findOneCinema(HttpServletRequest request,HttpServletResponse response) throws IOException {

        int cid = Integer.parseInt(request.getParameter("cid"));
        Cinema cinema  = cityService.findOneCinema(cid);

        writeValue(response,cinema);
    }

}
