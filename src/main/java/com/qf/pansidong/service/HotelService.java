package com.qf.pansidong.service;

import com.qf.pansidong.pojo.vo.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> listHotels();

    int deleteHotel(int hid);

    int addHotel(Hotel hotel);

    int editHotel(Hotel hotel);

    List<Hotel> listHotelsByPage(int current, int pageSize);
}
