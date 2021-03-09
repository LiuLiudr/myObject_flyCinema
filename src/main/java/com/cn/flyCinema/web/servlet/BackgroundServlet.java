package com.cn.flyCinema.web.servlet;

import com.cn.flyCinema.entity.*;
import com.cn.flyCinema.service.BackgroundService;
import com.cn.flyCinema.service.FilmsService;
import com.cn.flyCinema.service.impl.BackgroundServiceImpl;
import com.cn.flyCinema.service.impl.FilmsServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/Background/*")
public class BackgroundServlet extends BaseServlet {
    private FilmsService filmsService = new FilmsServiceImpl();
    private BackgroundService backgroundService = new BackgroundServiceImpl();

    public void findAllMovies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int currentPage = -1;
        if (_currentPage == null || _currentPage.equals("null") || _currentPage.equals("") || _currentPage.equals("0")) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(_currentPage);
        }

        PageBean<Movie> pageBean = filmsService.findAll(currentPage, pageSize, "");
        writeValue(response, pageBean);
    }

    //插入movie
    public void MovieInsert(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("进insert");
        Movie movie = new Movie();
        try {
            //beanutil无法封装Date类型，需要注册一个转换器将字符串转换成Date对象
            ConvertUtils.register(new Converter() {

                @Override
                public Object convert(Class clazz, Object value) {
                    //clazz是目的对象的字节码对象，value是要转换的对象
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse = null;
                    try {
                        parse = sdf.parse(value.toString());//将格式为yyyy-MM-dd转换为Date类型
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return parse;
                }
            }, Date.class);
            BeanUtils.populate(movie,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int mid = backgroundService.InsertMovie(movie);
        writeValue(response,mid);
    }
    //插入schedule
    public void ScheduleInsert(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Schedule schedule = new Schedule();

        try {
            //beanutil无法封装Date类型，需要注册一个转换器将字符串转换成Date对象
            ConvertUtils.register(new Converter() {

                @Override
                public Object convert(Class clazz, Object value) {
                    //clazz是目的对象的字节码对象，value是要转换的对象
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date parse = null;
                    try {
                        parse = sdf.parse(value.toString());//将格式为yyyy-MM-dd转换为Date类型
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return parse;
                }
            }, Date.class);
            BeanUtils.populate(schedule,request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        boolean flag = backgroundService.InsertSchedule(schedule);
        if(flag){
            writeValue(response,flag);
        }
    }

    public void findAllCid(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<Cinema> list =  backgroundService.findAllCid();
        writeValue(response, list);
    }

    public void deleteMovieByMid(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer mid = Integer.parseInt(request.getParameter("mid"));
        boolean flag = backgroundService.deleteMovieByMid(mid);
        writeValue(response, flag);
    }


    public void booleanAdmin(HttpServletRequest request,HttpServletResponse response) throws IOException {
        boolean flag = false;
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser != null && loginUser.getAdmin() == 1) {
            flag = true;
        }
        writeValue(response, flag);
    }

}
