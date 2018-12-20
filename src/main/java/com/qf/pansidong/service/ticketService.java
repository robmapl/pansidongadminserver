package com.qf.pansidong.service;

import com.qf.pansidong.pojo.po.Ticket1;

import java.util.List;

public interface ticketService {
    List<Ticket1> checkFJ(String tid, int offset, int pagesize);
    int getAllsize(String tid);
    int deleteFJ(String cid);
    int update(Ticket1 ticket1);
    int addFJ(Ticket1 ticket1);
    List<Ticket1> searchFJ(String sousuo, String tid);
    List<Ticket1> fenyesearch(String tid, int pagesize, int offset, String sousuo);
    List<Ticket1> getLists();
}
