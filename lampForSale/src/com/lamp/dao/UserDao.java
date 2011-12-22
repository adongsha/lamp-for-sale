package com.lamp.dao;

import java.util.List;
import java.util.Map;

import com.lamp.model.UserInfo;
import com.lamp.util.PageInfo;

/**
 * �û�DAOģ��
 * @author ��粺�
 * @createTime:
 */
public interface UserDao {
	/**
	 * ע��
	 * @param user   �û�����
	 */
    public void register(UserInfo user);
    
    /**
     * ǰ̨��¼
     * @param userName   �û���
     * @param password   ����
     * @return           
     */
    public boolean login(String userName, String password);
    
    /**
     * ��̨��½
     * @param userName
     * @param password
     * @return
     */
    public boolean ad_login(String userName, String password);
    /**
     * �޸��û���Ϣ
     * @param user   �û�����
     */
    public void updateUserInfo(Integer userId);
    
    /**
     * �õ������û��б�
     * @return
     */
    public List<UserInfo> getUserList(PageInfo pageInfo);
    
    /**
     * ͳ���û�Ȩ������
     * @return
     */
    public Map<String, Integer> countPower();
    

}
