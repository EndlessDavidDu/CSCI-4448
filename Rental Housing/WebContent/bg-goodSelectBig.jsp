<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.wy.domain.GoodsForm" %>
<%@page import="java.util.List" %>
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
        if (confirm("//are you sure to delete?£¿")) {
            window.location = "bigTypeAction.do?action=3&id=" + date;
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
                        <div align="center"><strong>Inquiry by large category commodity information</strong></div>
                    </td>
                </tr>
            </table>
            <br>
            <table width="90%" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
                <tr>
                    <td width="14%" height="25">
                        <div align="center">number</div>
                    </td>
                    <td width="19%">
                        <div align="center">house name</div>
                    </td>
                    <td width="14%">
                        <div align="center"> big type</div>
                    </td>
                    <td width="14%">
                        <div align="center">small type</div>
                    </td>
                    <td width="14%">
                        <div align="center">whether special price</div>
                    </td>
                    <td width="25%">
                        <div align="center">operation</div>
                    </td>
                </tr>
                <%
                    for (int i = start; i < over; i++) {
                        GoodsForm form = (GoodsForm) list.get(i);

                %>
                <tr bgcolor="#FFFFFF">
                    <td height="30">
                        <div align="center"><%=form.getId()%>
                        </div>
                    </td>
                    <td>
                        <div align="center"><a href="<%=form.getPriture()%>" target="_blank"><%=form.getName()%>
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
                        <div align="center"><%if (form.getMark().toString().equals("0")) {%>no<%} else {%>yes<%}%></div>
                    </td>
                    <td>
                        <div align="center"><a href="goodsAction.do?action=5&id=<%=form.getId()%>">details</a>


                        </div>
                    </td>
                    <%}%></tr>
            </table>
            <br>
            <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center">
                    <td width="20%">Total  <%=maxPage%>  page</td>
                    <td width="25%">Total  <%=pageNumber%>  records</td>
                    <td width="14%">This is <%=number + 1%>  page</td>
                    <td width="25%"><%if ((number + 1) == 1) {%>
                        previous page
                        <%} else {%>

                        <a href="goodsAction.do?action=9&i=<%=number-1%>&big=<%=request.getParameter("big")%>">
                            previous page</a></td>
                    <%}%>
                    <td width="18%"><%if(maxPage<=(number+1)){%>
                        next page
                            <%}else{%>

                        <a href="goodsAction.do?action=9&i=<%=number+1%>  &big=<%=request.getParameter("big")%>">next
                            page</a>
                            <%}%>


                </tr>
            </table>


        </td>
    </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true"/>


</body>
</html>
