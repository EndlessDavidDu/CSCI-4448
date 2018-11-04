package com.wy.dao;

import com.wy.domain.MerchantForm;
import com.wy.syntheticDomain.MemberMerchantForm;
import com.wy.tool.JDBConnection;
import java.sql.*;
import java.util.*;
import com.wy.domain.MemberForm;

//对会员表的操作
public class MemberDao {
  private Connection connection = null;
  private PreparedStatement ps = null;
  private JDBConnection jdbc = null;
  public MemberDao() {
    jdbc = new JDBConnection();
    connection = jdbc.connection;}


//以数据库流水号为条件修改会员的密码
  public boolean updatePassword(String password, Integer id) {
    try {
      ps = connection.prepareStatement("update tb_member set password=? where id=?");
      ps.setString(1, password);
      ps.setInt(2, id);
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }
  }

//找回密码之用
  public MemberForm selectFind(String name, String result) {
    MemberForm member = null;
    try {
      ps = connection.prepareStatement("select id,name,password,reallyName,age,profession,email,question,result from tb_member where name=? and result=?");
      ps.setString(1, name);
      ps.setString(2, result);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setId(rs.getInt(1));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(rs.getInt(5));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }

  //全部查询的操作或以会员名称为条件查询信息
  public MemberForm selectMemberForm(String name) {
    MemberForm member = null;
    try {
      ps = connection.prepareStatement("select id,name,password,reallyName,age,profession,email,question,result from tb_member where name=?");
      ps.setString(1, name);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setId(rs.getInt(1));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(rs.getInt(5));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }

//delete操作
  public boolean deleteMember(Integer id) {
    try {
      ps = connection.prepareStatement("delete from tb_member where id=?");
      ps.setString(1, id.toString());
      ps.executeUpdate();
      ps.close();
      return true;
    }
    catch (SQLException ex) {
      return false;
    }
  }

  //save the information of merchant
  public void insertMerchant(MerchantForm merchantForm){
    try {
      ps = connection.prepareStatement("insert into tb_merchant values (?)");
      ps.executeUpdate();
//      ps.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

//add member information
  public void insertMember(MemberForm memberForm) {
    try {


      ps = connection.prepareStatement("insert into tb_member(name, password, reallyName, age, profession, email, question, result) values (?,?,?,?,?,?,?,?)");

      ps.setString(1, memberForm.getName());
      ps.setString(2, memberForm.getPassword());
      ps.setString(3, memberForm.getReallyName());
      ps.setString(4, memberForm.getAge().toString());
      ps.setString(5, memberForm.getProfession());
      ps.setString(6, memberForm.getEmail());
      ps.setString(7, memberForm.getQuestion());
      ps.setString(8, memberForm.getResult());

      ps.executeUpdate();


      if(memberForm.getMerchantForm()!= null){
        MemberDao memberDao =  new MemberDao();
        //save the merchant information
        memberDao.insertMerchant(memberForm.getMerchantForm());
        //change roletype
        memberDao.updateRoleType();
      }

        connection.commit();

        ps.close();
    }
    catch (SQLException ex) {
    }
  }

  //change roleType to admin
  public void updateRoleType(){
    try {
      ps = connection.prepareStatement("UPDATE  tb_member set roleType = 1");
      ps.executeUpdate();
//      ps.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  //Modify information with the database stream number as a condition
  public void updateMember(MemberForm form) {
    try {
      ps = connection.prepareStatement("update tb_member set name=?,password=?,reallyName=?,age=?,profession=?,email=?,question=?,result=?,roleType=? where id=?");
      ps.setString(1, form.getName());
      ps.setString(2, form.getPassword());
      ps.setString(3, form.getReallyName());
      ps.setString(4, form.getAge().toString());
      ps.setString(5, form.getProfession());
      ps.setString(6, form.getEmail());
      ps.setString(7, form.getQuestion());
      ps.setString(8, form.getResult());
      ps.setString(9, form.getId().toString());
//      ps.setInt(10,form.getRoleType());
      ps.executeUpdate();
      ps.close();
    }
    catch (SQLException ex) {
    }
  }



//全部查询信息操作
  public List<Object> selectMember() {
    List<Object> list = new ArrayList<>();
    MemberForm member = null;
    try {
      ps = connection.prepareStatement("select id,name,password,reallyName,age,profession,email,question,result from tb_member order by id DESC");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(Integer.valueOf(rs.getString(5)));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
        list.add(member);
      }
    }
    catch (SQLException ex) {
    }
    return list;
  }

//以数据库流水号为条件查询信息
  public MemberForm selectOneMember(Integer id) {
    MemberForm member = null;
    try {
      ps = connection.prepareStatement("select id,name,password,reallyName,age,profession,email,question,result from tb_member where id=?");
      ps.setInt(1, id.intValue());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        member = new MemberForm();
        member.setId(Integer.valueOf(rs.getString(1)));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(Integer.valueOf(rs.getString(5)));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
      }
    }
    catch (SQLException ex) {
    }
    return member;
  }




}
