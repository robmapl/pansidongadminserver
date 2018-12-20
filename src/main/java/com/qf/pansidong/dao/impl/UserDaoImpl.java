package com.qf.pansidong.dao.impl;

import com.qf.pansidong.dao.UserDao;
import com.qf.pansidong.pojo.vo.PageVo;
import com.qf.pansidong.pojo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<User> showListUser(PageVo pageVo1) {
        String sql = "select * from user limit ?,? ";
        List<User> list = jdbcTemplate.query(sql,new Object[]{pageVo1.getOffset(),pageVo1.getPageSize()}, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        System.out.println(list);
        return list;
    }

   @Override
   public int deleteUser(String uid){
        String sql = "delete  from user where uid=?";
       Integer a = jdbcTemplate.update(sql,uid);
        return a;
   }

    @Override
    public int updateUser(User user){
        String sql = "update user set uid=? , uname=? , upwd=? , ucardld=?  where uphone= ?";
        Integer a = jdbcTemplate.update(sql,user.getUid(),user.getUname(),user.getUpwd(),user.getUcardld(),user.getUphone());
        return a;
    }

    @Override
    public List<User> likeSearch(String uname){
        String sql = "select * from user where uname like ?";
        List<User> list = jdbcTemplate.query(sql,new String[]{uname}, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        System.out.println(list);
        return list;
    }

    @Override
    public User showUserSolo(String uid){
        String sql = "select * from user where uid= ?";
        List<User> list = jdbcTemplate.query(sql,new String[]{uid}, new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        return list.get(0);
    }

    private User mapRowHandler(ResultSet resultSet) throws SQLException {
        User role = new User();
        role.setUid(resultSet.getString("uid"));
        role.setUname(resultSet.getString("uname"));
        role.setUpwd(resultSet.getString("upwd"));
        role.setUcardld(resultSet.getString("ucardld"));
        role.setUphone(resultSet.getString("uphone"));
        return role;
    }

}
