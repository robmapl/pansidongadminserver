package com.qf.pansidong.service.impl;

import com.qf.pansidong.dao.impl.UserDaoImpl;
import com.qf.pansidong.pojo.vo.PageVo;
import com.qf.pansidong.pojo.vo.User;
import com.qf.pansidong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public List<User> showListUser(PageVo pageVo1) {
        List<User> pv = null;
        try {
            pv = userDaoImpl.showListUser(pageVo1);
        } catch (Exception e) {

        }
        return pv;
    }

    @Override
    public int deleteUser(String uid) {
        int a = 0;
        try {
            a = userDaoImpl.deleteUser(uid);
        } catch (Exception e) {

        }
        return a;
    }

    @Override
    public int updateUser(User user) {
        int a = 0;
        try {
            a = userDaoImpl.updateUser(user);
        } catch (Exception e) {

        }
        return a;

    }

    @Override
    public List<User> likeSearch(String uname){
        List<User> user = null;
        try {
            user = userDaoImpl.likeSearch("%"+uname+"%");
        }catch (Exception e){

        }
        return user;

    }

    @Override
    public User showUserSolo(String uid){
        User user = null;
        try {
            user = userDaoImpl.showUserSolo(uid);
        }catch (Exception e){

        }
        return user;
    }
}

