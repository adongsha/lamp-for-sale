package com.lamp.action;

//import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


/**
 * Action�Եĸ��࣬�����ж���־�Ĳ���
 * �����ƣ� SuperAction 
 * �������� �����������Զ����д��Action��Ļ��࣬��ʱ����Ϊ��
 * ��ΰ��
 */

public class SuperAction extends ActionSupport {

	public Logger log = Logger.getLogger(this.getClass());
	
	
	public SuperAction() {
	}
	//��¼�ɹ������ɹ���־
	protected void logSuccessString(String methodName,
			String opContent,String result) throws Exception {
		try {
//			Tuser user=getLoginedUser();
//			if(user==null)
//				this.logFailureString("logSuccessString", "�û���½ʱ��¼�ɹ���־", new Exception("�޷�ȡ���û���Ϣ"));
//			StringBuffer sb = new StringBuffer();
//			
//			sb.append("������:");
//			sb.append(user.getUserType().getTypeName()+" ");// �û���������SuperAction����д�õķ���
//			sb.append(user.getUserName());
//			sb.append("& �����ķ�����:");
//			sb.append(methodName);// ģ����
//			sb.append("& ��������:");
//			sb.append(opContent);// ��������
//			sb.append("  &");
//			sb.append("���:");// �������
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
	//��¼�ɹ�����ʧ����־
	protected void logFailureString(String methodName,
			String opContent,Exception e)  {
		try {
//			Tuser user=getLoginedUser();
//			if(user==null){
//				log.error("logFailureString���������޷�ȡ��session�е�user����");
//				return;
//			}
//			StringBuffer sb = new StringBuffer();
//			
//			sb.append("������:");
//			
//			sb.append(user.getUserType().getTypeName()+" ");// �û���������SuperAction����д�õķ���
//			sb.append(user.getUserName());
//			sb.append("&������:");
//			sb.append(methodName);// ģ����
//			sb.append("&��������:");
//			sb.append(opContent);// ��������
//			sb.append("&");
//			sb.append("�쳣:");// �������
//			sb.append(e);
//			log.error(sb.toString());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
