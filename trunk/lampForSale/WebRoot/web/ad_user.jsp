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
<title>UserManger</title>
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
<script type='text/javascript' src='dwr/interface/userAction.js'></script>
<script language="javascript" type="text/javascript" src="javascript/pageInfo.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    userAction.countPower(function(data) {
       var admin = data.admin;
       var ordinary = data.ordinary;
       $("#admin").html(admin);
       $("#ordinary").html(ordinary);
    });
	executeQuery(userAction.userListByPage,[userLists]);
});

function userLists(data){
    var page = data.pageInfo;
    var users = data.userLists;
    var index = 0;
    if(data == null || data.length == 0){
      alert("没有订单！ ");
      return;
   }
   if(!page){
   alert("出错了！请重试...");
   }
   initPage(page.totalPage, page.pageIndex, page.pageSize, page.totalRec);
   for(var i = 0; i< users.length; i++){
      index = index + 1;
      var user = users[i];
      var userName = user.userName;
      var power    = user.power;
      var email    = user.email;
      var phone    = user.phone;
      var address  = user.address;
      var userId   = user.userId;
      console.log("userName:"+userName);
      console.log("power:"+power);
      console.log("email:"+email);
      console.log("phone:"+phone);
      console.log("address:"+address);
      console.log("userid:"+userId);
      if(power == 0){
        power = '普通用户 ';
      } 
      if(power == 1){
        power = '管理人 ';
      }
      var tr =   '<tr id="tr'+userId+'">'
				+'<td width="15%">'+index+'</td>'
				+'<td width="30%">'+userName+'</td>'
				+'<td width="25%">'+power+'</td>'
				+'<td width="30%"><a href="javascript:seeUser(\''+userName+'\',\''
				+power+'\',\''+email+'\',\''+phone+'\',\''+address+'\')" alt="">查看</a> |'
				+'<a href="javascript:deleteUser('+userId+')"> 删除</a></td>'
				+'</tr>'
		$("#th").append(tr);		
   }
}

function seeUser(userName, power, email, phone, address){
   $("#userName").html(userName);
   $("#power").attr('value',power);
   $("#telephone").attr('value',phone);
   $("#email").attr('value',email);
   $("#address").attr('value',address);
   $("#seeUserDiv").dialog({
      modal : true,
      show  : "blind",
      hide  : "blind",
      width : 500,
      height: 250,
      buttons : {
        "修改" : function() {
        
        },
        "关闭" : function() {
           $(this).dialog("close");
        }
      }
   });
}

function deleteUser(userId){
   userAction.deleteUser(evalDwrData(userId),function(data){
       var tag = "#tr"+userId;
       $(tag).hide("show");
   });
}

 // 将DWR中值转化以便于传递后台
function evalDwrData(data) {
	if (!data) {
		return null;
	}
	if (data == "") {
		return null;
	}

	return eval(data);
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
					
					<h3>用户统计</h3>
					
					<div class="box box-info">点击显示说明</div>
					
					<table id="report" class="stylized full" style="">
						<thead>
							<tr>
								<th>用户</th>
								<th class="ta-right"></th>
                                <th>人数</th>
								<th class="ta-right"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="title">
									<div>
										<a href="#"><b>管理人</b></a>
									</div>
								</td>
								<td class="ta-right"></td>
                                <td id="admin"></td>
								<td class="ta-right"></td>
							</tr>
							<tr>
								<td class="title">
									<div>
										<a href="#"><b>普通用户</b></a>
									</div>
								</td>
								<td class="ta-right"></td>
                                <td id="ordinary"></td>
								<td class="ta-right"></td>
							</tr>
						</tbody>
					</table>
					
					<div class="clear">&nbsp;</div>
					
					<h3>用户列表</h3>
					<table class="display stylized" id="example">
						<thead id="th">
							<tr>
								<th width="15%">序号</th>
								<th width="30%">用户</th>
								<th width="25%">级别</th>
								<th width="30%">操作</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th width="15%">序号</th>
								<th width="30%">用户</th>
								<th width="25%">级别</th>
								<th width="30%">操作</th>
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
								<dt><br></dt>
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
							<div id="seeUserDiv" style="display: none;"
								title="用户信息<samp></samp>">
								<table border="0" cellspacing="10" width="450">
									<tr>
										<th colspan="4">
											用户名:&nbsp;
											<samp id="userName" >
												
											</samp>
										</th>
									</tr>
									<tr>
                                      <td class="table_title" >
											权限:
										</td>									
									<td class="table_writing2" >
									
									<select id="power">
										<option>
											管理人
										</option>
										<option>
											普通用户
										</option>
									</select>
										</td>
											<td class="table_title" >
											邮件:
										</td>
										<td width="15%">
											<input type="text" id="email"/>
										</td>
										
									</tr>
									<tr>
									   <td class="table_title" >
											电话号码:
										</td>
										<td class="table_writing2" >
											<input type="text" id="telephone"/>
										</td>
										<td class="table_title">
											地址
										</td>
										<td class="table_writing2" >
											<input type="text" id="address"/>
										</td>
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