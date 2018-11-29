<%@ page contentType="text/html; charset=utf-8" import="com.wy.domain.OrderDetailForm" errorPage="" %>
<%@ page import="com.wy.domain.OrderForm" %>
<%@ page import="com.wy.domain.SellHouseForm" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.wy.domain.MemberForm" %>
<jsp:useBean id="houseDao" class="com.wy.dao.HouseDao"/>
<jsp:useBean id="orderDao" class="com.wy.dao.OrderDao"/>
<jsp:useBean id="orderDetailDao" class="com.wy.dao.OrderDetailDao"/>
<jsp:useBean id="favoriteDao" class="com.wy.dao.FavoritesDao"/>
<%
    request.setCharacterEncoding("utf-8");
    OrderDetailForm orderDetail = new OrderDetailForm();
    OrderForm order = new OrderForm();
    order.setNumber(request.getParameter("number").trim());
    order.setName(request.getParameter("name"));
    order.setReallyName(request.getParameter("reallyName"));
    order.setAddress(request.getParameter("address"));
    order.setTel(request.getParameter("tel"));
    order.setMoney(request.getParameter("money"));
    order.setPost(request.getParameter("post"));
    order.setBz(request.getParameter("bz"));
    order.setSign("0");
    orderDao.insertOrderDetail(order);

    //then add order details
    @SuppressWarnings("unchecked")
    Vector<SellHouseForm> cart = (Vector<SellHouseForm>) session.getAttribute("cart");
    for (int i = 0; i < cart.size(); i++) {
        SellHouseForm form = cart.elementAt(i);
        orderDetail.setOrderNumber(order.getNumber());
        orderDetail.setHouseId(form.ID);
        orderDetail.setPrice(form.price);
        orderDetail.setNumber(form.number);
        houseDao.updateHouseNumber(form.number, form.ID);
        orderDetailDao.insertOrderDetail(orderDetail);
    }
    boolean success = favoriteDao.deleteHouse(((MemberForm) session.getAttribute("form")).getId());
    if (success && cart.size() > 0) {
        out.println("<script language='javascript'>alert('remember order number');window.location.href='cart_clear.jsp';</script>");
    } else {
        out.println("<script language='javascript'>alert('failed');window.location.href='cart_clear.jsp';</script>");
    }
%>
