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
	private Integer userId;
	private Timestamp publishedTime;
	private String replyContent;

	// Constructors

	/** default constructor */
	public Forum() {
	}

	/** minimal constructor */
	public Forum(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public Forum(Lamp lamp, Integer userId, Timestamp publishedTime,
			String replyContent) {
		this.lamp = lamp;
		this.userId = userId;
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

	@Column(name = "userId", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "publishedTime", length = 23)
	public Timestamp getPublishedTime() {
		return this.publishedTime;
	}

	public void setPublishedTime(Timestamp publishedTime) {
		this.publishedTime = publishedTime;
	}

	@Column(name = "replyContent", length = 560)
	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

}