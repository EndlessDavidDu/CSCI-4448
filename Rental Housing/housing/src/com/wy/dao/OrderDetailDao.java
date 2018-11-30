package com.wy.dao;

import com.wy.tool.JDBConnection;

import java.sql.*;
import java.util.*;

import com.wy.domain.OrderDetailForm;

/**
 * operation of order detail
 */
public class OrderDetailDao {
    private PreparedStatement ps = null;

    /**
     * query the order details with the given number
     *
     * @param number the number
     * @return a list of order details
     */
    public List<OrderDetailForm> selectOrderDetailNumber(String number) {
        List<OrderDetailForm> list = new ArrayList<OrderDetailForm>();
        OrderDetailForm orderDetail;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select id,orderNumber,houseId,price,number from tb_orderdetail where orderNumber=?");
            ps.setString(1, number);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                orderDetail = new OrderDetailForm();
                orderDetail.setId(rs.getInt(1));
                orderDetail.setOrderNumber(rs.getString(2));
                orderDetail.setHouseId(rs.getInt(3));
                orderDetail.setPrice(rs.getFloat(4));
                orderDetail.setNumber(rs.getInt(5));
                list.add(orderDetail);
            }
        } catch (SQLException ignored) {
        }
        return list;
    }

    /**
     * insert a order detail into the database
     *
     * @param form the order detail form
     */
    public void insertOrderDetail(OrderDetailForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("insert into tb_orderDetail(orderNumber,houseId,price,number) values (?,?,?,?)");
            ps.setString(1, form.getOrderNumber());
            ps.setInt(2, form.getHouseId());
            ps.setDouble(3, form.getPrice());
            ps.setInt(4, form.getNumber());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * delete a order detail with the given number
     *
     * @param number the number
     */
    public void deleteOrderDetail(String number) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("delete from tb_orderDetail where orderNumber=?");
            ps.setString(1, number);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

}
