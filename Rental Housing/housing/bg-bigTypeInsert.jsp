<%@ page contentType="text/html; charset=utf-8" %>
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
    <title>back management</title>
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
                        <div align="center"><strong>add big type information</strong></div>
                    </td>
                </tr>
            </table>
            <br>
            <form action="bigTypeAction.do?action=2" method="post" name="form" onSubmit="return checkEmpty(form)">
                <table width="74%" height="60" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"
                       bgcolor="#CCCCCC">
                    <tr>
                        <td width="25%" height="30">
                            <div align="center"> big type name</div>
                        </td>
                        <td width="75%" bgcolor="#FFFFFF">&nbsp;&nbsp;&nbsp;&nbsp;
                            <input name="name" type="text" size="50"></td>
                    </tr>
                </table>
                <br>
                <input type="image" class="input1" src="image/save.jpg" width="51" height="20">
                <a href="#" onClick="javascript:form.reset()"><img src="image/clear.gif"></a>
                <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
            </form>
        </td>
    </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true"/>
</body>
</html>
