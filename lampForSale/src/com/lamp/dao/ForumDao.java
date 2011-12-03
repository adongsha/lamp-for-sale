package com.lamp.dao;

import java.util.List;

import com.lamp.model.Forum;

public interface ForumDao {
	/**
	 * 论坛列表....
	 * 根据指定的灯评论..
	 * @param lampId  灯的id
	 * @return
	 */
   public List<Forum> forumList(Integer lampId);
}
