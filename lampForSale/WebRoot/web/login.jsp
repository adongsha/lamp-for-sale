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
<meta http-equiv="Content-Type" content="text/html;charset=gbk" />
<title>无标题文档</title>
<link href="../css/style1.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<div id="wrap">
	<div id="bg">
		<div id="head">
				<ul>
					<li><a href="main.html">首页</a></li>
					<li><a href="show.html">灯饰</a></li>
					<li  class="selected" ><a href="login.html">我的账号</a></li>
					<li><a href="register.html">注册</a></li>
					<li><a href="cart.html">购物车</a></li>
					<li><a href="about.html">关于我们</a></li>
					<li><a href="contact.html">联系我们</a></li>
				</ul>
		</div>
	</div>
</div>
<div id="ccenter">
					<div id="middle">
								<div id="left">
										<div class="title"><span class="title_icon"><img src="../images/bullet1.gif" /></span>Users Login</div>
										<div class="tishi">
										  <p>欢迎光临...赶快登陆你账号，拍下你喜爱的灯饰。</p>
										</div>
										<div class="login_title">
											<span>Login into your account</span>										</div>
										<div class="login_border">
										<form action="main.html" method="post">
											<div class="username">
													用户名：
													  <input type="text" name="username"/>
											</div>
											<div class="username">
													密&nbsp;&nbsp;码：
													  <input type="password" name="password"/>
											</div>
										  <div class="button">
													  <input type="reset" name="reset" value="重置"/>
													  <input type="submit" name="submit" value="登陆"/>
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