package com.qf.pansidong.pojo.vo;

public class Hotel {
    private int hid;
    private String hname;
    private String hcity;
    private String price;

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHcity() {
        return hcity;
    }

    public void setHcity(String hcity) {
        this.hcity = hcity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", hcity='" + hcity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
