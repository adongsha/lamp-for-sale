package com.lamp.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Forum entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "forum", schema = "dbo", catalog = "lampForSale")
public class Forum implements java.io.Serializable {

	// Fields

	private Integer forumId;
	private Lamp lamp;
	private UserInfo userInfo;
	private Timestamp publishedTime;
	private String replyContent;

	// Constructors

	/** default constructor */
	public Forum() {
	}

	/** full constructor */
	public Forum(Lamp lamp, UserInfo userInfo, Timestamp publishedTime,
			String replyContent) {
		this.lamp = lamp;
		this.userInfo = userInfo;
		this.publishedTime = publishedTime;
		this.replyContent = replyContent;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "forumId", unique = true, nullable = false)
	public Integer getForumId() {
		return this.forumId;
	}

	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lampId")
	public Lamp getLamp() {
		return this.lamp;
	}

	public void setLamp(Lamp lamp) {
		this.lamp = lamp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Column(name = "publishedTime", length = 23)
	public Timestamp getPublishedTime() {
		return this.publishedTime;
	}

	public void setPublishedTime(Timestamp publishedTime) {
		this.publishedTime = publishedTime;
	}

	@Column(name = "replyContent", length = 950)
	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

}