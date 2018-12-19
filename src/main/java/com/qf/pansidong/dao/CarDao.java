package com.qf.pansidong.dao;

import com.qf.pansidong.pojo.vo.Car;
import com.qf.pansidong.pojo.vo.PageVo;

import java.util.List;

public interface CarDao {
    //查询所有车的信息
    List<Car> carList();
    //查询车的总数量
    public int getTotalCount();
    //分页查询所有车
    List<Car> carLimit(PageVo<Car> pagevo);

    int addCar(Car car);

    Car getCarById(String cid);

    int updateCar(Car car);

    int deleteCar(String cid);

    List<Car> selectCar(String car_name);

    void up();
}
