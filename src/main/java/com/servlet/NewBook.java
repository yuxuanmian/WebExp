package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.beans.AuditBookBean;
import com.beans.BookBean;
import com.beans.LoginInfoBean;
import com.controller.Audit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Time;

@WebServlet(name = "NewBook", value = "/NewBook")
public class NewBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","application/json;charset=utf-8");
        HttpSession session=request.getSession();

        JSONObject obj=JSON.parseObject(request.getParameter("data"));
        AuditBookBean bb=new AuditBookBean();
        bb.setIntroduction("null");
        bb.setImgurl("null");
        bb.setBprice(Double.parseDouble(obj.getString("price")));
        bb.setBauthor(obj.getString("author"));
        bb.setBpublisher(obj.getString("publisher"));
        bb.setBname(obj.getString("name"));
        bb.setNumber("asdsadasd"+ (int) (Math.random() * 10000));
        LoginInfoBean lib=(LoginInfoBean)session.getAttribute("user") ;
        bb.setUploader(lib.getUsername());
        Audit a=new Audit();
        a.insertBook(bb);

    }
}
