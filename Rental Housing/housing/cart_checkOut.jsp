<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.wy.domain.MemberForm" %>
<%java.util.Date date = new java.util.Date();%>
<jsp:useBean id="dao" scope="page" class="com.wy.dao.MemberDao"/>
<%
    MemberForm form = (MemberForm) session.getAttribute("form");
%>
<html>
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
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Rental House</title>

    <style type="text/css">
        <!--
        .style1 {
            color: #FF0000;
            font-weight: bold;
        }

        -->
    </style>
</head>
<link href="css/css.css" rel="stylesheet" type="text/css">
<body>


<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="207" bgcolor="#F5F5F5">
            <!--left01-->
            <jsp:include page="fg-left.jsp" flush="true"/>
        </td>
        <td width="559" valign="top" bgcolor="#FFFFFF" align="center">
            <!--right01-->
            <jsp:include page="fg-goodSorts.jsp" flush="true"/>

            <br><br>
            <strong>Check Out</strong>
            <form name="form" method="post" action="cart_checkOutOrder.jsp" onSubmit="return checkEmpty(form)">
                <table width="60%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="30" width="30%">
                            <div align="center">Order Number:</div>
                        </td>
                        <td width="70%"><input type="hidden" name="number"
                                               value="<%=date.getTime()%>"><%=date.getTime()%>
                        </td>
                    </tr>
                    <tr>
                        <td width="24%" height="30">
                            <div align="center">User Name:</div>
                        </td>
                        <td width="76%"><input type="text" name="name" value="<%=form.getName()%>"></td>
                    </tr>
                    <tr>
                        <td height="30">
                            <div align="center">Real Name:</div>
                        </td>
                        <td><input type="text" name="reallyName" value="<%=form.getReallyName()%>"></td>
                    </tr>
                    <tr>
                        <td height="30">
                            <div align="center">Address:</div>
                        </td>
                        <td><input type="text" name="address" value=""></td>
                    </tr>
                    <tr>
                        <td height="30">
                            <div align="center">Telephone:</div>
                        </td>
                        <td><input type="text" name="tel" value=""></td>
                    </tr>
                    <tr>
                        <td height="30">
                            <div align="center">Payment:</div>
                        </td>
                        <td>
                            <select name="money" class="textarea">
                                <option value="wechat">WeChat</option>
                                <option value="alipay">AliPay</option>
                                <option value="bank">Bank</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td height="30">
                            <div align="center">Retention Time:</div>
                        </td>
                        <td>
                            <select name="post" class="textarea">
                                <option value="one hour">1 Hour</option>
                                <option value="two hour">2 Hours</option>
                                <option value="three hour">3 Hours</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td height="60">
                            <div align="center">Note:</div>
                        </td>
                        <td><textarea name="bz"></textarea></td>
                    </tr>
                </table>
                <br>
                <input type="submit" name="Submit2" value="submit">&nbsp;&nbsp;
                <input type="reset" name="reset" value="reset">&nbsp;&nbsp;
                <input type="button" name="back" value="back" onClick="javasrcipt:history.go(-1)">
            </form>
        </td>
    </tr>
</table>

<jsp:include page="fg-down.jsp" flush="true"/>

</body>
</html>
