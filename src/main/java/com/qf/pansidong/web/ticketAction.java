package com.qf.pansidong.web;

import com.qf.pansidong.pojo.po.Ticket1;
import com.qf.pansidong.service.impl.ticketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.qf.pansidong.service.ticketService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*@CrossOrigin(origins = "*",maxAge = 3600 )
@RestController//添加两个注解*/
@Controller
public class ticketAction {
    @Autowired
    private ticketService ticketService=new ticketServiceImpl();

    @ResponseBody
    @GetMapping("/all")
    public List getLists(){

        List lists = ticketService.getLists();
        System.out.println(lists);
        return lists;
    }

    @ResponseBody
    @PostMapping("/FJ1")
    public List<Ticket1> searchFJ(String sousuo, String tid, int current, int pagesize){

        List list=new ArrayList();
        if (tid==null){
            tid="飞机票";
        }
        System.out.println(sousuo);
        System.out.println(tid);

        List<Ticket1> ticket1s = ticketService.searchFJ(sousuo, tid);
        int size = ticket1s.size();
        int offset=(current-1)*pagesize;
        List<Ticket1> ticket5=ticketService.fenyesearch(tid,pagesize,offset,sousuo);


        list.add(ticket5);
        list.add(size);
        System.out.println(list);
        return list;


    }


    @ResponseBody
    @PostMapping("/FJ")
    public void addFJ(String cid,String origin,String destination,String origin_time,String end_time,String cprice,String number2,String tid){
       Ticket1 ticket1=new Ticket1();
       ticket1.setCid(cid);
       ticket1.setOrigin(origin);
       ticket1.setDestination(destination);
       ticket1.setOrigin_time(origin_time);
       ticket1.setEnd_time(end_time);
        double cprice1 = Double.parseDouble(cprice);
        ticket1.setCprice(cprice1);
        int number3 = Integer.parseInt(number2);
        ticket1.setNumber(number3);
       ticket1.setTid(tid);
       ticketService.addFJ(ticket1);


    }

    @ResponseBody
    @PutMapping("/FJ")
    public void updateFJ(String cid,String origin,String destination,String origin_time,String end_time,String cprice,String number2,String tid){
    Ticket1 ticket1=new Ticket1();
    ticket1.setTid(tid);
    ticket1.setCid(cid);
    ticket1.setOrigin_time(origin_time);
    ticket1.setOrigin(origin);
        int number1 = Integer.parseInt(number2);
        ticket1.setNumber(number1);
        double cprice1 = Double.parseDouble(cprice);
        ticket1.setCprice(cprice1);
    ticket1.setEnd_time(end_time);
    ticket1.setDestination(destination);
    int i= ticketService.update(ticket1);





    }

    @ResponseBody
    @DeleteMapping("/deleteFJ/{cid}")
    public void deleteFJ(@PathVariable(value = "cid") String cid){
        ticketService.deleteFJ(cid);
    }

    @ResponseBody
    @GetMapping("/checkFJ")
    public List checkFJ(String tid,int pagesize,int current,String v,String sousuo){
        System.out.println(v);
        System.out.println(tid);
        //System.out.println(tid);
        /*System.out.println(v);*/
        if ("sy66".equals(v)){
           return searchFJ(sousuo,tid,current,pagesize);
        }







        if (tid==null){
            tid="飞机票";
        }
        List list =new ArrayList();
        int allsize=ticketService.getAllsize(tid);
        /*System.out.println(pagesize);
        System.out.println(current);*/
        int offset=(current-1)*pagesize;//offset偏移量
        /*System.out.println(tid);*/
        List<Ticket1> tickets = ticketService.checkFJ(tid,offset,pagesize);
        list.add(tickets);
        list.add(allsize);
        return list;

    }


}
