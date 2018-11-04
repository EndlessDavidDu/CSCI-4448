package com.wy.dao;

import java.sql.*;
import java.util.*;

import com.wy.tool.JDBConnection;
import com.wy.domain.LinkForm;

//对友情连接网站表的操作
public class LinkDao {
  private Connection connection = null;
  private PreparedStatement ps = null;
  private JDBConnection jdbc = null;
  public LinkDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection;}

  //delete的方法
  public void deleteLink(Integer id) {
    try {
      ps = connection.prepareStatement("delete from tb_link where id=?");
      ps.setInt(1, id.intValue());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }



//添加的方法
  public void insertLink(LinkForm form) {
    try {
      ps = connection.prepareStatement("insert into tb_link values (?,?)");
      ps.setString(1, form.getLinkName());
      ps.setString(2, form.getLinkAddress());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }




//全部查询的方法
  public List<Object> selectLink() {
    List<Object> list = new ArrayList<>();
    LinkForm link = null;
    try {
      ps = connection.prepareStatement("select * from tb_link order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        link = new LinkForm();
        link.setId(Integer.valueOf(rs.getString(1)));
        link.setLinkName(rs.getString(2));
        link.setLinkAddress(rs.getString(3));
        list.add(link);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

}
