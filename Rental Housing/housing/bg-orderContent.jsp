<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.OrderDetailForm" %>
<%@page import="com.wy.domain.OrderForm" %>
<%@page import="java.util.List" %>
<jsp:useBean id="order" class="com.wy.dao.OrderDao"/>
<jsp:useBean id="house" class="com.wy.dao.HouseDao"/>
<jsp:useBean id="orderDetail" class="com.wy.dao.OrderDetailDao"/>
<%
    @SuppressWarnings("unchecked")
    List<OrderDetailForm> list = (List<OrderDetailForm>) request.getAttribute("orderDetailList");
    OrderForm orderForm = (OrderForm) request.getAttribute("orderForm");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>back management </title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">
<body>

<jsp:include page="bg-up.jsp" flush="true"/>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="170" valign="top">
            <jsp:include page="bg-left.jsp" flush="true"/>
        </td>
        <td width="618" align="center" valign="top" bgcolor="#FFFFFF"><br>
            <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
                <tr>
                    <td align="center"><strong>Order Number: <%=orderForm.getNumber()%> Details</strong></td>
                </tr>
            </table>
            <br>

            <table width="76%" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#DCDCDC">
                <tr align="center">
                    <td width="26%" height="25">Member Account</td>
                    <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getName()%>
                    </td>
                    <td width="26%">Member Name</td>
                    <td width="22%" bgcolor="#FFFFFF"><%=orderForm.getReallyName()%>
                    </td>
                </tr>
                <tr align="center">
                    <td height="25">Telephone</td>
                    <td bgcolor="#FFFFFF"><%=orderForm.getTel()%>
                    </td>
                    <td>Address</td>
                    <td bgcolor="#FFFFFF"><%=orderForm.getAddress()%>
                    </td>
                </tr>
                <tr align="center">
                    <td height="25">Payment</td>
                    <td bgcolor="#FFFFFF"><%=orderForm.getMoney()%>
                    </td>
                    <td>Delivery</td>
                    <td bgcolor="#FFFFFF"><%=orderForm.getPost()%>
                    </td>
                </tr>
                <tr align="center">
                    <td height="25">Note</td>
                    <td bgcolor="#FFFFFF"><%=orderForm.getBz()%>
                    </td>
                    <td>Order Time</td>
                    <td bgcolor="#FFFFFF"><%=orderForm.getCreateTime()%>
                    </td>
                </tr>
            </table>
            <br>
            <strong>House Details</strong> <br><br>
            <table width="74%" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#DCDCDC">
                <tr>
                    <td>
                        <div align="center">House Name</div>
                    </td>
                    <td>
                        <div align="center">Days</div>
                    </td>
                    <td>
                        <div align="center">Price</div>
                    </td>
                </tr>
                <%
                    float sum = 0;
                    for (OrderDetailForm form : list) {
                        sum = sum + form.getPrice() * form.getNumber();

                %>
                <tr bgcolor="#FFFFFF">
                    <td>
                        <div align="center"><%=house.selectOneHouse(form.getHouseId()).getName()%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><%=form.getNumber()%>
                        </div>
                    </td>
                    <td>
                        <div align="center">$<%=form.getPrice()%></div>
                    </td>
                </tr>
                <%}%>
            </table>
            <br>
            Total: $<%=sum%><br>
            <table width="76%" height="19" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="72%">
                        <div align="left">
                            <%if (orderForm.getSign().equals("1")) {%>
                            Checked in
                            <%} else {%>
                            Not checked
                            <%}%>
                        </div>
                    </td>
                    <td width="28%">
                        <div align="right"><a href="javascript:history.go(-1)">back</a></div>
                    </td>
                </tr>
            </table>


        </td>
    </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true"/>

</body>
</html>
