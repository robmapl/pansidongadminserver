package com.qf.pansidong.web;

import com.qf.pansidong.pojo.po.TripDetails;
import com.qf.pansidong.pojo.po.Type;
import com.qf.pansidong.pojo.vo.PageVo;
import com.qf.pansidong.service.TripService;
import com.qf.pansidong.service.impl.TripServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/travel")
public class TravelAction {

    @Autowired
    private TripService service = new TripServiceImpl();

    @ResponseBody
    @GetMapping("/ListTrip")
    public PageVo<TripDetails> ListTrip(int currentPage){
        PageVo<TripDetails> tripList = service.listTrip(currentPage);
        return tripList;
    }

    @ResponseBody
    @GetMapping("/ListType")
    public List<Type> ListType(){
        List<Type> types = service.ListType();
        return types;
    }

    @ResponseBody
    @GetMapping("/ListTripByType")
    public PageVo<TripDetails> ListTripByType(@RequestParam(defaultValue = "1") int currentPage, int ttid){
        PageVo<TripDetails> tripDetails = service.ListTripByType(currentPage,ttid);
        return tripDetails;
    }

    @ResponseBody
    @PostMapping("/addTravel")
    public String addTravel(TripDetails tripDetails, HttpServletRequest request) throws IOException {
       service.addTravel(tripDetails);
        return "success";
    }

    @ResponseBody
    @GetMapping("/getTravelById")
    public TripDetails getTravelById(String travalid){
        TripDetails tripDetails = service.getTravelById(travalid);
        return tripDetails;
    }

    @ResponseBody
    @PutMapping("/updateTravel")
    public String updateTravel(TripDetails tripDetails){
        service.updateTravel(tripDetails);
        return "success";
    }

    @ResponseBody
    @DeleteMapping("/deleteTravel")
    public PageVo<TripDetails> deleteTravel(String travalid,int currentPage){
        service.deleteTravel(travalid);
        return service.listTrip(currentPage);
    }

    @ResponseBody
    @GetMapping("/searchTravel")
    public PageVo<TripDetails> searchTravel(@RequestParam(defaultValue = "1") int currentPage,String name){
        return service.searchTravel(currentPage,name);

    }

    @ResponseBody
    @DeleteMapping("/deleteTravels")
    public PageVo<TripDetails> deleteTravels(int currentPage,String ids){
        String[] strings = ids.split("::");
       service.deleteTravels(strings);
        return service.listTrip(currentPage);
    }
}
