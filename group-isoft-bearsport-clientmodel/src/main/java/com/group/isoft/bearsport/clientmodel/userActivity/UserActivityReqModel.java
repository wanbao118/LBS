package com.group.isoft.bearsport.clientmodel.userActivity;

import java.util.Date;

import com.group.isoft.bearsport.common.BaseClientReqModel;

public class UserActivityReqModel extends BaseClientReqModel {
	private String actId;
	private String userId;
	private Date joinDate;
	private String joinTime;
	private String joinRemark;
	private String joinerName;

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
	public String getJoinRemark() {
		return joinRemark;
	}
	public void setJoinRemark(String joinRemark) {
		this.joinRemark = joinRemark;
	}
	public String getJoinerName() {
		return joinerName;
	}
	public void setJoinerName(String joinerName) {
		this.joinerName = joinerName;
	}
}
