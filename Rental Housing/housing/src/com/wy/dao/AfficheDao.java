package com.wy.dao;

import java.sql.*;
import java.util.*;

import com.wy.tool.JDBConnection;
import com.wy.domain.AfficheForm;

/**
 * The operation of the announcement information
 */
public class AfficheDao {
    private PreparedStatement ps = null;

    public AfficheDao() {
    }


    /**
     * delete Affiche
     * @param id the id
     */
    public void deleteAffiche(Integer id) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("delete from tb_affiche where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * update affiche
     * @param form the form
     */
    public void updateAffiche(AfficheForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("update tb_affiche set name=?,content=? where id=?");
            ps.setString(1, form.getName());
            ps.setString(2, form.getContent());
            ps.setInt(3, form.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * add affiche
     * @param form the form
     */
    public void insertAffiche(AfficheForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("insert into tb_affiche(name, content, issueTime) values (?,?,now())");
            ps.setString(1, form.getName());
            ps.setString(2, form.getContent());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * Query information on the condition of database stream number
     * @param id the id
     * @return the form
     */
    public AfficheForm selectOneAffiche(Integer id) {
        AfficheForm affiche = null;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select id,name,content,issueTime from tb_affiche where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                affiche = new AfficheForm();
                affiche.setId(rs.getInt(1));
                affiche.setName(rs.getString(2));
                affiche.setContent(rs.getString(3));
                affiche.setIssueTime(rs.getString(4));
            }
        } catch (SQLException ignored) {
        }
        return affiche;
    }

    /**
     * query all
     * @return all form
     */
    public List<AfficheForm> selectAffiche() {
        List<AfficheForm> list = new ArrayList<AfficheForm>();
        AfficheForm affiche;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select id,name,content,issueTime from tb_affiche order by id DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                affiche = new AfficheForm();
                affiche.setId(rs.getInt(1));
                affiche.setName(rs.getString(2));
                affiche.setContent(rs.getString(3));
                affiche.setIssueTime(rs.getString(4));
                list.add(affiche);
            }
        } catch (SQLException ignored) {
        }
        return list;
    }

}
