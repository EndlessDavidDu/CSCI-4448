package com.wy.dao;

import com.wy.domain.MerchantForm;
import com.wy.syntheticDomain.MemberMerchantForm;
import com.wy.tool.JDBConnection;

import java.sql.*;
import java.util.*;

import com.wy.domain.MemberForm;

/**
 * operation of member
 */
public class MemberDao {
    private PreparedStatement ps = null;

    /**
     * update the member's password
     *
     * @param password the password
     * @param id       the member's id
     * @return true if successfully, false else
     */
    public boolean updatePassword(String password, Integer id) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("update tb_member set password=? where id=?");
            ps.setString(1, password);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    /**
     * generate a member form from the result set
     *
     * @param rs the result set
     * @return a member form
     * @throws SQLException sql exception
     */
    private MemberForm generateMemberForm(ResultSet rs) throws SQLException {
        MemberForm member = new MemberForm();
        member.setId(rs.getInt(1));
        member.setName(rs.getString(2));
        member.setPassword(rs.getString(3));
        member.setReallyName(rs.getString(4));
        member.setAge(rs.getInt(5));
        member.setProfession(rs.getString(6));
        member.setEmail(rs.getString(7));
        member.setQuestion(rs.getString(8));
        member.setResult(rs.getString(9));
        return member;
    }

    /**
     * query a member from the database with the given name
     *
     * @param name   the name
     * @param result the result
     * @return a member form
     */
    public MemberForm selectFind(String name, String result) {
        MemberForm member = null;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select id,name,password,reallyName,age,profession,email,question,result from tb_member where name=? and result=?");
            ps.setString(1, name);
            ps.setString(2, result);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                member = generateMemberForm(rs);
            }
        } catch (SQLException ignored) {
        }
        return member;
    }

    /**
     * query a member from the database with the given name
     *
     * @param name the given name
     * @return a member form
     */
    public MemberForm selectMemberForm(String name) {
        MemberForm member = null;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select id,name,password,reallyName,age,profession,email,question,result from tb_member where name=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                member = generateMemberForm(rs);
            }
        } catch (SQLException ignored) {
        }
        return member;
    }

    /**
     * delete the member with the given id
     *
     * @param id the member's id
     * @return true if successfully, false else
     */
    public boolean deleteMember(Integer id) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("delete from tb_member where id=?");
            ps.setString(1, id.toString());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }


    /**
     * save the information of merchant
     *
     * @param merchantForm the merchant form
     */
    public void insertMerchant(MerchantForm merchantForm) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("insert into tb_merchant(merchantName) values (?)");
            ps.setString(1, merchantForm.getMerchantName());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {

        }
    }

    /**
     * add member information
     *
     * @param memberForm the member form
     */
    public void insertMember(MemberForm memberForm) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("insert into tb_member(name, password, reallyName, age, profession, email, question, result) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, memberForm.getName());
            ps.setString(2, memberForm.getPassword());
            ps.setString(3, memberForm.getReallyName());
            ps.setString(4, memberForm.getAge().toString());
            ps.setString(5, memberForm.getProfession());
            ps.setString(6, memberForm.getEmail());
            ps.setString(7, memberForm.getQuestion());
            ps.setString(8, memberForm.getResult());
            ps.executeUpdate();
            if (memberForm.getMerchantForm() != null) {
                MemberDao memberDao = new MemberDao();
                //save the merchant information
                memberDao.insertMerchant(memberForm.getMerchantForm());
            }
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * Modify information with the database stream number as a condition
     *
     * @param form the member form
     */
    public void updateMember(MemberForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("update tb_member set name=?,password=?,reallyName=?,age=?,profession=?,email=?,question=?,result=?,roleType=? where id=?");
            ps.setString(1, form.getName());
            ps.setString(2, form.getPassword());
            ps.setString(3, form.getReallyName());
            ps.setString(4, form.getAge().toString());
            ps.setString(5, form.getProfession());
            ps.setString(6, form.getEmail());
            ps.setString(7, form.getQuestion());
            ps.setString(8, form.getResult());
            ps.setString(9, form.getId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * query all member from the database
     *
     * @return a list of members
     */
    public List<Object> selectMember() {
        List<Object> list = new ArrayList<>();
        MemberForm member;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select id,name,password,reallyName,age,profession,email,question,result from tb_member order by id DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                member = generateMemberForm(rs);
                list.add(member);
            }
        } catch (SQLException ignored) {
        }
        return list;
    }

    /**
     * query the member with the given id
     *
     * @param id the member id
     * @return a member form
     */
    public MemberForm selectOneMember(Integer id) {
        MemberForm member = null;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select id,name,password,reallyName,age,profession,email,question,result from tb_member where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                member = generateMemberForm(rs);
            }
        } catch (SQLException ignored) {
        }
        return member;
    }
}
