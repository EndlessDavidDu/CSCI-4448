<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.HouseForm" %>
<%@page import="java.util.List" %>
<jsp:useBean id="houseDao" class="com.wy.dao.HouseDao"/>
<%List nowList = houseDao.selectMark(0);%>
<%List freeList = houseDao.selectMark(1);%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>index</title>
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
            <div align="center">
                <%if (session.getAttribute("form") != null) {%>
                <br>
                <img src="image/fg_right02.jpg">
            </div>
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#555555"
                   bordercolorlight="#555555" bordercolordark="#819BBC">
                <tr>
                    <%
                        int free = 2;
                        if (freeList.size() < 2) {
                            free = freeList.size();
                        }

                        for (int i = 0; i < free; i++) {
                            HouseForm newHouse = (HouseForm) freeList.get(i);
                    %>
                    <td valign="top">
                        <table width="257" height="136" border="1" align="center" cellpadding="1" cellspacing="1"
                               bordercolor="#FFFFFF" bgcolor="#999999">
                            <tr>
                                <td width="33%" height="80" rowspan="5" bgcolor="#FFFFFF"><input name="picture<%=i%>"
                                                                                                 type="image"
                                                                                                 src="<%=newHouse.getPicture()%>"
                                                                                                 width="140"
                                                                                                 height="126"></td>
                                <td width="67%" height="20" bgcolor="#FFFFFF">
                                    <div align="center"><%=newHouse.getName()%>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td height="20" bgcolor="#FFFFFF">
                                    <div align="center" style="text-decoration:line-through;color:#910402">Original
                                        Price: $<%=newHouse.getNowPrice()%>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td height="20" bgcolor="#FFFFFF">
                                    <div align="center"><font color="#F14D83">Current
                                        Price: $<%=newHouse.getFreePrice()%>
                                    </font></div>
                                </td>
                            </tr>
                            <tr>
                                <td height="20" bgcolor="#FFFFFF">
                                    <div align="center"><%=newHouse.getIntroduce()%>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td height="13" bgcolor="#FFFFFF">
                                    <div align="center" class="linkBlack">
                                        <a href="#" onClick="window.open('houseAction.do?action=16&id=<%=newHouse.getId()%>','','width=500,height=200');">Details</a>
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <%}%>
                </tr>
            </table>


            <div align="center">
                <%}%>
                <img src="image/fg_right01.jpg">
            </div>
            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td height="215" valign="top">
                        <%
                            int now = 5;
                            if (nowList.size() < 5) {
                                now = nowList.size();
                            }
                            if (session.getAttribute("form") != null) {
                                now = 3;
                            }
                            for (int i = 0; i < Math.min(nowList.size(), now); i++) {
                                HouseForm newHouse = (HouseForm) nowList.get(i);
                        %>
                        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0"
                                           bordercolor="#CCCCCC">
                                        <tr>
                                            <td height="150" bordercolor="#666666">
                                                <table width="96%" border="1" align="center" cellpadding="1"
                                                       cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
                                                    <tr>
                                                        <td width="36%" rowspan="4" bgcolor="#FFFFFF">
                                                            <div align="center">
                                                                <input name="picture<%=i%>" type="image"
                                                                       src="<%=newHouse.getPicture()%>" width="110"
                                                                       height="100">
                                                            </div>
                                                        </td>
                                                        <td width="64%" bgcolor="#FFFFFF">
                                                            <div align="center"><%=newHouse.getName()%>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td bgcolor="#FFFFFF">
                                                            <div align="center"><font
                                                                    color="#F14D83">Price: $<%=newHouse.getNowPrice()%>
                                                            </font></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td bgcolor="#FFFFFF">
                                                            <div align="center"><%=newHouse.getIntroduce()%>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td bgcolor="#FFFFFF" class="linkBlack" align="center">
                                                            <%if (session.getAttribute("form") != null || session.getAttribute("id") != null) {%>
                                                            <a href="#"
                                                               onClick="window.open('houseAction.do?action=16&id=<%=newHouse.getId()%>','','width=500,height=200');">Details</a>
                                                            <%} else {%>
                                                            Sign In to Operate
                                                        </td>
                                                        <%}%>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <%}%>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<jsp:include page="fg-down.jsp" flush="true"/>

</body>
</html>
