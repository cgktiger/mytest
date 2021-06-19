package com.changgou.message.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 实体类
 * @author Administrator
 *
 */
@Table(name="dream_title")
public class Title implements Serializable {

	@Id
	private Long id;//主键
	@Column(name = "banner_imgs")
	private String bannerImgs;//轮播图片
	@Column(name = "title")
	private String title;//标题
	@Column(name = "pageView")
	private Integer pageView;//浏览量
	@Column(name = "content")
	private String content;//内容
	@Column(name = "end_time")
	private String endTime;//结束时间
	@Column(name = "start_time")
	private String startTime;//开始时间
	@Column(name = "vote")
	private Integer vote;//票数
	@Column(name = "players")
	private Integer players;//所有选手
	@Column(name = "type")
	private String type;//类型

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBannerImgs() {
		return bannerImgs;
	}

	public void setBannerImgs(String bannerImgs) {
		this.bannerImgs = bannerImgs;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPageView() {
		return pageView;
	}

	public void setPageView(Integer pageView) {
		this.pageView = pageView;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Integer getVote() {
		return vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

	public Integer getPlayers() {
		return players;
	}

	public void setPlayers(Integer players) {
		this.players = players;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
