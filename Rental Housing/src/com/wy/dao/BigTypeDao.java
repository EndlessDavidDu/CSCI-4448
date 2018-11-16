package com.wy.dao;

import com.wy.tool.JDBConnection;
import java.sql.*;
import java.util.*;
import com.wy.domain.BigTypeForm;

//����Ʒ big type ��Ϣ�Ĳ���
public class BigTypeDao {
  private Connection connection = null;
  private PreparedStatement ps = null;
  private JDBConnection jdbc = null;
  public BigTypeDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection;}

//�����ݿ���ˮ��Ϊ������ѯ big type ������
  public String selectName(Integer id) {
    String name = null;
    try {
      this.ps = connection.prepareStatement("select * from tb_bigType where id=?");
      ps.setString(1, id.toString());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        name = rs.getString("bigName");
      }
    }
    catch (SQLException ex) {
    }
    return name;
  }

//delete����
  public boolean deleteBig(Integer id) {
    try {
      ps = connection.prepareStatement("delete from tb_bigType where id=?");
      ps.setString(1, id.toString());
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }
  }


  //��Ӳ���
  public void insertBig(String name) {
    try {
      ps = connection.prepareStatement("insert into tb_bigType values (?,getDate())");
      ps.setString(1, name);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //ȫ����ѯ�Ĳ���
  public List<Object> selectBig() {
    List<Object> list = new ArrayList<>();
    BigTypeForm big = null;
    try {
      this.ps = connection.prepareStatement("select * from tb_bigType order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        big = new BigTypeForm();
        big.setId(Integer.valueOf(rs.getString(1)));
        big.setBigName(rs.getString(2));
        big.setCreaTime(rs.getString(3));
        list.add(big);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

}
