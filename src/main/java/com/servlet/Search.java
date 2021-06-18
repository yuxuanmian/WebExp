package com.servlet;

import com.alibaba.fastjson.JSON;
import com.beans.BookBean;
import com.controller.BookInfo;
import com.controller.LoginInfoCon;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Search", value = "/Search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","application/json;charset=utf-8");//设置响应头，防止preview乱码
        String keyword=request.getParameter("keyword").trim();
        PrintWriter out =response.getWriter();
        BookInfo bi=new BookInfo();


        List<BookBean> li = bi.getBookBeansBySearch(keyword);
        out.print(JSON.toJSONString(li));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
