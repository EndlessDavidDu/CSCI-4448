package com.wy.dao;

import com.wy.tool.JDBConnection;
import java.sql.*;
import java.util.*;
import com.wy.domain.OrderDetailForm;

//订货明细表的操作
public class OrderDetailDao {
  private Connection connection = null;
  private PreparedStatement ps = null;
  private JDBConnection jdbc = null;
  public OrderDetailDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection;}
public List<Object> selectOrderDetailNumber(String number){
  List<Object> list =new ArrayList<>();
  OrderDetailForm orderDetail=null;
  try {
    ps = connection.prepareStatement("select * from tb_orderDetail where orderNumber=?");
    ps.setString(1,number);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
      orderDetail=new OrderDetailForm();
      orderDetail.setId(Integer.valueOf(rs.getString(1)));
      orderDetail.setOrderNumber(rs.getString(2));
      orderDetail.setGoodsId(Integer.valueOf(rs.getString(3)));
      orderDetail.setPrice(Float.parseFloat(rs.getString(4)));
      orderDetail.setNumber(Integer.parseInt(rs.getString(5)));
      list.add(orderDetail);
    }
  }
  catch (SQLException ex) {
  }
    return list;
}


//添加的方法
  public void insertOrderDetail(OrderDetailForm form) {
    try {
      ps = connection.prepareStatement("insert into tb_orderDetail values (?,?,?,?)");
      ps.setString(1, form.getOrderNumber());
      ps.setString(2, form.getGoodsId().toString());
      ps.setFloat(3, form.getPrice());
      ps.setInt(4, form.getNumber());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //delete子表的操作
  public void deleteOrderDetail(String number){
    try {
      ps = connection.prepareStatement("delete from tb_orderDetail where orderNumber=?");
      ps.setString(1,number);
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }


  }

}
