package com.qf.pansidong.web;

import com.qf.pansidong.pojo.vo.PageVo;
import com.qf.pansidong.pojo.vo.User;
import com.qf.pansidong.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UserAction {
    @Autowired
    private UserServiceImpl userServiceImpl;
    //查询所有
    @ResponseBody
    @GetMapping("/showListUser/{pageVo}")
    public PageVo showListUser(@PathVariable("pageVo") int pageVo,Model model){
        System.err.println(pageVo);
        PageVo pageVo1 = new PageVo();
        pageVo1.setCurrentPage(1);
        pageVo1.setPageSize(10);
        int a = 0;
        if(pageVo > 0){
//            a = Integer.parseInt(pageVo);
            pageVo1.setCurrentPage(pageVo);
        }
        System.err.println(pageVo);
        List<User> user = userServiceImpl.showListUser(pageVo1);
        System.err.println(user);
        pageVo1.setListData(user);
        System.err.println(pageVo1);
        model.addAttribute("pageVo1",pageVo1);
       return pageVo1;
    }

    @ResponseBody
    @GetMapping("/deleteUser")
    public String deleteUser(String uid){
        System.err.println("进来了");
        System.err.println(uid);
        int a = userServiceImpl.deleteUser(uid);
        System.err.println(a);
        System.err.println("执行完毕");
        return null;
    }

    @ResponseBody
    @GetMapping("updateUser")
    public String updateUser(User user){
        System.err.println("进来了");
        userServiceImpl.updateUser(user);
        System.err.println("执行完毕");
        return null;
    }

    @ResponseBody
    @GetMapping("/likeSearch/{uname}")
    public List<User> likeSearch(@PathVariable("uname") String uname) {
        System.err.println("进来了");
        List<User> users = userServiceImpl.likeSearch(uname);
        System.err.println(users);
        System.err.println("执行完毕");
        return users;
    }
    @ResponseBody
    @GetMapping("/showUserSolo")
    public  User  showUserSolo(Model model){
        System.err.println("进来了");
        String id = "3";
//        uid = id;
        System.out.println("uid:"+id);
//        User user = new User();
//        user.setUid(uid);
        User user = userServiceImpl.showUserSolo(id);
        System.err.println("执行完毕");
        System.out.println("user:"+user);
        model.addAttribute("User",user);
        return user;
    }
}
