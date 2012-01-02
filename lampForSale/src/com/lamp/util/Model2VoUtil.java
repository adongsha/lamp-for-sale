package com.lamp.util;

import com.lamp.model.CartShop;
import com.lamp.model.Lamp;
import com.lamp.model.OrderInfo;
import com.lamp.model.UserInfo;
import com.lamp.vo.CartShopVo;
import com.lamp.vo.LampVo;
import com.lamp.vo.OrderInfoVo;
import com.lamp.vo.UserInfoVo;


public class Model2VoUtil {

	/**
	 * 将订单类转换成订单VO类
	 * @param orderInfo  订单信息对象
	 * @return
	 */
     public static OrderInfoVo orderInfo2orderInfoVo(OrderInfo orderInfo){
    	 OrderInfoVo orderInfoVo = new OrderInfoVo();
    	 orderInfoVo.setAllPrice(orderInfo.getAllPrice());
    	 orderInfoVo.setCode(orderInfo.getCode());
    	 orderInfoVo.setIsBackSingle(orderInfo.getIsBackSingle());
    	 orderInfoVo.setMessage(orderInfo.getMessage());
    	 orderInfoVo.setOrderAddress(orderInfo.getOrderAddress());
    	 orderInfoVo.setOrderCompany(orderInfo.getOrderCompany());
    	 orderInfoVo.setOrderEmail(orderInfo.getOrderEmail());
    	 orderInfoVo.setOrderId(orderInfo.getOrderId());
    	 orderInfoVo.setOrderPerson(orderInfo.getOrderPerson());
    	 orderInfoVo.setOrderPhone(orderInfo.getOrderPhone());
    	 orderInfoVo.setOrderStatus(orderInfo.getOrderStatus());
    	 orderInfoVo.setOrderTime(orderInfo.getOrderTime());
    	 orderInfoVo.setUserName(orderInfo.getUserInfo().getUserName());
    	 if(orderInfo.getUserInfo() == null){
    		 UserInfo user = new UserInfo();
    		 orderInfoVo.setUserName(user.getUserName());
    	 }
    	 return orderInfoVo;
     }
     
     
     /**
      * 将用户信息类转换成用户信息VO类
      * @param userInfo  用户信息对象
      * @return
      */
     public static UserInfoVo userInfo2userInfoVo(UserInfo userInfo){
    	 UserInfoVo userInfoVo  = new UserInfoVo();
    	 userInfoVo.setAddress(userInfo.getAddress());
    	 userInfoVo.setCompany(userInfo.getCompany());
    	 userInfoVo.setEmail(userInfo.getEmail());
    	 userInfoVo.setPassword(userInfo.getPassword());
    	 userInfoVo.setPhone(userInfo.getPhone());
    	 userInfoVo.setPower(userInfo.getPower());
    	 userInfoVo.setUserId(userInfo.getUserId());
    	 userInfoVo.setUserName(userInfo.getUserName());
    	 userInfoVo.setUserPicture(userInfo.getUserPicture());
    	 
    	 return userInfoVo;
     }
     
     
     /**
      * 将lamp类转换成lampVo类
      * @param lamp
      * @return
      */
     public static LampVo lamp2lampVo(Lamp lamp){
    	 LampVo lampVo = new LampVo();
    	 lampVo.setEvaluationCount(lamp.getEvaluationCount());
    	 lampVo.setIsbn(lamp.getIsbn());
    	 lampVo.setIsDiscount(lamp.getIsDiscount());
    	 lampVo.setLampDescription(lamp.getLampDescription());
    	 lampVo.setLampId(lamp.getLampId());
    	 lampVo.setLampName(lamp.getLampName());
    	 lampVo.setMaterial(lamp.getMaterial());
    	 lampVo.setOrigin(lamp.getOrigin());
    	 lampVo.setPrice(lamp.getPrice());
    	 lampVo.setPrictureImage1(lamp.getPrictureImage1());
    	 lampVo.setPrictureImage2(lamp.getPrictureImage2());
    	 lampVo.setPrictureImage3(lamp.getPrictureImage3());
    	 lampVo.setPrictureImage4(lamp.getPrictureImage4());
    	 lampVo.setProcess(lamp.getProcess());
    	 lampVo.setSaleEvMouth(lamp.getSaleEvMouth());
    	 lampVo.setSize(lamp.getSize());
    	 lampVo.setType(lamp.getType());
    	 lampVo.setWeight(lamp.getWeight());
    	 
    	 return lampVo;
     }
     
     public static CartShopVo cartShop2cartShopVo(CartShop cartShop){
    	 CartShopVo cartShopVo = new CartShopVo();
    	 /* cartShopVo.setCartId(cartShop.getCartId());
    	 cartShopVo.setCount(cartShop.getCount());
    	 cartShopVo.setLampid(lampid)*/
    	 return cartShopVo;
     }
}
