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
<link href="../css/style1.css" type="text/css" rel="stylesheet"/>
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
										<div class="title"><span class="title_icon"><img src="../images/bullet1.gif" /></span>Pay Message </div>
										<div class="tips">
											<span>您本次需要支付:</span>
											<span class="red">￥800</span>
										</div>
										<div class="login_title">
											<span>&nbsp;Pay for your goods </span>										</div>
										<div class="pay_border">
										
										<form action="cart.html" method="post">
											<div class="username">
													&nbsp;收货人&nbsp;：
													  <input type="text" name="consignee"/>
											</div>
											<div class="username">
													联系电话：
													  <input type="text" name="phone"/>
											</div>
											<div class="username">
													收货地址：
													  <input type="text" name="address"/>
											</div>
											<div class="username">
													支付密码：
													  <input type="password" name="pay_password"/>
											</div>
										  <div class="button">
													  <input type="reset" name="reset" value="重置"/>
													  <input type="submit" name="submit" value="确定"/>
										  </div>
										  </form>
										</div>	
								</div>

	
					<div id="category">
					  		<div class="cart">
									  <div class="cart_title"><span class="title_icon"><img src="../images/cart.gif" /></span>购物车</div>
									  <div class="home_cart_content">数&nbsp;&nbsp;量&nbsp;&nbsp;&brvbar;&nbsp; &nbsp;<span class="red">3</span>
									  </div>
									  <a href="cart.html" class="view_cart">查看购物车</a>
								  
              				</div>
							<div class="line"></div>
					  <div class="about">
									<div class="about_title"><span class="title_icon"><img src="../images/bullet2.gif" alt=""/></span>About Out Web</div>
									<div class="about_t">
											<div class="about_text"> &nbsp;&nbsp;我们的网站提供了各种各样的灯饰品种繁多价格实惠。 不仅可以照亮你的蜗居而且可以美化你的房子，心动不如行动，喜欢的就把它“购”回家吧！</div>
											<div class="picture"><img src="../images/about.jpg" alt=""/></div>
									</div>
					  </div>
					  	<div class="line"></div>

							<div class="cate">
									<div class="about_title"><span class="title_icon"><img src="../images/bullet1.gif" alt=""/></span>Promotions</div>
									<div class="about_title"><span class="title_icon"><img src="../images/bullet2.gif" alt=""/></span>Product List</div>
							</div>										
					  <div class="name1">
												
														<div class="picture">
																<a href="details.html"><img src="../images/picture1.jpg" alt=""/></a>									        
														</div>
												
												<div class="picture"><a href="details.html"><img src="../images/picture1.jpg" alt=""/></a></div>
												
												<div class="picture"><a href="details.html"><img src="../images/picture1.jpg" alt=""/></a></div>
											
										</div>

										<div class="name">
											<div class="item">
												<span class="icon"><img src="../images/icon.gif" alt=""/></span>
												<a href="show.html">家&nbsp;居&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="../images/icon.gif" alt=""/></span>
												<a href="show.html">创&nbsp;意&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="../images/icon.gif" alt=""/></span>
												<a href="show.html">落&nbsp;地&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="../images/icon.gif" alt=""/></span>
												<a href="show.html">节&nbsp;能&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="../images/icon.gif" alt=""/></span>
												<a href="show.html">吸&nbsp;顶&nbsp;灯</a>											
											</div>
											<div class="item">
												<span class="icon"><img src="../images/icon.gif" alt=""/></span>
												<a href="show.html">壁&nbsp;&nbsp;&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="../images/icon.gif" alt=""/></span>
												<a href="show.html">台&nbsp;&nbsp;&nbsp;灯</a>
											</div>
											<div class="item">
												<span class="icon"><img src="../images/icon.gif" alt=""/></span>
												<a href="show.html">吊&nbsp;&nbsp;&nbsp;灯</a>
											</div>
											
											
										</div>
					  </div>
					  
					  
					  
					</div>


					<div id="bottom">
										<div class="bottom">
											<a href="main.html"><span>.首页</span></a>
											<a href="show.html"><span>.灯饰</span></a>
											<a href="into.html"><span>.进入后台</span></a>
											<a href="contact.html"><span>.联系我们</span></a>
										</div>
										<div class="copyright">
											<span>&copy;Copyright:</span>
											<span>王华君&nbsp;王海静&nbsp;梁绮红&nbsp;关伟海&nbsp;陆永坚</span>
										</div>
					
					
					</div>
</div>
</body>
</html>
