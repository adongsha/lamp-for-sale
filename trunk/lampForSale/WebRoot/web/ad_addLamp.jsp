<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Admin Lamp</title>
<meta name="description" content="Admin Lamp" />
<meta name="keywords" content="Lamp" />
<!-- Favicons --> 
<link rel="shortcut icon" type="image/png" HREF="images/favicons/favicon.png"/>
<link rel="icon" type="image/png" HREF="images/favicons/favicon.png"/>
<link rel="apple-touch-icon" HREF="images/favicons/apple.png" />
<!-- Main Stylesheet --> 
<link rel="stylesheet" href="css/style.css" type="text/css" />
<!-- Colour Schemes
Default colour scheme is blue. Uncomment prefered stylesheet to use it.
<link rel="stylesheet" href="css/brown.css" type="text/css" media="screen" />  
<link rel="stylesheet" href="css/gray.css" type="text/css" media="screen" />  
<link rel="stylesheet" href="css/green.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/pink.css" type="text/css" media="screen" />  
<link rel="stylesheet" href="css/red.css" type="text/css" media="screen" />
-->
<!-- Your Custom Stylesheet --> 
<link rel="stylesheet" href="css/custom.css" type="text/css" />
<!--swfobject - needed only if you require <video> tag support for older browsers -->
<script type="text/javascript" SRC="javascript/swfobject.js"></script>
<!-- jQuery with plugins -->
<script type="text/javascript" SRC="javascript/jquery-1.4.2.min.js"></script>
<!-- Could be loaded remotely from Google CDN : <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script> -->
<script type="text/javascript" SRC="javascript/jquery.ui.core.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.ui.widget.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.ui.tabs.min.js"></script>
<!-- jQuery tooltips -->
<script type="text/javascript" SRC="javascript/jquery.tipTip.min.js"></script>
<!-- Superfish navigation -->
<script type="text/javascript" SRC="javascript/jquery.superfish.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.supersubs.min.js"></script>
<!-- jQuery popup box -->
<script type="text/javascript" SRC="javascript/jquery.nyroModal.pack.js"></script>
<!-- jQuery form validation -->
<script type="text/javascript" SRC="javascript/jquery.validate_pack.js"></script>
<!-- dwr -->
<script type='text/javascript' src='dwr/interface/addLampAction.js'></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'>  </script>

<script type="text/javascript">
 /* ----------------表单验证----------------------  */
$(document).ready(function(){
	Administry.setup();
	Administry.progress("#progress1", 1, 6);
	var validator = $("#addLampForm").validate({
		rules: {
			isbn:   "required",
			lampName: "required",
			price:    "required",
			origin:   "required",
			material: "required",
			process:  "required",
			weight:   "required",
			images: "required",
		},
		messages: {
			isbn: "请输入灯饰型号",
			lampName: "请输入灯饰名称",
			price:    "请输入灯饰的价钱",
			origin:   "请输入产地",
			material: "请输入材料",
			process:  "请输入工艺",
			weight:   "请输入重量",
			images: "请至少上传一张图片"
		},
		/*errorPlacement: function(error, element) {
			error.insertAfter(element.parent().find('label:first'));
		},
		submitHandler: function() {
			alert("Data submitted!");
		},*/
		success: function(label) {
			label.html("&nbsp;").addClass("ok");
		}
		})
*/
});
/*-----------------------表单验证结束 ------------------------------------------*/



/*-------------------------------DWR--------------------------------------------*/
function addLampDWR(){
       var isbn = $("#isbn").val(); //获得lamp的型号 
       var lampName = $("#lampName").val(); //获得lamp名 
       var price = $("#price").val();   //获得灯的价钱
       var origin = $("#origin").val(); //获得产地
       var weight = $("#weight").val(); //获得lamp的重量
       var process = $("#process").val(); //获得工艺
       var material = $("#material").val();//获得材料 
       var lampDescription = $("#lampDescription").val(); //获得描述 
       addLampAction.addLamp(isbn, lampName, price,
			origin, material, process, weight, lampDescription);
}
/*-------------------------------DWR结束 --------------------------------------------*/

//function tip(){
//   alert("添加成功!");
//}
</script>
</head>
<body>
	<!-- Header -->
	<header id="top">
		<div class="wrapper">
			<!-- Title/Logo - can use text instead of image -->
			<div id="title"><img SRC="images/logo.png" alt="Administry" /><!--<span>Administry</span> demo--></div>
			<!-- Top navigation -->
			<div id="topnav">
				<a href="#"><img class="avatar" SRC="images/user_32.png" alt="" /></a>
				<b>Admin</b>
				<span>|</span> <a href="#">个人信息</a>
				<span>|</span> <a href="#">注销</a><br />
			</div>
			<!-- End of Top navigation -->
			<!-- Main navigation -->
			<nav id="menu">
								<ul class="sf-menu">
					<li class="current"><a HREF="MainAction">管理主页</a></li>
					<li>
						<a HREF="">产品管理</a>
						<ul>
							<li>
								<a HREF="AddLampAction">添加灯饰</a>
							</li>
							<li>
								<a HREF="LampMangerAction">灯饰管理</a>
							</li>
						</ul>
					</li>
					<li ><a HREF="UserMangerAction">用户管理</a></li>
					<li><a HREF="OrderMangeAction">订单管理</a></li>	
					
				</ul>
			</nav>
			<!-- End of Main navigation -->
			<!-- Aside links -->
			<aside></aside>
			<!-- End of Aside links -->
		</div>
	</header>
	<!-- End of Header -->
	<!-- Page title -->
	<div id="pagetitle">
		<div class="wrapper">
			<h1>LampForSale</h1>
			<!-- Quick search box -->
			
		</div>
	</div>
	<!-- End of Page title -->
	
	<!-- Page content -->
	<div id="page">
		<!-- Wrapper -->
		<div class="wrapper">
				<!-- Left column/section -->
				<section class="column width6 first">					

					<h3>添加灯饰</h3>
					<div class="box box-info">按要求录入产品信息</div>
					                                             
					<form id="addLampForm" method="post" action="addLampAction" enctype="multipart/form-data">

						<fieldset>
							<legend>Lamp Form Validation</legend>

							<table width="730">
                            <tr>
                            <td width="50%" height="60">
                            <p>    
								<label class="required" for="isbn">灯饰型号:</label><br/>
								<input type="text" id="isbn" class="half" value="" name="isbn"/>
                                <small>e.g. xs-0000</small>
							</p>
                            </td>
                            <td width="50%">
                            <p>
								<label class="required" for="lampName">灯饰名称:</label><br/>
								<input type="text" id="lampName" class="half" value="" name="lampName"/>
                                <small>e.g. xxxx</small>
							</p>
                            </td>
                            </tr>
                            </table>
                            
                            <table width="730">
                            <tr>
                            <td width="50%" height="60">
                            <p>    
								<label class="required" for="price">灯饰价钱:</label><br/>
								<input type="text" id="price" class="half" value="" name="price"/>
								<small>e.g. 10000</small>
							</p>
                            </td>
                            <td width="50%">
                            <p>
								<label class="required" for="origin">产地:</label><br/>
								<input type="text" id="origin" class="half" value="" name="origin"/>
                                <small>e.g. xx省xxx市</small>
							</p>
                            </td>
                            </tr>
                            </table>

							
                            <table width="730">
                            <tr>
                            <td width="50%" height="60"> 
							<p>
								<label class="required" for="material">材料：</label><br/>
								<input type="text" id="material" class="half" value="" name="material"/>
							</p>
                            </td>
                            <td width="50%">
                            <p>
								<label class="required" for="process">工艺:</label><br/>
								<input type="text" id="process" class="half" value="" name="process"/>
							</p>
                            </td>
                            </tr>
                            </table>
                            
                            
                            
                           <table width="730">
                            <tr>
                            <td width="50%" height="60"> 
							<p>
								<label class="required" for="weight">重量:</label><br/>
								<input type="text" id="weight" class="half" value="" name="weight"/>
							</p>
                            </td>
                             <td width="50%">
                            <p>
								<label class="required" for="weight">灯饰类型:</label><br/>
								<select id="type" name="type">
										<option value="">
											--请选择类型--
										</option >
										<option value="1">
											家居灯
										</option>
										<option  value="2">
											创意灯
										</option>
										<option  value="3">
											落地灯
										</option>
										<option  value="4">
											吸顶灯
										</option>
										<option  value="5">
											射   灯
										</option>
										<option  value="6">
											壁   灯
										</option>
										<option  value="7">
											台   灯
										</option>
										<option  value="8">
											吊   灯
										</option>
									</select>
							</p>
                            </td> 
                            </tr>
                            </table>
                            
                            
                             <table width="730">
                            <tr>
                            <td width="50%" height="60"> 
							<p>
                            <p>
								<label class="required" for="images">图片1:</label><br/>
								<input type="file" id="images" class="half" value="" name="images"/>
							</p>
                            </td>
                            <td width="50%">
								<label for="pritureImages2">图片2:</label><br/>
								<input type="file" id="pritureImages2" class="half" value="" name="images"/>
							</td>
                            </tr>
                            </table>
                            
                            <table width="730">
                            <tr>
                            <td width="50%" height="60"> 
							<p>
                            <p>
								<label for="pritureImages3">图片3:</label><br/>
								<input type="file" id="pritureImages3" class="half" value="" name="images"/>
							</p>
                            </td>
                            <td width="50%">
								<label for="pritureImages4">图片4:</label><br/>
								<input type="file" id="pritureImages4" class="half" value="" name="images"/>
							</td>
                            </tr>
                            </table>
                            
                            <p>
								<label for="lampDescription">灯饰描述:</label><br/>
								<textarea id="lampDescription" class="medium half" name="lampDescription"></textarea>
								
							</p>
							
							<p class="box"><input type="submit" class="btn btn-green big" value="添加"/> or <input type="reset" class="btn" value="重置"/></p>

						</fieldset>

					</form>

					
					
					
					
					
					
				
				</section>
				<!-- End of Left column/section -->
				
				<!-- Right column/section -->
				<aside class="column width2">
					<div id="rightmenu">
						<header>
							<h3>You might also want to check out...</h3>
						</header>
						<dl class="first">
							<dt><img width="16" height="16" alt="Basic styles" SRC="images/style.png"></dt>
							<dd><a HREF="styles.html">Basic styles</a></dd>
							<dd class="last">Basic elements and styles</dd>							
							
							<dt><img width="16" height="16" alt="Form validation" SRC="images/book.png"></dt>
							<dd><a HREF="file:///D|/docs.jquery.com/Plugins/Validation">Form validation</a></dd>
							<dd class="last">jQuery form validation documentation</dd>							
						</dl>
					</div>
					<div class="content-box">
						<header>
							<h3>Quick info</h3>
						</header>
						<section>
							<q>A form is an area that can contain form elements.
							Form elements are elements that allow the user to enter information (like text fields, textarea fields, drop-down menus, radio buttons, checkboxes, etc.) in a form.
							A form is defined with the &lt;form&gt; tag.
							<cite>w3schools.com</cite></q>							
						</section>
					</div>
				</aside>
				<!-- End of Right column/section -->
				
		</div>
		<!-- End of Wrapper -->
	</div>
	<!-- End of Page content -->
	
	<!-- Page footer -->
	<footer id="bottom">
		<div class="wrapper">
			<nav>
				<a href="#">管理主页</a> &middot;
				<a href="#">添加灯饰</a> &middot;
				<a href="#">产品展示</a> &middot;
				<a href="#">订单管理</a> &middot;
				<a href="#">用户管理</a> &middot;
				<a href="#">业绩图表</a>
			</nav>
			<p>Copyright &copy; 2010 <b><a HREF="http://www.865171.cn" title="关伟海、陆永坚、王海静、梁绮红">小组成员</a></b> | Icons by <a HREF="http://www.865171.cn" title="王华君">09网编1班</a></p>
		</div>
	</footer>
	<!-- End of Page footer -->
	
	<!-- Animated footer -->
	<footer id="animated">
		<ul>
			<li><a href="#">管理主页</a></li>
			<li><a href="#">添加灯饰</a></li>
			<li><a href="#">产品展示</a></li>
			<li><a href="#">订单管理</a></li>
			<li><a href="#">用户管理</a></li>
			<li><a href="#">业绩图表</a></li>
		</ul>
	</footer>
	<!-- End of Animated footer -->
	
	<!-- Scroll to top link -->
	<a href="#" id="totop">^ scroll to top</a>

<!-- User interface javascript load -->
<script type="text/javascript" SRC="javascript/administry.js"></script>
</body>
</html>