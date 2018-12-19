package com.qf.pansidong.web;

import com.qf.pansidong.pojo.vo.Car;
import com.qf.pansidong.pojo.vo.PageVo;
import com.qf.pansidong.service.CarService;
import com.qf.pansidong.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("/addcar")
    //增加车的数量
    public String addCar(Car car){
        System.out.println(car);
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
    @RequestMapping(value = "/upcar" , method = RequestMethod.GET)
    //修改车的信息
    public String updateCar(Car car){
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
