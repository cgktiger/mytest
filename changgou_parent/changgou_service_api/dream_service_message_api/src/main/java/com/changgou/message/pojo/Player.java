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
@Table(name="dream_players")
public class Player implements Serializable {

	@Id
	private Long id;//主键
	@Column(name = "player_serial")
	private String playerSerial;//选手编号
	@Column(name = "player_name")
	private String playerName;//选手姓名
	@Column(name = "player_sex")
	private String playerSex;//选手性别
	@Column(name = "player_height")
	private String playerHeight;//选手身高
	@Column(name = "player_weight")
	private String playerWeight;//选手体重
	@Column(name = "san_wei")
	private String sanWei;//选手三围
	@Column(name = "player_strong")
	private String playerStrong;//选手特长
	@Column(name = "player_magnum")
	private String playerMagnum;//选手代表作
	@Column(name = "player_age")
	private String playerAge;//选手年龄
	@Column(name = "player_vote")
	private String playerVote;//投票数
	@Column(name = "player_stage")
	private String player_stage;//选手艺名
	@Column(name = "player_role")
	private String playerRole;//参加角色
	@Column(name = "player_voice")
	private String playerVoice;//音频
	@Column(name = "player_video")
	private String playerVideo;//视频
	@Column(name = "imgUrls")
	private String imgUrls;//选手多张照片
	@Column(name = "being_type")
	private String beingType;//正在参加的类型
	@Column(name = "being_movie")
	private String beingMovie;//正在参加的电影
	@Column(name = "player_tel")
	private String playerTel;//选手电话
	@Column(name = "player_email")
	private String playerEmail;//选手邮箱

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlayerSerial() {
		return playerSerial;
	}

	public void setPlayerSerial(String playerSerial) {
		this.playerSerial = playerSerial;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerSex() {
		return playerSex;
	}

	public void setPlayerSex(String playerSex) {
		this.playerSex = playerSex;
	}

	public String getPlayerHeight() {
		return playerHeight;
	}

	public void setPlayerHeight(String playerHeight) {
		this.playerHeight = playerHeight;
	}

	public String getPlayerWeight() {
		return playerWeight;
	}

	public void setPlayerWeight(String playerWeight) {
		this.playerWeight = playerWeight;
	}

	public String getSanWei() {
		return sanWei;
	}

	public void setSanWei(String sanWei) {
		this.sanWei = sanWei;
	}

	public String getPlayerStrong() {
		return playerStrong;
	}

	public void setPlayerStrong(String playerStrong) {
		this.playerStrong = playerStrong;
	}

	public String getPlayerMagnum() {
		return playerMagnum;
	}

	public void setPlayerMagnum(String playerMagnum) {
		this.playerMagnum = playerMagnum;
	}

	public String getPlayerAge() {
		return playerAge;
	}

	public void setPlayerAge(String playerAge) {
		this.playerAge = playerAge;
	}

	public String getPlayerVote() {
		return playerVote;
	}

	public void setPlayerVote(String playerVote) {
		this.playerVote = playerVote;
	}

	public String getPlayer_stage() {
		return player_stage;
	}

	public void setPlayer_stage(String player_stage) {
		this.player_stage = player_stage;
	}

	public String getPlayerRole() {
		return playerRole;
	}

	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}

	public String getPlayerVoice() {
		return playerVoice;
	}

	public void setPlayerVoice(String playerVoice) {
		this.playerVoice = playerVoice;
	}

	public String getPlayerVideo() {
		return playerVideo;
	}

	public void setPlayerVideo(String playerVideo) {
		this.playerVideo = playerVideo;
	}

	public String getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(String imgUrls) {
		this.imgUrls = imgUrls;
	}

	public String getBeingType() {
		return beingType;
	}

	public void setBeingType(String beingType) {
		this.beingType = beingType;
	}

	public String getBeingMovie() {
		return beingMovie;
	}

	public void setBeingMovie(String beingMovie) {
		this.beingMovie = beingMovie;
	}

	public String getPlayerTel() {
		return playerTel;
	}

	public void setPlayerTel(String playerTel) {
		this.playerTel = playerTel;
	}

	public String getPlayerEmail() {
		return playerEmail;
	}

	public void setPlayerEmail(String playerEmail) {
		this.playerEmail = playerEmail;
	}
}
