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
		<link href="css/cart.css" type="text/css" rel="stylesheet" />
		<script language="javascript" type="text/javascript"
			src="web/common/js/jquery-1.6.2.min.js"></script>
		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/lampAction.js'></script>
		<script type="text/javascript">
	    $(document).ready(function(){
	    lampAction.cartLamp(function(data){
	       console.log("data-->"+data);
	       for(var i = 0; i<data.length; i++){
	         var lamp = data[i];
	         var lampName = lamp.lampName;
	         var price = lamp.price;
	         var pic = "images/lampImages/"+lamp.prictureImage1+".jpg";
	         var div = '<div class="show">'
					   +'<div class="picture_cart">'
					   +'<a href="details.html"><img src="'
					   +pic
					   +'" /></a>'
					   +'</div>'
					   +'<div class="produce_name">'
					   +lampName
					   +'</div>'
					   +'<div class="p_price">'
					   +price
					   +'</div>'
					   +'<div class="p_count">'
					   +'<input type="button" value="-" onclick="jian('
					   +price
					   +')"/><samp id="aaa">'
					   +1
					   +'</samp><input type="button" value="+" onclick="add('
					   +price
					   +')"/>'
					   +'</div>'
					   +'<div class="p_total"><samp id="sum">'
					   +price
					   +'</samp></div>'
					   +'<div class="p_delete" ><a href="javascript:del()"><img src="images/delete.gif" /></a></div>'
					   +'</div>';
					   $("#show_border").append(div);
	       }
	    });
	 });
	 function jian(price){
	    var smapNum = document.getElementById('aaa');
	    var num = Number(smapNum.innerHTML);
	
	    num = num - 1;
	    if(num < 0 ){
	      alert("数量已经为零，不能再减..");
	      smapNum.innerHTML = 0;
	      document.getElementById('sum').innerHTML = 0;
	    } else {
	    	smapNum.innerHTML = num;
	    }
	     var sum = num*price;
	     document.getElementById('sum').innerHTML = sum;
	 }
	 
	 function add(price) {
	 	var smapNum = document.getElementById('aaa');
	    var num = Number(smapNum.innerHTML);
	
	    num = num + 1;
	    smapNum.innerHTML = num;
	    var sum = num*price;
	     document.getElementById('sum').innerHTML = sum;
	 }
	 
	 function sum(){
	     
	 }
	 
	 function del() {
	     
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
		<div id="ccenter">
			
			
			<div id="middle" style = "width:auto;">

				<div style = "float:left; position:relative; width:540px;">
					<div id="left">
						<div class="title">
							<span class="title_icon"><img src="images/bullet1.gif" />
							</span>View Cart
						</div>
						<div id="pay">
							<span>支付：</span>
							<span class="r">￥800</span>
							<a href="pay.html"><span class="pay">结算</span>
							</a>
						</div>
						<div id="show_border">
							<div class="show_title">
								<div class="pic">
									图片
								</div>
								<div class="p_name">
									产品名
								</div>
								<div class="price">
									单价
								</div>
								<div class="count">
									数量
								</div>
								<div class="total">
									总价
								</div>
								<div class="delete">
									删除
								</div>
							</div>
							<!--<div class="show">
								<div class="picture_cart">
									<a href="details.html"><img src="images/picture1.jpg" />
									</a>
								</div>
								<div class="produce_name">
									<a href="details.html">彩瓷镂空落地灯</a>
								</div>
								<div class="p_price">
									￥ 200
								</div>
								<div class="p_count">
									<input type="button" value="-" />
									1
									<input type="button" value="+" />
								</div>
								<div class="p_total">
									￥ 200
								</div>
								<div class="p_delete">
									<img src="images/delete.gif" />
								</div>
							</div>
	
							<div class="show">
								<div class="picture_cart">
									<a href="details.html"><img src="images/picture1.jpg" />
									</a>
								</div>
								<div class="produce_name">
									<a href="details.html">彩瓷镂空落地灯</a>
								</div>
								<div class="p_price">
									￥ 200
								</div>
								<div class="p_count">
									<input type="button" value="-" />
									1
									<input type="button" value="+" />
								</div>
								<div class="p_total">
									￥ 200
								</div>
								<div class="p_delete">
									<img src="images/delete.gif" />
								</div>
							</div>
							<div class="show">
								<div class="picture_cart">
									<a href="details.html"><img src="images/picture1.jpg" />
									</a>
								</div>
								<div class="produce_name">
									<a href="details.html">彩瓷镂空落地灯</a>
								</div>
								<div class="p_price">
									￥ 200
								</div>
								<div class="p_count">
									<input type="button" value="-" />
									1
									<input type="button" value="+" />
								</div>
								<div class="p_total">
									￥ 200
								</div>
								<div class="p_delete">
									<img src="images/delete.gif" />
								</div>
							</div>
							<div class="show">
								<div class="picture_cart">
									<a href="details.html"><img src="images/picture1.jpg" />
									</a>
								</div>
								<div class="produce_name">
									<a href="details.html">彩瓷镂空落地灯</a>
								</div>
								<div class="p_price">
									￥ 200
								</div>
								<div class="p_count">
									<input type="button" value="-" />
									1
									<input type="button" value="+" />
								</div>
								<div class="p_total">
									￥ 200
								</div>
								<div class="p_delete">
									<img src="images/delete.gif" />
								</div>
							</div>
						--></div>
	
						
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

			
		</div>
	</body>
</html>
