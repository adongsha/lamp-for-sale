package com.lamp.dao;

import java.util.List;

import com.lamp.model.UserInfo;

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
     * ��¼
     * @param userName   �û���
     * @param password   ����
     * @return           
     */
    public boolean login(String userName, String password);
    
    /**
     * �޸��û���Ϣ
     * @param user   �û�����
     */
    public void updateUserInfo(Integer userId);
    
    /**
     * �õ������û��б�
     * @return
     */
    public List<UserInfo> getUserList();
}