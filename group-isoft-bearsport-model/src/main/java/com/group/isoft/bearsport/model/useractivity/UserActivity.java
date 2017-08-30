package com.group.isoft.bearsport.model.useractivity;

import java.util.Date;

public class UserActivity {
	private String actId;
	private String openId;
	private String joinerName;
	private String joinerType;
	private Date joinDate;
	private String joinTime;
	private int status;
	private String detail;
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
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}
