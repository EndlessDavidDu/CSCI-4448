package com.wy.dao;

import java.sql.*;
import java.util.*;

import com.wy.tool.JDBConnection;
import com.wy.domain.GoodsForm;

//Operations on the merchandise list
public class GoodsDao {
  private Connection connection = null;
  private PreparedStatement ps = null;
  private JDBConnection jdbc = null;
  public GoodsDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection;}

//Modify the number of items purchased based on the ID of the item
  public void updateGoodsNumber(int number, Integer id) {
    try {
      ps = connection.prepareStatement("update tb_goods set number=number+? where id=?");
      ps.setInt(1, number);
      ps.setInt(2, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }

  }

//The method of setting special price
  public void managerPrice(GoodsForm form) {
    try {
      ps = connection.prepareStatement("update tb_goods set freePrice=?,mark=? where id=?");
      ps.setFloat(1, form.getFreePrice().floatValue());
      ps.setInt(2, form.getMark().intValue());
      ps.setInt(3, form.getId().intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //Inquire information as to whether the goods are special or not
  public List<Object> selectMark(Integer mark) {
    List<Object> list = new ArrayList<>();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement("select * from tb_goods where mark=? order by id DESC");
      ps.setInt(1, mark.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new GoodsForm();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//add
  public void insertGoods(GoodsForm form) {
    try {
      ps = connection.prepareStatement("insert into tb_goods( bigId, smallId, goodsName, goodsFrom, introduce, nowPrice, freePrice, number, pirture, mark) values (?,?,?,?,?,getDate(),?,?,?,?,?)");
      ps.setInt(1, form.getBig().intValue());
      ps.setInt(2, form.getSmall().intValue());
      ps.setString(3, form.getName());
      ps.setString(4, form.getFrom());
      ps.setString(5, form.getIntroduce());
      ps.setFloat(6, form.getNowPrice().floatValue());
      ps.setFloat(7, form.getFreePrice().floatValue());
      ps.setInt(8, 0);
      ps.setString(9, form.getPriture());
      ps.setInt(10, 0);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

// Delete information subject to item number
  public void deleteGoods(Integer id) {
    try {
      ps = connection.prepareStatement("delete from tb_goods where id=?");
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

//Query information with the item number as a condition
  public GoodsForm selectOneGoods(Integer id) {
    GoodsForm goods = new GoodsForm();
    try {
      ps = connection.prepareStatement("select * from tb_goods where id=? order by id DESC");
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {   
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
      }
    }
    catch (SQLException ex) {
    }
    return goods;
  }

  //Query information by the number of a small category of the item
  public List<Object> selectSmall(Integer small) {
    List<Object> list = new ArrayList<>();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement("select * from tb_goods where smallId=? order by id DESC");
      ps.setInt(1, small.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new GoodsForm();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

  //Query information in terms of the broad category of the item
  public List<Object> selectBig(Integer big) {
    List<Object> list = new ArrayList<>();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement("select * from tb_goods where bigId=? order by id DESC");
      ps.setInt(1, big.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new GoodsForm();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//query all
  public List<Object> selectGoods() {
    List<Object> list = new ArrayList<>();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement("select * from tb_goods order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new GoodsForm();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

  //query all
  public List<Object> selectGoodsNumber() {
    List<Object> list = new ArrayList<>();
    GoodsForm goods = null;
    try {
      ps = connection.prepareStatement("select * from tb_goods order by number DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        goods = new GoodsForm();
        goods.setId(Integer.valueOf(rs.getString(1)));
        goods.setBig(Integer.valueOf(rs.getString(2)));
        goods.setSmall(Integer.valueOf(rs.getString(3)));
        goods.setName(rs.getString(4));
        goods.setFrom(rs.getString(5));
        goods.setIntroduce(rs.getString(6));
        goods.setCreaTime(rs.getString(7));
        goods.setNowPrice(Float.valueOf(rs.getString(8)));
        goods.setFreePrice(Float.valueOf(rs.getString(9)));
        goods.setNumber(Integer.valueOf(rs.getString(10)));
        goods.setPriture(rs.getString(11));
        goods.setMark(Integer.valueOf(rs.getString(12)));
        list.add(goods);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }


}
