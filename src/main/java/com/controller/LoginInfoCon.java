package com.controller;

import com.beans.LoginInfoBean;
import com.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
/*所有返回查询的函数我都使用的接口回调，例如返回一个list数组，在遍历数组时要强转类型*/


public class LoginInfoCon {
    DBUtil dbUtil;

    public LoginInfoCon() {
        dbUtil=new DBUtil();
    }

    //从数据库中按需求读取用户账号和密码(自己传入sql语句和参数),只能查user表！！！！！不然数据会截断或者溢出
    public List getAllUser(String sql, String[] params) {//用法参见test包下的testGetResultList
        List orgin = dbUtil.getResultList(sql, params);
        List result=new ArrayList();
        for(Object a:orgin){
            Map<String, String> a1=(Map)a;
            LoginInfoBean temp=new LoginInfoBean();
            temp.setUsername(a1.get("username"));
            temp.setPassword(a1.get("password"));
            result.add(temp);
        }
        return result;
    }
    //从数据库库中读取所有用户账号和密码
    public List getAllUser(){
        String sql="select * from user";
        String []params={};
        List orgin = dbUtil.getResultList(sql, params);
        List result=new ArrayList();
        for(Object a:orgin){
            Map<String, String> a1=(Map)a;
            LoginInfoBean temp=new LoginInfoBean();
            temp.setUsername(a1.get("username"));
            temp.setPassword(a1.get("password"));
            result.add(temp);
        }
        return result;
    }
}
