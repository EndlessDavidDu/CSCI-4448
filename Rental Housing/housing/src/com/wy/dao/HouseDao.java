package com.wy.dao;

import java.sql.*;
import java.util.*;

import com.wy.tool.JDBConnection;
import com.wy.domain.HouseForm;


/**
 * Operations on the merchandise list
 */
public class HouseDao {
    private PreparedStatement ps = null;

    /**
     * Modify the number of items purchased based on the ID of the item
     * @param number the number
     * @param id the id
     */
    public void updateHouseNumber(int number, Integer id) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("update tb_house set number=number+? where id=?");
            ps.setInt(1, number);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }

    }

    /**
     * The method of setting special price
     * @param form the form
     */
    public void managerPrice(HouseForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("update tb_house set freePrice=?,mark=? where id=?");
            ps.setFloat(1, form.getFreePrice());
            ps.setInt(2, form.getMark());
            ps.setInt(3, form.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * Inquire information as to whether the house are special or not
     * @param mark the mark
     * @return the list of house information
     */
    public List<HouseForm> selectMark(Integer mark) {
        List<HouseForm> list = new ArrayList<>();
        try {
            ps = JDBConnection.getInstance().prepareStatement("select id,bigId,smallId,houseName,houseFrom,introduce,createTime,nowPrice,freePrice,number,picture,mark from tb_house where mark=? order by id DESC");
            ps.setInt(1, mark);
            ResultSet rs = ps.executeQuery();
            generateHouse(list, rs);
        } catch (SQLException ignored) {
        }
        return list;
    }

    /**
     * generate a house list from the result set
     * @param list the house list
     * @param rs the result set
     * @throws SQLException sql exception
     */
    private void generateHouse(List<HouseForm> list, ResultSet rs) throws SQLException {
        HouseForm house;
        while (rs.next()) {
            house = new HouseForm();
            house.setId(rs.getInt(1));
            house.setBig(rs.getInt(2));
            house.setSmall(rs.getInt(3));
            house.setName(rs.getString(4));
            house.setFrom(rs.getString(5));
            house.setIntroduce(rs.getString(6));
            house.setCreateTime(rs.getString(7));
            house.setNowPrice(rs.getFloat(8));
            house.setFreePrice(rs.getFloat(9));
            house.setNumber(rs.getInt(10));
            house.setPicture(rs.getString(11));
            house.setMark(rs.getInt(12));
            list.add(house);
        }
    }

    /**
     * add a house to the database
     * @param form the house form
     */
    public void insertHouse(HouseForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("insert into tb_house( bigId, smallId, houseName, houseFrom, introduce,createTime, nowPrice, freePrice, number, picture, mark) values (?,?,?,?,?,now(),?,?,?,?,?)");
            ps.setInt(1, form.getBig());
            ps.setInt(2, form.getSmall());
            ps.setString(3, form.getName());
            ps.setString(4, form.getFrom());
            ps.setString(5, form.getIntroduce());
            ps.setFloat(6, form.getNowPrice());
            ps.setFloat(7, form.getFreePrice());
            ps.setInt(8, 0);
            ps.setString(9, form.getPicture());
            ps.setInt(10, 0);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }


    /**
     * Delete information subject to item number
     * @param id the id
     */
    public void deleteHouse(Integer id) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("delete from tb_house where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * Query information with the item number as a condition
     * @param id the id
     * @return the house form
     */
    public HouseForm selectOneHouse(Integer id) {
        HouseForm house = new HouseForm();
        try {
            ps = JDBConnection.getInstance().prepareStatement("select * from tb_house where id=? order by id DESC");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                house.setId(rs.getInt(1));
                house.setBig(rs.getInt(2));
                house.setSmall(rs.getInt(3));
                house.setName(rs.getString(4));
                house.setFrom(rs.getString(5));
                house.setIntroduce(rs.getString(6));
                house.setCreateTime(rs.getString(7));
                house.setNowPrice(rs.getFloat(8));
                house.setFreePrice(rs.getFloat(9));
                house.setNumber(rs.getInt(10));
                house.setPicture(rs.getString(11));
                house.setMark(rs.getInt(12));
            }
        } catch (SQLException ignored) {
        }
        return house;
    }

    /**
     * Query information by the number of a small category of the item
     * @param small the small id
     * @return the list of houses
     */
    public List<HouseForm> selectSmall(Integer small) {
        List<HouseForm> list = new ArrayList<HouseForm>();
        try {
            ps = JDBConnection.getInstance().prepareStatement("select * from tb_house where smallId=? order by id DESC");
            ps.setInt(1, small);
            ResultSet rs = ps.executeQuery();
            generateHouse(list, rs);
        } catch (SQLException ignored) {
        }
        return list;
    }


    /**
     * Query information in terms of the broad category of the item
     * @param big the big id
     * @return the list of houses
     */
    public List<HouseForm> selectBig(Integer big) {
        List<HouseForm> list = new ArrayList<HouseForm>();
        try {
            ps = JDBConnection.getInstance().prepareStatement("select * from tb_house where bigId=? order by id DESC");
            ps.setInt(1, big);
            ResultSet rs = ps.executeQuery();
            generateHouse(list, rs);
        } catch (SQLException ignored) {
        }
        return list;
    }


    /**
     * query all house information, desc by number
     * @return the list of all houses' information
     */
    public List<HouseForm> selectHouse() {
        List<HouseForm> list = new ArrayList<HouseForm>();
        try {
            ps = JDBConnection.getInstance().prepareStatement("select * from tb_house order by id DESC");
            ResultSet rs = ps.executeQuery();
            generateHouse(list, rs);
        } catch (SQLException ignored) {
        }
        return list;
    }

    /**
     * query all house information, desc by number
     * @return the list of all houses' information
     */
    public List<HouseForm> selectHouseNumber() {
        List<HouseForm> list = new ArrayList<HouseForm>();
        try {
            ps = JDBConnection.getInstance().prepareStatement("select * from tb_house order by number DESC");
            ResultSet rs = ps.executeQuery();
            generateHouse(list, rs);
        } catch (SQLException ignored) {
        }
        return list;
    }
}
