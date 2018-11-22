<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件下载</title>
</head>
<body>
<%
out.print(new String(request.getParameter("name").getBytes("ISO-8859-1")));
%>
<a href="/File1/download1?Filename1=<%=new String(request.getParameter("name").getBytes("ISO-8859-1")) %>">下载文件</a>                                 
</body>
</html>