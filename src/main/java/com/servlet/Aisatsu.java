package com.servlet;

import com.alibaba.fastjson.JSON;
import com.beans.LoginInfoBean;
import com.controller.LoginInfoCon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Aisatsu", value = "/Aisatsu")
public class Aisatsu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 这个servlet会接受sign传来的一个空的ajax请求，这个请求时我在页面创建的时候发起的
        * 需要从session对象中取出用户名，然后以json格式返回给网页
        * */
        PrintWriter out= response.getWriter();
        //获取session
        HttpSession session = request.getSession();
        LoginInfoBean lib=(LoginInfoBean) (session.getAttribute("user"));
        //获取用户名
        String username= lib.getUsername();
        /*LoginInfoCon loginInfoCon=new LoginInfoCon();
        String  out_str=loginInfoCon.getusername(username);*/
        //将传回的用户名转换成json字符串发送
        String Jsonstr= JSON.toJSONString(lib.getUsername().trim());
        System.out.println(Jsonstr);
        out.print(Jsonstr);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
