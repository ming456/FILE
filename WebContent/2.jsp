<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
 <head>
  <title>Ò³Ãæ¶þ</title>
 </head>
 <body>
  <%=new String(request.getParameter("name").getBytes("ISO-8859-1")) %> &&
  <%=request.getParameter("password") %> 
 </body>
</html>