package com.lamp.dao;

import java.util.List;

import com.lamp.model.Lamp;
import com.lamp.util.PageInfo;

/**
 * ����DAOģ��
 * @author ½����
 * @createTime
 */
public interface LampDao {
	/**
	 * ��ӵ�
	 * @param lamp   �ƶ���
	 */
     public void addLamp(Lamp lamp);
     
     /**
      * �޸ĵ�
      * @param lampId   �Ƶ�id
      */
     public void updateLamp(Integer lampId);
     
     /**
      * ��õƵ���ϸ��Ϣ
      * @param lampId  �Ƶ�ID
      * @return
      */
     public Lamp detailsLamp(Integer lampId);
     
     /**
      * ȡ�õƵ��б�
      * @return
      */
     public List<Lamp> getLampList(PageInfo pageInfo);
     
     /**
      * �����ε����ͽ��з���
      * @param pageInfo  ��ҳ����
      * @param type      ��������
      * @return
      */
     public List<Lamp> lampTypeListByPage(PageInfo pageInfo, Integer type);

}
