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
        if (isNaN(document.form.free.value)) {
            window.alert("Prices can only be in Numbers");
            return false;
        }
        if (document.form.free.value === document.form.now.value) {
            window.alert("The price you entered should be equal to the previous special price！");
            return false;
        }
        if (document.form.free.value - document.form.now.value > 0) {
            window.alert("The price you entered should be higher than the previous special price！");
            return false;
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
                        <div align="center"><strong>Set Special Price House</strong></div>
                    </td>
                </tr>
            </table>
            <br>

            <form name="form" method="post" action="houseAction.do?action=11&id=<%=houseForm.getId()%>&mark=1"
                  onSubmit="return checkEmpty(form)">
                <table width="90%" height="233" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF"
                       bgcolor="#CCCCCC">
                    <tr>
                        <td width="20%" height="26">Big Type</td>
                        <td width="31%" bgcolor="#FFFFFF">&nbsp;&nbsp;<%=big.selectName(houseForm.getBig())%>
                        </td>
                        <td width="20%">Small Type</td>
                        <td width="31%" bgcolor="#FFFFFF">&nbsp;&nbsp;<%=small.selectName(houseForm.getSmall())%>
                        </td>
                    </tr>
                    <tr>
                        <td height="26">House Name</td>
                        <td bgcolor="#FFFFFF">&nbsp;&nbsp;<%=houseForm.getName()%>
                        </td>
                        <td>Merchant</td>
                        <td bgcolor="#FFFFFF">&nbsp;&nbsp;<%=houseForm.getFrom()%>
                        </td>
                    </tr>
                    <tr>
                        <td height="26">House Price</td>
                        <td bgcolor="#FFFFFF">
                            <input name="now" type="hidden"
                                   value="<%=houseForm.getNowPrice()%>">$<%=houseForm.getNowPrice()%>
                        </td>
                        <td>Special Price</td>
                        <td bgcolor="#FFFFFF">
                            <%if (houseForm.getMark().toString().equals("0")) {%>No<%} else {%>Yes<%}%></td>
                    </tr>
                    <tr>
                        <td height="23">House Description</td>
                        <td bgcolor="#FFFFFF"><%=houseForm.getIntroduce()%>
                        </td>
                        <td>Special Price</td>
                        <td bgcolor="#FFFFFF">
                            &nbsp;
                            <input name="free" type="text" size="12">
                            <input type="submit" name="Submit" value="submit"></td>
                    </tr>
                    <tr>
                        <td height="79">House Pictures</td>
                        <td colspan="3" bgcolor="#FFFFFF">&nbsp;&nbsp;
                            <input name="imageField" type="image" src="<%=houseForm.getPicture()%>" width="140"
                                   height="126"></td>
                    </tr>
                </table>
            </form>
            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="87%" height="29" align="right"></td>
                    <td width="13%"><a href="javascript:history.back();">back</a></td>
                </tr>
            </table>


        </td>
    </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true"/>


</body>
</html>
