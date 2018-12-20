package com.qf.pansidong.service.impl;

import com.qf.pansidong.dao.impl.CarDaoImpl;
import com.qf.pansidong.pojo.vo.Car;
import com.qf.pansidong.pojo.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl {
    @Autowired
    private CarDaoImpl carDao;
    public List<Car> carList(){
        return carDao.carList();
    }

    public PageVo<Car> carLimit(Integer currentPage, Integer pageSize) {
        PageVo<Car> pagevo = new PageVo<>();
        pagevo.setCurrentPage(currentPage);
        pagevo.setPageSize(pageSize);
        int totalNum = carDao.getTotalCount();
        pagevo.setTotalNum(totalNum);
        System.out.println(pagevo);
        List<Car> cars = carDao.carLimit(pagevo);
        //pagevo.setListData(cars);
        return pagevo;
    }

    public int addCar(Car car) {
        String cid = UUID.randomUUID().toString();
        car.setCid(cid);
        return carDao.addCar(car);
    }

    public Car getCarById(String cid) {
        System.out.println(carDao.getCarById(cid));
        return carDao.getCarById(cid);
    }

    public int updateCar(Car car) {
        return carDao.updateCar(car);
    }

    public int deleteCar(String cid) {
        return carDao.deleteCar(cid);
    }

    public List<Car> selectCar(String car_name) {
        return carDao.selectCar("%"+car_name+"%");
    }

    public void up() {
        carDao.up();
    }
}
