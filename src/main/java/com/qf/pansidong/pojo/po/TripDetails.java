package com.qf.pansidong.pojo.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TripDetails{
    private String travalid;
    private String tname;
    private double tprice;
    private String timage;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private String tdestination;
    private String typename;

    public String getTravalid() {
        return travalid;
    }

    public void setTravalid(String travalid) {
        this.travalid = travalid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }

    public String getTimage() {
        return timage;
    }

    public void setTimage(String timage) {
        this.timage = timage;
    }

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss",timezone ="GMT+8")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTdestination() {
        return tdestination;
    }

    public void setTdestination(String tdestination) {
        this.tdestination = tdestination;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "TripDetails{" +
                "travalid='" + travalid + '\'' +
                ", tname='" + tname + '\'' +
                ", tprice=" + tprice +
                ", timage='" + timage + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", tdestination='" + tdestination + '\'' +
                ", typename='" + typename + '\'' +
                '}';
    }
}
