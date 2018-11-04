<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wy.domain.GoodsForm" %>
<%List newList =(List)request.getAttribute("list");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>rental house</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css"> 
<body>
<jsp:include page="fg-top.jsp" flush="true"/>
<table width="766" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="207" valign="top" bgcolor="#F5F5F5">
    <!--left01-->
    <jsp:include page="fg-left.jsp" flush="true"/></td>
    <td width="559" valign="top" bgcolor="#FFFFFF">
    <!--right01-->
	<jsp:include page="fg-goodSorts.jsp" flush="true"/>	
	
	<table width="546" height="42" border="0" align="center" cellpadding="0" cellspacing="0" background="image/fg_right01.jpg">
  <tr>
    <td>&nbsp;	</td>
    </tr>
</table>


  		        <%
              int now=6;
              if(newList.size()<6){
              now=newList.size();
              }
             
              for(int i=0;i<now;i++)
              {
                GoodsForm newGoods=(GoodsForm)newList.get(i);
                %>
		
			 
			 <br> <table width="99%" height="100"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

              <tr>
                <td width="36%" rowspan="4" height="120"><div align="center">
                  <input name="pricture<%=i%>" type="image" src="<%=newGoods.getPriture()%>" width="140" height="110">
                </div></td>
                <td width="64%" height="30"><div align="center"><%=newGoods.getName()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center">单价：<%=newGoods.getNowPrice()%>元</div></td>
              </tr>
              <tr>
                <td height="30"><div align="center"><%=newGoods.getIntroduce()%></div></td>
              </tr>
              <tr>
                <td height="30"><div align="center"> <%if(session.getAttribute("form")!=null||session.getAttribute("id")!=null){%>
               <a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=newGoods.getId()%>','','width=500,height=200');">view details</a></div>
				<%}else{%>
			    <div align="center">you can order only login in</div></td>
				<%}%>
              </tr>
            </table>
			<%}%><br>
            <table width="99%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><div align="right"><a href="#" onClick="javasrcipt:history.go(-1);">back</a></div></td>
              </tr>
            </table>




	</td>
  </tr>
</table>
<jsp:include page="fg-down.jsp" flush="true"/>
</body>
</html>
