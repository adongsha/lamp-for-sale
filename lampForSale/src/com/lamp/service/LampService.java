package com.lamp.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lamp.dao.LampDao;
import com.lamp.model.CartShop;
import com.lamp.model.Lamp;
import com.lamp.util.Model2VoUtil;
import com.lamp.util.PageInfo;
import com.lamp.vo.LampVo;
@Component("lampService")
public class LampService {
    LampDao lampDao;

    @Resource
	public void setLampDao(LampDao lampDao) {
		this.lampDao = lampDao;
	}
    
    
    /**
     * ��ӵ���
     * @param lamp
     */
    public void addLamp(Lamp lamp){
    	lampDao.addLamp(lamp);
    }
    
    /**
     * ��õƵ���ϸ��Ϣ
     * @param lampId  �Ƶ�id
     * @return
     */
    public LampVo detailsLamp(Integer lampId){
    	Lamp lamp =  lampDao.detailsLamp(lampId);
    	LampVo lampVo = Model2VoUtil.lamp2lampVo(lamp);
    	return lampVo;
    }
    
    
    /**
     * �����б�ͷ�ҳ
     * @param pageInfo ��ҳ����
     * @return
     */
    public List<LampVo> getLampList(PageInfo pageInfo){
    	List<Lamp> lamps = lampDao.getLampList(pageInfo);
    	List<LampVo> lampVos = new ArrayList<LampVo>();
    	for(Lamp lamp : lamps){
    		LampVo lampVo = Model2VoUtil.lamp2lampVo(lamp);
    		lampVos.add(lampVo);
    	}
    	return lampVos;
    }
    
    /**
     * �����ѯ�����б�
     * @param pageInfo  ��ҳ����
     * @param type      ��������
     * @return
     */
    public List<LampVo> lampTypeListByPage(PageInfo pageInfo, Integer type){
    	List<Lamp> lamps = lampDao.lampTypeListByPage(pageInfo, type);
    	List<LampVo> lampVos = new ArrayList<LampVo>();
    	for(Lamp lamp : lamps){
    		LampVo lampVo = Model2VoUtil.lamp2lampVo(lamp);
    		lampVos.add(lampVo);
    	}
    	return lampVos;
    }
    
    /**
     * ��ӹ��ﳵ��Ʒ
     * @param cartShop  ����
     */
    public void addCartShop(CartShop cartShop) {
    	lampDao.addCartShop(cartShop);
    }
}
