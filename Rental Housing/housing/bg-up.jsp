<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.wy.domain.ManagerForm" %>
<%
    if (session.getAttribute("manager") == null) {
        out.print("<script language=javascript>alert('You are disconnected from the server. Please login again！');window.location.href='bg-land.jsp';</script>");
    } else {
        ManagerForm manager = (ManagerForm) session.getAttribute("manager");
%>
<table width="770" height="66" border="0" align="center" cellpadding="0" cellspacing="0" background="image/bg_01.jpg">
    <tr>
        <td valign="top">
            <table width="788" border="0" align="center">
                <tr>
                    <td width="100" height="53" valign="bottom">
                        <div align="right"></div>
                    </td>
                    <td width="700" valign="bottom" align="right"><font color="#FFFFFF"><a
                            href="houseAction.do?action=0" class="a2">Housing Query</a> | <a
                            href="bigTypeAction.do?action=0" class="a2">Big Type Query</a> | <a
                            href="smallTypeAction.do?action=0" class="a2">Small Type Query</a> | <a
                            href="orderAction.do?action=0" class="a2">Home Page</a></font></td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#000000">
    <tr>
        <td width="15" height="25">&nbsp;</td>
        <td width="579"><font color="#FFFFFF">Current User: <%=manager.getAccount()%>
        </font>
        </td>
    </tr>
</table>
<%}%>