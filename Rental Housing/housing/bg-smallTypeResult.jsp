<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>no title</title>
</head>

<body>

<script language='javascript'>alert('<%=request.getAttribute("result")%>');
window.location.href = 'smallTypeAction.do?action=0';</script>

</body>
</html>
