package com.lamp.dao;

import java.lang.reflect.Array;
import java.util.List;

import com.lamp.model.Lamp;

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
      * ȡ�õƵ��б�
      * @return
      */
     public List<Lamp> getLampList();
     

}
