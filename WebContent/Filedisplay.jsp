<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户信息列表</title>
<link rel="stylesheet" href="../css/admin.css" />

<script src="../js/jquery2.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
	 //指定表格中所有<th class="back">的单元格隐藏
     $("table tr th.back").hide();
	 //指定表格中所有<td class="back">的单元格隐藏
	 $("table tr td.back").hide();
	 
	 //获取第一行<tr>对象
	// $("tr:first").css("font-family","Verdana, Geneva, sans-serif");
	 //下行代码与上一行代码等价
	 $("tr").first().css("font-family","Verdana, Geneva, sans-serif");
     //获取索引值为奇数的<tr>对象
     $("tr:odd").css("background","#F5F5F5");
	 //当鼠标移动到表格当前行时，变换背景色
     $("tr").mouseover(function(){
    	 $(this).css("background","#F9F4F6");
     });
	 //当鼠标移走时，恢复原来的背景色
     $("tr").mouseleave(function(){
    	 $("tr:odd").css("background","#F5F5F5");
		 $("tr:even").css("background","");
     });

  	 //在标题行中的复选框的click事件进行编程	
	 $("#all").click(function (){
		//如果该复选框被选中
	 if(this.checked)
	 {		
		//页面中所有的checkbox均改为选中
		$("input:checkbox").attr("checked",true);
		//修改<span>元素中的文本内容为“全不选”
	    $('span').text('全不选');
	 }
	 else
	 {
		 //页面中所有的checkbox均改为选
		 $(":checkbox").attr("checked",false);
		 //修改<span>元素中的文本内容为“全选”
		 $('span').text('全选');
	 }
	});  
  });
  
  	$(document).ready(function() {
		$("#find").click(function(){
				$("table tr").hide().filter(":contains('" + $("#keyword").val() + "')").show();
				
			});
	});	
</script>
</head>

<body>
<div>
	<form action="/File1/download?method=search" method="post">
	<div id="search">
		查找方式：<select name="column">
			<option value="Filename">文件名</option>
			<option value="Filestyle">文件类型</option>
			<option value="Filesize">文件大小</option>
			<option value="author">作者</option>
			
		</select>
		关键字：<input type="text" name="value" id="keyword" value="" />
		      <input type="submit"  id="find" value="查询" />
		
		&nbsp;&nbsp;
		<a href="upload.jsp" target="main">上传文件</a>
	</div>
	</form>
	<table border="1">
		
		<tr>
			<th class="back">文件名</th>
			<th class="back">文件类型</th>
			<th class="back">文件时间</th>
			<th class="back">文件路径</th>
			<th class="back">文件大小</th>
			<th class="back">文件作者</th>
			<th class="back">文件描述</th>
			<th class="back">操作</th>
		</tr>
	   <%
	   
	   	StringBuffer sb = (StringBuffer)session.getAttribute("message");
	   	out.print(sb.toString());
	   %>
		
	</table>
</div>

</body>
</html>
