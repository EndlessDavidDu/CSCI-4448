<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.BigTypeForm" %>
<%@page import="java.util.List" %>
<%
    @SuppressWarnings("unchecked")
    List<BigTypeForm> list = (List<BigTypeForm>) request.getAttribute("list");
    int number = Integer.parseInt((String) request.getAttribute("number"));
    int maxPage = Integer.parseInt((String) request.getAttribute("maxPage"));
    int pageNumber = Integer.parseInt((String) request.getAttribute("pageNumber"));
    int start = number * 6;//start numbers
    int over = (number + 1) * 6;//end numbers
    int count = pageNumber - over;//the remaining numbers

    if (count <= 0) {
        over = pageNumber;
    }
%>
<script lang="JavaScript">
    function deleteType(date) {
        if (confirm("Are you sure you want to delete it?")) {
            window.location = "bigTypeAction.do?action=3&id=" + date;
        }
    }
</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>back stage management system</title>

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
                        <div align="center"><strong>Big Type Querying</strong></div>
                    </td>
                </tr>
            </table>
            <br>
            <table width="90%" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
                <tr>
                    <td width="14%" height="25">
                        <div align="center">No.</div>
                    </td>
                    <td width="28%">
                        <div align="center">Type Name</div>
                    </td>
                    <td width="28%">
                        <div align="center">Create Time</div>
                    </td>
                    <td width="30%">
                        <div align="center">Operation</div>
                    </td>
                </tr>
                <%
                    for (int i = start; i < over; i++) {
                        BigTypeForm form = list.get(i);
                %>
                <tr bgcolor="#FFFFFF">
                    <td height="30">
                        <div align="center"><%=form.getId()%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><%=form.getBigName()%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><%=form.getCreaTime()%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><a href="javascript:deleteType('<%=form.getId()%>')">Delete</a></div>
                    </td>
                    <%}%></tr>
            </table>
            <br>
            <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center">
                    <td width="20%">Total Pages: <%=maxPage%>  </td>
                    <td width="20%">Total Records: <%=pageNumber%>  </td>
                    <td width="20%">Current Page: <%=number + 1%>  </td>
                    <td width="20%"><%if ((number + 1) == 1) {%>
                        <%} else {%>
                        <a href="bigTypeAction.do?action=0&i=<%=number-1%>">Previous</a></td>
                    <%}%>
                    <td width="20%"><%if (maxPage <= (number + 1)) {%>
                        <%} else {%>
                        <a href="bigTypeAction.do?action=0&i=<%=number+1%>  ">Next</a></td>
                    <%}%>
                </tr>
                <tr height="20"></tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <div><img src="image/bg-add.gif" width="9" height="9">
                            <a href="bg-bigTypeInsert.jsp">Add Big Type&nbsp;</a>
                        </div>
                    </td>
                </tr>

            </table>
            <%
                if (request.getAttribute("result") != null) {
            %>
            <P align="center"><%=request.getAttribute("result")%>
            </P>
            <%}%>
        </td>
    </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true"/>
</body>
</html>
