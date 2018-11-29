<%@ page contentType="text/html; charset=utf-8" language="java" import="com.wy.domain.AfficheForm" errorPage="" %>
<jsp:useBean id="dao" scope="page" class="com.wy.dao.AfficheDao"/>
<%AfficheForm form = dao.selectOneAffiche(Integer.valueOf(request.getParameter("id")));%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/css.css">
    <title></title>
    <style type="text/css">
        body {
            background-color: #fafafa;
        }
        td {
            font-size: 9pt;
            color: #F0F0F0;
        }
        .style1 {
            color: #FF9900;
            font-weight: bold;
        }
    </style>
</head>

<body bgcolor="#FFC7C6">
<table width="400" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF">
    <tr>
        <td height="39" colspan="2">
            <p align="center" class="style1">Bulletin Information</td>
    </tr>

    <tr>
        <td width="31%" height="37">
            <div align="center"><font size="5">Title:  </font></div>
        </td>
        <td width="69%"><font size="5"><%=form.getName()%>
        </font></td>
    </tr>
    <tr>
        <td width="31%" height="32">
            <div align="center">Bulletin Content: </div>
        </td>
        <td width="69%" height="32"><%=form.getContent()%>
        </td>
    </tr>

    <tr>
        <td width="31%" height="27">
            <div align="center">Publish Time: </div>
        </td>
        <td width="69%" height="27"><%=form.getIssueTime()%>
        </td>
    </tr>

    <tr>
        <td height="27" colspan="2" align="center">
            <input type="button" name="wclose" value="close window" onClick="window.close()">
        </td>
    </tr>
</table>

</body>
</html>
