<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.AfficheForm" %>
<%@page import="java.util.List" %>
<%
    @SuppressWarnings("unchecked")
    List<AfficheForm> list = (List<AfficheForm>) request.getAttribute("list");
    int number = Integer.parseInt((String) request.getAttribute("number"));
    int maxPage = Integer.parseInt((String) request.getAttribute("maxPage"));
    int pageNumber = Integer.parseInt((String) request.getAttribute("pageNumber"));
    int start = number * 7;
    int over = (number + 1) * 7;
    int count = pageNumber - over;//remaining records
    if (count <= 0) {
        over = pageNumber;
    }
%>
<script lang="JavaScript">
    function deleteAffiche(date) {
        if (confirm("are you sure to delete?")) {
            window.location = "afficheAction.do?action=3&id=" + date;
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
                        <div align="center"><strong>query bulletin</strong></div>
                    </td>
                </tr>
            </table>
            <br>

            <table width="90%" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
                <tr>
                    <td width="20%" height="25">
                        <div align="center">No.</div>
                    </td>
                    <td width="25%">
                        <div align="center">Bulletin Name</div>
                    </td>
                    <td width="25%">
                        <div align="center">Publish Time</div>
                    </td>
                    <td width="30%">
                        <div align="center">Operation</div>
                    </td>
                </tr>
                <%
                    for (int i = start; i < over; i++) {
                        AfficheForm form = list.get(i);
                %>
                <tr bgcolor="#FFFFFF">
                    <td height="30">
                        <div align="center"><%=form.getId()%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><%=form.getName()%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><%=form.getIssueTime()%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><a href="afficheAction.do?action=4&id=<%=form.getId()%>">Modify</a>&nbsp;&nbsp;<a
                                href="afficheAction.do?action=6&id=<%=form.getId()%>">Query</a>&nbsp;&nbsp;<a
                                href="javascript:deleteAffiche('<%=form.getId()%>')">Delete</a></div>
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
                        <a href="afficheAction.do?action=0&i=<%=number-1%>">Previous</a></td>
                    <%}%>
                    <td width="20%"><%if (maxPage <= (number + 1)) {%>
                        <%} else {%>
                        <a href="afficheAction.do?action=0&i=<%=number+1%>  ">Next</a></td>
                    <%}%>
                </tr>
                <tr height="20"></tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <img src="image/bg-add.gif" width="9" height="9">
                        <a href="bg-afficheInsert.jsp">Add Bulletin</a>
                    </td>
                </tr>
            </table>

        </td>
    </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true"/>

</body>
</html>
