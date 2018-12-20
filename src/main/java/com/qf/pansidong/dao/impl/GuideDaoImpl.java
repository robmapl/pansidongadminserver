package com.qf.pansidong.dao.impl;

import com.qf.pansidong.dao.GuideDao;
import com.qf.pansidong.pojo.po.Guide;
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
public class GuideDaoImpl implements GuideDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 查询所有的导游信息，不分页
     * @return
     */
    @Override
    public List<Guide> listGuide() {
        String sql = "select * from guide";
        List<Guide> list = jdbcTemplate.query(sql, new RowMapper<Guide>() {
            @Override
            public Guide mapRow(ResultSet resultSet, int i) throws SQLException {
//                System.out.println("~~~~~~~~~~~~~"+i);
                return mapRowHandler(resultSet);

            }
        });
        return list;
    }

    /**
     * 查询导游的总数
     * @return
     */
    @Override
    public int getGuideTotal() {
        String sql = "select * from guide";
        List<Guide> guides = jdbcTemplate.query(sql, new RowMapper<Guide>() {
            @Override
            public Guide mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        return guides.size();
    }

    /**
     * 根据pageVo查询导游并分页
     * @param pageVo
     * @return
     */
    @Override
    public List<Guide> listGuideByPage(PageVo<Guide> pageVo) {
        String sql = "select * from guide limit ?,?";

        List<Guide> guides = jdbcTemplate.query(sql,new Object[]{pageVo.getOffset(),pageVo.getPageSize()}, new RowMapper<Guide>() {
            @Override
            public Guide mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });

        return guides;
    }

    /**
     * 根据pid删除导游信息
     * @param pid
     * @return
     */
    @Override
    public int removeGuideByPid(int pid) {
        String sql = "delete from guide where pid=?";
        int r = jdbcTemplate.update(sql,new Object[]{pid});
        return r;
    }

    /**
     * 增加新导游的方法
     * @param guide
     * @return
     */
    @Override
    public int addGuideByGuide(Guide guide) {
        String sql = "insert into guide(pname,price,pimage,pdesc,age,psex) values(?,?,?,?,?,?)";
        int r = jdbcTemplate.update(sql,new Object[]{guide.getPname(),guide.getPrice(),guide.getPimage(),guide.getPdesc(),guide.getAge(),guide.getPsex()});
        return r;
    }

    /**
     * 修改导游
     * @param guide
     * @return
     */
    @Override
    public int EditGuideByGuide(Guide guide) {
        String sql = "update guide set pname=?,price=?,pimage=?,pdesc=?,age=?,psex=? where pid=?";
        int r = jdbcTemplate.update(sql,new Object[]{guide.getPname(),guide.getPrice(),guide.getPimage(),guide.getPdesc(),guide.getAge(),guide.getPsex(),guide.getPid()});
        return r;
    }

    /**
     * 搜索获取匹配总条数
     * @param value
     * @return
     */
    @Override
    public int getSearchGuideTotal(String value) {
//        String sql = "select * from guide ";
        StringBuffer sql = new StringBuffer();
        sql.append("select * from guide ");
        if(value != null && value != ""){
//            sql = sql +"    "+ " where pname like CONCAT('%',CONCAT('"+value+"','%'))";
            sql.append("        where pname like CONCAT('%',CONCAT('"+value+"','%'))");
        }
//        System.out.println("_+_+_+_+_++"+sql.toString());
        List<Guide> guides = jdbcTemplate.query(sql.toString() ,new RowMapper<Guide>() {
            @Override
            public Guide mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        return guides.size();
    }

    /**
     * 搜索获取相应的分页搜索
     * @param pageVo
     * @param value
     * @return
     */
    @Override
    public List<Guide> searchGuide(PageVo<Guide> pageVo, String value) {
        String sql = "select * from guide";
        if(value != null && value != ""){
            sql = sql + " where pname like '%" + value +"%'";
        }
        sql = sql + " limit ?,?";
        List<Guide> guides = jdbcTemplate.query(sql,new Object[]{pageVo.getOffset(),pageVo.getPageSize()}, new RowMapper<Guide>() {
            @Override
            public Guide mapRow(ResultSet resultSet, int i) throws SQLException {
                return mapRowHandler(resultSet);
            }
        });
        return guides;
    }

    /**
     * SpringJDBC结果集处理函数
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private Guide mapRowHandler(ResultSet resultSet) throws SQLException {
        Guide guide = new Guide();

        guide.setPdesc(resultSet.getString("pdesc"));
        guide.setAge(resultSet.getInt("age"));
        guide.setPid(resultSet.getInt("pid"));
        guide.setPimage(resultSet.getString("pimage"));
        guide.setPname(resultSet.getString("pname"));
        guide.setPrice(resultSet.getDouble("price"));
        guide.setPsex(resultSet.getString("psex"));

        return guide;
    }
}
