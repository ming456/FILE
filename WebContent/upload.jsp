<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
<center>
<form action="/File1/upload" method="post" enctype="multipart/form-data">
<ul>
  <li>&nbsp;文&nbsp;件&nbsp;名:<input type="text" name="Filename"/></li>
  <li>&nbsp;文&nbsp;件&nbsp;类&nbsp;型:<input type="text" name="Filestyle"/></li>
  <li>&nbsp;文&nbsp;件&nbsp;路&nbsp;径:<input type="file" name="Filepath"/></li>
  <li>&nbsp;文&nbsp;件&nbsp;作&nbsp;者:<input type="text" name="author"/></li>
  <li>&nbsp;文&nbsp;件&nbsp;描&nbsp;述:<textarea name="description" cols="30" rows="3" id="txtIntro"></textarea></li>
</ul>
<input type="submit" name ="upload" value="上传"/>
</form>
</center></body></html>