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
		<link href="css/style1.css" type="text/css" rel="stylesheet" />

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/userAction.js'></script>
		<script language="javascript" type="text/javascript"
			src="javascript/pageInfo.js"></script>
		<script language="javascript" type="text/javascript"
			src="web/common/js/jquery-1.6.2.min.js"></script>
		<script language="javascript" type="text/javascript">
	function register() {
		var userName = $("#userName").val();
		if (userName == "") {
			userName = null;
		}
		alert("userName-->"+userName);
		var password = $("#password").val();
		if (password == "") {
			password = null;
		}
		alert("password-->"+password);
		var isPassword = $("#isPassword").val();
		if (isPassword == "") {
			password = null;
		}
		alert("isPassword-->"+isPassword);
		if (password != isPassword) {
			alert("密码不一致!");
		}
		var email = $("#email").val();
		if (email == "") {
			email = null;
		}
		alert("email-->"+email);
		var telephone = $("#telephone").val();
		if (telephone == "") {
			telephone = null;
		}
		alert("telephone-->"+telephone);
		var address = $("#address").val();
		if (address == "") {
			address = null;
		}
		alert("address-->"+address);
		userAction.register(userName, password, email, telephone, address,
				function() {
					alert("注册成功!");
				});
	}
</script>
	</head>
	<body>
		<div id="wrap">
			<div id="bg">
				<div id="head">
					<ul style = "padding-top:0px;">
						<li>
							<br />
						</li>
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
					<div style = "float:left; position:relative; width:550px;">
						<div class="title">
							<span class="title_icon"><img src="images/bullet1.gif" />
							</span>Users Register
						</div>
						<div class="tishi">
							<span>赶快注册你的账号，成为我们的一员。</span>
						</div>
						<div class="login_title">
							<span>Register your account</span>
						</div>
						<div class="register_border">
							<form action="main.html" method="post">
								<div class="username">
									&nbsp;&nbsp;用户名：
									<input type="text" id="userName" />
								</div>
								<div class="username">
									&nbsp;&nbsp;密&nbsp;&nbsp;码：
									<input type="password" id="password" />
								</div>
								<div class="username">
									确认密码：
									<input type="password" id="isPassword" />
								</div>
								<div class="username">
									&nbsp;&nbsp;Email&nbsp;：
									<input type="text" id="email" />
								</div>
								<div class="username">
									&nbsp;&nbsp;电&nbsp;话&nbsp;：
									<input type="text" id="telephone" />
								</div>
								<div class="username">
									&nbsp;&nbsp;地&nbsp;址&nbsp;：
									<input type="text" id="address" />
								</div>
								<span class="button"> 
								<a href="javascript:register()" ><img src="images/register.jpg"></img> </a>
								 </span>
							</form>
						</div>
					</div>

					<div id="category">
						<div class="cart">
							<div class="cart_title">
								<span class="title_icon"><img src="images/cart.gif" /> </span>购物车
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
										alt="" /> </span>About Out Web
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
										alt="" /> </span>Promotions
							</div>
							<div class="about_title">
								<span class="title_icon"><img src="images/bullet2.gif"
										alt="" /> </span>Product List
							</div>
						</div>
						<div class="name1">
	
							<div class="picture">
								<img src="images/picture1.jpg" alt="" />
								<a href="details.html"></a>
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
								<span class="icon"><img src="images/icon.gif" alt="" /> </span>
								<a href="show.html">家&nbsp;居&nbsp;灯</a>
							</div>
							<div class="item">
								<span class="icon"><img src="images/icon.gif" alt="" /> </span>
								<a href="show.html">创&nbsp;意&nbsp;灯</a>
							</div>
							<div class="item">
								<span class="icon"><img src="images/icon.gif" alt="" /> </span>
								<a href="show.html">落&nbsp;地&nbsp;灯</a>
							</div>
							<div class="item">
								<span class="icon"><img src="images/icon.gif" alt="" /> </span>
								<a href="show.html">节&nbsp;能&nbsp;灯</a>
							</div>
							<div class="item">
								<span class="icon"><img src="images/icon.gif" alt="" /> </span>
								<a href="show.html">吸&nbsp;顶&nbsp;灯</a>
							</div>
							<div class="item">
								<span class="icon"><img src="images/icon.gif" alt="" /> </span>
								<a href="show.html">壁&nbsp;&nbsp;&nbsp;灯</a>
							</div>
							<div class="item">
								<span class="icon"><img src="images/icon.gif" alt="" /> </span>
								<a href="show.html">台&nbsp;&nbsp;&nbsp;灯</a>
							</div>
							<div class="item">
								<span class="icon"><img src="images/icon.gif" alt="" /> </span>
								<a href="show.html">吊&nbsp;&nbsp;&nbsp;灯</a>
							</div>
	
	
						</div>
					</div>
				</div>



			</div>


		</div>
	</body>
</html>
