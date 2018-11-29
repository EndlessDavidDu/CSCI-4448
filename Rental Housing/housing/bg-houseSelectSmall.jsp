<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="com.wy.domain.HouseForm" %>
<jsp:useBean id="big" scope="page" class="com.wy.dao.BigTypeDao"/>
<jsp:useBean id="small" scope="page" class="com.wy.dao.SmallTypeDao"/>
<%
    List list = (List) request.getAttribute("list");
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
    function deleteType(date) {
        if (confirm("are you sure to delete?")) {
            window.location = "bigTypeAction.do?action=3&id=" + date;
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
        <td width="618" align="center" valign="top" bgcolor="#FFFFFF"><br>

            <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
                <tr>
                    <td>
                        <div align="center"><strong>by small type information</strong></div>
                    </td>
                </tr>
            </table>
            <br>
            <table width="90%" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
                <tr>
                    <td width="14%" height="25">
                        <div align="center">Number</div>
                    </td>
                    <td width="19%">
                        <div align="center">House Name</div>
                    </td>
                    <td width="14%">
                        <div align="center">Big Type</div>
                    </td>
                    <td width="14%">
                        <div align="center">Small Type</div>
                    </td>
                    <td width="14%">
                        <div align="center">Special Price</div>
                    </td>
                    <td width="25%">
                        <div align="center">Operation</div>
                    </td>
                </tr>
                <%
                    for (int i = start; i < over; i++) {
                        HouseForm form = (HouseForm) list.get(i);

                %>
                <tr bgcolor="#FFFFFF">
                    <td height="30">
                        <div align="center"><%=form.getId()%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><a href="<%=form.getPicture()%>" target="_blank"><%=form.getName()%>
                        </a></div>
                    </td>

                    <td>
                        <div align="center"><%=big.selectName(form.getBig())%>
                        </div>
                    </td>

                    <td>
                        <div align="center"><%=small.selectName(form.getSmall())%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><%if (form.getMark().toString().equals("0")) {%>No<%} else {%>Yes<%}%></div>
                    </td>
                    <td>
                        <div align="center">
                            <a href="houseAction.do?action=5&id=<%=form.getId()%>">Details</a>
                        </div>
                    </td>
                    <%}%></tr>
            </table>
            <br>
            <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center">
                    <td width="20%">Total Pages: <%=maxPage%>
                    </td>
                    <td width="20%">Total Records: <%=pageNumber%>
                    </td>
                    <td width="20%">Current Page: <%=number + 1%>
                    </td>
                    <td width="20%"><%if ((number + 1) == 1) {%>
                        <%} else {%>
                        <a href="houseAction.do?action=8&i=<%=number-1%>&small=<%=request.getParameter("small")%>">
                            Previous</a>
                    </td>
                    <%}%>
                    <td width="20%"><%if(maxPage<=(number+1)){%>
                            <%}else{%>
                        <a href="houseAction.do?action=8&i=<%=number+1%>  &small=<%=request.getParameter("small")%>">Next</a>
                            <%}%>
                </tr>
            </table>


        </td>
    </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true"/>


</body>
</html>
