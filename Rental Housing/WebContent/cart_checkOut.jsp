<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="com.wy.domain.MemberForm" %>
<%java.util.Date date = new java.util.Date();%>
<jsp:useBean id="dao" scope="page" class="com.wy.dao.MemberDao"/>
<%

    MemberForm form = (MemberForm) session.getAttribute("form");
%>
<html>
<script language="javascript">
    function checkEmpty(form) {
        for (i = 0; i < form.length; i++) {
            if (form.elements[i].value == "") {
                alert("Form information cannot be empty");
                return false;
            }
        }

    }
</script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>rental house</title>

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
            <strong>check out</strong>
            <form name="form" method="post" action="cart_checkOutOrder.jsp" onSubmit="checkEmpty(form)">
                <table width="68%" border="0" cellspacing="0" cellpadding="0">

                    <tr>
                        <td height="30">
                            <div align="center">order number：</div>
                        </td>
                        <td>&nbsp;<input type="hidden" name="number" value="<%=date.getTime()%>"><%=date.getTime()%>
                        </td>
                    </tr>
                    <tr>
                        <td width="24%" height="30">
                            <div align="center">username：</div>
                        </td>
                        <td width="76%">&nbsp;<input type="text" name="name" value="<%=form.getName()%>"></td>
                    </tr>
                    <tr>
                        <td height="30">
                            <div align="center">realname：</div>
                        </td>
                        <td>&nbsp;<input type="text" name="reallyName" value="<%=form.getReallyName()%>"></td>
                    </tr>
                    <tr>
                        <td height="30">
                            <div align="center">address：</div>
                        </td>
                        <td>&nbsp;<input type="text" name="address"></td>
                    </tr>
                    <tr>
                        <td height="30">
                            <div align="center">telephone：</div>
                        </td>
                        <td>&nbsp;<input type="text" name="tel"></td>
                    </tr>
                    <tr>
                        <td height="30">
                            <div align="center">pay method：</div>
                        </td>
                        <td>&nbsp;
                            <select name="setMoney" class="textarea">
                                <option value="">choose</option>
                                <option value="wechat">wechat</option>
                                <option value="alipay">alipay</option>
                                <option value="bank">bank</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td height="30">
                            <div align="center"> retention time：</div>
                        </td>
                        <td>&nbsp;<select name="post" class="textarea">
                            <option value="">choose</option>
                            <option value="one hour">one hour</option>
                            <option value="two hour">two hour</option>
                            <option value="three hour">three hour</option>
                        </select>

                        </td>
                    </tr>
                    <tr>
                        <td height="60">
                            <div align="center">note：</div>
                        </td>
                        <td>&nbsp;<textarea name="bz"></textarea></td>
                    </tr>
                </table>
                <br>

                <input type="submit" name="Submit2" value="submit">&nbsp;
                <input type="reset" name="reset" value="reset">&nbsp;
                <input type="button" name="back" value="back" onClick="javasrcipt:history.go(-1)">
            </form>


        </td>
    </tr>
</table>

<jsp:include page="fg-down.jsp" flush="true"/>


</body>
</html>
