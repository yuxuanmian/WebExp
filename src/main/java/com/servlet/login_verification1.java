package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beans.LoginInfoBean;
import com.controller.LoginInfoCon;
import com.json.LoginState;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns = "/verification")


public class login_verification1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        JSONObject obj=JSON.parseObject(request.getParameter("data"));
        String username=obj.getString("username");
        String password=obj.getString("password");
        String whostr=obj.getString("who");


        int who=0;
        if(whostr.equals("user")){
            who=LoginInfoCon.USER;
        }else if(whostr.equals("administrator")){
            who=LoginInfoCon.ADMINISTRATOR;
        }

        LoginInfoBean loginInfoBean = new LoginInfoBean();
        loginInfoBean.setPassword(password);
        loginInfoBean.setUsername(username);

        LoginInfoCon loginInfoCon = new LoginInfoCon();
        boolean flag = loginInfoCon.isLoginSuccess(loginInfoBean,who);
        PrintWriter out = response.getWriter();

        if (flag) {
            String jsonString =JSON.toJSONString(new LoginState("success"));
            out.println(jsonString);
            HttpSession session = request.getSession();
            session.setAttribute("user", loginInfoBean);
        } else {
            String jsonString = JSON.toJSONString(new LoginState("fail"));
            out.println(jsonString);
        }


    }
}


