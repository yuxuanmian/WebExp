package com.controller;

import com.beans.LoginInfoBean;
import com.util.DBUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
/*所有返回查询的函数我都使用的接口回调，例如返回一个list数组，在遍历数组时要强转类型*/


public class LoginInfoCon {
    DBUtil dbUtil;
    public static final int USER=1;
    public static final int ADMINISTRATOR=2;

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


    //获取所有管理员账号
    public List getAllAdmin(){
        String sql="select * from administrator";
        String []params={};
        List orgin = dbUtil.getResultList(sql, params);
        List result=new ArrayList();
        for(Object a:orgin){
            Map<String, String> a1=(Map)a;
            LoginInfoBean temp=new LoginInfoBean();
            temp.setUsername(a1.get("name"));
            temp.setPassword(a1.get("password"));
            result.add(temp);
        }
        return result;
    }

    //登陆名比较方法
    public boolean isLoginSuccess(LoginInfoBean lib,int who){
        boolean flag=false;
        List list=null;
        if(who==USER){
            list=getAllUser();
        }else if(who==ADMINISTRATOR){
            list=getAllAdmin();
        }
        for(Object temp:list){
            LoginInfoBean a=(LoginInfoBean) temp;
            if(a.equals(lib)){
                flag=true;
            }
        }
        return flag;
    }


    //通过LoginInfoBean传参向数据库中写入一条用户数据
    public boolean insertNewUser(LoginInfoBean lib){
        String username=lib.getUsername().trim();
        String password=lib.getPassword().trim();
        String sql="insert into user (username, password) VALUES (?,?) ";
        String[] params={username,password};
        int a=dbUtil.update(sql,params);
        return a != 0;
    }


    //查找数据库中是否存在重复的账号名,存在返回true；
    public boolean isAccountRepeat(LoginInfoBean lib){
        String acc=lib.getUsername();
        String sql="select username from user";
        List li=dbUtil.getResultList(sql,new String[]{});
        for(Object b:li){
            HashMap<String,String>a=(HashMap<String, String>) b;
            if(acc.trim().equals(a.get("username").trim()))
                return true;
        }
        return false;
    }
}
