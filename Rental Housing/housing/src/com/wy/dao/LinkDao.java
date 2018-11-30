package com.wy.dao;

import java.sql.*;
import java.util.*;

import com.wy.tool.JDBConnection;
import com.wy.domain.LinkForm;

/**
 * Operation of link
 */
public class LinkDao {
    private PreparedStatement ps = null;

    /**
     * delete the link with the given id
     * @param id the link id
     */
    public void deleteLink(Integer id) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("delete from tb_link where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * insert a link into the database
     * @param form the link form
     */
    public void insertLink(LinkForm form) {
        try {
            ps = JDBConnection.getInstance().prepareStatement("insert into tb_link(linkName, linkAddress) values (?,?)");
            ps.setString(1, form.getLinkName());
            ps.setString(2, "http://"+form.getLinkAddress());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ignored) {
        }
    }

    /**
     * query all link from the database desc by id
     * @return the list of link
     */
    public List<LinkForm> selectLink() {
        List<LinkForm> list = new ArrayList<>();
        LinkForm link;
        try {
            ps = JDBConnection.getInstance().prepareStatement("select id,linkName,linkAddress from tb_link order by id DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                link = new LinkForm();
                link.setId(rs.getInt(1));
                link.setLinkName(rs.getString(2));
                link.setLinkAddress(rs.getString(3));
                list.add(link);
            }
        } catch (SQLException ignored) {
        }
        return list;
    }

}
