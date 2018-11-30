package com.wy.dao;

import com.wy.tool.JDBConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import com.wy.domain.OrderForm;

/**
 * operation of order
 */
public class OrderDao {
    private PreparedStatement ps = null;

    /**
     * generate a order form from the result set
     *
     * @param rs the result set
     * @return a order form
     * @throws SQLException sql exception
     */
    private OrderForm generateOrderForm(ResultSet rs) throws SQLException {
        OrderForm order = new OrderForm();
        order.setId(rs.getInt(1));
        order.setNumber(rs.getString(2));
        order.setName(rs.getString(3));
        order.setReallyName(rs.getString(4));
        order.setAddress(rs.getString(5));
        order.setTel(rs.getString(6));
        order.setMoney(rs.getString(7));
        order.setPost(rs.getString(8));
        order.setBz(rs.getString(9));
        order.setSign(String.valueOf(rs.getInt(10)));
        Timestamp timestamp = rs.getTimestamp(11);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setCreateTime(sdf.format(new Date(timestamp.getTime())));
        return order;
    }

    /**
     * query the orders with the given name
     *
     * @param name the name
     * @return a list of order form
     */
    public List<OrderForm> selectOrderHead(String name) {
        List<OrderForm> list = new ArrayList<OrderForm>();
        OrderForm order;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select * from tb_order where name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order = generateOrderForm(rs);
                list.add(order);
            }
        } catch (SQLException ignored) {
        }
        return list;
    }

    /**
     * query the order with the given number
     *
     * @param number the number
     * @return a order form
     */
    public OrderForm selectOrderNumber(String number) {

        OrderForm order = null;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select id,number,name,reallyName,address,tel,money,post,bz,sign,createTime from tb_order where number=?");
            ps.setString(1, number);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order = generateOrderForm(rs);
            }
            ps.close();
        } catch (SQLException ignored) {
        }
        return order;
    }

    /**
     * update the sign with the given number
     *
     * @param number the number
     */
    public void updateSignOrder(String number) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("update tb_order set sign=1 where number=?");
            ps.setString(1, number);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }

    }

    /**
     * delete the order with the given number
     *
     * @param number the number
     * @return true if delete successfully, false else
     */
    public boolean deleteOrder(String number) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("delete from tb_order where number=?");
            ps.setString(1, number);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * query the orders with the given id
     *
     * @param id the id
     * @return a list of the order form
     */
    public List<OrderForm> selectOrderSign(Integer id) {
        List<OrderForm> list = new ArrayList<OrderForm>();
        OrderForm order;
        try {
            if (id == null) {
                ps = JDBConnection.getInstance().prepareStatement("select id,number,name,reallyName,address,tel,money,post,bz,sign,createTime from tb_order order by id DESC");
            } else {
                ps = JDBConnection.getInstance().prepareStatement("select * from tb_order where sign=? order by id DESC");
                ps.setInt(1, id);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order = generateOrderForm(rs);
                list.add(order);
            }
        } catch (SQLException ignored) {
        }
        return list;
    }

    /**
     * insert a order into the database
     *
     * @param form the order form
     */
    public void insertOrderDetail(OrderForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("insert into tb_order(number,name,reallyName,address,tel,money,post,bz,sign,createTime) values (?,?,?,?,?,?,?,?,?,now())");
            ps.setString(1, form.getNumber());
            ps.setString(2, form.getName());
            ps.setString(3, form.getReallyName());
            ps.setString(4, form.getAddress());
            ps.setString(5, form.getTel());
            ps.setString(6, form.getMoney());
            ps.setString(7, form.getPost());
            ps.setString(8, form.getBz());
            ps.setString(9, form.getSign());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }
}
