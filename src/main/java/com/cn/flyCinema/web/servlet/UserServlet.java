package com.cn.flyCinema.web.servlet;

import com.cn.flyCinema.entity.ResultInfo;
import com.cn.flyCinema.entity.User;
import com.cn.flyCinema.service.UserService;
import com.cn.flyCinema.service.impl.UserServiceImpl;
import com.cn.flyCinema.util.Md5Util;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    private UserService us = new UserServiceImpl();
    private ResultInfo info = new ResultInfo();
    //登录 需前端判断输入是否为空
    public void userLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String pass = Md5Util.encodeByMd5(password);
        User loginUser = us.findUser(username,pass);
        if (loginUser==null){
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }else {

            if ("y".equalsIgnoreCase(loginUser.getStatus())){
            //自动登录的设置
                String autoLogin = request.getParameter("autoLogin");
                if (autoLogin.equals("B")){
                    //存入cookie;
                    Cookie _username = new Cookie("username",loginUser.getUsername());
                    Cookie _password = new Cookie("password",loginUser.getPassword());
                    //设置持久化时间
                    _username.setMaxAge(60*60);
                    _password.setMaxAge(60*60);
                    //设置携带路径
                    _username.setPath(request.getContextPath());
                    _password.setPath(request.getContextPath());
                    //发送cookie
                    response.addCookie(_password);
                    response.addCookie(_username);
                }
                info.setFlag(true);
                request.getSession().setAttribute("loginUser",loginUser);
            }else {
                info.setFlag(false);
                info.setErrorMsg("用户未邮箱验证");
            }
        }
        writeValue(response,info);
    }
    //注册 需前端判断输入是否为空
    public void regUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String code = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        String checkCode = request.getParameter("checkCode");
        Map<String, String[]> userMap = request.getParameterMap();
        User user = new User();
        BeanUtils.populate(user,userMap);
        boolean isReg = us.reg(user);
        if (code != null && code.equalsIgnoreCase(checkCode)){
            if (!isReg){
                info.setErrorMsg("你输入的注册信息有误，请重新输入");
            }
        }else {
            isReg = false;
            info.setErrorMsg("验证码有误");

        }
        info.setFlag(isReg);
        writeValue(response,info);

    }
    //正在登录的用户
    public void isLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{
        User user = (User)request.getSession().getAttribute("loginUser");
        writeValue(response,user);
    }
    //退出
    public void exit(HttpServletRequest request,HttpServletResponse response) throws Exception{
        request.getSession().removeAttribute("loginUser");
        Cookie cookie1 = new Cookie("username", "");
        Cookie cookie2 = new Cookie("password", "");

        cookie1.setMaxAge(0);
        cookie2.setMaxAge(0);
        cookie1.setPath(request.getContextPath());
        cookie2.setPath(request.getContextPath());

        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.sendRedirect(request.getContextPath()+"/login.html");
    }
    //注册时检验该用户名是否存在
    public void CheckUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        boolean flag = us.findUserByUname(username);
        if (!flag){
            info.setErrorMsg("该用户名不存在,请先注册");
        }
        info.setFlag(flag);
        writeValue(response,info);
    }
    //修改个人信息 需前端判断输入是否为空
    public void updateUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
        String uid = request.getParameter("uid");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");

        boolean flag = us.update(Integer.parseInt(uid),Integer.parseInt(age),email,birthday);
        if(flag){
            User loginUser = (User) request.getSession().getAttribute("loginUser");
            loginUser.setAge(Integer.parseInt(age));
            loginUser.setBirthday(birthday);
            loginUser.setEmail(email);
            request.getSession().setAttribute("loginUser",loginUser);
        }
        info.setFlag(flag);
        writeValue(response,info);
    }
    public void changePwd(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String uid = request.getParameter("uid");
        String password = request.getParameter("password1");
        String payment = request.getParameter("payment1");
        if (password==null||"".equals(password)||payment==null||"".equals(payment)){
            info.setFlag(false);
            info.setErrorMsg("密码均不能为空");
            writeValue(response,info);
        }else {
            us.changePwdById(uid, password,payment);
            User loginUser = (User) request.getSession().getAttribute("loginUser");
            loginUser.setPassword(password);
            loginUser.setPayment(payment);
            request.getSession().setAttribute("loginUser",loginUser);

            info.setFlag(true);
            writeValue(response,info);
        }
    }
    public void active(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String code = request.getParameter("code");
        response.setContentType("text/html;charset=utf-8");
        boolean flag =  us.active(code);
        if (flag){
            response.sendRedirect(request.getContextPath()+"/login.html");
//            response.sendRedirect("http://192.168.56.101/flyCinema/login.html");

        }else {
            response.getWriter().println("激活失败!");
        }
    }

}

