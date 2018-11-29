<%@ page import="com.wy.domain.MemberForm" %>
<%@ page contentType="text/html; charset=utf-8"  %>
<jsp:useBean id="cartDao" class="com.wy.dao.FavoritesDao"/>
<%
    cartDao.deleteHouse(((MemberForm) session.getAttribute("form")).getId());
    response.sendRedirect("cart_see.jsp");
%>
