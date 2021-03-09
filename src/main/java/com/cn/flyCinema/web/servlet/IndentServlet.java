package com.cn.flyCinema.web.servlet;

import com.cn.flyCinema.entity.Indent;
import com.cn.flyCinema.service.IndentService;
import com.cn.flyCinema.service.impl.IndentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Indent/*")
public class IndentServlet extends BaseServlet {
    private IndentService is = new IndentServiceImpl();
    public void findIndent(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String uid = request.getParameter("uid");
        if (uid==null||"".equals(uid)){
            writeValue(response,null);
        }else {
            List<Indent> indent = is.findByUid(uid);
            writeValue(response, indent);
        }
    }

}
