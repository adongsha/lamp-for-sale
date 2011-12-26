<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>dialog例子</title>

<link href="common/css/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" /> 
<script language="javascript" type="text/javascript" src="common/js/jquery-1.6.2.min.js"></script> 
<script language="javascript" type="text/javascript" src="common/js/jquery-ui-1.8.16.custom.min.js"></script> 
<script language="javascript" type="text/javascript">
	
	function showBut(){  
		alert('1321');
		$('#showDiv').dialog({
					width: 600,
					buttons: {
						"Ok": function() { 
							$(this).dialog("close"); 
						}, 
						"Cancel": function() { 
							$(this).dialog("close"); 
						} 
					}
				}); //调用 dialog()方法
	}
</script>
</head>

<body>
<input  type="button"   value="使用dialog()方法" onclick="showBut()" /> <!-- 按钮 onclick 函数为showBut()  -->
<div id="showDiv"  style="display:none; ">这个层 是用 dialog()方法 调用出来的</div><!--使用dialog()方法 调用 ID为 'showDiv'   -->
</body>
</html>