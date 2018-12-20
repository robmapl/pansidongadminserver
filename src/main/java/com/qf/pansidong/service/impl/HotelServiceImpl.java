package com.qf.pansidong.service.impl;

import com.qf.pansidong.dao.HotelDao;
import com.qf.pansidong.pojo.vo.Hotel;
import com.qf.pansidong.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelDao hotelDao;
    @Override
    public List<Hotel> listHotels() {
       return hotelDao.listHotels();

    }

    @Override
    public int deleteHotel(int hid) {
        return hotelDao.deleteHotel(hid);
    }

    @Override
    public int addHotel(Hotel hotel) {
        return hotelDao.addHotel(hotel);
    }

    @Override
    public int editHotel(Hotel hotel) {
        return hotelDao.editHotel(hotel);
    }

    @Override
    public List<Hotel> listHotelsByPage(int current, int pageSize) {
        int pageIndex = (current-1)*pageSize;
        return hotelDao.listHotelsByPage(pageIndex,pageSize);
    }
}
