package com.lamp.dao;

import java.util.List;

import com.lamp.model.Forum;

public interface ForumDao {
	/**
	 * ��̳�б�....
	 * ����ָ���ĵ�����..
	 * @param lampId  �Ƶ�id
	 * @return
	 */
   public List<Forum> forumList(Integer lampId);
}
