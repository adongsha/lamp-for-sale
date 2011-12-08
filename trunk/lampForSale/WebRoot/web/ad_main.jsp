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
<title>LampForSale</title>
<meta name="description" content="Administry - Admin Template by www.865171.cn" />
<meta name="keywords" content="Admin,Template" />
<!-- We need to emulate IE7 only when we are to use excanvas -->
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<![endif]-->
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
<!-- jQuery form validation -->
<script type="text/javascript" SRC="javascript/jquery.validate_pack.js"></script>
<!-- jQuery popup box -->
<script type="text/javascript" SRC="javascript/jquery.nyroModal.pack.js"></script>
<!-- jQuery graph plugins -->
<!--[if IE]><script type="text/javascript" src="js/flot/excanvas.min.js"></script><![endif]-->
<script type="text/javascript" SRC="javascript/flot/jquery.flot.min.js"></script>
<!-- Internet Explorer Fixes --> 
<!--[if IE]>
<link rel="stylesheet" type="text/css" media="all" href="css/ie.css"/>
<script src="js/html5.js"></script>
<![endif]-->
<!--Upgrade MSIE5.5-7 to be compatible with MSIE8: http://ie7-js.googlecode.com/svn/version/2.1(beta3)/IE8.js -->
<!--[if lt IE 8]>
<script src="js/IE8.js"></script>
<![endif]-->
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='dwr/interface/orderAction.js'></script>
<script language="javascript" type="text/javascript" src="javascript/pageInfo.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	Administry.setup();
	alert("aaaa");
	aa();
	Administry.progress("#progress1", 1, 5);
	Administry.progress("#progress2", 3, 5);
	Administry.progress("#progress3", 2, 6);
	Administry.progress("#progress4", 2, 6);
	Administry.progress("#progress5", 2, 6);

	/* flot graphs */
	var sales = [{
		label: '月销售额',
		data: [[1, 5555],[2,0],[3,0],[4,0],[5,0],[6,0],[7,9000],[8,0],[9,0],[10,0],[11,0],[12,0]]
	}
	];

	var plot = $.plot($("#placeholder"), sales, {
		bars: { show: true, lineWidth: 1 },
		legend: { position: "ne" },
		xaxis: { ticks: [[1, "Jan"], [2, "Feb"], [3, "Mar"], [4, "Apr"], [5, "May"], [6, "Jun"], [7, "Jul"], [8, "Aug"], [9, "Sep"], [10, "Oct"], [11, "Nov"], [12, "Dec"]] },
		yaxis: { min: 0, max: 300000 },
		grid: { color: "#666" },
		colors: ["#0a0", "#f00"]			
    });
});

function aa(){
alert("bbb");
    orderAction.statisticsOrderForToday(function(data){
	alert("vvvv");
	alert("data-->"+data);
	  $("#todayOrder").html(data);
	});
}
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
				Logged in as <b>Admin</b>
				<span>|</span> <a href="#">Settings</a>
				<span>|</span> <a href="#">Logout</a><br />
				<small>You have <a href="#" class="high"><b>1</b> new message!</a></small>
			</div>
			<!-- End of Top navigation -->
			<!-- Main navigation -->
			<nav id="menu">
								<ul class="sf-menu">
					<li class="current"><a HREF="adminLamp.html">管理主页</a></li>
					<li>
						<a HREF="styles.html">产品管理</a>
						<ul>
							<li>
								<a HREF="addLamp.html">添加灯饰</a>
							</li>
							<li>
								<a HREF="showLamp.html">产品展示</a>
							</li>
						</ul>
					</li>
					<li ><a HREF="adminUser.html">用户管理</a></li>
					<li><a HREF="styles.html">订单管理</a></li>	
					<li><a HREF="graphs.html">业绩图表</a></li>	
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
			<h1>Lamp</h1>
			<!-- Quick search box -->
			<form action="" method="get"><input class="" type="text" id="q" name="q" /></form>
		</div>
	</div>
	<!-- End of Page title -->
	
	<!-- Page content -->
	<div id="page">
		<!-- Wrapper -->
		<div class="wrapper">
				<!-- Left column/section -->
				<section class="column width6 first">
				
					<div class="colgroup leading">
						<div class="column width3 first">
							<h3>欢迎你, <a href="#">Admin</a></h3>
							<p>
								You are currently signed up to the <b>Free Trial Plan</b>.<br /><a href="#">Upgrade now?</a>
							</p>
						</div>
						<div class="column width3">
							<h4>Last login</h4>
							<p>
								Monday July 12th, 2010 at 11:32am from 127.0.0.1<br />
								No error login attempts.
							</p>
						</div>
					</div>
					
					<div class="colgroup leading">
						<div class="column width3 first">
							<h4>售后情况</h4>
							<hr/>
							<table class="no-style full">
								<tbody>
									<tr>
										<td>今天退单数</td>
										<td class="ta-right"></td>
										<td class="ta-right"><a href="#">10</a></td>
									</tr>
									<tr>
										<td>今天退单额</td>
										<td class="ta-right"><a href="#"></a></td>
										<td class="ta-right">900.00 &euro;</td>
									</tr>
									<tr>
										<td>月总退单数</td>
										<td class="ta-right"></td>
										<td class="ta-right"><a href="#">1</a></td>
									</tr>
									<tr>
										<td>月总退单额</td>
										<td class="ta-right"></td>
										<td class="ta-right">0.00 &euro;</td>
									</tr>
                                    <tr>
										<td>年总退单数</td>
										<td class="ta-right"></td>
										<td class="ta-right"><a href="#">1</a></td>
									</tr>
                                    <tr>
										<td>年总退单额</td>
										<td class="ta-right"></td>
										<td class="ta-right">0.00 &euro;</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="column width3">
							<h4>销售情况 </h4>
							<hr/>
							<table class="no-style full">
								<tbody>
									<tr>
										<td>今天订单数</td>
										<td class="ta-right" id="todayOrder"><a href="#">1</a></td>
										<td class="ta-right"></td>
									</tr>
									<tr>
										<td>今天销售额</td>
										<td class="ta-right"><a href="#">9</a></td>
										<td class="ta-right">900.00 &euro;</td>
									</tr>
									<tr>
										<td>月总订单数</td>
										<td class="ta-right"><a href="#">5</a></td>
										<td class="ta-right"></td>
									</tr>
									<tr>
										<td>月销售总额</td>
										<td class="ta-right"><a href="#">9</a></td>
										<td class="ta-right">900.00 &euro;</td>
									</tr>
                                    <tr>
										<td>年总订单数</td>
										<td class="ta-right"><a href="#">5</a></td>
										<td class="ta-right"></td>
									</tr>
									<tr>
										<td>年销售总额</td>
										<td class="ta-right"><a href="#">9</a></td>
										<td class="ta-right">900.00 &euro;</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				
					<div class="colgroup leading">
						<div class="column width3 first">
							<h4>客户数据</h4>
							<hr/>
                            <p><b>满意度调查</b></p>
							<table class="no-style full">
								<tbody>
									<tr>
										<td>非常满意</td>
										<td class="ta-right">1/5</td>
										<td><div id="progress1" class="progress full progress-green"><span><b></b></span></div></td>
									</tr>
									<tr>
										<td>满&nbsp;&nbsp;&nbsp;&nbsp;意</td>
										<td class="ta-right">2/5</td>
										<td><div id="progress2" class="progress full progress-blue"><span><b></b></span></div></td>
									</tr>
									<tr>
										<td>差</td>
										<td class="ta-right">2/5</td>
										<td><div id="progress3" class="progress full progress-red"><span><b></b></span></div></td>
									</tr>
                                    <tr>
										<td>很差</td>
										<td class="ta-right">2/5</td>
										<td><div id="progress4" class="progress full progress-red"><span><b></b></span></div></td>
									</tr>
                                    <tr>
										<td>不表态</td>
										<td class="ta-right">2/5</td>
										<td><div id="progress5" class="progress full progress-red"><span><b></b></span></div></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="column width3">
							<h4>销售报表</h4>
							<hr/>
							<p><b>月销售额</b></p>
							<div id="placeholder" style="height:200px"></div>
						</div>
					</div>
					<div class="clear">&nbsp;</div>
				
				</section>
				<!-- End of Left column/section -->
				
				<!-- Right column/section -->
				<aside class="column width2">
					<div id="rightmenu">
						<header>
							<h3>登陆账号</h3>
						</header>
						<dl class="first">
							<dt><img width="16" height="16" alt="" SRC="images/key.png"></dt>
							<dd><a href="#">Administry (admin)</a></dd>
							<dd class="last">Free Account.</dd>
							
							<dt><img width="16" height="16" alt="" SRC="images/help.png"></dt>
							<dd><a href="#">帮助</a></dd>
							<dd class="last">常见问题解决方法</dd>
						</dl>
					</div>
					<div class="content-box">
						<header>
							<h3>Latest in the Community</h3>
						</header>
						<section>
							<dl>
								<dt>Maximize every interaction with a client</dt>
								<dd><a href="#">Read more</a></dd>
								<dt>Diversification for Small Business Owners</dt>
								<dd><a href="#">Read more</a></dd>
							</dl>
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
				<a href="#">业绩图表</a> &middot;
				
			</nav>
			<p>Copyright &copy; 2010 <b><a HREF="" title="关伟海、陆永坚、王海静、梁绮红">小组成员</a></b> | Icons by <a HREF="" title="王华君">09网编1班</a></p>
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

<!-- Admin template javascript load -->
<script type="text/javascript" SRC="javascript/administry.js"></script>
</body>
</html>