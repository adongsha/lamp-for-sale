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
		<link href="web/common/css/jquery-ui-1.8.16.custom.css"
			rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript"
			src="web/common/js/jquery-1.6.2.min.js"></script>
		<script language="javascript" type="text/javascript"
			src="web/common/js/jquery-ui-1.8.16.custom.min.js"></script>
		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/lampAction.js'></script>
		<script type='text/javascript' src='dwr/interface/orderAction.js'></script>
		<script type='text/javascript' src='dwr/interface/userAction.js'></script>
		<script type="text/javascript">
	    $(document).ready(function(){
	    
	    userAction.loadUserName(function(data){
        $("#userName").html(data);
         }); 
	    
	    lampAction.cartLamp(function(data){
	       console.log("data-->"+data);
	       var allSum = 0;
	       for(var i = 0; i<data.length; i++){
	         var lamp = data[i];
	         var lampId = lamp.lampId;
	         var lampName = lamp.lampName;
	         var price = lamp.price;
	         var count = lamp.count;
	         allSum += price;
	         console.log("-----"+allSum);
	        
	         var pic = "images/lampImages/"+lamp.prictureImage1+".jpg";
	         var div = '<div class="show">'
					   +'<div class="picture_cart">'
					   +'<img src="'
					   +pic
					   +'" />'
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
					   +','+lampId+')"/><samp id="'+lampId+'">'
					   +count
					   +'</samp><input type="button" value="+" onclick="add('
					   +price
					   +','+lampId+')"/>'
					   +'</div>'
					   +'<div class="p_total"><samp id="sum'+lampId+'">'
					   +price
					   +'</samp></div>'
					   +'<div class="p_delete" ><a href="javascript:del()"><img src="images/delete.gif" /></a></div>'
					   +'</div>';
					   $("#show_border").append(div);
	       }
	        $("#allSum").html(allSum);
	    });
	 });
	 function jian(price,lampId){
	    var smapNum = document.getElementById(lampId);
	    var num = Number(smapNum.innerHTML);
	    
	    var allSum = Number(document.getElementById('allSum').innerHTML)-price;
	    console.log("allSum-->"+allSum);
	    document.getElementById('allSum').innerHTML = allSum;
	    num = num - 1;
	    
	    if(num < 0 ){
	      alert("数量已经为零，不能再减..");
	      smapNum.innerHTML = 0;
	      document.getElementById('sum'+lampId).innerHTML = 0;
	    } else {
	    	smapNum.innerHTML = num;
	    }
	     var sum = num*price;
	     document.getElementById('sum'+lampId).innerHTML = sum;
	     lampAction.addLampToCart(lampId,num);
	 }
	 
	 function add(price,lampId) {
	 	var smapNum = document.getElementById(lampId);
	    var num = Number(smapNum.innerHTML);
	    
	    var allSum = Number(document.getElementById('allSum').innerHTML)+price;
	    console.log("allSum-->"+allSum);
	    document.getElementById('allSum').innerHTML = allSum;
	    num = num + 1;
	    smapNum.innerHTML = num;
	    var sum = num*price;
	     document.getElementById('sum'+lampId).innerHTML = sum;
	     lampAction.addLampToCart(lampId,num);
	 }

	 
	 
function jieZhang(){
    var userName = document.getElementById('userName').innerHTML;
    var allPrice = document.getElementById('allSum').innerHTML;
    orderAction.sessionAllPrice(evalDwrData(allPrice));
    if(userName == "" ){
       alert("对不起！你还没有登录，请先登录..");
       window.location.href='loginAction.action';
    }else{
       window.location.href='contactAction.action';
    }
    /*
    var allPrice = document.getElementById('allSum').innerHTML;
    $("#allPrice").html(allPrice);
    var userName = $("#userName").val();
    var telephone = $("#telephone").val();
    var code = $("#code").val();
    var message = $("#message").val();
    var email = $("#email").val();
    var address = $("#address").val();
  $("#adong").dialog({
        modal : true,
		show : "blind",
		hide : "blind",
		width : 730,
		height : 350,
				buttons : {
			"关闭" : function() {
					$(this).dialog("close");
				},
			"提交" : function() {
			      orderAction.addOrder(userName,telephone,message,email,code,address,allPrice);
			lampAction.cartLamp(function(data){
	        for(var i = 0; i<data.length; i++){
	             var lamp = data[i];
	             var lampId = lamp.lampId;
	             var count = document.getElementById(lampId).innerHTML;
	             lampAction.addSaledLamp();
	        }
	     });
			}
		}
  }
  );
  */
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
		<div id="ccenter">


			<div id="middle" style="width: auto;">

				<div style="float: left; position: relative; width: 540px;">
					<div id="left">
						<div class="title">
							<span class="title_icon"><img src="images/bullet1.gif" />
							</span>View Cart
						</div>
						<div id="pay">
							<span>支付：</span>
							<span class="r" id="allSum">￥800</span>
							<a href="javascript:jieZhang()"><span class="pay">结算</span> </a>
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
						</div>


					</div>
				</div>





				<div id="category">
					<div class="cart">
						<div class="cart_title">
							<span class="title_icon"><img src="images/cart.gif" /> </span>购物车
						</div>
						<div class="home_cart_content">
							欢迎你&brvbar;&nbsp;
							<span class="red" id="userName"></span>
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


		<!-- 查看订单Div对话框 -->
		<div id="adong" style="display: none;" title="订单信息<samp></samp>">
			<table border="0" style="width:700px">
				<tr>
					<th colspan="4">
						订单号:&nbsp;
						<samp id="orderId">
							010416524
						</samp>
						&nbsp;&nbsp;&nbsp;订单总价：
						<samp id="allPrice">
							100000
						</samp>
					</th>
				</tr>
				<tr>
					<td style="width:50px">
						收货人:
					</td>
					<td style="width:200px;">
						<input type="text" style="width:150px" id="userName"/>
					</td>
					<td style="width:50px">
						电话：
					</td>
					<td>
						<input type="text" style = "width:150px;" id="telephone"/>
					</td>
				</tr>
				<tr>
					<td>
						Email:
					</td>
					<td>
						<input type="text"  style = "width:150px;" id="email"/>
					</td>
					<td>
						邮编：
					</td>
					<td>
						<input type="text" style = "width:150px;" id="code"/>
					</td>
				</tr>
				
				<tr>
					<td>
						地址:
					</td>
					<td>
						<input type="text" style = "width:150px;"  id="address"  />
					</td>
				</tr>
				<tr>
					<td>
						备注:
					</td>
					<td>
						<textarea rows="" cols="" style="width:300px" id="message"></textarea>
					</td>
				</tr>
				<!--
				<tr>
					<td width="10%">
						备注:
					</td>
					<td colspan="5">
						<textarea rows="" cols="" id="message"></textarea>
					</td>
				</tr>
			--></table>

		</div>

	</body>
</html>
