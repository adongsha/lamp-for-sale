package com.lamp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lamp.dao.ForumDao;
import com.lamp.model.Forum;
import com.lamp.util.PageInfo;

@Component("forumService")
public class ForumService {
    ForumDao forumDao;

    @Resource
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}
    
    public List<Forum> forumList(Long lampId, PageInfo pageInfo){
    	forumDao.forumList(lampId, pageInfo);
    	return null;
    }
    
    
}
