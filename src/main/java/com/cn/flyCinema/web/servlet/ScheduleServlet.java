package com.cn.flyCinema.web.servlet;

import com.cn.flyCinema.entity.Cinema;
import com.cn.flyCinema.entity.Schedule;
import com.cn.flyCinema.service.ScheduleService;
import com.cn.flyCinema.service.impl.ScheduleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/Schedule/*")
public class ScheduleServlet extends BaseServlet {
    ScheduleService scheduleService =new ScheduleServiceImpl();
    public void findScheduleByCid(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String _cid = request.getParameter("cid");
        String _mid = request.getParameter("mid");
        int cid = Integer.parseInt(_cid);
        int mid = Integer.parseInt(_mid);
        List<Schedule> list = scheduleService.findScheduleByCid(cid,mid);
//       System.out.println(_cid);
//       System.out.println("mid:"+mid);
//
//       System.out.println(list);
        writeValue(response,list);
    }
    public void findScheduleBySid(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String _sid = request.getParameter("sid");
        int sid = Integer.parseInt(_sid);
        Schedule schedule = scheduleService.findScheduleBySid(sid);
//        System.out.println("sid:"+sid);
//        System.out.println(schedule);
        writeValue(response,schedule);
    }
    public void findCinemaBySid(HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException {

        request.setCharacterEncoding("utf-8");
        String _cid = request.getParameter("cid");
        String _mid = request.getParameter("mid");
        String _date = request.getParameter("date");
        int cid = Integer.parseInt(_cid);
        int mid = Integer.parseInt(_mid);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年M月d日");
        Date date = simpleDateFormat1.parse(_date);

        SimpleDateFormat df=new
                SimpleDateFormat("yyyy-MM-dd");

        String dateget = df.format(date);

        List<Schedule> list = scheduleService.findScheduleByCidDateMid(cid,mid,dateget);
//        System.out.println("---------------");
//        System.out.println("cidcidcid"+cid);
//        System.out.println("datedate:"+dateget);
//        System.out.println("midmid:"+mid);
        System.out.println("排片：："+list);
        writeValue(response,list);
    }
    public void findCinemaByCid(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String _cid = request.getParameter("cid");
        int cid = Integer.parseInt(_cid);
        Cinema cinema =scheduleService.findCinemaByCid(cid);
//        System.out.println("cidcid:::"+cid);
        writeValue(response,cinema);
    }
    public void findCinemaDateByCidMid(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String _cid = request.getParameter("cid");
        String _mid = request.getParameter("mid");
        int cid = Integer.parseInt(_cid);
        int mid = Integer.parseInt(_mid);
        List<Schedule> schedules =scheduleService.findScheduleByCidMid(cid,mid);
        writeValue(response,schedules);

    }
}
