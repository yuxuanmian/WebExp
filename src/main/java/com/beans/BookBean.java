package com.beans;

public class BookBean {
    private String number;
    private String bname;
    private String bauthor;
    private String bpublisher;
    private double bprice;
    private String imgurl;
    private String introduction;

    public BookBean() {
    }


    public BookBean(String number, String bname, String bauthor, String bpublisher,
                    double bprice, String imgurl, String introduction) {
        this.number = number;
        this.bname = bname;
        this.bauthor = bauthor;
        this.bpublisher = bpublisher;
        this.bprice = bprice;
        this.imgurl = imgurl;
        this.introduction = introduction;
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

    public void setBprice(float bprice) {
        this.bprice = bprice;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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


    @Override
    public String toString() {
        return "BookBean{" +
                "number='" + number + '\'' +
                ", bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", bpublisher='" + bpublisher + '\'' +
                ", bprice=" + bprice +
                ", imgurl='" + imgurl + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
