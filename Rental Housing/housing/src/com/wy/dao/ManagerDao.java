package com.wy.dao;

import java.sql.*;
import java.util.*;

import com.wy.domain.ManagerForm;
import com.wy.tool.JDBConnection;

/**
 * Operation of manager
 */
public class ManagerDao {
    private PreparedStatement ps = null;

    /**
     * insert manager into the database
     *
     * @param form the manager form
     */
    public void insertManager(ManagerForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("insert into tb_manager(account,password,name,sign) values (?,?,?,?)");
            ps.setString(1, form.getAccount());
            ps.setString(2, form.getPassword());
            ps.setString(3, form.getName());
            ps.setInt(4, 0);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * update the password of the manager
     *
     * @param form the manager form
     */
    public void updateManagerPassword(ManagerForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("update tb_manager set password=? where account=?");
            ps.setString(1, form.getPassword());
            ps.setString(2, form.getAccount());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * delete the manager with the given id
     *
     * @param id the manager id
     */
    public void deleteManager(Integer id) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("delete from tb_manager where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * query all manager from the database
     *
     * @return a list of managers
     */
    public List<ManagerForm> selectManager() {
        List<ManagerForm> list = new ArrayList<ManagerForm>();
        ManagerForm manager;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select * from tb_manager order by id DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                manager = new ManagerForm();
                manager.setId(rs.getInt(1));
                manager.setAccount(rs.getString(2));
                manager.setPassword(rs.getString(3));
                manager.setName(rs.getString(4));
                manager.setSign(rs.getInt(5));
                list.add(manager);
            }
        } catch (SQLException ignored) {
        }
        return list;
    }

    /**
     * query a manager with the given account
     *
     * @param account the account
     * @return a manager form
     */
    public ManagerForm selectOne(String account) {
        ManagerForm manager = null;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select id,account,password,name,sign from tb_manager where account=?");
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                manager = new ManagerForm();
                manager.setId(rs.getInt(1));
                manager.setAccount(rs.getString(2));
                manager.setPassword(rs.getString(3));
                manager.setName(rs.getString(4));
                manager.setSign(rs.getInt(5));
            }
        } catch (SQLException ignored) {
        }
        return manager;
    }


}
