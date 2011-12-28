<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>无标题文档</title>
		<link href="css/style1.css" type="text/css" rel="stylesheet" />
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
							<a href="aboutActon">关于我们</a>
						</li>
						<li>
							<a href="contactAction">联系我们</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="ccenter">
			<div id="middle" style="width: auto;">

				<div style="float: left; position: relative; width: 540px;">
					<div id="left">
						<div class="title">
							<span class="title_icon"><img src="images/bullet1.gif" />
							</span>About Us
						</div>
						<div class="tishi">
							<span>如果你有什么问题可以<a href="contact.html">联系我们</a>...</span>
						</div>
						<div class="login_title">
							<span>&nbsp;&nbsp;Briefly&nbsp;&nbsp;Explain</span>
						</div>
						<div class="about_border">
							<ol>
								<li>
									注册成为我们网站的会员，请详细填写资料。如:姓名,电话,地址,邮箱等（我现在就去
									<a href="register.html"><em>注册</em>
									</a>）.
								</li>
								<li>
									登陆我们网站查找您需要的产品，查看商品说明，也可以联系我们询问是否有您需要的产品。
								</li>
								<li>
									在线下单(不登陆/注册本站会员也可在线下订单)。具体操作步骤如下：1.点击“购买”将您需要的产品放入购物车，
									2.进入购物车核对商品并填写要货数量， 3.点击“更新购物车”， 4.进入“结算中心”，
									5.核对“商品列表”“收货人信息”并选择“配送方式”和“支付方式”， 6.提交订单。
								</li>
								<li>
									联系客服核对订购商品现货是否齐全以及确认订单。(注：已付款的订单为有效订单，未及时付款订单保留3天，3天后仍未付款自动注销，期间不对订单产品进行保留。）&nbsp;
								</li>
								<li>
									完成付款后联系客服确认发货，默认为次日发货。(根据地区不同,快递3-5天左右到货,物流7-10天到货)。
								</li>
							</ol>
							<p>
								有其他问题请
								<a href="contact.html"><em>联系我们</em>
								</a>
							</p>
						</div>
					</div>
				</div>


					<div id="category">
						<div class="cart">
							<div class="cart_title">
								<span class="title_icon"><img src="images/cart.gif" />
								</span>购物车
							</div>
							<div class="home_cart_content">
								数&nbsp;&nbsp;量&nbsp;&nbsp;&brvbar;&nbsp; &nbsp;
								<span class="red">3</span>
							</div>
							<a href="cart.html" class="view_cart">查看购物车</a>

						</div>
						<div class="line"></div>
						<div class="about">
							<div class="about_title">
								<span class="title_icon"><img src="images/bullet2.gif"
										alt="" />
								</span>About Out Web
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
								</span>Product List
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



				</div>


				<div id="bottom">
					
					
				</div>
			</div>
	</body>
</html>
