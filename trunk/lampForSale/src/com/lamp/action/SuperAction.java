package com.lamp.action;

//import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * Action对的父类，这里有对日志的操作
 * 类名称： SuperAction 
 * 类描述： 此类是所有自定义编写的Action类的基类，暂时类体为空
 * 陈伟斌
 */

public class SuperAction extends ActionSupport {

	public Logger log = Logger.getLogger(this.getClass());
	
	
	public SuperAction() {
	}
	//记录成功操作成功日志
	protected void logSuccessString(String methodName,
			String opContent,String result) throws Exception {
		try {
//			Tuser user=getLoginedUser();
//			if(user==null)
//				this.logFailureString("logSuccessString", "用户登陆时记录成功日志", new Exception("无法取得用户信息"));
//			StringBuffer sb = new StringBuffer();
//			
//			sb.append("操作人:");
//			sb.append(user.getUserType().getTypeName()+" ");// 用户名，调用SuperAction中已写好的方法
//			sb.append(user.getUserName());
//			sb.append("& 操作的方法名:");
//			sb.append(methodName);// 模块名
//			sb.append("& 操作内容:");
//			sb.append(opContent);// 操作内容
//			sb.append("  &");
//			sb.append("结果:");// 操作结果
//			sb.append(result);
//			log.warn(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//
//	protected Tuser getLoginedUser() {
//		Tuser  user=(Tuser)ActionContext.getContext().getSession().get("user");
//		return user;
//	}
	//记录成功操作失败日志
	protected void logFailureString(String methodName,
			String opContent,Exception e)  {
		try {
//			Tuser user=getLoginedUser();
//			if(user==null){
//				log.error("logFailureString方法出错，无法取得session中的user对象");
//				return;
//			}
//			StringBuffer sb = new StringBuffer();
//			
//			sb.append("操作人:");
//			
//			sb.append(user.getUserType().getTypeName()+" ");// 用户名，调用SuperAction中已写好的方法
//			sb.append(user.getUserName());
//			sb.append("&方法名:");
//			sb.append(methodName);// 模块名
//			sb.append("&操作内容:");
//			sb.append(opContent);// 操作内容
//			sb.append("&");
//			sb.append("异常:");// 操作结果
//			sb.append(e);
//			log.error(sb.toString());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
