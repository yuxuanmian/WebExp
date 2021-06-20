package com.servlet;

import com.alibaba.fastjson.JSON;
import com.beans.AuditBookBean;
import com.controller.Audit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AuditGetBook", value = "/AuditGetBook")
public class AuditGetBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","application/json;charset=utf-8");//设置响应头，防止preview乱码
        PrintWriter out=response.getWriter();
        Audit at=new Audit();

        AuditBookBean abb;
        List<AuditBookBean> li=at.getBookAll();
        if(li!=null){
            abb=li.get(0);
        }else{
            abb=null;
        }

        if(abb==null){
            out.print("failure");
        }else{
            out.print(JSON.toJSONString(abb));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
