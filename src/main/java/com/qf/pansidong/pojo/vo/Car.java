package com.qf.pansidong.pojo.vo;

public class Car {
    private String cid;
    private String car_name;
    private Double price_week;  //周租价格
    private Double price_day;   //日租价格
    private String seller_phone;   //商家电话
    private String pick_address;   //取车地点
    private String back_address;   //还车地点

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public Double getPrice_week() {
        return price_week;
    }

    public void setPrice_week(Double price_week) {
        this.price_week = price_week;
    }

    public Double getPrice_day() {
        return price_day;
    }

    public void setPrice_day(Double price_day) {
        this.price_day = price_day;
    }

    public String getSeller_phone() {
        return seller_phone;
    }

    public void setSeller_phone(String seller_phone) {
        this.seller_phone = seller_phone;
    }

    public String getPick_address() {
        return pick_address;
    }

    public void setPick_address(String pick_address) {
        this.pick_address = pick_address;
    }

    public String getBack_address() {
        return back_address;
    }

    public void setBack_address(String back_address) {
        this.back_address = back_address;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cid='" + cid + '\'' +
                ", car_name='" + car_name + '\'' +
                ", price_week=" + price_week +
                ", price_day=" + price_day +
                ", seller_phone='" + seller_phone + '\'' +
                ", pick_address='" + pick_address + '\'' +
                ", back_address='" + back_address + '\'' +
                '}';
    }
}
