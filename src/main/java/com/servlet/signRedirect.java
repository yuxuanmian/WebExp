package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "signRedirect", urlPatterns = "/signRedirect")
public class signRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*System.out.println(request.getParameter("bookname"));
        request.getRequestDispatcher("detail.html").forward(request,response);*/


        /*
        * 这个servlet接受从sign.html中传来的转向请求，方式为get，参数名为bookname，用request对象取出对应的书的名字
        * 再通过BookInfo管理类中的方法得到对应书的BookBean对象，然后保存在request对象中，最
        * 后不更新url跳转到detail.html(方法参考我的注释)
        *
        * 注：1.有空写完了调试，比如打印一下对象验证是否为null
        * 2.检查乱码
        * 3.往数据库中查询的参数一定要trim()!!!!!!!!!
        *
        *
        * */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
