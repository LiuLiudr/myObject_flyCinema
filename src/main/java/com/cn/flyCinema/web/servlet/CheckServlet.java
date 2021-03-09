package com.cn.flyCinema.web.servlet;

import com.cn.flyCinema.entity.ResultInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CodeCheckServlet")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        String check = request.getParameter("checkCode");
        ResultInfo ri = new ResultInfo();
        boolean flag = false;
        if ( checkcode_server!=null && checkcode_server.equalsIgnoreCase(check) ){
            flag = true;
        }
        ri.setFlag(flag);
        ObjectMapper om = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        om.writeValue(response.getOutputStream(), ri);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
