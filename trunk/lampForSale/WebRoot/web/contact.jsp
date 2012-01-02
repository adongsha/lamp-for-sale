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
<link href="css/style1.css" type="text/css" rel="stylesheet"/>
<script language="javascript" type="text/javascript"
			src="web/common/js/jquery-1.6.2.min.js"></script>
<script type='text/javascript' src='dwr/engine.js'></script>
<script type='text/javascript' src='dwr/util.js'></script>
<script type='text/javascript' src='dwr/interface/orderAction.js'></script>
<script type='text/javascript' src='dwr/interface/userAction.js'></script>
<script type='text/javascript' src='dwr/interface/lampAction.js'></script>
<script type="text/javascript">
  $(document).ready(function(){
    userAction.loadUserName(function(data){
        $("#userName").html(data);
         }); 
    
    orderAction.orderInfo(function(data){
       console.log("data-->"+data);
       var orderId = data.orderId;
       $("#orderId").html(orderId);
       var allPrice = data.allPrice;
       $("#allPrice").html(allPrice);
       var user = data.userInfo;
       $("#userId").html(user.userId);
       $("#userName").attr("value",user.userName);
       $("#email").attr("value", user.email);
       $("#address").attr("value",user.address);
       $("#phone").attr("value", user.phone);
    }); 
  });
  
  function addOrder(){
      var orderId = document.getElementById('orderId').innerHTML;
      var allPrice = document.getElementById('allPrice').innerHTML;
      var userId   = document.getElementById('userId').innerHTML;
      var userName = $("#userName").val();
      var email = $("#email").val();
      var phone = $("#phone").val();
      var address = $("#address").val();
      var message = $("#message").val();
      orderAction.insertOrder(evalDwrData(orderId),evalDwrData(allPrice),userName,email,phone,address,message,evalDwrData(userId),function(data){
          lampAction.insertCartShop(evalDwrData(orderId));
          alert("提交成功...");
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
					<div id="middle" style = "width:auto;">
							<div style = "float:left; position:relative; width:540px;">
								<div id="left">
										<div class="title"><span class="title_icon"><img src="images/bullet1.gif" /></span>Contact Us</div>
										<div class="tishi">
										  <span>你的支持是我们无限的动力，谢谢你为我们提出宝贵的建议。</span>
										</div>
										<div class="login_title">
											<span>Send your message</span>									
										</div>
										<div class="contack_border">
										   <span  id="userId"></span>
										   
										    <div class="zhanghao">订单号：<span id="orderId">161631363</span>
										         总价：<span id="allPrice">65452</span>
										    </div>
											<div class="username">
													&nbsp;&nbsp;用户名：
													  <input type="text" name="username" id="userName"/>
											</div>
											
											<div class="username">
													&nbsp;&nbsp;Email&nbsp;：
													  <input type="text" name="email" id="email"/>
											</div>
											<div class="username">
													&nbsp;&nbsp;电&nbsp;话&nbsp;：
													  <input type="text" name="phone" id="phone"/>
											</div>
											<div class="username">
													&nbsp;&nbsp;地&nbsp;址&nbsp;：
													  <input type="text" name="address" id="address"/>
											</div>
											<div class="contact">
													&nbsp;&nbsp;信&nbsp;息&nbsp;：
													<textarea name="textarea" class="contact_textarea" cols="5" rows="5" id="message"></textarea>
											</div>
										  <div class="button">
													  <input type="reset" name="reset" value="重置"/>
													  <input type="submit" name="submit" value="提交" onclick="addOrder()"/>
										  </div>
										</div>	
								</div>
							</div>
	
	
	
	
	
					<div id="category">
					  		<div class="cart">
									  <div class="cart_title"><span class="title_icon"><img src="images/cart.gif" /></span>购物车</div>
									  <div class="home_cart_content">用戶名&brvbar;&nbsp;<span class="red" id="userName"></span>
									  </div>
									  <a href="cart.html" class="view_cart">查看购物车</a>
								  
              				</div>
							<div class="line"></div>
					  <div class="about">
									<div class="about_title"><span class="title_icon"><img src="images/bullet2.gif" alt=""/></span>About Out Web</div>
									<div class="about_t">
											<div class="about_text"> &nbsp;&nbsp;我们的网站提供了各种各样的灯饰品种繁多价格实惠。 不仅可以照亮你的蜗居而且可以美化你的房子，心动不如行动，喜欢的就把它“购”回家吧！</div>
											<div class="picture"><img src="images/about.jpg" alt=""/></div>
									</div>
					  </div>
					  	<div class="line"></div>

							<div class="cate">
									<div class="about_title"><span class="title_icon"><img src="images/bullet1.gif" alt=""/></span>Promotions</div>
									<div class="about_title"><span class="title_icon"><img src="images/bullet2.gif" alt=""/></span>Product List</div>
							</div>										
					  <div class="name1">
												
														<div class="picture">
																<a href="details.html"><img src="images/picture1.jpg" alt=""/></a>									        
														</div>
												
												<div class="picture"><a href="details.html"><img src="images/picture1.jpg" alt=""/></a></div>
												
												<div class="picture"><a href="details.html"><img src="images/picture1.jpg" alt=""/></a></div>
											
										</div>

										<div class="name">
											<div class="item">
												<span class="icon"><img src="images/icon.gif" alt=""/></span>
												<a href="show.html">家&nbsp;居&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif" alt=""/></span>
												<a href="show.html">创&nbsp;意&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif" alt=""/></span>
												<a href="show.html">落&nbsp;地&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif" alt=""/></span>
												<a href="show.html">节&nbsp;能&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif" alt=""/></span>
												<a href="show.html">吸&nbsp;顶&nbsp;灯</a>											
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif" alt=""/></span>
												<a href="show.html">壁&nbsp;&nbsp;&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif" alt=""/></span>
												<a href="show.html">台&nbsp;&nbsp;&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="images/icon.gif" alt=""/></span>
												<a href="show.html">吊&nbsp;&nbsp;&nbsp;灯</a>
											</div>
											
											
										</div>
					  </div>
					  
					  
					  
					</div>


					<div id="bottom">
										
					
					</div>
</div>
</body>
</html>
										

