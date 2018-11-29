<%@ page contentType="text/html; charset=utf-8" language="java" import="com.wy.domain.AfficheForm" errorPage="" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

</head>
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

    function quit() {
        if (confirm("Do not you have any plans for a reservation?")) {
            window.location.href = "loginOut.jsp";
        }
    }
</script>
<%@page import="com.wy.domain.HouseForm" %>
<%@page import="com.wy.domain.LinkForm" %>
<%@page import="com.wy.domain.MemberForm" %>
<%@page import="java.util.List" %>
<jsp:useBean id="affiche" class="com.wy.dao.AfficheDao"/>
<jsp:useBean id="house" class="com.wy.dao.HouseDao"/>
<jsp:useBean id="linkdao" class="com.wy.dao.LinkDao"/>
<%List afficheList = affiche.selectAffiche();%>
<body>
<!--left01-->
<%if (session.getAttribute("form") == null) {%>
<table width="100%" height="138" border="0" cellpadding="0" cellspacing="0" background="image/fg_left01.jpg">
    <tr>
        <td valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td height="30"></td>
                </tr>
            </table>
            <form name="form" method="post" action="memberAction.do?action=1" onSubmit="return checkEmpty(form)">
                <table width="185" border="0" align="center">
                    <tr>
                        <td width="56" height="25">Username: </td>
                        <td width="115"><input name="name" type="text" size="15"></td>
                    </tr>
                    <tr>
                        <td height="25">Password: </td>
                        <td><input name="password" type="password" size="15"></td>
                    </tr>
                    <tr>
                        <td height="26"><input type="image" class="input1" src="image/fg-land.gif" width="51"
                                               height="20"></td>
                        <td height="26"><a href="fg-memberRegister.jsp">Register</a>&nbsp;&nbsp;<a href="fg-one.jsp">Retrieve
                            Password</a></td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
<%
} else {
    MemberForm form = (MemberForm) session.getAttribute("form");
%>

<table width="100%" height="138" border="0" cellpadding="0" cellspacing="0" background="image/fg_left01.jpg">
    <tr>
        <td valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td height="30">&nbsp;</td>
                </tr>
            </table>

            <table width="167" border="0" align="center">
                <tr>
                    <td width="161" height="25"><font color="#FB6801"><%=form.getName()%>,</font>welcome back</td>
                </tr>

                <tr>
                    <td height="25">User Name: <%=form.getReallyName()%>
                    </td>
                </tr>
                <tr>
                    <td height="20" align="right" valign="middle"><a href="javascript:quit()">logging out</a></td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<%}%>
<table width="100%" height="194" border="0" background="image/fg_left02.jpg">
    <tr>
        <td valign="top">
            <table width="150" border="0">
                <tr>
                    <td height="32">&nbsp;</td>
                </tr>
            </table>
            <table width="179" border="0" align="center">
                <tr>
                    <td width="171" height="143">
                        <marquee direction="up" height="114" onmouseout="this.start()"
                                 onmouseover="this.stop()" scrollAmount="1" scrollDelay="1">
                            <%
                                for (int i = 0; i < afficheList.size(); i++) {
                                    AfficheForm afficheForm = (AfficheForm) afficheList.get(i);
                            %>
                            <img src="image/sign.gif">&nbsp;<a href="#"
                                                               onClick="window.open('fg-afficheSelect.jsp?id=<%=afficheForm.getId()%>','','width=500,height=400');"><%=afficheForm.getName()%>
                        </a><br><br>
                            <%}%>
                        </marquee>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<table width="100%" height="193" border="0" cellpadding="0" cellspacing="0" background="image/fg_left03.jpg">
    <tr>
        <td valign="top">
            <table width="194" border="0">
                <tr>
                    <td height="40">&nbsp;</td>
                </tr>
            </table>

            <%
                List houseList = house.selectHouseNumber();
                int number = houseList.size();
                if (number > 7) {
                    number = 7;
                }
                for (int account = 0; account < number; account++) {
                    HouseForm form = (HouseForm) houseList.get(account);
            %>
            <table width="178" height="19" border="0" align="center" cellpadding="0" cellspacing="0"
                   background="image/fg_left04.jpg">
                <tr>
                    <td width="14"></td>
                    <td width="164"><a
                            href="bg-sellResult.jsp?id=<%=form.getId()%>&account=<%=account+1%>"><%=account + 1%>&nbsp;&nbsp;<%=form.getName()%>
                    </a></td>
                </tr>
            </table>
            <%}%></td>
    </tr>
</table>
<table width="207" height="181" border="0" cellpadding="0" cellspacing="0" background="image/fg_left05.jpg">
    <tr>
        <td valign="top">
            <table width="173">
                <tr>
                    <td height="35">&nbsp;</td>
                </tr>
            </table>
            <table width="186" align="center">
                <tr>
                    <td height="38">
                        <MARQUEE direction="up" height="114" onmouseout="this.start()"
                                 onmouseover="this.stop()" scrollAmount="1" scrollDelay="1">
                            <%
                                List linkList = linkdao.selectLink();
                                for (int i = 0; i < linkList.size(); i++) {
                                    LinkForm linkForm = (LinkForm) linkList.get(i);
                            %>
                            <img src="image/sign1.gif">&nbsp; <a href=" <%=linkForm.getLinkAddress()%>"
                                                                 target="_blank"><%=linkForm.getLinkName()%>
                        </a><br><br>
                            <%}%>
                        </marquee>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>


</body>
</html>
