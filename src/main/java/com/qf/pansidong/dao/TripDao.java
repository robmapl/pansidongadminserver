package com.qf.pansidong.dao;

import com.qf.pansidong.pojo.po.TripDetails;
import com.qf.pansidong.pojo.po.Type;

import java.util.List;

public interface TripDao {
    List<TripDetails> listTrip();

    List<TripDetails> listTripByPage(int offset, int pageSize);

    List<Type> ListType();


    List<TripDetails> ListTripByType(int offset, int pageSize, int ttid);

    List<TripDetails> listTripByTypec(int ttid);

    void addTravel(TripDetails tripDetails);

    TripDetails getTravelById(String travalid);

    void updateTravel(TripDetails tripDetails);

    void deleteTravel(String travalid);
}
