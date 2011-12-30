<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="css/show.css" type="text/css" rel="stylesheet"/>
<script language="javascript" type="text/javascript" src="web/common/js/jquery-1.6.2.min.js"></script> 
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='dwr/interface/lampAction.js'></script>
<script language="javascript" type="text/javascript" src="javascript/pageInfo.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
     executeQuery(lampAction.lampListByPage,[lampShow]);
   })
   
   function lampShow(data){
    console.log("data-->"+data);
   var page = data.pageInfo;
   var lamps = data.lampVos;
   if(data == null || data.length == 0){
      alert("没有订单！ ");
      return;
   }
   if(!page){
   alert("出错了！请重试...");
   }
   //alert(page.totalPage+"|"+page.pageIndex+"|"+page.pageSize+"|"+page.totalRec);
   initPage(page.totalPage, page.pageIndex, page.pageSize, page.totalRec);
   for(var i = 0; i < lamps.length; i++){
      var lamp = lamps[i];
      var lampId = lamp.lampId;
      var lampName = lamp.lampName;
      var lampPrice = lamp.price;
      var lampPricture = lamp.prictureImage1;
      
      var div = '<div class="element">'
			   +'<div class="row_title">'
			   +'<div class="text">'
			   +'<a href="detailsLampAction.action?lampId='
			   +lampId
			   +'"><samp>'
			   +lampName
			   +'<samp></a></div></div>'
		       +'<div class="row">'
			   +'<div class="image">'
			   +'<a href="detailsLampAction.action?lampId='
			   +lampId
			   +'"><img src="images/lampImages/'
			   +lampPricture+'.jpg'
			   +'"  alt=""/></a>'
			   +'</div>'
			   +'<div class="price">'
			   +'<div class="sale"><img src="images/sale.gif" alt=""/></div>'
			   +'<div class="num">￥'
			   +lampPrice
			   +'</div>'
			   +'</div></div></div>' ;
			   $("#showLamp").append(div);
   }
   }

   
   
   
   function showLampType(data){
      var type = data;
      if(type == ""){
          type = null;      
      }
      executeQuery(lampAction.lampTypeListByPage,[evalDwrData(type),lampShow]);
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
<div id="wrap">
	<div id="bg">
		<div id="head">
				<ul>
					<li class="selected" ><a href="lampAction">首页</a></li>
					<li><a href="showLampAction">灯饰</a></li>
					<li><a href="loginAction">我的账号</a></li>
					<li><a href="registerAction">注册</a></li>
					<li><a href="cartAction">购物车</a></li>
					<li><a href="aboutAction">关于我们</a></li>
					<li><a href="contactAction">联系我们</a></li>
				</ul>
		</div>
	</div>
</div>


<div id="ccenter">
					<div id="middle">

								
								<div id="left">
									<div class="title"><span class="title_icon"><img src="images/bullet1.gif" /></span>Produce Show </div>
								  <div class="picture_show" id="showLamp">
											
										  </div>
						
										  
							<div id="allDataDiv">
							<!--上一页，下一页 开始-->
							<table width="100%" class="pagecss">
								<tr>
									<td align="left">
										<span id="AllPage">共几页/几条</span>
										<!--
										<span id="setupNum">显示每页记录条数</span>
										<select id="setSize"
											onchange="ajaxChangeCount(this.options[this.options.selectedIndex].value)">
										</select>
										-->
										<span id="Flexigrid_Bar"><a href="">上5页</a><span
											>1</span><a href="">2</a><a href="">3</a><a
											href="">下5页</a> </span>
										<span id="checkPage"><input type="text"
												style="width: 20px;" />&nbsp;页<a href="">GO</a> </span>
									</td>
								</tr>
							</table>
							<!--上一页，下一页 结束-->
						</div>	
								  </div>
				</div>
	
	
	
	
	<div id="category">
					  		<div class="cart">
									  <div class="cart_title"><span class="title_icon"><img src="images/cart.gif" /></span>购物车</div>
									  <div class="home_cart_content">数&nbsp;&nbsp;量&nbsp;&nbsp;&brvbar;&nbsp; &nbsp;<span class="red">3</span>
									  </div>
									  <a href="cart.html" class="view_cart">查看购物车</a>
								  
              				</div>
							<div class="line"></div>
					  <div class="about">
									<div class="about_title"><span class="title_icon"><img src="images/bullet2.gif"/></span>About Out Web</div>
									<div class="about_t">
											<div class="about_text"> &nbsp;&nbsp;我们的网站提供了各种各样的灯饰品种繁多价格实惠。 不仅可以照亮你的蜗居而且可以美化你的房子，心动不如行动，喜欢的就把它“购”回家吧！</div>
											<div class="picture"><img src="images/about.jpg"/></div>
									</div>
					  </div>
					  	<div class="line"></div>

							<div class="cate">
									<div class="about_title"><span class="title_icon"><img src="images/bullet1.gif"/></span>Promotions</div>
									<div class="about_title"><span class="title_icon"><img src="images/bullet2.gif"/></span>Product List</div>
							</div>										
					  <div class="name1">
												
														<div class="picture">
																<a href="details.html"><img src="images/picture1.jpg"/></a>									        
														</div>
												
												<div class="picture"><a href="details.html"><img src="images/picture1.jpg" /></a></div>
												
												<div class="picture"><a href="details.html"><img src="images/picture1.jpg"/></a></div>
											
										</div>

										<div class="name">
											<div class="item">
												<span class="icon"><img src="images/icon.gif"/></span>
												<a href="javascript:showLampType(1)">家&nbsp;居&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif"/></span>
												<a href="javascript:showLampType(2)">创&nbsp;意&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif"/></span>
												<a href="javascript:showLampType(3)">落&nbsp;地&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif"/></span>
												<a href="javascript:showLampType(4)">吸&nbsp;顶&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif"/></span>
												<a href="javascript:showLampType(5)">射&nbsp;&nbsp;&nbsp;灯</a>											
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif"/></span>
												<a href="javascript:showLampType(6)">壁&nbsp;&nbsp;&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif"/></span>
												<a href="javascript:showLampType(7)">台&nbsp;&nbsp;&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif"/></span>
												<a href="javascript:showLampType(8)">吊&nbsp;&nbsp;&nbsp;灯</a>
											</div>
										</div>
					  </div>
					</div>
					

</body>
</html>
