<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.wy.domain.HouseForm" %>
<%@ page import="com.wy.domain.MemberForm" %>
<%@ page import="com.wy.tool.JDBConnection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.Vector" %>
<%@ page import="com.wy.domain.SellHouseForm" %>
<jsp:useBean id="dao" class="com.wy.dao.HouseDao"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>rental house</title>

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
            <strong>My Favorites</strong>
            <div align="center"><br>
            </div>

            <form method="post" action="cart_modify.jsp" name="form">
                <table width="92%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#555555"
                       bordercolorlight="#555555" bordercolordark="#819BBC">
                    <tr bgcolor="#F5F5F5">
                        <td width="16%" height="28">
                            <div align="center">No.</div>
                        </td>
                        <td width="23%">
                            <div align="center">House Name</div>
                        </td>
                        <td width="22%">
                            <div align="center">Price/Day</div>
                        </td>
                        <td width="22%">
                            <div align="center">Days</div>
                        </td>
                        <td width="17%">
                            <div align="center">Total Price</div>
                        </td>
                    </tr>
                    <%
                        float sum = 0;
                        int i = 0;
                        PreparedStatement ps;
                        try {
                            ps = JDBConnection.getInstance().prepareStatement("select id,houseID,number from tb_favorite where memberID=?");
                            int memberID = ((MemberForm) session.getAttribute("form")).getId();
                            ps.setInt(1, memberID);
                            ResultSet rs = ps.executeQuery();
                            Vector<SellHouseForm> vector = new Vector<>();
                            while (rs.next()) {
                                SellHouseForm sellHouseForm = new SellHouseForm();
                                int id = rs.getInt(1);
                                int houseID = rs.getInt(2);
                                int number = rs.getInt(3);


                                HouseForm form = dao.selectOneHouse(houseID);
                                sum += number * form.getNowPrice();

                                sellHouseForm.ID = houseID;
                                sellHouseForm.number = number;
                                sellHouseForm.price = form.getNowPrice();
                                vector.add(sellHouseForm);
                                System.out.print("sum=" + sum);
                    %>
                    <tr>
                        <td height="28">
                            <div align="center"><%=i + 1%>
                            </div>
                        </td>
                        <td>
                            <div align="center"><%=dao.selectOneHouse(form.getId()).getName()%>
                            </div>
                        </td>
                        <td>
                            <div align="center">$<%=form.getNowPrice()%>
                            </div>
                        </td>
                        <td>
                            <div align="center"><input name="rnum<%=i%>" size="7" type="text" value="<%=number%>"
                                                       onBlur="check(this.form)">
                                <input hidden name="num<%=i%>" size="7" type="text">
                            </div>
                        </td>
                        <td>
                            <div align="center">$<%=number * form.getNowPrice()%>
                            </div>
                        </td>
                    </tr>
                    <script language="javascript">
                        <!--
                        function check(myform) {
                            if (isNaN(myform.rnum<%=i%>.value) || myform.rnum<%=i%>.value.indexOf('.', 0) !== -1) {
                                alert("Please do not enter illegal characters");
                                myform.rnum<%=i%>.focus();
                                return;
                            }
                            if (myform.rnum<%=i%>.value === "") {
                                alert("Please enter the number of changes");
                                myform.rnum<%=i%>.focus();
                                return;
                            }
                            myform.num<%=i%>.value = <%=id%>+"_" + myform.rnum<%=i%>.value;
                            myform.submit();
                        }

                        -->
                    </script>
                    <%
                                i++;
                                session.setAttribute("cart", vector);
                            }
                        } catch (Exception e) {
                        }
                    %>
                </table>

            </form>

            <table width="100%" height="52" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr align="center" valign="middle">
                    <td height="10">&nbsp;</td>
                    <td width="24%" height="10" colspan="-3" align="left">&nbsp;</td>
                </tr>
                <tr align="center" valign="middle">
                    <td height="21" class="tableBorder_B1">&nbsp;</td>
                    <td height="21" colspan="-3" align="left">total price: $<%=sum%>
                    </td>
                </tr>
                <tr align="center" valign="middle">
                    <td height="21" colspan="2"><a href="index.jsp">go on</a> | <a href="cart_checkOut.jsp">check
                        out</a> | <a href="cart_clear.jsp">clear</a></td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<jsp:include page="fg-down.jsp" flush="true"/>


</body>
</html>
