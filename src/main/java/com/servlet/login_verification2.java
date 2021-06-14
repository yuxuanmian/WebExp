package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beans.LoginInfoBean;
import com.controller.LoginInfoCon;
import com.json.LoginState;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login",urlPatterns = "/login")

public class login_verification2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setHeader("Content-Type","application/json;charset=utf-8");//设置响应头，防止preview乱码


        JSONObject obj= JSON.parseObject(request.getParameter("data"));
        String username=obj.getString("username");
        String password=obj.getString("password");

        LoginInfoBean loginInfoBean = new LoginInfoBean();
        loginInfoBean.setPassword(password);
        loginInfoBean.setUsername(username);

        LoginInfoCon loginInfoCon = new LoginInfoCon();
        boolean flag = loginInfoCon.isAccountRepeat(loginInfoBean);
        PrintWriter out = response.getWriter();
        if(flag){
            String jsonString = JSON.toJSONString(new LoginState("alreadyhas"));
            out.println(jsonString);
        }
        else{
            if (loginInfoCon.insertNewUser(loginInfoBean)){
                String jsonString=JSON.toJSONString(new LoginState("success"));
                out.print(jsonString);
            }else{
                String jsonString =JSON.toJSONString(new LoginState("failure"));
                out.print(jsonString);
            }

        }

    }
}
