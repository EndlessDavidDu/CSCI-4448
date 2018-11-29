<%@ page import="com.wy.tool.JDBConnection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page contentType="text/html; charset=utf-8" errorPage="" %>
<%
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
        String number = request.getParameter("num" + i);
        System.out.println(number);
        if (number == null) {
            break;
        }
        try {
            String[] s = number.split("_");
            int id = Integer.parseInt(s[0]);
            int num = Integer.parseInt(s[1]);
            PreparedStatement ps2 = JDBConnection.getInstance().prepareStatement("update tb_favorite set number=? where id=?");
            ps2.setInt(1, num);
            ps2.setInt(2, id);
            int update = ps2.executeUpdate();
            if (update == 1) {
                System.out.println("成功");
            }else {
                System.out.println("失败");
            }
        } catch (Exception e) {
//            out.println("<script language='javascript'>alert('illegal integer!');history.back();</script>");
            return;
        }
    }
    response.sendRedirect("cart_see.jsp");
%>
