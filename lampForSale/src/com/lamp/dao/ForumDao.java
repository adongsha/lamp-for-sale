package com.lamp.dao;

import java.util.List;

import com.lamp.model.Forum;
import com.lamp.util.PageInfo;

public interface ForumDao {
	/**
	 * ��̳�б�....
	 * ����ָ���ĵ�����..
	 * @param lampId  �Ƶ�id
	 * @return
	 */
   public List<Forum> forumList(Long lampId, PageInfo pageInfo);
}
