package com.cn.flyCinema.web.servlet;

import com.cn.flyCinema.entity.*;
import com.cn.flyCinema.service.SeatsService;
import com.cn.flyCinema.service.impl.SeatsServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/seats/*")
public class SeatServlet extends BaseServlet {
    private SeatsService seatsService = new SeatsServiceImpl();
    private ResultInfo resultInfo = new ResultInfo();

    public void getAllSeats(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Integer sid = Integer.valueOf(request.getParameter("sid"));
        List<Seating> list = seatsService.getAllSeats(sid);
        writeValue(response, list);
    }


    public void makeIndent(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Integer sid = Integer.parseInt(request.getParameter("sid"));
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        String payment = request.getParameter("payment");

        resultInfo.setFlag(true);

        if (loginUser == null) {
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("not_loginUser");
        } else {
            if (payment == null || !payment.equals(loginUser.getPayment())) {
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("支付密码错误");
            } else {
                String[] choosingList = request.getParameterValues("choosingList");

                if (choosingList == null || choosingList.length == 0) {
                    resultInfo.setFlag(false);
                    resultInfo.setErrorMsg("您还没有选座");
                } else {
                    seatsService.addIndent(loginUser.getUid(), sid, choosingList);
                    seatsService.ySeat(sid, choosingList);
                }
            }
        }
        writeValue(response, resultInfo);
    }

    public void findBySid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Integer sid = Integer.parseInt(request.getParameter("sid"));
        IndentBean indentBean = seatsService.findBySid(sid);
        writeValue(response, indentBean);
    }

}
