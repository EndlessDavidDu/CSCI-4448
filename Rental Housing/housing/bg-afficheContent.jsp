<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.AfficheForm" %>
<%AfficheForm affiche = (AfficheForm) request.getAttribute("affiche");%>
<script lang="javascript">
    function checkEmpty(form) {
        var i;
        for (i = 0; i < form.length; i++) {
            if (form.elements[i].value === "") {
                alert("Form information cannot be empty");
                return false;
            }
        }
        return true;
    }
</script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Back Management</title>
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
                        <div align="center"><strong>View Bulletin</strong></div>
                    </td>
                </tr>
            </table>
            <br>

            <table width="90%" height="243" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"
                   bgcolor="#CCCCCC">
                <tr>
                    <td width="23%" height="30">
                        <div align="center">Bulletin Name</div>
                    </td>
                    <td width="77%" bgcolor="#FFFFFF">&nbsp;<%=affiche.getName()%>
                    </td>
                </tr>
                <tr>
                    <td width="23%" height="208">
                        <div align="center">Content</div>
                    </td>
                    <td width="77%" bgcolor="#FFFFFF">&nbsp;<%=affiche.getContent()%>
                    </td>
                </tr>
            </table>

            <table width="82%" height="30" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td>&nbsp;</td>
                    <td>
                        <div align="right"><a href="javascript:history.go(-1)">back</a></div>
                    </td>
                </tr>
            </table>

        </td>
    </tr>
</table>

<jsp:include page="bg-down.jsp" flush="true"/>


</body>
</html>
