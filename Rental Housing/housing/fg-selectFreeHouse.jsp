<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.HouseForm" %>
<%@page import="java.util.List" %>
<jsp:useBean id="house" scope="page" class="com.wy.dao.HouseDao"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Rental House</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">
<%List freeList = (List) request.getAttribute("list");%>
<%
    int number = Integer.parseInt((String) request.getAttribute("number"));
    int maxPage = Integer.parseInt((String) request.getAttribute("maxPage"));
    int pageNumber = Integer.parseInt((String) request.getAttribute("pageNumber"));
    int start = number * 4;
    int over = (number + 1) * 4;
    int count = pageNumber - over;//remaining records
    if (count <= 0) {
        over = pageNumber;
    }
%>
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="207" valign="top" bgcolor="#F5F5F5">
            <!--left01-->
            <jsp:include page="fg-left.jsp" flush="true"/>
        </td>
        <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
            <jsp:include page="fg-goodSorts.jsp" flush="true"/>
            <table width="546" height="42" border="0" align="center" cellpadding="0" cellspacing="0"
                   background="image/fg_right02.jpg">
                <tr>
                    <td></td>
                </tr>
            </table>
            <%
                for (int i = start; i < over; i++) {
                    HouseForm freeHouse = (HouseForm) freeList.get(i);
            %>
            <br>
            <table width="99%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#555555"
                   bordercolorlight="#555555" bordercolordark="#819BBC">

                <tr>
                    <td width="36%" rowspan="5" height="120">
                        <div align="center">
                            <input name="picture<%=i%>" type="image" src="<%=freeHouse.getPicture()%>" width="140"
                                   height="126">
                        </div>
                    </td>
                    <td width="64%" height="30">
                        <div align="center"><%=freeHouse.getName()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="30">
                        <div align="center" style="text-decoration:line-through;color:#FF0000">Original Price: $<%=freeHouse.getNowPrice()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="30">
                        <div align="center">Special Price: $<%=freeHouse.getFreePrice()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="30">
                        <div align="center"><%=freeHouse.getIntroduce()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="30"
                        align="center"><%if (session.getAttribute("form") != null || session.getAttribute("id") != null) {%>
                        <a href="#"
                           onClick="window.open('houseAction.do?action=16&id=<%=freeHouse.getId()%>','','width=500,height=200');">Details</a>
                        <%} else {%>Sign In to Operate<%}%></td>
                </tr>
            </table>
            <%}%><br>

            <div align="center">
                <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr align="center">
                        <td width="20%">Total Pages: <%=maxPage%>  </td>
                        <td width="20%">Total Records: <%=pageNumber%>  </td>
                        <td width="20%">Current Page: <%=number + 1%>
                        </td>
                        <td width="20%"><%if ((number + 1) == 1) {%>
                            <%} else {%>
                            <a href="houseAction.do?action=15&mark=1&i=<%=number-1%>">Previous</a></td>
                        <%}%>
                        <td width="20%"><%if (maxPage <= (number + 1)) {%>
                            <%} else {%>
                            <a href="houseAction.do?action=15&mark=1&i=<%=number+1%>  ">Next</a></td>
                        <%}%>
                    </tr>
                </table>
            </div>
        </td>
    </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
