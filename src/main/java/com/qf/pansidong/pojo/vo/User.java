package com.qf.pansidong.pojo.vo;

public class User {
   private String uid;
   private String uname;
   private String upwd;
   private String ucardld;
   private String uphone;

   public User() {
   }

   public String getUid() {
      return uid;
   }

   public void setUid(String uid) {
      this.uid = uid;
   }

   public String getUname() {
      return uname;
   }

   public void setUname(String uname) {
      this.uname = uname;
   }

   public String getUpwd() {
      return upwd;
   }

   public void setUpwd(String upwd) {
      this.upwd = upwd;
   }

   public String getUcardld() {
      return ucardld;
   }

   public void setUcardld(String ucardld) {
      this.ucardld = ucardld;
   }

   public String getUphone() {
      return uphone;
   }

   public void setUphone(String uphone) {
      this.uphone = uphone;
   }

   @Override
   public String toString() {
      return "User{" +
              "uid='" + uid + '\'' +
              ", uname='" + uname + '\'' +
              ", upwd='" + upwd + '\'' +
              ", ucardld='" + ucardld + '\'' +
              ", uphone='" + uphone + '\'' +
              '}';
   }
}
