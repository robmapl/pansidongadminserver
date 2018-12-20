package com.qf.pansidong.web;

import com.qf.pansidong.pojo.vo.Car;
import com.qf.pansidong.pojo.vo.PageVo;
import com.qf.pansidong.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CarAction {

    @Autowired
    private CarServiceImpl carService;
    //后台查询所有车的信息
    @ResponseBody
    @GetMapping("/cars")
    public List<Car> carList(){
        List<Car> cars= carService.carList();
        //System.out.println(cars);
        return cars;
    }
    @ResponseBody
    @GetMapping("/car")
    //分页查询所有车的信息
    public PageVo<Car> carlimit(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "3") Integer pageSize){

        PageVo<Car> page = carService.carLimit(currentPage,pageSize);
        return page;
    }

    @ResponseBody
    @PostMapping("/addcar")
    //增加车的数量
    public String addCar(@RequestBody Map map){
        Car car = new Car();
        System.out.println(map);
        String car_name = (String)map.get("car_name");
        String price_week1 =(String)map.get("price_week");
        String price_day1 =(String)map.get("price_day");
        Double price_week= Double.parseDouble(price_week1);
        Double price_day = Double.parseDouble(price_day1);
        String seller_phone = (String)map.get("seller_phone");
        String pick_address = (String)map.get("pick_address");
        String back_address = (String)map.get("back_address");
        car.setCar_name(car_name);
        car.setPrice_week(price_week);
        car.setPrice_day(price_day);
        car.setSeller_phone(seller_phone);
        car.setPick_address(pick_address);
        car.setBack_address(back_address);
        int i = carService.addCar(car);
        if(i==1){
            return "add Seccuse";
        }else{
            return "add Faild";
        }
    }
    @ResponseBody
    @GetMapping("carid")
    //根据id查询该车的信息
    public Car getCarById(String cid){
        return carService.getCarById(cid);
    }

    @ResponseBody
    @RequestMapping(value = "/upcar" , method = RequestMethod.POST)
    //修改车的信息
    public String updateCar(Car car){
       /* Car car = new Car();
        System.out.println(map);
        String cid = (String)map.get("cid");
        String car_name = (String)map.get("car_name");
        String price_week1 =(String)map.get("price_week");
        String price_day1 =(String)map.get("price_day");
        Double price_week= Double.parseDouble(price_week1);
        Double price_day = Double.parseDouble(price_day1);
        String seller_phone = (String)map.get("seller_phone");
        String pick_address = (String)map.get("pick_address");
        String back_address = (String)map.get("back_address");
        car.setCid(cid);
        car.setCar_name(car_name);
        car.setPrice_week(price_week);
        car.setPrice_day(price_day);
        car.setSeller_phone(seller_phone);
        car.setPick_address(pick_address);
        car.setBack_address(back_address);*/
        System.out.println(car);
        int i = carService.updateCar(car);
        if(i==1){
            return "1";
        }else{
            return "0";
        }
    }
    @ResponseBody
    @GetMapping("/deleteCar")
    //删除车的信息
    public String deleteCar(String cid){
       int i = carService.deleteCar(cid);
       if(i==1){
           return "1";
       }else{
           return "0";
       }
    }
    public void up(){
        carService.up();
    }
    @ResponseBody
    @RequestMapping(value = "/scar",method = RequestMethod.GET)
    //根据车名模糊搜索
    public List<Car> selectCar(String car_name){
        return carService.selectCar(car_name);
    }
}
