<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.wy.domain.MemberForm" %>
<jsp:useBean id="dao" scope="page" class="com.wy.dao.MemberDao"/>
<%
    request.setCharacterEncoding("utf-8");
    MemberForm form = dao.selectMemberForm(request.getParameter("name"));%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>rental house</title>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
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
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
    <tr>
        <td bgcolor="#FFFFFF" align="center">
            <img src="image/fg2.jpg" width="752" height="45">


            <%if (form == null || form.getName().equals("")) {%>
            <p><strong>No Existing！</strong></p>
            <meta http-equiv="refresh" content="3;URL=fg-One.jsp">
            <%} else {%>
            <p><strong>Enter The Answer</strong></p>
            <form name="form" method="post" action="fg-three.jsp" onSubmit="return checkEmpty(form)">
                <table width="298" border="0" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF"
                       bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
                    <tr>
                        <td width="105" height="35">
                            <div align="right">Question:</div>
                        </td>
                        <td width="187">
                            <div align="left">
                                <input type="hidden" name="name" value="<%=form.getName()%>">
                                <input type="hidden" name="question" value="<%=form.getQuestion()%>">
                                <%=form.getQuestion()%>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td width="105" height="35">
                            <div align="right">Question:</div>
                        </td>
                        <td width="187">
                            <div align="left">
                                <input type="text" name="result">
                            </div>
                        </td>
                    </tr>
                </table>
                <br>
                <input type="image" class="input1" src="image/save.jpg" width="51" height="20">
                <a href="#" onClick="javascript:form.reset()"><img src="image/clear.gif"></a>
                <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
            </form>
            <%}%>
        </td>
    </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
