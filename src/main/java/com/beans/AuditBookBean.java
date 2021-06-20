package com.beans;

public class AuditBookBean {
    private String number;
    private String bname;
    private String bauthor;
    private String bpublisher;
    private double bprice;
    private String imgurl;
    private String introduction;
    private String uploader;

    public AuditBookBean(String number, String bname, String bauthor, String bpublisher, double bprice,
                         String imgurl, String introduction, String uploader) {
        this.number = number;
        this.bname = bname;
        this.bauthor = bauthor;
        this.bpublisher = bpublisher;
        this.bprice = bprice;
        this.imgurl = imgurl;
        this.introduction = introduction;
        this.uploader = uploader;
    }

    public AuditBookBean() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getBpublisher() {
        return bpublisher;
    }

    public void setBpublisher(String bpublisher) {
        this.bpublisher = bpublisher;
    }

    public double getBprice() {
        return bprice;
    }

    public void setBprice(double bprice) {
        this.bprice = bprice;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    @Override
    public String toString() {
        return "AuditBookBean{" +
                "number='" + number + '\'' +
                ", bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", bpublisher='" + bpublisher + '\'' +
                ", bprice=" + bprice +
                ", imgurl='" + imgurl + '\'' +
                ", introduction='" + introduction + '\'' +
                ", uploader='" + uploader + '\'' +
                '}';
    }
}
