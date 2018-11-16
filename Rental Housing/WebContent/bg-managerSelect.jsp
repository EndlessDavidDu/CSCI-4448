<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.wy.domain.ManagerForm" %>
<%@page import="java.util.List" %>
<%
    List list = (List) request.getAttribute("list");
    ManagerForm manager = (ManagerForm) session.getAttribute("manager");
    int sigh = manager.getSigh().intValue();
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
<script Language="JavaScript">
    function deleteManager(date) {
        if (confirm("//are you sure to delete?��")) {
            window.location = "managerAction.do?action=4&id=" + date;
        }
    }
</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
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
                        <div align="center"><strong>manager info</strong></div>
                    </td>
                </tr>
            </table>
            <br>
            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="20%" height="20" colspan="4">
                        <div align="right"><a href="bg-managerUpdatePassword.jsp">modify your password</a>&nbsp;&nbsp;&nbsp;
                        </div>
                    </td>
                <tr>
            </table>
            <table width="90%" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
                <tr>
                    <td width="20%" height="25">
                        <div align="center">number</div>
                    </td>
                    <td width="20%">
                        <div align="center">username</div>
                    </td>
                    <td width="20%">
                        <div align="center">realname</div>
                    </td>
                    <td width="44%">
                        <div align="center">operation</div>
                    </td>
                </tr>
                <%
                    for (int i = start; i < over; i++) {
                        ManagerForm form = (ManagerForm) list.get(i);
                %>
                <tr bgcolor="#FFFFFF">
                    <td height="30">
                        <div align="center"><%=form.getId()%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><%=form.getAccount()%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><%=form.getName()%>
                        </div>
                    </td>
                    <td>
                        <div align="center">
                            <%if (form.getSigh() != 1) { %>
                            <a href="javascript:deleteManager('<%=form.getId()%>')">delete</a>
                            <% } else {%>delete<%}%>
                        </div>
                    </td>
                </tr>
                <%}%>
            </table>
            <br>
            <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center">
                    <td width="20%">Total  <%=maxPage%>  page</td>
                    <td width="25%">Total  <%=pageNumber%>  records</td>
                    <td width="14%">This is <%=number + 1%>  page</td>
                    <td width="25%"><%if ((number + 1) == 1) {%> previous page<%} else {%><a
                            href="managerAction.do?action=1&i=<%=number-1%>">previous page</a></td>
                    <%}%>
                    <td width="18%"><%if (maxPage <= (number + 1)) {%>next page<%} else {%><a
                            href="managerAction.do?action=1&i=<%=number+1%>  ">next page</a></td>
                    <%}%>
                    <%if (sigh == 1) {%>
                    <td width="20%">
                        <div align="right"><a href="bg-managerInsert.jsp">add manager</a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    </td>
                    <%} else {%><%}%>

                </tr>
            </table>

                <%
if(request.getAttribute("reslut")!=null){
%>
            <P align="center"><%=request.getAttribute("reslut")%>
            </P>
                <%}%>


</table>
<jsp:include page="bg-down.jsp" flush="true"/>
</body>
</html>
