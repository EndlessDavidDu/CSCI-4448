<%@ page contentType="text/html; charset=utf-8" %>

<%@page import="com.wy.domain.HouseForm" %>
<jsp:useBean id="big" scope="page" class="com.wy.dao.BigTypeDao"/>
<jsp:useBean id="small" scope="page" class="com.wy.dao.SmallTypeDao"/>
<%
    HouseForm houseForm = (HouseForm) request.getAttribute("form");

%>

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

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Back Management </title>
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
                        <div align="center"><strong>Check Details</strong></div>
                    </td>
                </tr>
            </table>
            <br>

            <table width="90%" height="209" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"
                   bgcolor="#CCCCCC">
                <tr>
                    <td width="20%" height="26">Big Type</td>
                    <td width="31%" bgcolor="#FFFFFF"> <%=big.selectName(houseForm.getBig())%>
                    </td>
                    <td width="20%">Small Type</td>
                    <td width="31%" bgcolor="#FFFFFF"> <%=small.selectName(houseForm.getSmall())%>
                    </td>
                </tr>
                <tr>
                    <td height="26">House Name</td>
                    <td bgcolor="#FFFFFF"> <%=houseForm.getName()%>
                    </td>
                    <td>Merchant</td>
                    <td bgcolor="#FFFFFF"> <%=houseForm.getFrom()%>
                    </td>
                </tr>
                <tr>
                    <td height="26">House Price</td>
                    <td bgcolor="#FFFFFF"> $<%=houseForm.getNowPrice()%></td>
                    <td>Special Price</td>
                    <td bgcolor="#FFFFFF"> $<%=houseForm.getFreePrice()%></td>
                </tr>
                <tr>
                    <td height="26">Details</td>
                    <td colspan="3" bgcolor="#FFFFFF"> <%=houseForm.getIntroduce()%>
                    </td>
                </tr>
                <tr>
                    <td height="79">House Pictures</td>
                    <td colspan="3" bgcolor="#FFFFFF">
                        <input name="imageField" type="image" src="<%=houseForm.getPicture()%>" width="140"
                               height="126"></td>
                </tr>
            </table>
            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                <tr><%String mark = houseForm.getMark().toString();%>
                    <td width="30%" height="29" align="right">
                        <%if (mark.equals("0")) {%>
                        <%} else {%>
                        <a href="houseAction.do?action=11&id=<%=houseForm.getId()%>&mark=0">Delete</a>
                        <%}%>
                    </td>

                    <td width="50%" align="right">
                        <%if (mark.equals("0")) {%>
                        <a href="houseAction.do?action=10&id=<%=houseForm.getId()%>">Set Special Price House</a>
                        <%} else {%>
                        <a href="houseAction.do?action=10&id=<%=houseForm.getId()%>">Adjust Special Price House</a>
                        <%}%>
                        &nbsp;&nbsp;
                    </td>
                    <td width="20%" align="right"><a href="javascript:history.back();">back</a></td>
                </tr>
            </table>


        </td>
    </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true"/>
</body>
</html>
