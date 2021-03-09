package com.cn.flyCinema.web.filter;

import com.cn.flyCinema.entity.User;
import com.cn.flyCinema.service.UserService;
import com.cn.flyCinema.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null){
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("username")){
                    username = cookie.getValue();
                }
                if (cookie.getName().equals("password")){
                    password = cookie.getValue();
                }
            }
        }
        if (username != null && password != null){
            User loginUser = new UserServiceImpl().findUser(username, password);
            if (loginUser != null) {
                request.getSession().setAttribute("loginUser", loginUser);
            }
        }
        chain.doFilter(req, resp);
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
