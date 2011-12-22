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
<!-- jQuery data tables -->
<script type="text/javascript" SRC="javascript/jquery.dataTables.min.js"></script>
<!-- Internet Explorer Fixes --> 
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
<script type='text/javascript' src='dwr/interface/orderAction.js'></script>
<script language="javascript" type="text/javascript" src="javascript/pageInfo.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
		//Administry.setup();
     	//$('#example').dataTable();
	   // Administry.expandableRows();
	orderAction.notDealOrder(function(data){
      $("#notDealorder").html(data)
     });
     
    orderAction.dealedOrder(function(data) {
      $("#dealorder").html(data);
    });
    
    orderAction.problemOrder(function(data) {
      $("#problemOrder").html(data);
    });
    
    orderAction.notDealOrderAmount(function(data){
      $("#notDealAmount").html(data);
    });
    
    orderAction.dealedOrderAmount(function(data) {
      $("#dealAmount").html(data);
    });
    
    orderAction.problemOrderAmount(function(data) {
      $("#problemAmount").html(data);
    });
    
    executeQuery(orderAction.orderListByPage,[orderLists]);
});

function orderLists(data){
   var page = data.pageInfo;
   var orders = data.orderLists;
   if(data == null || data.length == 0){
      alert("没有订单！ ");
      return;
   }
   if(!page){
   alert("出错了！请重试...");
   }
   //alert(page.totalPage+"|"+page.pageIndex+"|"+page.pageSize+"|"+page.totalRec);
   initPage(page.totalPage, page.pageIndex, page.pageSize, page.totalRec);
   for(var i = 0; i < orders.length; i++){
   var order = orders[i];
   var orderStatus = order.orderStatus;
   if(orderStatus = 1){
      orderStatus = "已处理";
   }
   if(orderStatus = 2){
      orderStatus = "未处理";
   }
   var orderId = order.orderId;
   var userName = order.userName;
   var allPrice = order.allPrice;
   var tr = '<tr><td width="15%">'
          +orderId
          +'</td><td width="24%">'
          +userName
          +'</td><td width="32%">'
          +'<input type="submit" value="查看" id="'
          +orderId
          +'" onclick="seeOrder(this)"/><input type="submit" value="删除" id="'
          +orderId
          +'" onclick="delOrder()"/></td><td width="16%">'
          +allPrice
          +'</td><td width="13%"><input type="submit" value="'
          +orderStatus
          +'"/>'
          +'</td></tr>'
    $("#example").append(tr);
   }
}

function seeOrder(){
  orderAction.seeOrder(id,function() {
    
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
					<li><a HREF="adminLamp.html">管理主页</a></li>
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
					<li><a HREF="adminUser.html">用户管理</a></li>
					<li class="current"><a HREF="order.html">订单管理</a></li>	
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
			<h1>Order Management</h1>
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
					
					<h3>订单汇总</h3>
					
					<div class="box box-info">请即时处理用户订单</div>
					
					<table id="report" class="stylized full" style="">
						<thead>
							<tr>
								<th>订单</th>
								<th class="ta-right">订单数</th>
							    <th class="ta-right">总额</th>
								
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="title">
									<div>
										<a href="#"><b>未处理的订单</b></a>
										<div class="listingDetails">
											<div class="pad">
												<b>Additional information</b>
												<ul>
													<li><a HREF="http://www.865171.cn">www.865171.cn</a></li>
													<li><a HREF="http://www.865171.cn">www.865171.cn</a></li>
													<li><a HREF="http://www.865171.cn">www.865171.cn</a></li>
												</ul>
											</div>
										</div>
									</div>
								</td>
								<td class="ta-right" id="notDealorder"></td>

								<td class="ta-right" id="notDealAmount"></td>

							</tr>
							<tr>
								<td class="title">
									<div>
										<a href="#"><b>以处理的订单</b></a>
										<div class="listingDetails" style="z-index:1">
											<div class="pad">
												<b>Additional information</b>
												<ul>
													<li><a HREF="http://www.865171.cn">www.865171.cn</a></li>
													<li><a HREF="http://www.865171.cn">www.865171.cn</a></li>
													<li><a HREF="http://www.865171.cn">www.865171.cn</a></li>
												</ul>
											</div>
										</div>
									</div>
								</td>
								<td class="ta-right" id="dealorder"></td>
								<td class="ta-right" id="dealAmount"></td>
								
							</tr>
							<tr>
								<td class="title">
									<div>
										<a href="#"><b>有问题的订单</b></a>
										<div class="listingDetails">
											<div class="pad">
												<b>Additional information</b>
												<ul>

													<li><a HREF="http://www.865171.cn">www.865171.cn</a></li>
													<li><a HREF="http://www.865171.cn">www.865171.cn</a></li>
													<li><a HREF="http://www.865171.cn">www.865171.cn</a></li>
												</ul>
											</div>
										</div>
									</div>
								</td>
								<td class="ta-right" id="problemOrder"></td>
								<td class="ta-right" id="problemAmount"></td>
								
							</tr>
						</tbody>
					</table>
					
					<div class="clear">&nbsp;</div>
					
					<h3>订单列表</h3>
					
					<table class="display stylized" id="example">
						<thead>
							<tr>
								<th width="15%">订单号</th>
								<th width="24%">用户名</th>
								<th width="32%">是否处理</th>
								<th width="16%">总价钱</th>
								<th width="13%">操作</th>
                             
							</tr>
						</thead>
							<!--<tr class="gradeX">
								<td>Trident</td>
								<td>Internet Explorer 4.0</td>
								<td>Win 95+</td>
								<td class="center">4</td>
								<td class="center">X</td>
							</tr>
							<tr class="gradeC">
								<td>Trident</td>
								<td>Internet
									 Explorer 5.0</td>
								<td>Win 95+</td>
								<td class="center">5</td>
								<td class="center">C</td>
							</tr>
							<tr class="gradeA">
								<td>Trident</td>
								<td>Internet
									 Explorer 5.5</td>
								<td>Win 95+</td>
								<td class="center">5.5</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Trident</td>
								<td>Internet
									 Explorer 6</td>
								<td>Win 98+</td>
								<td class="center">6</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Trident</td>
								<td>Internet Explorer 7</td>
								<td>Win XP SP2+</td>
								<td class="center">7</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Trident</td>
								<td>AOL browser (AOL desktop)</td>
								<td>Win XP</td>
								<td class="center">6</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Firefox 1.0</td>
								<td>Win 98+ / OSX.2+</td>
								<td class="center">1.7</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Firefox 1.5</td>
								<td>Win 98+ / OSX.2+</td>
								<td class="center">1.8</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Firefox 2.0</td>
								<td>Win 98+ / OSX.2+</td>
								<td class="center">1.8</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Firefox 3.0</td>
								<td>Win 2k+ / OSX.3+</td>
								<td class="center">1.9</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Camino 1.0</td>
								<td>OSX.2+</td>
								<td class="center">1.8</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Camino 1.5</td>
								<td>OSX.3+</td>
								<td class="center">1.8</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Netscape 7.2</td>
								<td>Win 95+ / Mac OS 8.6-9.2</td>
								<td class="center">1.7</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Netscape Browser 8</td>
								<td>Win 98SE+</td>
								<td class="center">1.7</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Netscape Navigator 9</td>
								<td>Win 98+ / OSX.2+</td>
								<td class="center">1.8</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Mozilla 1.0</td>
								<td>Win 95+ / OSX.1+</td>
								<td class="center">1</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Mozilla 1.1</td>
								<td>Win 95+ / OSX.1+</td>
								<td class="center">1.1</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Mozilla 1.2</td>
								<td>Win 95+ / OSX.1+</td>
								<td class="center">1.2</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Mozilla 1.3</td>
								<td>Win 95+ / OSX.1+</td>
								<td class="center">1.3</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Mozilla 1.4</td>
								<td>Win 95+ / OSX.1+</td>
								<td class="center">1.4</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Mozilla 1.5</td>
								<td>Win 95+ / OSX.1+</td>
								<td class="center">1.5</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Mozilla 1.6</td>
								<td>Win 95+ / OSX.1+</td>
								<td class="center">1.6</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Mozilla 1.7</td>
								<td>Win 98+ / OSX.1+</td>
								<td class="center">1.7</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Mozilla 1.8</td>
								<td>Win 98+ / OSX.1+</td>
								<td class="center">1.8</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Seamonkey 1.1</td>
								<td>Win 98+ / OSX.2+</td>
								<td class="center">1.8</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Gecko</td>
								<td>Epiphany 2.20</td>
								<td>Gnome</td>
								<td class="center">1.8</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Webkit</td>
								<td>Safari 1.2</td>
								<td>OSX.3</td>
								<td class="center">125.5</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Webkit</td>
								<td>Safari 1.3</td>
								<td>OSX.3</td>
								<td class="center">312.8</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Webkit</td>
								<td>Safari 2.0</td>
								<td>OSX.4+</td>
								<td class="center">419.3</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Webkit</td>
								<td>Safari 3.0</td>
								<td>OSX.4+</td>
								<td class="center">522.1</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Webkit</td>
								<td>OmniWeb 5.5</td>
								<td>OSX.4+</td>
								<td class="center">420</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Webkit</td>
								<td>iPod Touch / iPhone</td>
								<td>iPod</td>
								<td class="center">420.1</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Webkit</td>
								<td>S60</td>
								<td>S60</td>
								<td class="center">413</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Presto</td>
								<td>Opera 7.0</td>
								<td>Win 95+ / OSX.1+</td>
								<td class="center">-</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Presto</td>
								<td>Opera 7.5</td>
								<td>Win 95+ / OSX.2+</td>
								<td class="center">-</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Presto</td>
								<td>Opera 8.0</td>
								<td>Win 95+ / OSX.2+</td>
								<td class="center">-</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Presto</td>
								<td>Opera 8.5</td>
								<td>Win 95+ / OSX.2+</td>
								<td class="center">-</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Presto</td>
								<td>Opera 9.0</td>
								<td>Win 95+ / OSX.3+</td>
								<td class="center">-</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Presto</td>
								<td>Opera 9.2</td>
								<td>Win 88+ / OSX.3+</td>
								<td class="center">-</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Presto</td>
								<td>Opera 9.5</td>
								<td>Win 88+ / OSX.3+</td>
								<td class="center">-</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Presto</td>
								<td>Opera for Wii</td>
								<td>Wii</td>
								<td class="center">-</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Presto</td>
								<td>Nokia N800</td>
								<td>N800</td>
								<td class="center">-</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>Presto</td>
								<td>Nintendo DS browser</td>
								<td>Nintendo DS</td>
								<td class="center">8.5</td>
								<td class="center">C/A<sup>1</sup></td>
							</tr>
							<tr class="gradeC">
								<td>KHTML</td>
								<td>Konqureror 3.1</td>
								<td>KDE 3.1</td>
								<td class="center">3.1</td>
								<td class="center">C</td>
							</tr>
							<tr class="gradeA">
								<td>KHTML</td>
								<td>Konqureror 3.3</td>
								<td>KDE 3.3</td>
								<td class="center">3.3</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeA">
								<td>KHTML</td>
								<td>Konqureror 3.5</td>
								<td>KDE 3.5</td>
								<td class="center">3.5</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeX">
								<td>Tasman</td>
								<td>Internet Explorer 4.5</td>
								<td>Mac OS 8-9</td>
								<td class="center">-</td>
								<td class="center">X</td>
							</tr>
							<tr class="gradeC">
								<td>Tasman</td>
								<td>Internet Explorer 5.1</td>
								<td>Mac OS 7.6-9</td>
								<td class="center">1</td>
								<td class="center">C</td>
							</tr>
							<tr class="gradeC">
								<td>Tasman</td>
								<td>Internet Explorer 5.2</td>
								<td>Mac OS 8-X</td>
								<td class="center">1</td>
								<td class="center">C</td>
							</tr>
							<tr class="gradeA">
								<td>Misc</td>
								<td>NetFront 3.1</td>
								<td>Embedded devices</td>
								<td class="center">-</td>
								<td class="center">C</td>
							</tr>
							<tr class="gradeA">
								<td>Misc</td>
								<td>NetFront 3.4</td>
								<td>Embedded devices</td>
								<td class="center">-</td>
								<td class="center">A</td>
							</tr>
							<tr class="gradeX">
								<td>Misc</td>
								<td>Dillo 0.8</td>
								<td>Embedded devices</td>
								<td class="center">-</td>
								<td class="center">X</td>
							</tr>
							<tr class="gradeX">
								<td>Misc</td>
								<td>Links</td>
								<td>Text only</td>
								<td class="center">-</td>
								<td class="center">X</td>
							</tr>
							<tr class="gradeX">
								<td>Misc</td>
								<td>Lynx</td>
								<td>Text only</td>
								<td class="center">-</td>
								<td class="center">X</td>
							</tr>
							<tr class="gradeC">
								<td>Misc</td>
								<td>IE Mobile</td>
								<td>Windows Mobile 6</td>
								<td class="center">-</td>
								<td class="center">C</td>
							</tr>
							<tr class="gradeC">
								<td>Misc</td>
								<td>PSP browser</td>
								<td>PSP</td>
								<td class="center">-</td>
								<td class="center">C</td>
							</tr>
							<tr class="gradeU">
								<td>Other browsers</td>
								<td>All others</td>
								<td>-</td>
								<td class="center">-</td>
								<td class="center">U</td>
							</tr>
						--><tfoot>
							<tr>
								<th width="15%">型号</th>
								<th width="24%">名称</th>
								<th width="32%">类别</th>
								<th width="16%">价钱</th>
								<th width="13%">操作</th>
							</tr>
						</tfoot>
					</table>
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
						
						
					<div class="clear">&nbsp;</div>
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
							
							<dt><img width="16" height="16" alt="" SRC="images/book.png"></dt>
							<dd><a HREF="http://www.865171.cn">www.865171.cn</a></dd>
							<dd class="last">Datatable documentation</dd>							
						</dl>
					</div>
					<div class="content-box">
						<header>
							<h3>Tables</h3>
						</header>
						<section>
							Try other alternatives:<br/>
							<dl>
								<dt></dt>
								<dd><a HREF="http://www.865171.cn">www.865171.cn</a></dd>
							</dl>
						</section>
					</div>
				</aside>
				<!-- End of Right column/section -->
				
		</div>
		<!-- End of Wrapper -->
	</div>
	<!-- End of Page content -->
	
	<!-- 查看订单Div对话框 -->
							<div id="seeOrderDiv" style="display: none;">
								<div class="noData">
									<samp>
										补考结果
									</samp>
									<!---暂无数据 根据当前考核结果 动态修改 这个层的文本 不明白效果 问美工-->
								</div>
								<table border="0" cellpadding="6" cellspacing="1"
									class="table_popup1">
									<tr>
										<th style="display: none;">
											分数ID
										</th>
										<!-- 获得分数Id ，但不显示，只进行数据传输-->
										<th>
											学号
										</th>
										<th>
											姓名
										</th>
										<!--

					                    <th><samp>补考</samp>结果</th>
					                    -->
										<th>
											<samp>
												补考
											</samp>
											成绩
										</th>
										<th>
											<samp>
												补考
											</samp>
											次数
										</th>
									</tr>
									<tr class="table_centre">
										<td style="display: none;" id="markIdAdd"></td>
										<td id="stuNumAdd">
											0104100716
										</td>
										<td id="stuNameAdd">
											刘日斯
										</td>
										<td id="makeUpScoreAdd">
											<input type="text" size="5" maxlength="3" id="addInputScore" />
										</td>
										<td id="makeUpCountAdd"></td>
									</tr>
								</table>
							</div>
	
	
	
	
	
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