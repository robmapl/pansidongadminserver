package com.qf.pansidong.service;

import com.qf.pansidong.dao.impl.CarDaoImpl;
import com.qf.pansidong.pojo.vo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

public class CarService {
    @Autowired
    private CarDaoImpl carDao;
    //后台查询所有车的信息
    public List<Car> carList(){
        return carDao.carList();
    }
}
