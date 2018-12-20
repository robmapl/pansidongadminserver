package com.qf.pansidong.dao;

import com.qf.pansidong.pojo.vo.PageVo;
import com.qf.pansidong.pojo.vo.User;

import java.util.List;

public interface UserDao {

    List<User> showListUser(PageVo pageVo1);


    

    int updateUser(User user);

    int deleteUser(String uid);

    List<User> likeSearch(String uname);

    User showUserSolo(String uid);
}
