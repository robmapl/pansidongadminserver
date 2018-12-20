package com.qf.pansidong.dao;

import com.qf.pansidong.pojo.vo.Hotel;

import java.util.List;

public interface HotelDao {
    List<Hotel> listHotels();

    int deleteHotel(int hid);

    int addHotel(Hotel hotel);

    int editHotel(Hotel hotel);

    List<Hotel> listHotelsByPage(int pageIndex, int pageSize);
}
