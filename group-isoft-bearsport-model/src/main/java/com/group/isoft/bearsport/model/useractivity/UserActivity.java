package com.group.isoft.bearsport.model.useractivity;

import java.util.Date;

public class UserActivity {
	private String actId;
	private String userId;
	private String joinerName;
	private Date joinDate;
	private String joinTime;
	private int status;
	private String detail;

	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getJoinerName() {
		return joinerName;
	}
	public void setJoinerName(String joinerName) {
		this.joinerName = joinerName;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
