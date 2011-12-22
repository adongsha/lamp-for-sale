package com.lamp.util;

import com.lamp.model.OrderInfo;
import com.lamp.model.UserInfo;
import com.lamp.vo.OrderInfoVo;
import com.lamp.vo.UserInfoVo;


public class Model2VoUtil {

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
}
