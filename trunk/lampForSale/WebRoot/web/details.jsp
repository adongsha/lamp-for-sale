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
		<link href="css/style.css" type="text/css" rel="stylesheet" />
		<link href="css/style1.css" type="text/css" rel="stylesheet" />
		<link href="css/style2.css" type="text/css" rel="stylesheet" />
		<link href="css/lightbox.css" type="text/css" rel="stylesheet" />
		
		<!--<script src="javascript/scriptaculous.js?load=effects"
			type="text/javascript"></script>
		<script type="text/javascript" src="javascript/java.js"></script>
		--><script language="javascript" type="text/javascript"
			src="web/common/js/jquery-1.6.2.min.js"></script>
		<script type="text/javascript" src="javascript/jquery.nyroModal.pack.js"></script>
		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/lampAction.js'></script>
		<script type='text/javascript' src='dwr/interface/userAction.js'></script>
		<script type="text/javascript">

$(document).ready(function(){
   var lampId = GetQueryString("lampId");
   if(lampId == ""){
     lampId = null;
   }
   lampAction.detailsLamp(evalDwrData(lampId),function(data) {
    var lampDescription = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+data.lampDescription;
    var prictureImage1 = data.prictureImage1+".jpg";
    var pri = "images/lampImages/"+prictureImage1
    var price = data.price+"￥";
    var p1 = "images/lampImages/"+data.prictureImage1+".jpg";
    var p2 = "images/lampImages/"+data.prictureImage2+".jpg";
    var p3 = "images/lampImages/"+data.prictureImage3+".jpg";
    var p4 = "images/lampImages/"+data.prictureImage4+".jpg";
        $("#p1").attr("href",p1);
        $("#p2").attr("href",p2);
        $("#p3").attr("href",p3);
        $("#p4").attr("href",p4);
       
    $("#price").html(price);
    $("#description").html(lampDescription);
    $("#img").attr("src",pri);
   });
   
   userAction.loadUserName(function(data){
        $("#userName").html(data);
     });
});


function cartAddOne() {
     var lampId = GetQueryString("lampId");
     if(lampId == ""){
       lampId = null;
     }
     
     lampAction.addLampToCart(evalDwrData(lampId),1);
     
     lampAction.cartCount(function(data) {
            console.log("data-->"+data);
         $("#count").html(data);
     });
}



//通过js获取URL的值 
function GetQueryString(name){
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
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
						<li class="selected">
							<a href="lampAction">首页</a>
						</li>
						<li>
							<a href="showLampAction">灯饰</a>
						</li>
						<li>
							<a href="loginAction">我的账号</a>
						</li>
						<li>
							<a href="registerAction">注册</a>
						</li>
						<li>
							<a href="cartAction">购物车</a>
						</li>
						<li>
							<a href="aboutAction">关于我们</a>
						</li>
						<li>
							<a href="contactAction">联系我们</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="d_ccenter">
			<div id="d_middle">
			<div style = "float:left; position:relative;">
				<div class="left_content">
					<div class="title">
						<span class="title_icon"><img src="images/bullet1.gif"
								alt="" title="" />
						</span>灯饰详情
					</div>

					<div class="feat_prod_box_details">

						<div class="prod_img">
							<!--<a class="nyroModal" rel="gal" href="" id="p1">--><img src="" alt="" title="" border="0"
									id="img" height="150" width="150" />
							<!--</a>
                            <a class="nyroModal" rel="gal" href="" id="p2"></a>
                            <a class="nyroModal" rel="gal" href="" id="p3"></a> 
                            <a class="nyroModal" rel="gal" href="" id="p4"></a>
							--><br />
							<br />
							<a class="nyroModal" rel="gal" href="" id="p1"><img
									src="images/zoom.gif" alt="" title="" border="0" />
							</a>
							<a class="nyroModal" rel="gal" href="" id="p2"></a>
                            <a class="nyroModal" rel="gal" href="" id="p3"></a> 
                            <a class="nyroModal" rel="gal" href="" id="p4"></a>
						</div>

						<div class="prod_det_box">
							<div class="box_top"></div>
							<div class="box_center">
								<div class="prod_title">
									详情
								</div>
								<p class="details" id="description">
									
								</p>
								<div class="price">
									<strong>价钱:</strong>
									<span class="red" id="price">￥</span>
								</div>
								<a href="javascript:cartAddOne()" class="more"><img
										src="images/order_now.gif" alt="" title="" border="0" />
								</a>
								<div class="clear"></div>
							</div>

							<div class="box_bottom"></div>
						</div>
						<div class="clear"></div>
					</div>


					<div id="demo" class="demolayout">

						<ul id="demo-nav" class="demolayout">
							<li>
								<a class="active" href="">详细信息</a>
							</li>
							<li>
								<a class="" href="PingLun">评论</a>
							</li>
						</ul>

						<div class="tabs-container">

							<div style="display: block;" class="tab" id="tab1">
								<table>
								  <tr>
								    <td>产品名称：</td>
								    <td id="lampName"></td>
								   
								    <td>型号：</td>
								    <td id="isbn"></td>
								  </tr>
								   <tr>
								    <td>灯身材料：</td>
								    <td id="material"></td>
								    <td>品牌：</td>
								    <td>Pattriot</td>
								  </tr>
								   <tr>
								    <td>光源类型：</td>
								    <td>白炽灯</td>
								    <td>工艺：</td>
								    <td id="process"></td>
								  </tr>
								  <tr>
								   <td>灯罩材料：</td>
								    <td>水晶</td>
								     <td>光源个数：</td>
								    <td>15到20</td>
								  </tr>
								   <tr>
								    <td>照射面积：</td>
								    <td>15-30平方米</td>
								    <td>灯具是否带光源：</td>
								    <td>不带光源</td>
								  </tr>
								   <tr>
								    <td>合适的光源功率：</td>
								    <td>31-40W</td>
								    <td>合适空间：</td>
								    <td>客厅 、 卧室</td>
								  </tr>
								  <tr>
								    <td>风格：</td>
								    <td>简约现代</td>
								     <td>电压：</td>
								    <td>220V</td>
								  </tr>
								</table>
							</div>
							
							<div class="clear"></div>
						</div>

					</div>


				</div>
			</div>
				
			<div id="d_category">
				<div class="cart">
					<div class="cart_title">
						<span class="title_icon"><img src="images/cart.gif" />
						</span>购物车
					</div>
					<div class="home_cart_content">
						用户名&brvbar;&nbsp; &nbsp;
						<span class="red" id="userName"></span>
					</div>
					<a href="cartAction" class="view_cart">查看购物车</a>

				</div>
				<div class="line"></div>
				<div class="about">
					<div class="about_title">
						<span class="title_icon"><img src="images/bullet2.gif"
								alt="" />
						</span>关于本店网站
					</div>
					<div class="about_t">
						<div class="about_text">
							&nbsp;&nbsp;我们的网站提供了各种各样的灯饰品种繁多价格实惠。
							不仅可以照亮你的蜗居而且可以美化你的房子，心动不如行动，喜欢的就把它“购”回家吧！
						</div>
						<div class="picture">
							<img src="images/about.jpg" alt="" />
						</div>
					</div>
				</div>
				<div class="line"></div>

				<div class="cate">
					<div class="about_title">
						<span class="title_icon"><img src="images/bullet1.gif"
								alt="" />
						</span>Promotions
					</div>
					<div class="about_title">
						<span class="title_icon"><img src="images/bullet2.gif"
								alt="" />
						</span>灯饰类别
					</div>
				</div>
				<div class="name1">

					<div class="picture">
						<a href="details.html"><img src="images/picture1.jpg" alt="" />
						</a>
					</div>

					<div class="picture">
						<a href="details.html"><img src="images/picture1.jpg" alt="" />
						</a>
					</div>

					<div class="picture">
						<a href="details.html"><img src="images/picture1.jpg" alt="" />
						</a>
					</div>

				</div>

				<div class="name">
					<div class="item">
						<span class="icon"><img src="images/icon.gif" alt="" />
						</span>
						<a href="show.html">家&nbsp;居&nbsp;灯</a>
					</div>
					<div class="item">
						<span class="icon"><img src="images/icon.gif" alt="" />
						</span>
						<a href="show.html">创&nbsp;意&nbsp;灯</a>
					</div>
					<div class="item">
						<span class="icon"><img src="images/icon.gif" alt="" />
						</span>
						<a href="show.html">落&nbsp;地&nbsp;灯</a>
					</div>
					<div class="item">
						<span class="icon"><img src="images/icon.gif" alt="" />
						</span>
						<a href="show.html">节&nbsp;能&nbsp;灯</a>
					</div>
					<div class="item">
						<span class="icon"><img src="images/icon.gif" alt="" />
						</span>
						<a href="show.html">吸&nbsp;顶&nbsp;灯</a>
					</div>
					<div class="item">
						<span class="icon"><img src="images/icon.gif" alt="" />
						</span>
						<a href="show.html">壁&nbsp;&nbsp;&nbsp;灯</a>
					</div>
					<div class="item">
						<span class="icon"><img src="images/icon.gif" alt="" />
						</span>
						<a href="show.html">台&nbsp;&nbsp;&nbsp;灯</a>
					</div>
					<div class="item">
						<span class="icon"><img src="images/icon.gif" alt="" />
						</span>
						<a href="show.html">吊&nbsp;&nbsp;&nbsp;灯</a>
					</div>


				</div>
			</div>



				<div class="clear"></div>
			</div>
			<!--end of left content-->




		</div>


		<div id="bottom">
			<div class="bottom">
				<a href="main.html"><span>.首页</span>
				</a>
				<a href="show.html"><span>.灯饰</span>
				</a>
				<a href="into.html"><span>.进入后台</span>
				</a>
				<a href="contact.html"><span>.联系我们</span>
				</a>
			</div>
			<div class="copyright">
				<span>&copy;Copyright:</span>
				<span>王华君&nbsp;王海静&nbsp;梁绮红&nbsp;关伟海&nbsp;陆永坚</span>
			</div>

		</div>
		</div>
	</body>
</html>
