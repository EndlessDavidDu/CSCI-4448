package com.wy.dao;

import com.wy.tool.JDBConnection;

import java.sql.*;
import java.util.*;

import com.wy.domain.SmallTypeForm;

/**
 * operation of small type
 */
public class SmallTypeDao {
    private PreparedStatement ps = null;

    /**
     * generate a small type from the result set
     *
     * @param rs the result set
     * @return a small type form
     * @throws SQLException sql exception
     */
    private SmallTypeForm generateSmallTypeForm(ResultSet rs) throws SQLException {
        SmallTypeForm small = new SmallTypeForm();
        small.setId(rs.getInt(1));
        small.setBigId(rs.getInt(2));
        small.setSmallName(rs.getString(3));
        small.setCreateTime(rs.getString(4));
        return small;
    }

    /**
     * query the small type with the given big id
     *
     * @param bigId the big id
     * @return a list of small type form
     */
    public List<SmallTypeForm> selectOneBigId(Integer bigId) {
        List<SmallTypeForm> list = new ArrayList<SmallTypeForm>();
        SmallTypeForm small;
        try {
            this.ps = JDBConnection.getInstance().prepareStatement("select id,bigId,smallName,createTime from tb_smallType where bigId=?");
            ps.setInt(1, bigId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                small = generateSmallTypeForm(rs);
                list.add(small);
            }
        } catch (SQLException ignored) {
        }
        return list;
    }

    /**
     * query the name with the given id
     *
     * @param id the id
     * @return the name
     */
    public String selectName(Integer id) {
        String name = null;
        try {
            this.ps = JDBConnection.getInstance().prepareStatement("select smallName from tb_smallType where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (SQLException ignored) {
        }
        return name;
    }

    /**
     * delete a small type from the database with the given id
     *
     * @param id the id
     * @return true if delete successfully, false else
     */
    public boolean deleteSmall(Integer id) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("delete from tb_smallType where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * update the small type
     *
     * @param form the small type form
     */
    public void updateSmall(SmallTypeForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("update tb_smallType set bigId=?,smallName=? where id=?");
            ps.setInt(1, form.getBigId());
            ps.setString(2, form.getSmallName());
            ps.setInt(3, form.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * insert a small type into database
     *
     * @param form the small type form
     */
    public void insertSmall(SmallTypeForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("insert into tb_smallType(bigId,smallName,createTime) values (?,?,now())");
            ps.setInt(1, form.getBigId());
            ps.setString(2, form.getSmallName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * query a small type from the database with the given id
     *
     * @param id the id
     * @return a small type form
     */
    public SmallTypeForm selectOneBig(Integer id) {
        SmallTypeForm small = null;
        try {
            this.ps = JDBConnection.getInstance()
                    .prepareStatement("select id,bigId,smallName,createTime from tb_smallType where id=?");
            ps.setString(1, id.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                small = generateSmallTypeForm(rs);
            }
        } catch (SQLException ignored) {
        }
        return small;
    }

    /**
     * query all the small type from the database
     *
     * @return a list of small type form
     */
    public List<SmallTypeForm> selectSmall() {
        List<SmallTypeForm> list = new ArrayList<SmallTypeForm>();
        SmallTypeForm small;
        try {
            this.ps = JDBConnection.getInstance().prepareStatement("select id,bigId,smallName,createTime from tb_smallType order by id DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                small = generateSmallTypeForm(rs);
                list.add(small);
            }
        } catch (SQLException ignored) {
        }
        return list;
    }
}
