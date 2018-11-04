<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.wy.domain.SmallTypeForm"%>
<jsp:useBean id="big" scope="page" class="com.wy.dao.BigTypeDao"/>
<%
List list=(List)request.getAttribute("list");
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*6;
int over=(number+1)*6;
int count=pageNumber-over;//remaining records

if(count<=0){
  over=pageNumber;
  }
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>back management </title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>










<jsp:include page="bg-up.jsp" flush="true"/>
<table width="788" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="170"  valign="top"><jsp:include page="bg-left.jsp" flush="true" /></td>
    <td width="618" align="center" valign="top" bgcolor="#FFFFFF"> <br>
	
        <table width="610" height="25" border="0" cellpadding="0" cellspacing="0" background="image/bg_02.jpg">
          <tr>
            <td><div align="center"><strong>商品小类别查询</strong></div></td>
          </tr>
        </table>
        <br>


	  <table width="90%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
        <tr>
          <td width="10%" height="25"><div align="center">number</div></td>
          <td width="18%"><div align="center">小类别名称</div></td>
		  <td width="20%"><div align="center">属于 big type 名称</div></td>
          <td width="27%"><div align="center">创建时间</div></td>

          <td width="25%"><div align="center">操作</div></td>
        </tr>
		     <%for(int i=start;i<over;i++){
      SmallTypeForm form=(SmallTypeForm)list.get(i);
          %>
        <tr bgcolor="#FFFFFF">
          <td height="30"><div align="center"><%=form.getId()%></div></td>
          <td><div align="center"><%=form.getSmallName()%></div></td>
		  <td><div align="center">
		  <%if(request.getParameter("bigId")==null){%>
		  <a href="smallTypeAction.do?action=6&bigId=<%=form.getBigId()%>"><%=big.selectName(form.getBigId())%></a>
		  <%}else{%><%=big.selectName(form.getBigId())%><%}%>
		  </div></td>
          <td><div align="center"><%=form.getCreaTime()%></div></td>                                                                                                                                                                                                   
       
		 <td>  <%if(request.getParameter("bigId")==null){%>
		   <div align="center">   
		  <a href="smallTypeAction.do?action=3&id=<%=form.getId()%>">delete</a> </div>
		   <%}else{%>
		 <div align="center">  无操作 </div>
		  <%}%></td>
		 
      <%}%>  </tr>
      </table> 
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td width="20%">Total  <%=maxPage%>  page</td>
          <td width="25%">Total  <%=pageNumber%>  records</td>
          <td width="14%">This is <%=number+1%>  page</td>
          <td width="25%"><%if((number+1)==1){%>
      previous page
        <%}else{%>
		<%if(request.getParameter("bigId")==null){%>
        <a href="smallTypeAction.do?action=0&i=<%=number-1%>">previous page</a>
		<%}else{%>
		 <a href="smallTypeAction.do?action=6&i=<%=number-1%>&bigId=<%=request.getParameter("bigId")%>">previous page</a>
		
		<%}}%>
		
		
		</td>
          
          <td width="18%"><%if(maxPage<=(number+1)){%>
            next page
              <%}else{%>
			  <%if(request.getParameter("bigId")==null){%>
        <a href="smallTypeAction.do?action=0&i=<%=number+1%>  ">next page</a>
		<%}else{%>
             <a href="smallTypeAction.do?action=6&i=<%=number+1%>  &bigId=<%=request.getParameter("bigId")%>">next page</a>
			  
			  <%}}%></td>
          

        
          
			<%if(request.getParameter("bigId")==null){%>
			  <td width="20%"><a href="bg-smallTypeInsert.jsp">添加小类别&nbsp;</a></td>
			<%}else{%><%}%>
			

        </tr>
      </table>










<%
if(request.getAttribute("reslut")!=null){
%>
<P align="center"><%=request.getAttribute("reslut")%></P>
<%}%>		
    </td>
  </tr>
</table>
<jsp:include page="bg-down.jsp" flush="true" />
















</body>
</html>
