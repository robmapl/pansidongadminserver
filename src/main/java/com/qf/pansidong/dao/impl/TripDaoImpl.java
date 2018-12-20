package com.qf.pansidong.dao.impl;

import com.qf.pansidong.dao.TripDao;
import com.qf.pansidong.pojo.po.TripDetails;
import com.qf.pansidong.pojo.po.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TripDaoImpl implements TripDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TripDetails> listTrip() {
        String sql = "SELECT travalid,td.tname,tprice,timage,start_time,end_time,tdestination,tt.tname AS typename FROM trip_details AS td JOIN trip_type AS tt ON td.ttid=tt.ttid";
        List<TripDetails> list = jdbcTemplate.query(sql, new RowMapper<TripDetails>() {
            public TripDetails mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        return list;
    }

    @Override
    public List<TripDetails> listTripByPage(int offset, int pageSize) {
        String sql = "SELECT travalid,td.tname,tprice,timage,start_time,end_time,tdestination,tt.tname AS typename FROM trip_details AS td JOIN trip_type AS tt ON td.ttid=tt.ttid limit ?,?";
        List<TripDetails> list = jdbcTemplate.query(sql,new Object[]{offset,pageSize}, new RowMapper<TripDetails>() {
            public TripDetails mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        return list;
    }

    private TripDetails mapRowHandler(ResultSet resultSet) throws SQLException {
        TripDetails trip = new TripDetails();
        trip.setTravalid(resultSet.getString("travalid"));
        trip.setTname(resultSet.getString("tname"));
        trip.setTprice(resultSet.getDouble("tprice"));
        trip.setTimage(resultSet.getString("timage"));
        trip.setStartTime(resultSet.getTimestamp("start_time"));
        trip.setEndTime(resultSet.getTimestamp("end_time"));
        trip.setTdestination(resultSet.getString("tdestination"));
        trip.setTypename(resultSet.getString("typename"));
        return trip;
    }

    @Override
    public List<Type> ListType() {
        String sql = "SELECT ttid,tname FROM trip_type";
        List<Type> types = jdbcTemplate.query(sql, new RowMapper<Type>() {
            @Override
            public Type mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandlerT(resultSet);
            }
        });
        return types;
    }

    private Type mapRowHandlerT(ResultSet resultSet) throws SQLException {
        Type type = new Type();
        type.setTtid(resultSet.getString("ttid"));
        type.setTypename(resultSet.getString("tname"));
        return type;
    }

    @Override
    public List<TripDetails> ListTripByType(int offset, int pageSize, int ttid) {
        String sql = "SELECT travalid,td.tname,tprice,timage,start_time,end_time,tdestination,tt.tname AS typename FROM trip_details AS td JOIN trip_type AS tt ON td.ttid=tt.ttid WHERE tt.ttid=? limit ?,?";
        List<TripDetails> list = jdbcTemplate.query(sql,new Object[]{ttid,offset,pageSize}, new RowMapper<TripDetails>() {
            public TripDetails mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        return list;
    }

    @Override
    public List<TripDetails> listTripByTypec(int ttid) {
        String sql = "SELECT travalid,td.tname,tprice,timage,start_time,end_time,tdestination,tt.tname AS typename FROM trip_details AS td JOIN trip_type AS tt ON td.ttid=tt.ttid where tt.ttid=?";
        List<TripDetails> list = jdbcTemplate.query(sql,new Object[]{ttid}, new RowMapper<TripDetails>() {
            public TripDetails mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        return list;
    }

    @Override
    public void addTravel(TripDetails tripDetails) {
        String sql="INSERT INTO trip_details(travalid,tname,tprice,timage,start_time,end_time,tdestination,ttid) VALUES(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,tripDetails.getTravalid(),tripDetails.getTname(),tripDetails.getTprice(),tripDetails.getTimage(),
                tripDetails.getStartTime(),tripDetails.getEndTime(),tripDetails.getTdestination(),tripDetails.getTypename());
    }

    @Override
    public TripDetails getTravelById(String travalid) {
        String sql ="SELECT travalid,td.tname,tprice,timage,start_time,end_time,tdestination,tt.tname AS typename FROM trip_details AS td JOIN trip_type AS tt ON td.ttid=tt.ttid WHERE travalid=?";
        List<TripDetails> tripDetails = jdbcTemplate.query(sql, new Object[]{travalid}, new RowMapper<TripDetails>() {
            @Override
            public TripDetails mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        System.out.println(tripDetails.get(0));
        return tripDetails.get(0);
    }

    @Override
    public void updateTravel(TripDetails tripDetails) {
        String sql="UPDATE trip_details set tname=?,tprice=?,start_time=?,end_time=?,tdestination=?,ttid=? where travalid=?";
        jdbcTemplate.update(sql,tripDetails.getTname(),tripDetails.getTprice(),tripDetails.getStartTime(),
                tripDetails.getEndTime(),tripDetails.getTdestination(),tripDetails.getTypename(),tripDetails.getTravalid());
    }

    @Override
    public void deleteTravel(String travalid) {
        String sql="DELETE from trip_details where travalid=?";
        jdbcTemplate.update(sql,travalid);
    }

    @Override
    public int searchTravel() {
        String sql="SELECT COUNT(*)\n" +
                "FROM (SELECT travalid,td.tname,tprice,timage,start_time,end_time,tdestination,tt.tname AS typename \n" +
                " FROM trip_details AS td JOIN trip_type AS tt ON td.ttid=tt.ttid ) AS a\n" +
                "WHERE tname LIKE CONCAT('%','胡','%') OR tdestination LIKE CONCAT('%','胡','%')";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;
    }

    @Override
    public List<TripDetails> searchTravelByName(String name, int offset, int pageSize) {
        String sql="SELECT a.* \n" +
                "FROM (SELECT travalid,td.tname,tprice,timage,start_time,end_time,tdestination,tt.tname AS typename \n" +
                " FROM trip_details AS td JOIN trip_type AS tt ON td.ttid=tt.ttid ) AS a\n" +
                "WHERE tname LIKE CONCAT('%',?,'%') OR tdestination LIKE CONCAT('%',?,'%') limit ?,?";
        return jdbcTemplate.query(sql, new Object[]{name, name, offset, pageSize}, new RowMapper<TripDetails>() {
            @Override
            public TripDetails mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
    }

    @Override
    public void deleteTravels(String sql,String[] strings) {
        jdbcTemplate.update(sql,strings);
    }
}