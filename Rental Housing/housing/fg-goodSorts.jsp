<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.BigTypeForm" %>
<%@page import="java.util.List" %>
<jsp:useBean id="big" class="com.wy.dao.BigTypeDao"/>
<%List<BigTypeForm> bigList = big.selectBig();%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<table height="25" border="0" cellpadding="0" cellspacing="0" align="center">
    <tr>
        <td align="center">
            <%
                for (BigTypeForm aBigList : bigList) {
            %>
            <a href="houseAction.do?action=12&big=<%=aBigList.getId()%>"><%=aBigList.getBigName()%>
            </a>&nbsp;&nbsp;
            <%}%>
        </td>
    </tr>
</table>
