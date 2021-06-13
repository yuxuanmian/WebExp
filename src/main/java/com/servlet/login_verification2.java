package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beans.LoginInfoBean;
import com.controller.LoginInfoCon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class login_verification2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JSONObject obj= JSON.parseObject(request.getParameter("data"));
        String username=obj.getString("username");
        String password=obj.getString("password");

        LoginInfoBean loginInfoBean = new LoginInfoBean();
        loginInfoBean.setPassword(password);
        loginInfoBean.setUsername(username);

        LoginInfoCon loginInfoCon = new LoginInfoCon();
        boolean flag = loginInfoCon.isLoginSuccess(loginInfoBean);
        PrintWriter out = response.getWriter();
        if(flag){
            String jsonString = "{state:'数据库中已有该用户'}";
            out.println(jsonString);
        }
        else{
            if (loginInfoCon.insertNewUser(loginInfoBean)){
                String jsonStrin="{state:'已写入数据库'}";
                out.print(jsonStrin);
            }
            String jsonStrin ="{state:'数据库写入失败'}";
            out.print(jsonStrin);
        }

    }
}
