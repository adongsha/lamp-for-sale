package com.lamp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lamp.service.LampService;
import com.lamp.util.PageInfo;
import com.lamp.vo.LampVo;


@Component("LampAction")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RemoteProxy(name = "lampAction")
public class LampAction extends SuperAction {
      LampService lampService;

      @Resource
	public void setLampService(LampService lampService) {
		this.lampService = lampService;
	}
      
      /**
       * ��ʾ���õ���
       * @param pageInfo  ��ҳ����
       * @return
       */
    @RemoteMethod
    public Map<String, Object> lampListByPage(PageInfo pageInfo){
    	Map<String, Object> map = new HashMap<String, Object>();
    	List<LampVo> listVos = lampService.getLampList(pageInfo);
    	map.put("lampVos", listVos);
    	map.put("pageInfo", pageInfo);
    	return map;
    }  
    
    /**
     * ������ʾ����
     * @param pageInfo  ��ҳ����
     * @param type      ����
     * @return
     */
    @RemoteMethod
    public Map<String, Object> lampTypeListByPage(PageInfo pageInfo, Integer type){
    	Map<String, Object> map = new HashMap<String, Object>();
        List<LampVo> lampVos = lampService.lampTypeListByPage(pageInfo, type);
        map.put("pageInfo", pageInfo);
        map.put("lampVos", lampVos);
        return map;
    }
}
