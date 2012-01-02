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
<title>Order Lamp</title>
<meta name="description" content="Administry - Admin Template by www.865171.cn" />
<meta name="keywords" content="Admin,Template" />
<!-- Favicons --> 
<link rel="shortcut icon" type="image/png" HREF="images/favicons/favicon.png"/>
<link rel="icon" type="image/png" HREF="images/favicons/favicon.png"/>
<link rel="apple-touch-icon" HREF="images/favicons/apple.png" />
<!-- Main Stylesheet --> 
<link rel="stylesheet" href="css/style.css" type="text/css" />
<!-- Your Custom Stylesheet --> 
<link rel="stylesheet" href="css/custom.css" type="text/css" />

<link href="web/common/css/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" /> 
<script language="javascript" type="text/javascript" src="web/common/js/jquery-1.6.2.min.js"></script> 
<script language="javascript" type="text/javascript" src="web/common/js/jquery-ui-1.8.16.custom.min.js"></script> 

<!--swfobject - needed only if you require <video> tag support for older browsers -->
<script type="text/javascript" SRC="javascript/swfobject.js"></script>
<!-- jQuery with plugins -->
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
      orderStatus = "处理";
   }
   var orderId = order.orderId;
   var userName = order.userName;
   var address = order.orderAddress;
   var email = order.orderEmail;
   var telephone = order.orderPhone;
   var message = order.message;
   var code  = order.code;
   var orderTime = order.orderTime;
   var allPrice = order.allPrice;
   var tr = '<tr><td width="15%">'
          +orderId
          +'</td><td width="24%">'
          +userName
          +'</td><td width="32%">'
          +'<a '
          +orderId
          +' onclick="seeOrder(\''
          +orderStatus+'\',\''+orderId+'\',\''+userName+'\',\''+address+'\',\''+email+'\',\''+telephone+'\',\''
          +message+'\',\''+code+'\',\''+orderTime+'\',\''+allPrice
          +'\')">查看</a> | <a href="" id="'
          +orderId
          +'">删除</a></td><td width="16%">'
          +allPrice
          +'</td><td width="13%"><a href="" onclick="delOrder">'
          +orderStatus
          +'</a></td></tr>'
    $("#example").append(tr);
   } 
}

function seeOrder(orderStatus, orderId, userName, address, email, telephone, message, code, orderTime, allPrice){
      console.log("orderId-->"+orderId);
      console.log("userName-->"+userName);
      console.log("address-->"+address);
      console.log("email-->"+email);
      console.log("telephone-->"+telephone);
      console.log("message-->"+message);
      console.log("code-->"+code);
      console.log("orderTime-->"+orderTime);
      console.log("allPrice-->"+allPrice);
      $("#orderId").html(orderId);
      $("#userName").html(userName);
      $("#address").html(address);
      $("#email").html(email);
      $("#telephone").html(telephone);
      $("#message").html(message);
      $("#code").html(code);
      $("#orderTime").html(orderTime);
      $("#allPrice").html(allPrice);
  //拿到指定订单 列出订单表 
  
  $("#seeOrderDiv").dialog({
        modal : true,
		show : "blind",
		hide : "blind",
		width : 700,
		height : 350,
				buttons : {
			"关闭" : function() {
				
					$(this).dialog("close");
				}
		}
  }
  );
}



function delOrder(){

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
									</div>
								</td>
								<td class="ta-right" id="notDealorder"></td>
								<td class="ta-right" id="notDealAmount"></td>
							</tr>
							<tr>
								<td class="title">
									<div>
										<a href="#"><b>以处理的订单</b></a>
										
									</div>
								</td>
								<td class="ta-right" id="dealorder"></td>
								<td class="ta-right" id="dealAmount"></td>
							</tr>
							<tr>
								<td class="title">
									<div>
										<a href="#"><b>有问题的订单</b></a>
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
								<th width="32%">操作</th>
								<th width="16%">总价钱</th>
								<th width="13%">是否处理</th>
                             
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th width="15%">订单号</th>
								<th width="24%">用户名</th>
								<th width="32%">操作</th>
								<th width="16%">总价钱</th>
								<th width="13%">是否处理</th>
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
							<dd><a HREF="">www.865171.cn</a></dd>
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
								<dd><a HREF="">www.865171.cn</a></dd>
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
							<div id="seeOrderDiv" style="display: none;"
								title="订单信息：<samp>123456789</samp>">
								<table border="0" cellspacing="10" width="700">
									<tr>
										<th colspan="4">
											订单号:&nbsp;
											<samp id="orderId" >
												010416524
											</samp>
											&nbsp;&nbsp;顾客名:&nbsp;
											<samp id="userName" >
												张三
											</samp>
										</th>
									</tr>
									<tr>
										<td class="table_title" width="10%">
											送货地址:
										</td>
										<td id="address" width="15%">
											<samp id="studentName" >
												张三
											</samp>
										</td>
										<td class="table_title" width="10%">
											电话号码:
										</td>
										<td class="table_writing2" id="telephone" width="15%">
											13750042440
										</td>
										<td class="table_title" width="10%">
											订单时间:
										</td>
										<td class="table_writing2" id="orderTime" width="15%">
											2011-12-25
										</td>
										<td class="table_title" width="10%">
											订单状态:
										</td>
										<td class="table_writing2" id="orderStatus" width="15%">
											未处理
										</td>
									</tr>
									<tr>
									   <td class="table_title" width="10%">
											订单邮编:
										</td>
										<td class="table_writing2" id="code" width="15%">
											519090
										</td>
										<td class="table_title" width="10%">
											订单备注:
										</td>
										<td class="table_writing2" id="message" width="15%">
											请速度发货
										</td>
										<td class="table_title" width="10%">
											订单邮件:
										</td>
										<td class="table_writing3" id="email" width="15%">
											106890194@qq.com
										</td>
										<td class="table_title" width="10%">
											订单总价:
										</td>
										<td class="table_writing4" id="allPrice" width="15%">
											1000￥
										</td>
									</tr>
									</table>
									
									
									
					<table class="display stylized" id="seeOrderList">
						<thead>
							<tr>
								<th >序号</th>
								<th >灯名</th>
								<th >单价</th>
								<th >数量</th>
								<th >总价</th>
							</tr>
						</thead>
						
							<tfoot>
							<tr>
								<th >序号</th>
								<th >灯名</th>
								<th >单价</th>
								<th >数量</th>
								<th >总价</th>
							</tr>
						</tfoot>
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

<!-- User interface javascript load -->
<script type="text/javascript" SRC="javascript/administry.js"></script>
</body>
</html>