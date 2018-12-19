package com.qf.pansidong.service;

import com.qf.pansidong.pojo.po.TripDetails;
import com.qf.pansidong.pojo.po.Type;
import com.qf.pansidong.pojo.vo.PageVo;

import java.util.List;

public interface TripService {


    PageVo<TripDetails> listTrip(int currentPage);

    List<Type> ListType();

    PageVo<TripDetails> ListTripByType(int currentPage,int ttid);

    void addTravel(TripDetails tripDetails);

    TripDetails getTravelById(String travalid);

    void updateTravel(TripDetails tripDetails);

    void deleteTravel(String travalid);
}
