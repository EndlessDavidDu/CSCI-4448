<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.wy.domain.ManagerForm" %>
<jsp:useBean id="dao" scope="page" class="com.wy.dao.ManagerDao"/>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
    ManagerForm form = (ManagerForm) session.getAttribute("manager");
%>
<script language="javascript">
    function checkEmpty(form) {
        for (i = 0; i < form.length; i++) {
            if (form.elements[i].value == "") {
                alert("Form information cannot be empty");
                return false;
            }
        }
        if (document.form.selectPassword.value != document.form.old.value) {
            window.alert("You entered the original password is not correct, please re-enter");
            return false;
        }
        if (document.form.password.value != document.form.passwordNext.value) {
            window.alert("The passwords you entered are inconsistent. Please enter again");
            return false;
        }

        return true;
    }
</script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>back management </title>
</head>

<html:html>
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
                            <div align="center"><strong>modify manager password</strong></div>
                        </td>
                    </tr>
                </table>
                <br>
                <form name="form" method="post" action="managerAction.do?action=8&account=<%=form.getAccount()%>"
                      onSubmit="return checkEmpty(form)">
                    <table width="60%" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"
                           bgcolor="#CCCCCC">
                        <tr><input name="selectPassword" type="hidden" value="<%=form.getPassword()%>">
                            <td width="29%" height="30">
                                <div align="center">old password</div>
                            </td>
                            <td width="71%" bgcolor="#FFFFFF">&nbsp;
                                <input name="old" type="password" size="30"></td>
                        </tr>
                        <tr>
                            <td height="30">
                                <div align="center">new password</div>
                            </td>
                            <td bgcolor="#FFFFFF">&nbsp;
                                <input name="password" type="password" size="30"></td>
                        </tr>
                        <tr>
                            <td height="30">
                                <div align="center">repeat</div>
                            </td>
                            <td bgcolor="#FFFFFF">&nbsp;
                                <input name="passwordNext" type="password" size="30"></td>
                        </tr>
                    </table>
                    <p>
                        <input type="image" class="input1" src="image/save.jpg" width="51" height="20">
                        &nbsp;&nbsp;
                        <a href="#" onClick="javascript:form.reset()"><img src="image/clear.gif"></a>
                        &nbsp;&nbsp;
                        <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
                    </p>
                </form>


                        <%
if(request.getAttribute("reslut")!=null){
%>
                <P align="center"><%=request.getAttribute("reslut")%>
                </P>
                <meta http-equiv="refresh" content="3;URL=loginOut.jsp">
                        <%}%>
    </table>
    <jsp:include page="bg-down.jsp" flush="true"/>


    </body>
</html:html>
