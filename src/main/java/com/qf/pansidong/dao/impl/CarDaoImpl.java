package com.qf.pansidong.dao.impl;


import com.qf.pansidong.dao.CarDao;
import com.qf.pansidong.pojo.vo.Car;
import com.qf.pansidong.pojo.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    private JdbcTemplate template;
    @Override
    public List<Car> carList() {
        String sql ="select * from car";
        List<Car> list = template.query(sql, new RowMapper<Car>() {
            public Car mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        return list;
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from car ;";
        Integer count = template.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public List<Car> carLimit(PageVo<Car> pagevo) {
        String sql ="select * from car limit ?,? ";
        List<Car> list = template.query(sql, new RowMapper<Car>() {
            public Car mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        },pagevo.getOffset(),pagevo.getPageSize());
        return list;
    }

    @Override
    public int addCar(Car car) {
        String sql = "insert into car values(?,?,?,?,?,?,?)";
        return template.update(sql,car.getCid(),car.getCar_name(),car.getPrice_week(),car.getPrice_day(),car.getSeller_phone(),car.getPick_address(),car.getBack_address());

    }

    @Override
    public Car getCarById(String cid) {
        String sql = "select * from car where cid = ?";
        Car car = (Car) template.queryForObject(sql, new Object[]{cid},
                new RowMapper<Object>() {
                    public Object mapRow(ResultSet resultSet, int index) throws
                            SQLException {
                        return mapRowHandler(resultSet);
                    }
                });
        return car;
    }

    @Override
    public int updateCar(Car car) {
        String sql = "update car set car_name=?,price_week=?,price_day=?,seller_phone=?,pick_address=?,back_address=? where cid=?";
        return template.update(sql,car.getCar_name(),car.getPrice_week(),car.getPrice_day(),car.getSeller_phone(),car.getPick_address(),car.getBack_address(),car.getCid());
    }

    @Override
    public int deleteCar(String cid) {
        String sql ="delete from car where cid=?";
        return template.update(sql,cid);
    }

    @Override
    public List<Car> selectCar(String car_name) {
        String sql="select * from car where car_name like ?";
        List<Car> list = template.query(sql, new Object[]{car_name}, new RowMapper<Car>() {
            public Car mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        return list;

    }

    private Car mapRowHandler(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        car.setCid(resultSet.getString("cid"));
        car.setCar_name(resultSet.getString("car_name"));
        car.setPrice_day(resultSet.getDouble("price_day"));
        car.setPrice_week(resultSet.getDouble("price_week"));
        car.setSeller_phone(resultSet.getString("seller_phone"));
        car.setPick_address(resultSet.getString("pick_address"));
        car.setBack_address(resultSet.getString("back_address"));

//        role.setRname(resultSet.getString("rname"));
//        role.setAlias(resultSet.getString("alias"));
        return car;

    }

    @Override
    public void up() {

    }
}
