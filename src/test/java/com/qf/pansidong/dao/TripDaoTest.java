package com.qf.pansidong.dao;

import com.qf.pansidong.pojo.po.TripDetails;
import com.qf.pansidong.service.TripService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao-test.xml")
public class TripDaoTest {

    @Autowired
    private TripDao tripDao;

    @Test
    public void lsitTrip(){
        List<TripDetails> tripDetails = tripDao.listTrip();
        System.out.println(tripDetails);
    }

    @Test
    public void listTripPage(){
        System.out.println(tripDao.listTripByPage(0,8));
        System.out.println((tripDao.listTripByPage(0,8)).size());
    }

    @Test
    public void listType(){
        System.out.println(tripDao.ListType());
    }
}

