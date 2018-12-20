package com.qf.pansidong.pojo.po;

import java.util.Date;

public class Ticket1 {
    private  String cid;
    private String origin;
    private String destination;
    private String origin_time;
    private String end_time;
    private double cprice;
    private int number;
    private String tid;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Ticket1{" +
                "cid='" + cid + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", origin_time='" + origin_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", cprice=" + cprice +
                ", number=" + number +
                ", tid='" + tid + '\'' +
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

    public double getCprice() {
        return cprice;
    }

    public void setCprice(double cprice) {
        this.cprice = cprice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
