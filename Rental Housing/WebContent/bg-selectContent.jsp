<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.wy.domain.MemberForm" %>


<%
    MemberForm form = (MemberForm) request.getAttribute("form");

%>


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
                        <div align="center"><strong>view member info</strong></div>
                    </td>
                </tr>
            </table>
            <br>

            <table width="71%" height="130" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"
                   bgcolor="#CCCCCC">
                <tr>
                    <td width="20%" height="26">
                        <div align="center">number</div>
                    </td>
                    <td width="31%" bgcolor="#FFFFFF">
                        <div align="center"><%=form.getId()%>
                        </div>
                    </td>
                    <td width="20%">
                        <div align="center">account</div>
                    </td>
                    <td width="31%" bgcolor="#FFFFFF">
                        <div align="center"><%=form.getName()%>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td height="25">
                        <div align="center">name</div>
                    </td>
                    <td bgcolor="#FFFFFF">
                        <div align="center"><%=form.getReallyName()%>
                        </div>
                    </td>
                    <td>
                        <div align="center">age</div>
                    </td>
                    <td bgcolor="#FFFFFF">
                        <div align="center"><%=form.getAge()%></div>
                    </td>
                </tr>
                <tr>
                    <td height="27">
                        <div align="center">profession</div>
                    </td>
                    <td bgcolor="#FFFFFF">
                        <div align="center"><%=form.getProfession()%>
                        </div>
                    </td>
                    <td>
                        <div align="center">email</div>
                    </td>
                    <td bgcolor="#FFFFFF">
                        <div align="center"><%=form.getEmail()%>
                        </div>
                    </td>
                </tr>


            </table>
            <table width="71%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="87%" height="29">&nbsp;</td>
                    <td width="13%"><a href="javascript:history.back();">back</a></td>
                </tr>
            </table>


</table>
<jsp:include page="bg-down.jsp" flush="true"/>


</body>
</html>
