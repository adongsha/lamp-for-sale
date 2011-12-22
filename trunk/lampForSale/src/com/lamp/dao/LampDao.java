package com.lamp.dao;

import java.util.List;

import com.lamp.model.Lamp;
import com.lamp.util.PageInfo;

/**
 * 灯饰DAO模块
 * @author 陆永坚
 * @createTime
 */
public interface LampDao {
	/**
	 * 添加灯
	 * @param lamp   灯对象
	 */
     public void addLamp(Lamp lamp);
     
     /**
      * 修改灯
      * @param lampId   灯的id
      */
     public void updateLamp(Integer lampId);
     
     /**
      * 取得灯的列表
      * @return
      */
     public List<Lamp> getLampList(PageInfo pageInfo);
     

}
