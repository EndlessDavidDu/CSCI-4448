<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.wy.domain.AfficheForm" %>
<%@page import="java.util.List" %>
<%
    List<Object> list = (List<Object>) request.getAttribute("list");
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
        if (confirm("//are you sure to delete?？")) {
            window.location = "afficheAction.do?action=3&id=" + date;
        }
    }
</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>back management </title>
    <style type="text/css">
        <!--
        .style1 {
            color: #5F5F5F
        }

        -->
    </style>
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
                    <td width="17%" height="25">
                        <div align="center">number</div>
                    </td>
                    <td width="19%">
                        <div align="center">bulletion name</div>
                    </td>
                    <td width="27%">
                        <div align="center">publish time</div>
                    </td>
                    <td width="37%">
                        <div align="center">operation</div>
                    </td>
                </tr>
                <%
                    for (int i = start; i < over; i++) {
                        AfficheForm form = (AfficheForm) list.get(i);
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
                        <div align="center"><a href="afficheAction.do?action=4&id=<%=form.getId()%>">modify</a>&nbsp;&nbsp;<a
                                href="afficheAction.do?action=6&id=<%=form.getId()%>">query</a>&nbsp;&nbsp;<a
                                href="javascript:deleteAffiche('<%=form.getId()%>')">delete</a></div>
                    </td>
                    <%}%></tr>
            </table>
            <br>
            <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center">
                    <td width="20%">Total  <%=maxPage%>  pages</td>
                    <td width="25%">Total  <%=pageNumber%>  records</td>
                    <td width="14%">This is<%=number + 1%>  page</td>
                    <td width="25%"><%if ((number + 1) == 1) {%>
                        previous page
                        <%} else {%>
                        <a href="afficheAction.do?action=0&i=<%=number-1%>">previous page</a></td>
                    <%}%>
                    <td width="18%"><%if (maxPage <= (number + 1)) {%>
                        next page
                        <%} else {%>
                        <a href="afficheAction.do?action=0&i=<%=number+1%>  ">next page</a></td>
                    <%}%>

                    <td width="20%">&nbsp;
                        <a href="bg-afficheInsert.jsp"><img src="image/bg-add.gif" width="9" height="9">&nbsp;Add
                            Bulletin</a></td>

                </tr>
            </table>

        </td>
    </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true"/>


</body>
</html>
