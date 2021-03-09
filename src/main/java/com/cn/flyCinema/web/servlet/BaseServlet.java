package com.cn.flyCinema.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String method = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        try {
            Method method1 = this.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            method1.invoke(this,req,resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    protected void writeValue(HttpServletResponse response,Object o) throws IOException {
        ObjectMapper om = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        om.writeValue(response.getOutputStream(),o);
    }
}
