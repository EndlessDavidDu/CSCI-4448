<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.HouseForm" %>
<%@page import="java.util.List"%>
<jsp:useBean id="house" class="com.wy.dao.HouseDao"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>rental housing</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="207" valign="top" bgcolor="#F5F5F5">
            <!--left01-->
            <jsp:include page="fg-left.jsp" flush="true"/>
        </td>
        <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
            <!--right01-->
            <jsp:include page="fg-goodSorts.jsp" flush="true"/>
            <%
                List list = house.selectHouseNumber();
                int number = list.size();
                if (number > 10) {
                    number = 10;
                }%>
            Sales rankings TOP<%=number%>
            <br><br>
            <% for (int i = 0; i < number; i++) {
                HouseForm form = (HouseForm) list.get(i);
            %>
            No. <%=i + 1%>
            <table width="99%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#555555"
                   bordercolorlight="#555555" bordercolordark="#819BBC">
                <tr>
                    <td width="36%" rowspan="4" height="84">
                        <div align="center">
                            <input name="picture<%=i%>" type="image" src="<%=form.getPicture()%>" width="110"
                                   height="100">
                        </div>
                    </td>
                    <td width="64%" height="21">
                        <div align="center"><%=form.getName()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="21">
                        <div align="center">Price: $<%=form.getNowPrice()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="21">
                        <div align="center"><%=form.getIntroduce()%>
                        </div>
                    </td>
                </tr>
                <tr>

                    <td height="21" align="center"><%if (session.getAttribute("form") != null) {%>
                        <a href="#"
                           onClick="window.open('houseAction.do?action=16&id=<%=form.getId()%>','','width=500,height=200');">Details</a>
                        <%} else {%>
                        Sign In to Operate
                    </td>
                    <%}%>
                </tr>
            </table>
            <br>
            <%}%>


        </td>
    </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
