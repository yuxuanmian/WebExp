package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beans.LoginInfoBean;
import com.controller.LoginInfoCon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns = "/verification")


public class login_verification extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        JSONObject obj=JSON.parseObject(request.getParameter("data"));
        String username=obj.getString("username");
        String password=obj.getString("password");

        LoginInfoBean loginInfoBean = new LoginInfoBean();
        loginInfoBean.setPassword(password);
        loginInfoBean.setUsername(username);

        LoginInfoCon loginInfoCon = new LoginInfoCon();
        boolean flag = loginInfoCon.isLoginSuccess(loginInfoBean);
        PrintWriter out = response.getWriter();

        if (flag) {
            String jsonString = "{state:'success'}";
            out.println(jsonString);
            HttpSession session = request.getSession();
            session.setAttribute("user", loginInfoBean);
        } else {
            String jsonString = "{state:'fail'}";
            out.println(jsonString);
        }


    }
}


