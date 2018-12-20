package com.qf.pansidong.service.impl;

import com.qf.pansidong.dao.impl.ticketDaoImpl;
import com.qf.pansidong.pojo.po.Ticket1;
import com.qf.pansidong.service.ticketService;
import com.qf.pansidong.dao.ticketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class ticketServiceImpl implements ticketService {
    @Autowired
    private ticketDao ticketDao=new ticketDaoImpl();//Dao层接口有实现类，不会爆红
    @Override
    public List<Ticket1> checkFJ(String tid, int offset, int pagesize) {
        return ticketDao.checkFJ(tid, offset, pagesize);
    }

    @Override
    public int getAllsize(String tid) {
        return ticketDao.getAllsize(tid);
    }

    @Override
    public int deleteFJ(String cid) {
        return ticketDao.deleteFJ(cid);
    }

    @Override
    public int update(Ticket1 ticket1) {

        return ticketDao.update(ticket1);
    }

    @Override
    public int addFJ(Ticket1 ticket1) {
        return ticketDao.addFJ(ticket1);
    }

    @Override
    public List<Ticket1> searchFJ(String sousuo,String tid) {
        String sousuo1="%"+sousuo+"%";
        System.out.println(sousuo1);
        return  ticketDao.searchFJ(sousuo1,tid);
    }

    @Override
    public List<Ticket1> fenyesearch(String tid, int pagesize, int offset, String sousuo) {
        String sousuo1="%"+sousuo+"%";
        return  ticketDao.fenyesearch(tid,pagesize,offset,sousuo1);
    }

    @Override
    public List<Ticket1> getLists() {
        return ticketDao.getLists();
    }
}