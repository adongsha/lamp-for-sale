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
<link href="web/common/css/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" /> 
<script language="javascript" type="text/javascript" src="web/common/js/jquery-1.6.2.min.js"></script> 
<script language="javascript" type="text/javascript" src="web/common/js/jquery-ui-1.8.16.custom.min.js"></script> 


<script type="text/javascript" SRC="javascript/swfobject.js"></script>
<script type="text/javascript" SRC="javascript/jquery.ui.core.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.ui.widget.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.ui.tabs.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.tipTip.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.superfish.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.supersubs.min.js"></script>
<script type="text/javascript" SRC="javascript/jquery.nyroModal.pack.js"></script>
<script type="text/javascript" SRC="javascript/jquery.validate_pack.js"></script>

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
      var lampType = lamp.type;
      if(lampType == 1){
         lampType = "家居灯 ";
      }
      if(lampType == 2){
         lampType = "创意灯  ";
      }
      if(lampType == 3){
         lampType = "落地灯  ";
      }
      if(lampType == 4){
         lampType = "吸顶灯  ";
      }
      if(lampType == 5){
         lampType = "射灯  ";
      }
      if(lampType == 6){
         lampType = "壁灯 ";
      }
      if(lampType == 7){
         lampType = "台灯  ";
      }
      if(lampType == 8){
         lampType = "吊灯  ";
      }
       var lampPricture = lamp.prictureImage1;
       var lampId = lamp.lampId;
       var p1 = "images/lampImages/"+lamp.prictureImage1+".jpg";
       var p2 = "images/lampImages/"+lamp.prictureImage2+".jpg";
       var p3 = "images/lampImages/"+lamp.prictureImage3+".jpg";
       var p4 = "images/lampImages/"+lamp.prictureImage4+".jpg";
        $("#p1").attr("href",p1);
        $("#p2").attr("href",p2);
        $("#p3").attr("href",p3);
        $("#p4").attr("href",p4);
      var div = '<div class="colgroup leading">'
				+'<div class="width1 column first ta-center">'
				+'<img SRC="images/lampImages/'
				+lampPricture+'.jpg'
				+'" alt="" style="width:80px;height=80px"/>'
				+'</div><div class="width5 column">'
				+'<a ><b class="big">'
				+lamp.lampName
				+'</b></a><br/><small><b></b>   类型: <b>'
				+lampType
				+'</b> |  型号: '
				+lamp.isbn
				+'</small><br/><a href="javascript:delLamp('+lampId+')">删除</a> '
				+'&middot; <a class="nyroModal" rel="gal" href="" id="p1">展示</a>'
				+'<a class="nyroModal" rel="gal" href="" id="p2"></a>'
                +'<a class="nyroModal" rel="gal" href="" id="p3"></a>'
                +'<a class="nyroModal" rel="gal" href="" id="p4"></a>'
				+'&middot; <a href="javascript:edit('+lampId+')">编辑</a></div>'
				+'</div>';
		$("#hr").append(div);		
    }
}

function edit(lampId){
     lampAction.detailsLamp(evalDwrData(lampId),function(data){
         var lampName = data.lampName;
         var origin = data.origin;
         var process = data.process;
         var lampType = data.type;
         var size = data.size;
         var weight = data.weight;
         var price = data.price;
         var material = data.material;
         var isbn = data.isbn;
         var lampDescription = data.lampDescription;
         $("#lampName").attr('value',lampName);
         $("#origin").attr('value',origin);
         $("#process").attr('value',process);
         //$("#lampType").attr('value',lampType);
         $("#size").attr('value',size);
         $("#weight").attr('value',weight);
         $("#price").attr('value',price);  
         $("#material").attr('value',material);
         $("#isbn").attr('value',isbn);
         $("#lampDescription").attr('value',lampDescription);
          if(lampType == 1){
         $("#jiaju").attr("selected","selected");
         }
         if(lampType == 2){
          $("#chuangyi").attr("selected","selected");
         }
         if(lampType == 3){
          $("#luodi").attr("selected","selected");
         }
         if(lampType == 4){
          $("#xiding").attr("selected","selected");
         }
         if(lampType == 5){
          $("#shedeng").attr("selected","selected");
         }
         if(lampType == 6){
         $("#bideng").attr("selected","selected");
         }
         if(lampType == 7){
         $("#taideng").attr("selected","selected");
         }
         if(lampType == 8){
          $("#diaodeng").attr("selected","selected");
         }
        });
     $("#editLamp").dialog({
        modal : true,
		show : "blind",
		hide : "blind",
		width : 700,
		height : 350,
				buttons : {
			"修改" : function() {
			    var lampName = $("#lampName").val();
			    var origin   = $("#origin").val();
			    var process  = $("#process").val();
			    var size     = $("#size").val();
                var weight   = $("#weight").val();
                var price    = $("#price").val();
                var material = $("#material").val();
                var isbn     = $("#isbn").val();
                var type     = $("#selectLampType").val();
                var lampDescription = $("#lampDescription").val();
			    console.log("lampId---->"+lampId);
			    lampAction.updateLamp(isbn, lampName, evalDwrData(type), lampDescription, evalDwrData(price), origin, size, 
			    material, process, weight,evalDwrData(lampId));
			  
	       
			            alert("修改成功..");
				$(this).dialog("close");  
			   },
			"关闭" : function() {
					$(this).dialog("close");
				}
			
		}
  }
  );
}

function delLamp(lampId){
   lampAction.delLamp(evalDwrData(lampId),function(data){
      alert("删除成功..");
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
			<h1>LampForSale</h1>
			<!-- Quick search box -->
			<form action="" method="get"><input class="" type="text" id="q" name="q" /></form>
		</div>
	</div>
	<!-- End of Page title -->
		<!-- 查看订单Div对话框 -->
							<div id="editLamp" style="display: none;"
								title="灯饰信息">
								<table border="0" cellspacing="10" width="700">
									
									<tr>
										<td class="table_title" width="10%">
											灯名：
										</td>
										<td>
											<input type="text" id="lampName"/>
										</td>
										<td class="table_title" width="10%">
											类型：
										</td>
										<td class="table_writing2" width="15%">
											<select id="selectLampType">
											  <option id="jiaju" value="1" >家居灯</option>
											  <option id="chuangyi" value="2">创意灯</option>
											  <option id="luodi" value="3">落地灯</option>
											  <option id="xiding" value="4">吸顶灯</option>
											  <option id="shedeng" value="5">射     灯</option>
											  <option id="bideng" value="6">壁     灯</option>
											  <option id="taideng" value="7">台     灯</option>
											  <option id="diaodeng" value="8">吊     灯</option>
											</select>
										</td>
										<td class="table_title" width="10%">
											价钱：
										</td>
										<td class="table_writing2">
											<input type="text" id="price"/>
										</td>
										
									</tr>
									<tr>
									   <td class="table_title" width="10%">
											产地：
										</td>
										<td class="table_writing2">
											<input type="text" id="origin"/>
										</td>
										<td class="table_title" width="10%">
											尺寸：
										</td>
										<td class="table_writing2">
											<input type="text" id="size"/>
										</td>
										<td class="table_title" width="10%">
											材料：
										</td>
										<td class="table_writing3">
											<input type="text" id="material"/>
										</td>
									</tr>
										<tr>
									   <td class="table_title" width="10%">
											工艺：
										</td>
										<td class="table_writing2">
											<input type="text" id="process"/>
										</td>
										<td class="table_title" width="10%">
											重量：
										</td>
										<td class="table_writing2">
											<input type="text" id="weight"/>
										</td>
										<td class="table_title" width="10%">
											型号：
										</td>
										<td class="table_writing3">
											<input type="text" id="isbn"/>
										</td>
									</tr>
									<tr>
									  <td valign="top">灯饰描述：</td>
									  <td colspan="5"><textarea id="lampDescription" rows="5" cols="98"></textarea></td>
									</tr>
									</table>
							</div>
	
	
	
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