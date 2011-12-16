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
<link href="../css/cart.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<div id="wrap">
	<div id="bg">
		<div id="head">
				<ul>
					<li><a href="main.html">首页</a></li>
					<li><a href="show.html">灯饰</a></li>
					<li><a href="login.html">我的账号</a></li>
					<li><a href="register.html">注册</a></li>
					<li class="selected" ><a href="cart.html">购物车</a></li>
					<li><a href="about.html">关于我们</a></li>
					<li><a href="contact.html">联系我们</a></li>
				</ul>
		</div>
	</div>
</div>
<div id="ccenter">
					<div id="middle">

								
								<div id="left">
											<div class="title"><span class="title_icon"><img src="../images/bullet1.gif" /></span>View Cart</div>
											<div id="pay">
												<span>支付：</span>
												<span class="r">￥800</span>
												<a href="pay.html"><span class="pay">结算</span></a>
											</div>
											<div id="show_border">
												<div class="show_title">
													<div class="pic">图片</div>
													<div class="p_name">产品名</div>
													<div class="price">单价</div>
													<div class="count">数量</div>
													<div class="total">总价</div>
													<div class="delete">删除</div>
												</div>
												<div class="show">
													<div class="picture_cart"><a href="details.html"><img src="../images/picture1.jpg"/></a></div>
													<div class="produce_name"><a href="details.html">彩瓷镂空落地灯</a></div>
													<div class="p_price">￥ 200</div>
													<div class="p_count"><input type="button" value="-"/>1<input type="button" value="+"/></div>
													<div class="p_total">￥ 200</div>
													<div class="p_delete"><img src="../images/delete.gif"/></div>
												</div>
												
												<div class="show">
													<div class="picture_cart"><a href="details.html"><img src="../images/picture1.jpg"/></a></div>
													<div class="produce_name"><a href="details.html">彩瓷镂空落地灯</a></div>
													<div class="p_price">￥ 200</div>
													<div class="p_count"><input type="button" value="-"/>1<input type="button" value="+"/></div>
													<div class="p_total">￥ 200</div>
													<div class="p_delete"><img src="../images/delete.gif"/></div>
												</div>
												<div class="show">
													<div class="picture_cart"><a href="details.html"><img src="../images/picture1.jpg"/></a></div>
													<div class="produce_name"><a href="details.html">彩瓷镂空落地灯</a></div>
													<div class="p_price">￥ 200</div>
													<div class="p_count"><input type="button" value="-"/>1<input type="button" value="+"/></div>
													<div class="p_total">￥ 200</div>
													<div class="p_delete"><img src="../images/delete.gif"/></div>
												</div>
												<div class="show">
													<div class="picture_cart"><a href="details.html"><img src="../images/picture1.jpg"/></a></div>
													<div class="produce_name"><a href="details.html">彩瓷镂空落地灯</a></div>
													<div class="p_price">￥ 200</div>
													<div class="p_count"><input type="button" value="-"/>1<input type="button" value="+"/></div>
													<div class="p_total">￥ 200</div>
													<div class="p_delete"><img src="../images/delete.gif"/></div>
												</div>
											</div>
											
											<div class="next">
												<span>&nbsp;&lt; 上一页</span>
												<span>1 2 3 4 5  ...</span>
												<span>&nbsp;下一页 &gt;</span>
												&nbsp;&nbsp;<a href="show.html">继续购物</a>
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
												
												<div class="picture"><a href="details.html"><img src="../images/picture1.jpg" alt="" /></a></div>
												
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
