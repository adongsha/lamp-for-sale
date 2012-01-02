package com.lamp.dao;

import java.util.List;

import com.lamp.model.CartShop;
import com.lamp.model.Lamp;
import com.lamp.model.OrderInfo;
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
     public Lamp detailsLamp(Long lampId);
     
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
     
     /**
      * ��ӹ��ﳵ��Ʒ
      * @param cartShop
      */
     public void addCartShop(CartShop cartShop);
     
     
     /**
      * �õ�ָ����lamp
      * @param lampId
      * @return
      */
     public Lamp loadLampByLampId(Long lampId);
     
     /**
      * �õ�ָ����ӆ��
      * @param orderId
      * @return
      */
     public OrderInfo loadOrderByOrderId(Long orderId);
     
     /**
      * ���ӆ�ε���Ʒ
      * @param lampId
      * @param orderId
      * @param count
      * @param perPrice
      */
     public void insertCartShop(Long lampId, Long orderId, Integer count, Double perPrice);

}
