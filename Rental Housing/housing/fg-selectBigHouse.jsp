<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.HouseForm" %>
<%@page import="java.util.List" %>
<%List bigList = (List) request.getAttribute("list");%>
<%List smallList = (List) request.getAttribute("smallList");%>
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
        <td width="559" valign="top" bgcolor="#FFFFFF">
            <!--right01-->
            <jsp:include page="fg-goodSorts.jsp" flush="true"/>

            <%if (bigList.size() == 0) {%>
            <br><br><br>
            <center>No House Information</center>
            <br><br><br>
            <%} else {%>
            <%
                for (int i = start; i < over; i++) {
                    HouseForm bigForm = (HouseForm) bigList.get(i);
            %>
            <br>
            <table width="67%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF"
                   bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
                <tr>
                    <td width="36%" rowspan="4" height="120"><input name="picture<%=i%>" type="image"
                                                                    src="<%=bigForm.getPicture()%>" width="140"
                                                                    height="126"></td>
                    <td width="64%" height="30">
                        <div align="center"><%=bigForm.getName()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="30">
                        <div align="center">
                            <%if (bigForm.getMark().toString().equals("0")) {%>
                            Price/Day: $<%=bigForm.getNowPrice()%>
                            <%} else {%>
                            <font color="#FF0000">Special Price: $<%=bigForm.getFreePrice()%>
                            </font>
                            <%}%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="30">
                        <div align="center"><%=bigForm.getIntroduce()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="30">
                        <div align="center"><%if (session.getAttribute("form") != null || session.getAttribute("id") != null) {%>
                            <a href="#"
                               onClick="window.open('houseAction.do?action=16&id=<%=bigForm.getId()%>','_self','width=500,height=200');">Details</a>
                            <%} else {%>
                            Sign In to Operate
                            <%}%>
                        </div>
                    </td>
                </tr>
            </table>
            <%
                    }
                }
            %><br>
            <%if (bigList.size() != 0) {%>
            <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center">
                    <td width="20%">Total Pages: <%=maxPage%> </td>
                    <td width="20%">Total Records: <%=pageNumber%> </td>
                    <td width="20%">Current Page: <%=number + 1%>
                    </td>
                    <td width="20%"><%if ((number + 1) == 1) {%>
                        <%} else {%>
                        <a href="houseAction.do?action=12&big=<%=request.getParameter("big")%>&i=<%=number-1%>">
                            Previous
                        </a>
                    </td>
                    <%}%>
                    <td width="20%"><%if (maxPage <= (number + 1)) {%>
                        <%} else {%>
                        <a href="houseAction.do?action=12&big=<%=request.getParameter("big")%>&i=<%=number+1%>">
                            Next
                        </a>
                    </td>
                    <%}%>
                </tr>
            </table>
            <%}%>
        </td>
    </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
