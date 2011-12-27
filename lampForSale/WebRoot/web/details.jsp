<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="../css/style.css" type="text/css" rel="stylesheet"/>
<link href="../css/style1.css" type="text/css" rel="stylesheet"/>
<link href="../css/style2.css" type="text/css" rel="stylesheet"/>
<link href="../css/lightbox.css" type="text/css" rel="stylesheet"/>
<script src="../javascript/prototype.js" type="text/javascript"></script>
<script src="../javascript/scriptaculous.js?load=effects" type="text/javascript"></script>
<script src="../javascript/lightbox.js" type="text/javascript"></script>
<script type="text/javascript" src="../javascript/java.js"></script>
<script type="text/javascript">

var tabber1 = new Yetii({
id: 'demo'
});

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
					<li><a href="aboutActon">关于我们</a></li>
					<li><a href="contactAction">联系我们</a></li>
				</ul>
		</div>
	</div>
</div>
<div id="d_ccenter">
					<div id="d_middle">
								       	<div class="left_content">
    <div class="title"><span class="title_icon"><img src="../images/bullet1.gif" alt="" title="" /></span>Product name</div>
        
        	<div class="feat_prod_box_details">
            
            	<div class="prod_img"><a href="details.html"><img src="../images/picture1.jpg" alt="" title="" border="0" /></a>
                <br /><br />
                <a href="../images/big_pic.jpg" rel="lightbox"><img src="../images/zoom.gif" alt="" title="" border="0" /></a>
                </div>
                
                <div class="prod_det_box">
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">Details</div>
                    <p class="details">我们的网站提供了各种各样的灯饰品种繁多价格实惠。 不仅可以照亮你的蜗居而且可以美化你的房子，心动不如行动<br />
                   我们的网站提供了各种各样的灯饰品种繁多价格实惠。 不仅可以照亮你的蜗居而且可以美化你的房子，心动不如行动 eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.                    </p>
                    <div class="price"><strong>PRICE:</strong> <span class="red">100 $</span></div>
                    <a href="details.html" class="more"><img src="../images/order_now.gif" alt="" title="" border="0" /></a>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>	
            
              
             <div id="demo" class="demolayout">

                 <ul id="demo-nav" class="demolayout">
                <li><a class="active" href="">More details</a></li>
                <li><a class="" href="">Related Products</a></li>
                </ul>
    
            <div class="tabs-container">
            
                    <div style="display: block;" class="tab" id="tab1">
                                        <p class="more_details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.
                                        </p>
                            <ul class="list">
                            <li><a href="http://www.865171.cn">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li><a href="http://www.865171.cn">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li><a href="http://www.865171.cn">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>
                            <li><a href="http://www.865171.cn">Lorem ipsum dolor sit amet, consectetur adipisicing elit</a></li>                                          
                            </ul>
                                         <p class="more_details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.
                                        </p>                           
                    </div>	
                    
                            <div style="display: none;" class="tab" id="tab2">
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>                    
                    
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>    

                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb1.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>
                    
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb2.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>                    
                    
                    <div class="new_prod_box">
                        <a href="details.html">product name</a>
                        <div class="new_prod_bg">
                        <a href="details.html"><img src="images/thumb3.gif" alt="" title="" class="thumb" border="0" /></a>
                        </div>           
                    </div>  


                   
                    <div class="clear"></div>
                            </div>	
            
            </div>


			</div>
            

            
        <div class="clear"></div>
        </div><!--end of left content-->
        
        
	
	
	
	
	
					<div id="d_category">
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
