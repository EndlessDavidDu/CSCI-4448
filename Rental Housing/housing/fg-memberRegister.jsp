<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Member Register</title>
</head>

<html:html>
    <link href="css/css.css" rel="stylesheet" type="text/css">
    <script language="javascript">
        function checkEmpty(memberForm) {
            var i;
            for (i = 0; i < memberForm.length; i++) {
                if (memberForm.elements[i].value === "") {
                    alert("Form information cannot be empty");
                    return false;
                }
            }
            //The newly added verification E-mail address is correct 209-05-25
            var vemail = memberForm.email.value;
            var regExp = /\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
            if (!regExp.test(vemail)) {
                window.alert("The email address you entered is incorrect！");
                return false;
            }
            if (document.memberForm.password.value !== document.memberForm.passwordOne.value) {
                window.alert("The passwords you entered are inconsistent. Please enter again");
                return false;
            }
            if (isNaN(document.memberForm.age.value)) {
                window.alert("Age is a number");
                return false;
            }
            return true;
        }
    </script>
    <body>
    <jsp:include page="fg-top.jsp" flush="true"/>
    <table width="766" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
        <tr>
            <td bgcolor="#F5F5F5" align="center">
                <img src="image/fg1.jpg" width="752" height="39">


                <html:form action="memberAction.do?action=0" onsubmit="return checkEmpty(memberForm)">

                    <table width="450" border="0" cellspacing="0" cellpadding="0" text-align="center">
                        <tr>
                            <td height="35">
                                <div align="right">User Name: </div>
                            </td>
                            <td width="220">
                                <div align="left">
                                    <html:text property="name"></html:text>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="35">
                                <div align="right">Password: </div>
                            </td>
                            <td>
                                <div align="left">
                                    <html:password property="password"></html:password>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="35">
                                <div align="right">Confirm: </div>
                            </td>
                            <td>
                                <div align="left">
                                    <input type="password" name="passwordOne">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="35">
                                <div align="right">Real Name: </div>
                            </td>
                            <td>
                                <div align="left">
                                    <html:text property="reallyName"></html:text>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="35">
                                <div align="right">Age: </div>
                            </td>
                            <td>
                                <div align="left">
                                    <html:text property="age"></html:text>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="35">
                                <div align="right">Profession: </div>
                            </td>
                            <td>
                                <div align="left">
                                    <html:text property="profession"></html:text>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="35">
                                <div align="right">Email: </div>
                            </td>
                            <td>
                                <div align="left">
                                    <html:text property="email"></html:text>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="35">
                                <div align="right">Retrieve Password Problem: </div>
                            </td>
                            <td>
                                <div align="left">
                                    <html:text property="question"></html:text>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td height="35">
                                <div align="right">Answer: </div>
                            </td>
                            <td>
                                <div align="left">
                                    <html:text property="result"></html:text>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td height="35">
                                <div align="right">Merchant Name2: </div>
                            </td>
                            <td>
                                <div align="left">
                                    <html:text property="merchantForm.merchantName"></html:text>
                                </div>
                            </td>
                        </tr>

                    </table>
                    <br>
                    <input type="image" class="input1" src="image/save.jpg" width="51" height="20">
                    &nbsp;&nbsp;
                    <a href="#" onClick="javascript:memberForm.reset()"><img src="image/clear.gif"></a>
                    &nbsp;&nbsp;
                    <a href="#" onClick="javasrcipt:history.go(-1)"><img src="image/back.gif"></a>
                </html:form>


                <p>&nbsp; </p></td>
        </tr>
    </table>
    <jsp:include page="fg-down.jsp" flush="true"/>
    </body>
</html:html>
