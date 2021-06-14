package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Aisatsu", value = "/Aisatsu")
public class Aisatsu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 这个servlet会接受sign传来的一个空的ajax请求，这个请求时我在页面创建的时候发起的
        * 需要从session对象中取出用户名，然后以json格式返回给网页
        * */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
