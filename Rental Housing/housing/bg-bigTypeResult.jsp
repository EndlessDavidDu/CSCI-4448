<%@ page contentType="text/html; charset=utf-8" errorPage="" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>no title</title>
</head>

<body>

<script lang='javascript'>
    alert('<%=request.getAttribute("result")%>');
    window.location.href = 'bigTypeAction.do?action=0';
</script>

</body>
</html>
