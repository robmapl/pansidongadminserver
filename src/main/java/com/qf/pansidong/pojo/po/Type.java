package com.qf.pansidong.pojo.po;

public class Type {
    private String ttid;
    private String Typename;

    public String getTtid() {
        return ttid;
    }

    public void setTtid(String ttid) {
        this.ttid = ttid;
    }

    public String getTypename() {
        return Typename;
    }

    public void setTypename(String typename) {
        Typename = typename;
    }

    @Override
    public String toString() {
        return "Type{" +
                "ttid='" + ttid + '\'' +
                ", Typename='" + Typename + '\'' +
                '}';
    }
}
