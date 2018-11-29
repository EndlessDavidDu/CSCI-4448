<%@ page contentType="text/html; charset=utf-8" language="java" import="com.wy.domain.HouseForm" errorPage="" %>
<%
    HouseForm form = (HouseForm) request.getAttribute("form");

%>
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

<body>
<form name="form" method="post" action="cart_add.jsp">
    <div align="center">
        <p class="style1">View House Info</p>
    </div>
    <table width="400" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF"
           bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
        <tr>
            <td width="36%" rowspan="4" height="120">
                <div align="center">
                    <input name="picture" type="image" src="<%=form.getPicture()%>" width="110" height="100">
                </div>
            </td>
            <td width="64%" height="30">
                <div align="center">
                    <table width="71%" height="20" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td>House Name: <%=form.getName()%> <input type="hidden" name="houseId"
                                                                      value="<%=form.getId()%>"/></td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td height="30">
                <div align="center">
                    <table width="71%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td><%if (form.getMark().toString().equals("1")) {%>
                                Special Price: $<%=form.getFreePrice()%>
                                <input type="hidden" name="price" value="<%=form.getFreePrice()%>"/>
                                <%} else {%>
                                Current Price: $<%=form.getNowPrice()%>
                                <input type="hidden" name="price" value="<%=form.getNowPrice()%>"/>
                                <%}%></td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <td height="30">
                <div align="center">
                    <table width="71%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                            <td>Description: <%=form.getIntroduce()%>
                            </td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
        <tr align="center">
            <td height="30">
                <img src="image/1.jpg" onClick="window.close()">
                <input type="image" src="image/2.jpg" name="Submit" value="Add To Favorites"></td>
        </tr>
    </table>
</form>
</body>
</html>
