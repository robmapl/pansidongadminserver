package com.qf.pansidong.dao.impl;

import com.qf.pansidong.dao.HotelDao;
import com.qf.pansidong.pojo.vo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class HotelDaoImpl implements HotelDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Hotel> listHotels() {
        String sql = "select * from hotel";
            List<Hotel> list = jdbcTemplate.query(sql,new RowMapper<Hotel>(){
            @Override
            public Hotel mapRow(ResultSet rs, int i) throws SQLException {
                return mapRowHandler(rs);
            }
        });
       return list;
    }

    @Override
    public List<Hotel> listHotelsByPage(int pageIndex, int pageSize) {
        String sql = "select * from hotel limit ?,?";
        List<Hotel> list = jdbcTemplate.query(sql,new Object[]{pageIndex,pageSize},new RowMapper<Hotel>(){
            @Override
            public Hotel mapRow(ResultSet rs, int i) throws SQLException {
                return mapRowHandler(rs);
            }
        });
        return list;
    }

    @Override
    public int deleteHotel(int hid) {
        String sql = "delete from hotel where hid=?";
        return jdbcTemplate.update(sql,hid);
    }

    @Override
    public int addHotel(Hotel hotel) {
        String sql = "insert into hotel(hprice,hname,hcity) values(?,?,?)";
        return jdbcTemplate.update(sql,hotel.getPrice(),hotel.getHname(),hotel.getHcity());
    }

    @Override
    public int editHotel(Hotel hotel) {
        String sql = "update hotel set hprice=?,hname=?,hcity=? where hid=?";
        return jdbcTemplate.update(sql,hotel.getPrice(),hotel.getHname(),hotel.getHcity(),hotel.getHid());
    }



    private Hotel mapRowHandler(ResultSet resultSet) throws SQLException{
        Hotel hotel = new Hotel();
        hotel.setHid(resultSet.getInt("hid"));
        hotel.setHcity(resultSet.getString("hcity"));
        hotel.setHname(resultSet.getString("hname"));
        hotel.setPrice(resultSet.getString("hprice"));
        return hotel;
    }
}
