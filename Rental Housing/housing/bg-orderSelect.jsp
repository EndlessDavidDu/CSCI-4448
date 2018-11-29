<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.OrderForm" %>
<%@page import="java.util.List" %>
<%
    @SuppressWarnings("unchecked")
    List<OrderForm> list = (List<OrderForm>) request.getAttribute("list");
    int number = Integer.parseInt((String) request.getAttribute("number"));
    int maxPage = Integer.parseInt((String) request.getAttribute("maxPage"));
    int pageNumber = Integer.parseInt((String) request.getAttribute("pageNumber"));
    int start = number * 6;
    int over = (number + 1) * 6;
    int count = pageNumber - over;//remaining records
    if (count <= 0) {
        over = pageNumber;
    }
%>
<script Language="JavaScript">
    function deleteOrder(date) {
        if (confirm("are you sure to delete?")) {
            window.location = "orderAction.do?action=2&number=" + date;
        }
    }
</script>

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
        <td width="618" align="center" valign="top" bgcolor="#FFFFFF">
            <br>
            <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
                <tr>
                    <td>
                        <div align="center"><strong>Order Querying</strong></div>
                    </td>
                </tr>
            </table>
            <br>
            <table width="96%" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="CCCCCC">

                <tr bgcolor="#DCDCDC">
                    <td width="20%" height="25">
                        <div align="center">No.</div>
                    </td>
                    <td width="14%">
                        <div align="center">Real Name</div>
                    </td>

                    <td width="11%">
                        <div align="center">Check</div>
                    </td>
                    <td width="26%">
                        <div align="center">Order time</div>
                    </td>
                    <td width="29%">
                        <div align="center">Operation</div>
                    </td>
                </tr>
                <%
                    for (int i = start; i < over; i++) {
                        OrderForm form = list.get(i);
                %>
                <tr align="center" bgcolor="#FFFFFF">
                    <td height="25"><%=form.getNumber()%>
                    </td>
                    <td><%=form.getReallyName()%>
                    </td>

                    <td><%if (form.getSign().equals("0")) {%>
                        <a href="orderAction.do?action=0&sign=<%=form.getSign()%>">No</a>
                        <%} else {%>
                        <a href="orderAction.do?action=0&sign=<%=form.getSign()%>">Yes</a>
                        <%}%></td>
                    <td><%=form.getCreateTime()%>
                    </td>
                    <td><a href="orderAction.do?action=3&number=<%=form.getNumber()%>">Details</a>
                        <%if (form.getSign().equals("1")) {%>
                        Checked
                        <%} else if (request.getParameter("sign") == null) {%>
                        <a href="orderAction.do?action=1&number=<%=form.getNumber()%>">Check</a>
                        <%} else {%>
                        <a href="orderAction.do?action=1&sign=<%=request.getParameter("sign")%>&number=<%=form.getNumber()%>">Check</a>
                        <%}%>
                        <a href="javascript:deleteOrder('<%=form.getNumber()%>')">Delete</a></td>
                </tr>
                <%}%>
            </table>
            <br>
            <%if (request.getParameter("sign") == null) {%>
            <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center">
                    <td width="20%">Total Pages: <%=maxPage%>  </td>
                    <td width="20%">Total Records: <%=pageNumber%>  </td>
                    <td width="20%">Current Page: <%=number + 1%>  </td>
                    <td width="20%"><%if ((number + 1) == 1) {} else {%><a
                            href="orderAction.do?action=0&i=<%=number-1%>">Previous</a></td>
                    <%}%>
                    <td width="20%"><%if (maxPage <= (number + 1)) {} else {%><a
                            href="orderAction.do?action=0&i=<%=number+1%>  ">Next</a></td>
                    <%}%>
                </tr>
            </table>
            <%} else {%>
            <table width="96%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center">
                    <td width="20%">Total Page: <%=maxPage%>  </td>
                    <td width="20%">Total Records: <%=pageNumber%>  </td>
                    <td width="20%">Current Page: <%=number + 1%>  </td>
                    <td width="20%"><%if ((number + 1) == 1) {} else {%><a
                            href="orderAction.do?action=0&i=<%=number-1%>&sign=<%=request.getParameter("sign")%>">Previous</a></td>
                    <%}%>
                    <td width="20%"><%if (maxPage <= (number + 1)) {} else {%><a
                            href="orderAction.do?action=0&i=<%=number+1%>  &sign=<%=request.getParameter("sign")%>">Next</a></td>
                    <%}%>

                </tr>
                <tr height="20"></tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td width="20%"><a href="orderAction.do?action=0">back</a></td>
                </tr>
            </table>


            <%}%></td>
    </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true"/>

</body>
</html>
