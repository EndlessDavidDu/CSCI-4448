package com.wy.dao;

import com.wy.tool.JDBConnection;

import java.sql.*;
import java.util.*;

import com.wy.domain.BigTypeForm;

/**
 * The operation of the big type
 */
public class BigTypeDao {
    private PreparedStatement ps = null;

    /**
     * query the name
     * @param id the big type id
     * @return a string of name
     */
    public String selectName(Integer id) {
        String name = null;
        try {
            this.ps = JDBConnection.getInstance().prepareStatement("select id,bigName,createTime from tb_bigType where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(2);
            }
        } catch (SQLException ignored) {
        }
        return name;
    }

    /**
     * delete by the id
     * @param id the big type id
     * @return true if delete success, false else
     */
    public boolean deleteBig(Integer id) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("delete from tb_bigType where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * insert into the database with the given name
     * @param name the given name
     */
    public void insertBig(String name) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("insert into tb_bigType(bigName,createTime) values (?,now())");
            ps.setString(1, name);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * query all big type from the database
     * @return the list of big type
     */
    public List<BigTypeForm> selectBig() {
        List<BigTypeForm> list = new ArrayList<BigTypeForm>();
        BigTypeForm big;
        try {
            this.ps = JDBConnection.getInstance().prepareStatement("select id,bigName,createTime from tb_bigType order by id DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                big = new BigTypeForm();
                big.setId(rs.getInt(1));
                big.setBigName(rs.getString(2));
                big.setCreaTime(rs.getString(3));
                list.add(big);
            }
        } catch (SQLException ignored) {
        }
        return list;
    }

}
