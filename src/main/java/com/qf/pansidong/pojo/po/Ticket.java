package com.qf.pansidong.pojo.po;

import java.util.Date;

public class Ticket {
    private String cid;//车票编号
    private String origin;//起始地点
    private String destination;//终点站
    private String origin_time;//出发时间
    private String  end_time;//到达时间
    private double cprice;
    private String tid;//类型编号
    private  int number;//车票的数量

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getCprice() {
        return cprice;
    }

    public void setCprice(double cprice) {
        this.cprice = cprice;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "cid='" + cid + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", origin_time=" + origin_time +
                ", end_time=" + end_time +
                ", cprice=" + cprice +
                ", tid='" + tid + '\'' +
                ", number=" + number +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin_time() {
        return origin_time;
    }

    public void setOrigin_time(String origin_time) {
        this.origin_time = origin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}

