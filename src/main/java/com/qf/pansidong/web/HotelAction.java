package com.qf.pansidong.web;

import com.qf.pansidong.pojo.vo.Hotel;
import com.qf.pansidong.pojo.vo.PageVo;
import com.qf.pansidong.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HotelAction {
    @Autowired
    private HotelService hotelService;
    @ResponseBody
    @GetMapping(value = "/listHotelByPage")
    public PageVo<Hotel> listHotelByPage(int page){
        System.out.println(page);
        PageVo<Hotel> pageVo = new PageVo<Hotel>();
        List list  = listHotels();
        pageVo.setTotalNum(list.size());
        int pageSize = 8;
        List<Hotel> hotels = hotelService.listHotelsByPage(page,pageSize);
        pageVo.setListData(hotels);
        pageVo.setCurrentPage(page);
        pageVo.setPageSize(pageSize);
        return pageVo;
    }
    @ResponseBody
    @GetMapping(value = "/list")
    public List<Hotel> listHotels(){
        List<Hotel> list = new ArrayList<>();
       return  hotelService.listHotels();
    }
    @ResponseBody
    @GetMapping(value ="/deleteHotel")
    public void deleteHotel( int hid){
        System.out.println(hid);
        int i = hotelService.deleteHotel(hid);
        System.out.println(i);
    }
    @ResponseBody
    @PostMapping(value = "/addHotel")
    public void addHotel(@RequestBody Map map){
        String object1 = (String)map.get("hname");
        String object2 =(String) map.get("hcity");
        String object3 =(String) map.get("price");
        System.out.println(object1);
        System.out.println(object2);
        System.out.println(object3);
        Hotel hotel = new Hotel();
        hotel.setPrice(object3);
        hotel.setHname(object1);
        hotel.setHcity(object2);
        System.out.println(hotel);
        int i = hotelService.addHotel(hotel);
        System.out.println(i);
    }
    @ResponseBody
    @PostMapping(value ="editHotel")
    public void editHotel(@RequestBody Map map){
        String object1 = (String)map.get("hname");
        String object2 =(String) map.get("hcity");
        String object3 =(String) map.get("price");
        int object4 =(Integer) map.get("hid");
        System.out.println(object1);
        System.out.println(object2);
        System.out.println(object3);
        System.out.println(object4);
        Hotel hotel = new Hotel();
        hotel.setPrice(object3);
        hotel.setHname(object1);
        hotel.setHcity(object2);
        hotel.setHid(object4);
        System.out.println(hotel);
        int i = hotelService.editHotel(hotel);
        System.out.println(i);
    }
}
