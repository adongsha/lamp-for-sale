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
<script type="text/javascript" SRC="javascript/jquery-1.4.2.min.js"></script>
<script type="text/javascript" SRC="javascript/swfobject.js"></script>
<script type="text/javascript" SRC="javascript/jquery.ui.core.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.ui.widget.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.ui.tabs.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.tipTip.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.superfish.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.supersubs.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.nyroModal.pack.js"></script>
<script type="text/javascript" SRC="javascript/jquery.validate_pack.js"></script>

<script language="javascript" type="text/javascript" src="web/common/js/jquery-1.6.2.min.js"></script>
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
    var page = data.pageInfo;
    console.log("pageInfo-->"+pageInfo);
    var lampVos = data.lampVos;
    console.log("lampVos-->"+lampVos);
     if(data == null || data.length == 0){
      alert("没有订单！ ");
      return;
   }
   if(!page){
   alert("出错了！请重试...");
       }
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
				<b>Admin</b>
				<span>|</span> <a href="#">个人信息</a>
				<span>|</span> <a href="#">注销</a><br />
			</div>
			<!-- End of Top navigation -->
			<!-- Main navigation -->
			<nav id="menu">
				<ul class="sf-menu">
                <li><a HREF="ad_mainAction">管理主页</a></li>
					<li class="current">
						<a HREF="#">产品管理</a>
						<ul>
							<li>
								<a HREF="addLamp">添加灯饰</a>
							</li>
							<li>
								<a HREF="ad_showLampAction">产品展示</a>
							</li>
						</ul>
					</li>
                    <li><a HREF="ad_userAction">用户管理</a></li>
					<li><a HREF="ad_orderAction">订单管理</a></li>	
				</ul>
			</nav>
			<!-- End of Main navigation -->
			<!-- Aside links -->
			
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
						<div id="tabs-date">
							<div class="clearfix"></div>
							<hr id="hr"/>

						  <div class="clearfix"></div>
							
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
							<div class="clearfix"></div>
						
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
				<a href="ad_mainAction">管理主页</a> &middot;
				<a href="addLamp">添加灯饰</a> &middot;
				<a href="ad_showLampAction">产品展示</a> &middot;
				<a href="ad_orderAction">订单管理</a> &middot;
				<a href="ad_userAction">用户管理</a> &middot;
			</nav>
			<p>Copyright &copy; 2010 <b><a HREF="" title="关伟海、陆永坚、王海静、梁绮红">小组成员</a></b> | Icons by <a HREF="" title="王华君">09网编1班</a></p>
		</div>
	</footer>
	<!-- End of Page footer -->
	
	<!-- Animated footer -->
	<footer id="animated">
		<ul>
			<li><a href="ad_mainAction">管理主页</a></li>
			<li><a href="addLamp">添加灯饰</a></li>
			<li><a href="ad_showLampAction">产品展示</a></li>
			<li><a href="ad_orderAction">订单管理</a></li>
			<li><a href="ad_userAction">用户管理</a></li>
		</ul>
	</footer>
	<!-- End of Animated footer -->
	
	<!-- Scroll to top link -->
	<a href="#" id="totop">^ scroll to top</a>

<!-- User interface javascript load -->
<script type="text/javascript" SRC="javascript/administry.js"></script>
</body>
</html>