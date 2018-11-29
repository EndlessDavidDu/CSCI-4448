<%@ page contentType="text/html; charset=utf-8" language="java" import="com.wy.domain.SellHouseForm" errorPage="" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.wy.tool.JDBConnection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.wy.domain.MemberForm" %>
<%
    int houseID = Integer.parseInt(request.getParameter("houseId"));
    float housePrice = Float.parseFloat(request.getParameter("price"));
    SellHouseForm sellHouseForm = new SellHouseForm();
    sellHouseForm.ID = houseID;
    PreparedStatement ps = JDBConnection.getInstance().prepareStatement("select id,number from tb_favorite where houseID=? and memberID=?");
    ps.setInt(1, houseID);
    int memberID = ((MemberForm) session.getAttribute("form")).getId();
    ps.setInt(2, memberID);
    ResultSet rs = ps.executeQuery();
    int number = 0;
    int id = 0;
    if (rs.next()) {
        id = rs.getInt(1);
        number = rs.getInt(2);
    }
    ps.close();
    number++;
    boolean flag = false;
    if (id == 0) {
        // do insert
        ps = JDBConnection.getInstance().prepareStatement("insert into tb_favorite(houseID,memberID,number) values(?,?,?)");
        ps.setInt(1, houseID);
        ps.setInt(2, memberID);
        ps.setInt(3, number);
        ps.execute();
        flag = true;
    } else if (id > 0) {
        // do update
        ps = JDBConnection.getInstance().prepareStatement("update tb_favorite set number=? where id=?");
        ps.setInt(1, number);
        ps.setInt(2, id);
        int update = ps.executeUpdate();
        flag = (update == 1);
    }
    if (flag) {
        out.println("<script language='javascript'>alert('add successfully!');window.close();</script>");
    } else {
        out.println("<script language='javascript'>alert('add failed!');window.close();</script>");
    }

//    sellHouseForm.price = housePrice;
//    sellHouseForm.number = 1;
//    boolean flag = true;
//    @SuppressWarnings("unchecked")
//    Vector<SellHouseForm> cart = (Vector<SellHouseForm>) session.getAttribute("cart");
//    if (cart == null) {
//        cart = new Vector<SellHouseForm>();
//    } else {
//        for (int i = 0; i < cart.size(); i++) {
//            SellHouseForm form = cart.elementAt(i);
//            if (form.ID == sellHouseForm.ID) {
//                form.number++;
//                cart.setElementAt(form, i);
//                flag = false;
//            }
//        }
//    }
//
//    if (flag)
//        cart.add(sellHouseForm);
//    session.setAttribute("cart", cart);


%>
