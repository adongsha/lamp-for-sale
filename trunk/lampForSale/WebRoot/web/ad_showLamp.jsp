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
<title>showLamp</title>
<meta name="description" content="Administry - Admin Template by www.865171.cn" />
<meta name="keywords" content="Admin,Template" />
<link rel="shortcut icon" type="image/png" HREF="images/favicons/favicon.png"/>
<link rel="icon" type="image/png" HREF="images/favicons/favicon.png"/>
<link rel="apple-touch-icon" HREF="images/favicons/apple.png" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/custom.css" type="text/css" />
<script type="text/javascript" SRC="javascript/swfobject.js"></script>
<script type="text/javascript" SRC="javascript/jquery-1.4.2.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.ui.core.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.ui.widget.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.ui.tabs.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.tipTip.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.superfish.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.supersubs.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.nyroModal.pack.js"></script>
<script type="text/javascript" SRC="javascript/jquery.validate_pack.js"></script>
<!--[if IE]>
<link rel="stylesheet" type="text/css" media="all" href="css/ie.css"/>
<script src="js/html5.js"></script>
<![endif]-->
<!--Upgrade MSIE5.5-7 to be compatible with MSIE8: http://ie7-js.googlecode.com/svn/version/2.1(beta3)/IE8.js -->
<!--[if lt IE 8]>
<script src="js/IE8.js"></script>
<![endif]-->
<script language="javascript" type="text/javascript" src="javascript/jquery-1.6.4.js"></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='dwr/interface/lampAction.js'></script>
<script language="javascript" type="text/javascript" src="javascript/pageInfo.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	//Administry.setup();

	//Administry.progress("#capacity", 72, 100);
	
	//$("#tabs").tabs();
	
	executeQuery(lampAction.lampListByPage,[lampsLists]);
});
function lampsLists(data){
    alert("data-->"+data);
    var pageInfo = data.pageInfo;
    var lampVos = data.lampVos;
     initPage(page.totalPage, page.pageIndex, page.pageSize, page.totalRec);
    for(var i = 0; i<lampVos.length; i++){
      var lamp = lampVos[i];
      alert("lamp-->"+lamp);
      var div = '<div class="colgroup leading">'
				+'<div class="width1 column first ta-center">'
				+'<img SRC="'
				+lamp.prictureImage1
				+'" alt="" />'
				+'</div><div class="width5 column">'
				+'<a href="#" title="First working version of my CV"><b class="big">'
				+lamp.lampName
				+'</b></a><br/><small><b></b>   类型: <b>'
				+lamp.lampType
				+'</b> |  型号: <a href="#">'
				+lamp.isbn
				+'</a></small><br/><a href="#">删除</a> &middot; <a href="#">展示</a> &middot; <a href="#">编辑</a></div>'
				+'</div>';
		$("#hr").append(div);		
    }
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
                <li><a HREF="adminLamp.html">管理主页</a></li>
					<li class="current">
						<a HREF="#">产品管理</a>
						<ul>
							<li>
								<a HREF="addLamp.html">添加灯饰</a>
							</li>
							<li>
								<a HREF="showLamp.html">产品展示</a>
							</li>
						</ul>
					</li>
                    <li><a HREF="adminUser.html">用户管理</a></li>
					<li><a HREF="order.html">订单管理</a></li>	
					<li><a HREF="graphs.html">业绩图表</a></li>
				</ul>
			</nav>
			<!-- End of Main navigation -->
			<!-- Aside links -->
			<aside><b>English</b> &middot; <a href="#">Spanish</a> &middot; <a href="#">German</a></aside>
			<!-- End of Aside links -->
		</div>
	</header>
	<!-- End of Header -->


	<!-- Page title -->
	<div id="pagetitle">
		<div class="wrapper">
			<h1>LampForSale</h1>
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

					<h3>Show Lamps</h3>
					
					<div id="tabs">
						<!--<ul>
							<li><a class="corner-tl" href="#tabs-date">List by date</a></li>
							
						</ul>
						--><div id="tabs-date">
							<!--<div class="colgroup">
								<div class="width3 column first">
									<p>显示 <b>1-5</b> 共<b>68</b>条</p>
								</div>
								<div class="width3 column">
									<p class="pagination ta-right">
										<a href="#">«</a>
										<a class="pagination-active" href="#">1</a>
										<a href="#">2</a>
										<a href="#">3</a>
										...
										<a href="#">12</a>
										<a href="#">13</a>
										<a href="#">14</a>
										<a href="#">»</a>
									</p>
								</div>
							</div>
							--><div class="clearfix"></div>
							<hr id="hr"/>
							
							
							
						  <!--<div class="colgroup leading">
								<div class="width1 column first ta-center">
									<img SRC="images/preview-not-available.gif" alt="" />
								</div>
								<div class="width5 column">
									<a href="#" title="First working version of my CV"><b class="big">一盏漂亮灯</b></a><br/>
									<small><b>75kB</b> |  类型: <b>台灯</b> |  灯饰: <a href="#">cv</a> <a href="#">xxxx</a></small><br/>
									<a href="#">删除</a> &middot; <a href="#">展示</a> &middot; <a href="#">编辑</a>
								</div>
							</div>
							
						  <div class="colgroup leading">
								<div class="width1 column first ta-center">
									<img SRC="images/preview-not-available.gif" alt="" />
								</div>
								<div class="width5 column">
									<a href="#" title="First working version of my CV"><b class="big">一盏漂亮灯</b></a><br/>
									<small><b>75kB</b> |  类型: <b>台灯</b> |  灯饰: <a href="#">cv</a> <a href="#">xxxx</a></small><br/>
									<a href="#">删除</a> &middot; <a href="#">展示</a> &middot; <a href="#">编辑</a>
								</div>
							</div>	
							
							 <div class="colgroup leading">
								<div class="width1 column first ta-center">
									<img SRC="images/preview-not-available.gif" alt="" />
								</div>
								<div class="width5 column">
									<a href="#" title="First working version of my CV"><b class="big">一盏漂亮灯</b></a><br/>
									<small><b>75kB</b> |  类型: <b>台灯</b> |  灯饰: <a href="#">cv</a> <a href="#">xxxx</a></small><br/>
									<a href="#">删除</a> &middot; <a href="#">展示</a> &middot; <a href="#">编辑</a>
								</div>
							</div>
							
							<div class="clearfix"></div>
						 

							 <div class="colgroup leading">
								<div class="width1 column first ta-center">
									<img SRC="images/preview-not-available.gif" alt="" />
								</div>
								<div class="width5 column">
									<a href="#" title="First working version of my CV"><b class="big">一盏漂亮灯</b></a><br/>
									<small><b>75kB</b> |  类型: <b>台灯</b> |  灯饰: <a href="#">cv</a> <a href="#">xxxx</a></small><br/>
									<a href="#">删除</a> &middot; <a href="#">展示</a> &middot; <a href="#">编辑</a>
								</div>
							</div>
						
							<div class="clearfix"></div>
							
							

							 <div class="colgroup leading">
								<div class="width1 column first ta-center">
									<img SRC="images/preview-not-available.gif" alt="" />
								</div>
								<div class="width5 column">
									<a href="#" title="First working version of my CV"><b class="big">一盏漂亮灯</b></a><br/>
									<small><b>75kB</b> |  类型: <b>台灯</b> |  灯饰: <a href="#">cv</a> <a href="#">xxxx</a></small><br/>
									<a href="#">删除</a> &middot; <a href="#">展示</a> &middot; <a href="#">编辑</a>
								</div>
							</div>
							
							--><div class="clearfix"></div>
							
							<hr/>
							<div id="allDataDiv">
							<!--上一页，下一页 开始-->
							<table width="100%" class="pagecss">
								<tr>
									<td align="left">
										<span id="AllPage">共几页/几条</span>
										<span id="setupNum">显示每页记录条数</span>
										<select id="setSize"
											onchange="ajaxChangeCount(this.options[this.options.selectedIndex].value)">
										</select>
									</td>
									<td align="right">
										<span id="Flexigrid_Bar"><a href="">上5页</a><span
											class="dan">1</span><a href="">2</a><a href="">3</a><a
											href="">下5页</a> </span>
										<span id="checkPage"><input type="text"
												style="width: 20px;" />&nbsp;页<a href="">GO</a> </span>
									</td>
								</tr>
							</table>
							<!--上一页，下一页 结束-->
						</div>
							<!--<div class="colgroup leading">
								<div class="width3 column first">
									<p>显示 <b>1-5</b> 共<b>68</b>条</p>
								</div>
								<div class="width3 column">
									<p class="pagination ta-right">
										<a href="#">«</a>
										<a class="pagination-active" href="#">1</a>
										<a href="#">2</a>
										<a href="#">3</a>
										...
										<a href="#">12</a>
										<a href="#">13</a>
										<a href="#">14</a>
										<a href="#">»</a>
									</p>
								</div>
							</div>
							--><div class="clearfix"></div>
						
						</div>
				
					</div> 

				</section>
				<!-- End of Left column/section -->
				
				
				
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