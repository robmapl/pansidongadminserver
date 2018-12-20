package com.qf.pansidong.dao.impl;

import com.qf.pansidong.dao.ticketDao;
import com.qf.pansidong.pojo.po.Ticket1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ticketDaoImpl extends JdbcDaoSupport implements ticketDao {
    @Override
    public List<Ticket1> checkFJ(String tid, int offset, int pagesize) {
        String sql="SELECT * FROM ticket WHERE tid=? limit ?,?";
        return this.getJdbcTemplate().query(sql, new Object[]{tid,offset,pagesize} ,new RowMapper<Ticket1>() {
            @Override
            public Ticket1 mapRow(ResultSet rs, int rowNum) throws SQLException {
                return mapRowHandler(rs);
            }
        });
    }
    private Ticket1 mapRowHandler(ResultSet rs) throws SQLException {
        /*Ticket ticket =new Ticket();*/
        Ticket1 ticket1=new Ticket1();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        /*ticket.setCid(rs.getString("cid"));
        ticket.setOrigin(rs.getString("origin"));
        ticket.setDestination(rs.getString("destination"));
        ticket.setOrigin(sdf.format(rs.getDate("origin_time")));
        ticket.setEnd_time(sdf.format(rs.getDate("end_time")));
        ticket.setCprice(rs.getDouble("cprice"));
        ticket.setTid(rs.getString("tid"));
        ticket.setNumber(rs.getInt("number"));*/

        ticket1.setCid(rs.getString("cid"));
        ticket1.setOrigin(rs.getString("origin"));
        ticket1.setDestination(rs.getString("destination"));
        ticket1.setOrigin_time(sdf.format(rs.getTimestamp("origin_time")));
        ticket1.setEnd_time(sdf.format(rs.getTimestamp("end_time")));
        ticket1.setCprice(rs.getDouble("cprice"));
        ticket1.setNumber(rs.getInt("number"));
        ticket1.setTid(rs.getString("tid"));


        return ticket1;

    }

    @Override
    public int getAllsize(String tid) {
        String sql="SELECT COUNT(*) FROM ticket WHERE tid=?";
        return this.getJdbcTemplate().queryForObject(sql, new Object[]{tid}, Integer.class);


    }

    @Override
    public int deleteFJ(String cid) {
        String sql="DELETE FROM ticket WHERE cid=?";
       return this.getJdbcTemplate().update(sql,cid);
    }

    @Override
    public int update(Ticket1 ticket1) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date origin_time = null;
        Date end_time=null;
        try {
            origin_time = sdf.parse(ticket1.getOrigin_time());
            end_time = sdf.parse(ticket1.getEnd_time());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String sql="update ticket set origin=?,destination=?,origin_time=?,end_time=?,cprice=?,number=?,tid=? WHERE cid=?";
        return this.getJdbcTemplate().update(sql,ticket1.getOrigin(),ticket1.getDestination(),origin_time,end_time,ticket1.getCprice(),ticket1.getNumber(),ticket1.getTid(),ticket1.getCid());
    }

    @Override
    public int addFJ(Ticket1 ticket1) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date origin_time = null;
        Date end_time=null;
        try {
            origin_time = sdf.parse(ticket1.getOrigin_time());
            end_time=sdf.parse(ticket1.getEnd_time());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String sql="insert into ticket(cid,origin,destination,origin_time,end_time,cprice,tid,number) values(?,?,?,?,?,?,?,?)";
        return this.getJdbcTemplate().update(sql,ticket1.getCid(),ticket1.getOrigin(),ticket1.getDestination(),origin_time,end_time,ticket1.getCprice(),ticket1.getTid(),ticket1.getNumber());
    }

    @Override
    public List<Ticket1> searchFJ(String sousuo1,String tid) {
        String sql="select * from ticket where tid=? and cid like ?  ";
        System.out.println(sql);
        return this.getJdbcTemplate().query(sql, new Object[]{tid, sousuo1}, new RowMapper<Ticket1>() {
            @Override
            public Ticket1 mapRow(ResultSet rs, int rowNum) throws SQLException {
                return mapRowHandler(rs);
            }
        });
    }

    @Override
    public List<Ticket1> fenyesearch(String tid, int pagesize, int offset, String sousuo) {
        String sql="select * from ticket where tid=? and cid like ? limit ?,?";
        return  this.getJdbcTemplate().query(sql, new Object[]{tid, sousuo, offset, pagesize}, new RowMapper<Ticket1>() {
            @Override
            public Ticket1 mapRow(ResultSet rs, int rowNum) throws SQLException {
                return mapRowHandler(rs);
            }
        });
    }

    @Override
    public List<Ticket1> getLists() {
        String sql="select * from ticket";
        return this.getJdbcTemplate().query(sql, new RowMapper<Ticket1>() {
            @Override
            public Ticket1 mapRow(ResultSet rs, int rowNum) throws SQLException {
                return mapRowHandler(rs);
            }
        });
    }
}
