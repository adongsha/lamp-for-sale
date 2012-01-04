package com.lamp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lamp.dao.ForumDao;
import com.lamp.model.Forum;
import com.lamp.util.PageInfo;

@Component("forumDao")
public class ForumDaoImpl extends HibernateDaoImpl implements ForumDao{

	public List<Forum> forumList(Long lampId, PageInfo pageInfo) {
		String hql = "from Forum f where f.lamp.lampId="+lampId;
		List<Forum> list = new ArrayList<Forum>();
		List<Forum> forums = this.findPageByQuery(hql, null, pageInfo);
		if(forums.size() < 1){
			return null;
		}
		return forums;
	}
    
}
