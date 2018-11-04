package com.wy.dao;

import java.sql.*;
import java.util.*;
import com.wy.domain.ManagerForm;
import com.wy.tool.JDBConnection;

//对管理员的操作
public class ManagerDao {
  private Connection connection = null;
  private PreparedStatement ps = null;
  private JDBConnection jdbc = null;
  public ManagerDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection;}

  //对管理员表的查询方法
  public void insertManager(ManagerForm form) {
    try {

      ps = connection.prepareStatement("insert into tb_manager values (?,?,?,?)");
      ps.setString(1, form.getAccount());
      ps.setString(2, form.getPassword());
      ps.setString(3, form.getName());
      ps.setInt(4, 0);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //modify manager password的方法
  public void updateManagerPassword(ManagerForm form) {
    try {
      ps = connection.prepareStatement("update tb_manager set password=? where account=?");
      ps.setString(1, form.getPassword());
      ps.setString(2,form.getAccount());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }


  //delete管理员的操作
  public void deleteManager(Integer id) {
    try {
      ps = connection.prepareStatement("delete from tb_manager where id=?");
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //查询全部管理员的信息
  public List<Object> selectManager() {
    List<Object> list = new ArrayList<>();
    ManagerForm manager = null;
    try {
      ps = connection.prepareStatement("select * from tb_manager order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        manager = new ManagerForm();
        manager.setId(Integer.valueOf(rs.getString(1)));
        manager.setAccount(rs.getString(2));
        manager.setPassword(rs.getString(3));
        manager.setName(rs.getString(4));
        manager.setSigh(Integer.valueOf(rs.getString(5)));
        list.add(manager);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//以管理员账号为条件查询管理员信息
  public ManagerForm selectOne(String account) {
    ManagerForm manager = null;
    try {
      ps = connection.prepareStatement("select * from tb_manager where account=?");
      ps.setString(1, account);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        manager = new ManagerForm();
        manager.setId(Integer.valueOf(rs.getString(1)));
        manager.setAccount(rs.getString(2));
        manager.setPassword(rs.getString(3));
        manager.setName(rs.getString(4));
        manager.setSigh(Integer.valueOf(rs.getString(5)));
      }
    }
    catch (SQLException ex) {
    }
    return manager;
  }



}
