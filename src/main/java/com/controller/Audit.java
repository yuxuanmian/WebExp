package com.controller;

import com.beans.AuditBookBean;
import com.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Audit {
    private DBUtil dao;

    public Audit() {
        dao = new DBUtil();
    }

    private List getOrgListAll() {
        String str = "select * from unaudited";
        return dao.getResultList(str, new String[]{});
    }

    private List getOrgListParam(String sql, String[] param) {
        return dao.getResultList(sql, new String[]{});
    }

    private List<AuditBookBean> getBookInfoList(List origin) {
        List<AuditBookBean> rs = new ArrayList<>();
        for (Object ittemp : origin) {
            Map<String, String> map = (Map<String, String>) ittemp;
            AuditBookBean abb = new AuditBookBean();
            abb.setBauthor(map.get("bauthor").trim());
            abb.setBprice(Double.parseDouble(map.get("bprice").trim()));
            abb.setBname(map.get("bname").trim());
            abb.setBpublisher(map.get("bpublisher").trim());
            abb.setImgurl(map.get("imgurl").trim());
            abb.setIntroduction(map.get("introduction").trim());
            abb.setNumber(map.get("number").trim());
            abb.setUploader(map.get("uploader").trim());
            rs.add(abb);
        }
        return rs;
    }

    public List<AuditBookBean> getBookAll(){
        return getBookInfoList(getOrgListAll());
    }

    public List<AuditBookBean> getBookByParams(String sql,String[]params){
        return getBookInfoList(getOrgListParam(sql,params));
    }

    public void insertBook(AuditBookBean bb){
        String sql="insert into book(number, bname, bauthor, bpublisher, bprice,imgurl,introduction,uploader) values " +
                "(?,?,?,?,?,?,?,?)";
        String[]params={bb.getNumber(),bb.getBname(),bb.getBauthor(),bb.getBpublisher(),String.valueOf(bb.getBprice())
                , bb.getImgurl(),bb.getIntroduction(),bb.getUploader()};
        dao.update(sql,params);
    }

    public void deleteBook(AuditBookBean abb){
        String sql="delete from unaudited where number=?";
        dao.update(sql,new String[]{abb.getNumber()});
    }
}
