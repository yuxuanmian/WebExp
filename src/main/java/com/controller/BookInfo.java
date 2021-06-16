package com.controller;

import com.beans.BookBean;
import com.util.DBUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookInfo {
    private DBUtil dbUtil;

    public BookInfo() {
        dbUtil = new DBUtil();
    }


    private List getBook(String sql, String[] params) {
        return dbUtil.getResultList(sql, params);
    }

    private List ListAllBook() {
        String sql = "select * from book";
        return getBook(sql, new String[]{});
    }

    public List ListBookByParam(String sql, String[] params) {
        return getBook(sql, params);
    }
    //以上三个方法都是按照要求得到图书信息，其中返回值为List<Map>


    //将查询得到的list<Map>转换为list<BookBean>
    private List<BookBean> getQueResult(List rsList){
        List<BookBean> li = new ArrayList<>();
        for (Object tempp : rsList) {
            HashMap<String, String> map = (HashMap<String, String>) tempp;
            BookBean bb = new BookBean();
            try{
                bb.setNumber(map.get("number").trim());
                bb.setBname(map.get("bname").trim());
                bb.setBauthor(map.get("bauthor").trim());
                bb.setBpublisher(map.get("bpublisher").trim());
                bb.setBprice(Double.parseDouble(map.get("bprice").trim()));
                bb.setImgurl(map.get("imgurl").trim());
                bb.setIntroduction(map.get("introduction").trim());
                li.add(bb);
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        }
        return li;
    }

    public List<BookBean> getAllBookBean() {//获取所有的书
        List rslist = ListAllBook();
        return getQueResult(rslist);
    }



    //按照名字查找唯一一本书
    public BookBean getBookBeanByName(String name){
        String sql="select * from book where bname=?";
        List rslist=ListBookByParam(sql,new String[]{name});
        List<BookBean> li=getQueResult(rslist);
        BookBean bb=null;
        if(li.size()!=0){
            bb=li.get(0);
        }
        return bb;
    }


}
