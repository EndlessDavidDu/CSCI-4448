package com.wy.dao;

import com.wy.tool.JDBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Operations on the merchandise list
 */
public class FavoritesDao {
    private PreparedStatement ps = null;

    /**
     * delete the house from the favorite table
     * @param memberID the memberID
     * @return true if delete successfully, false else
     */
    public boolean deleteHouse(Integer memberID) {
        boolean flag = false;
        try {
            ps = JDBConnection.getInstance().prepareStatement("delete from tb_favorite where memberID=?");
            ps.setInt(1, memberID);
            int i = ps.executeUpdate();
            flag = (i > 0);
            ps.close();
        } catch (SQLException ignored) {
        }
        return flag;
    }

}
