package com.servlet;

import com.alibaba.fastjson.JSON;
import com.beans.BookBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
* */
        PrintWriter out=response.getWriter();
        BookBean str= (BookBean) request.getAttribute("book");
        if(str==null){
            //填返回参数
            out.print("失败");
        }
        else {
            String jsonString = JSON.toJSONString(str);
            out.print(jsonString);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
