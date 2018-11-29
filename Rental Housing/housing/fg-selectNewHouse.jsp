<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.HouseForm" %>
<%@page import="java.util.List" %>
<%List newList = (List) request.getAttribute("list");%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>rental house</title>
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
        <td width="559" valign="top" bgcolor="#FFFFFF">
            <!--right01-->
            <jsp:include page="fg-goodSorts.jsp" flush="true"/>

            <table width="546" height="42" border="0" align="center" cellpadding="0" cellspacing="0"
                   background="image/fg_right01.jpg">
                <tr>
                    <td>&nbsp;</td>
                </tr>
            </table>
            <%
                int now = 6;
                if (newList.size() < 6) {
                    now = newList.size();
                }

                for (int i = 0; i < now; i++) {
                    HouseForm newHouse = (HouseForm) newList.get(i);
            %>


            <br>
            <table width="99%" height="100" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#555555"
                   bordercolorlight="#555555" bordercolordark="#819BBC">

                <tr>
                    <td width="36%" rowspan="4" height="120">
                        <div align="center">
                            <input name="picture<%=i%>" type="image" src="<%=newHouse.getPicture()%>" width="140"
                                   height="110">
                        </div>
                    </td>
                    <td width="64%" height="30">
                        <div align="center"><%=newHouse.getName()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="30">
                        <div align="center">Price/Day: $<%=newHouse.getNowPrice()%></div>
                    </td>
                </tr>
                <tr>
                    <td height="30">
                        <div align="center"><%=newHouse.getIntroduce()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="30">
                        <div align="center"><%if (session.getAttribute("form") != null || session.getAttribute("id") != null) {%>
                            <a href="#"
                               onClick="window.open('houseAction.do?action=16&id=<%=newHouse.getId()%>','','width=500,height=200');">Details</a></div>
                        <%} else {%>
                        <div align="center">Sign In to Operate</div>
                    </td>
                    <%}%>
                </tr>
            </table>
            <%}%><br>
        </td>
    </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
