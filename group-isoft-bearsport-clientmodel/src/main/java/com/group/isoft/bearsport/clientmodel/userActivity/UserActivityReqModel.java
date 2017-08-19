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
	private String joinerType;
	private Date cancelDate;
	private String cancelTime;
	private String cancelReason;
	private String cancelRemark;
	
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
	public String getJoinerType() {
		return joinerType;
	}
	public void setJoinerType(String joinerType) {
		this.joinerType = joinerType;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	public String getCancelTime() {
		return cancelTime;
	}
	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public String getCancelRemark() {
		return cancelRemark;
	}
	public void setCancelRemark(String cancelRemark) {
		this.cancelRemark = cancelRemark;
	}
}
