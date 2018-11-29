<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.wy.domain.OrderDetailForm" %>
<%@ page import="com.wy.domain.OrderForm" %>
<%@ page import="com.wy.domain.MemberForm" %>
<jsp:useBean id="order" class="com.wy.dao.OrderDao"/>
<jsp:useBean id="orderDetail" class="com.wy.dao.OrderDetailDao"/>
<jsp:useBean id="houseDao" class="com.wy.dao.HouseDao"/>
<jsp:useBean id="member" class="com.wy.dao.MemberDao"/>
<%MemberForm form = (MemberForm) session.getAttribute("form");%>
<%MemberForm memberForm = member.selectOneMember(form.getId());%>
<%List<OrderForm> orderList = order.selectOrderHead(memberForm.getName());%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Rental House</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="207" bgcolor="#F5F5F5">
            <!--left01-->
            <jsp:include page="fg-left.jsp" flush="true"/>
        </td>
        <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
            <!--right01-->
            <jsp:include page="fg-goodSorts.jsp" flush="true"/>

            <br>
            <strong>Order Views</strong>
            <br>
            <br>
            <%if (orderList.size() == 0) {%>
            No Order Information
            <%} else {%>
            <table width="96%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#555555"
                   bordercolorlight="#555555" bordercolordark="#819BBC">

                <tr align="center">
                    <td width="16%" height="21">No.</td>

                    <td width="16%">Telephone</td>
                    <td width="22%">Address</td>
                    <td width="20%">Order Time</td>
                    <td width="13%">Check In</td>
                    <td width="13%">Operation</td>
                </tr>
                <%
                    for (OrderForm anOrderList : orderList) {
                %>
                <tr align="center">
                    <td height="24"><%=anOrderList.getNumber()%>
                    </td>

                    <td><%=anOrderList.getTel()%>
                    </td>
                    <td><%=anOrderList.getAddress()%>
                    </td>

                    <td><%=anOrderList.getCreateTime()%>
                    </td>
                    <td><%if (anOrderList.getSign().equals("0")) {%>
                        No<%} else {%>Yes<%}%>
                    </td>
                    <td><a href="cart_detail.jsp?number=<%=anOrderList.getNumber()%>">Details</a></td>
                </tr>
                <%}%>
            </table>
            <div align="center">
                <br>
                <%if (request.getParameter("number") != null) {%>
                <br>
                <b>Details</b>
                <br>
                <br>

                <table width="89%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#555555"
                       bordercolorlight="#555555" bordercolordark="#819BBC">

                    <tr align="center">
                        <td width="25%" height="21">No.</td>
                        <td width="24%">House Name</td>
                        <td width="28%">House Price</td>
                        <td width="23%">Lease Days</td>
                    </tr>
                    <%
                        float sum = 0;
                        List orderDetailList = orderDetail.selectOrderDetailNumber(request.getParameter("number"));
                        for (Object anOrderDetailList : orderDetailList) {
                            OrderDetailForm orderDetailForm = (OrderDetailForm) anOrderDetailList;
                            sum = sum + orderDetailForm.getPrice() * orderDetailForm.getNumber();
                    %>
                    <tr align="center">
                        <td height="21"><%=orderDetailForm.getOrderNumber()%>
                        </td>
                        <td><%=houseDao.selectOneHouse(orderDetailForm.getHouseId()).getName()%>
                        </td>
                        <td>$<%=orderDetailForm.getPrice()%>
                        </td>
                        <td><%=orderDetailForm.getNumber()%>
                        </td>
                    </tr>
                    <%}%>
                </table>
                <br>
                <table width="89%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="24">
                            <div align="right">Total: $<%=sum%>
                            </div>
                        </td>
                    </tr>
                </table>
                <%}%>
            </div>
            <%}%>
        </td>
    </tr>
</table>

<jsp:include page="fg-down.jsp" flush="true"/>

</body>
</html>
