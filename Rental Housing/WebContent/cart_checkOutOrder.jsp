<%@ page contentType="text/html; charset=gb2312" language="java" import="com.wy.domain.OrderDetailForm" errorPage="" %>
<%@ page import="com.wy.domain.OrderForm" %>
<%@ page import="com.wy.domain.SellGoodsForm" %>
<%@ page import="java.util.Vector" %>
<jsp:useBean id="goodsDao" scope="page" class="com.wy.dao.GoodsDao"/>
<jsp:useBean id="orderDao" scope="page" class="com.wy.dao.OrderDao"/>
<jsp:useBean id="orderDetailDao" scope="page" class="com.wy.dao.OrderDetailDao"/>
<%
    request.setCharacterEncoding("gb2312");
    OrderForm order = new OrderForm();
    OrderDetailForm orderDetail = new OrderDetailForm();
    SellGoodsForm sellGoodsForm = new SellGoodsForm();
    String number = request.getParameter("number").trim();
//add order firset
    order.setNumber(number);
    order.setName(request.getParameter("name"));
    order.setReallyName(request.getParameter("reallyName"));
    order.setAddress(request.getParameter("address"));
    order.setTel(request.getParameter("tel"));
    order.setSetMoney(request.getParameter("setMoney"));
    order.setPost(request.getParameter("post"));
    order.setBz(request.getParameter("bz"));
    order.setSign("0");
    orderDao.insertOrderDetail(order);

//then add order details
    Vector cart = (Vector) session.getAttribute("cart");
    for (int i = 0; i < cart.size(); i++) {
        SellGoodsForm form = (SellGoodsForm) cart.elementAt(i);
        orderDetail.setOrderNumber(number);
        orderDetail.setGoodsId(new Integer(form.ID));
        orderDetail.setPrice(form.price);
        orderDetail.setNumber(form.number);
        goodsDao.updateGoodsNumber(form.number, new Integer(form.ID));
        orderDetailDao.insertOrderDetail(orderDetail);
    }
    out.println("<script language='javascript'>alert('remember order number');window.location.href='cart_clear.jsp';</script>");
%>
