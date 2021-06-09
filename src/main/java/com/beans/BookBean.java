package com.beans;

public class BookBean {
    private String number;
    private String bname;
    private String bauthor;
    private String bpublisher;
    private double bprice;

    public BookBean() {
    }

    public BookBean(String number, String bname, String bauthor, String bpublisher, double bprice) {
        this.number = number;
        this.bname = bname;
        this.bauthor = bauthor;
        this.bpublisher = bpublisher;
        this.bprice = bprice;
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

    @Override
    public String toString() {
        return "BookBean{" +
                "number='" + number + '\'' +
                ", bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", bpublisher='" + bpublisher + '\'' +
                ", bprice=" + bprice +
                '}';
    }

}
