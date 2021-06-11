package com.servlet;

import com.alibaba.fastjson.JSON;
import com.beans.LoginInfoBean;
import com.controller.LoginInfoCon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/Servlet")
public class login_verification extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        LoginInfoBean loginInfoBean = new LoginInfoBean();
        loginInfoBean.setPassword(password);
        loginInfoBean.setUsername(username);

        LoginInfoCon loginInfoCon = new LoginInfoCon();
        boolean flag = loginInfoCon.isLoginSuccess(loginInfoBean);
        PrintWriter out = response.getWriter();

        if (flag) {
            String jsonString = "{state:'success'}";
            out.println(jsonString);
        }

        else{
            String jsonString = "{state:'fail'}";
            out.println(jsonString);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", loginInfoBean);
        ServletContext application = this.getServletContext();
        RequestDispatcher rd = application.getRequestDispatcher("login.html");
        rd.forward(request, response);
    }
}


