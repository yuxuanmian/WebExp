package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShowBookDetail", value = "/ShowBookDetail")
public class ShowBookDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out=response.getWriter();
/*
*这个servlet接受从detail.html传来的空的ajax请求。
* 要求：signRedirect这个servlet中在request对象中设置了bookname参数，现在取出来，并通过json格式返回给页面。
* 注意null、乱码、trim（），返回前一定要验证是否为空，
*
*
*
*
* */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
