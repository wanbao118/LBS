package com.group.isoft.bearsport.clientmodel.activity;

import java.util.Date;

import com.group.isoft.bearsport.clientmodel.location.Location;
import com.group.isoft.bearsport.common.BaseClientReqModel;

public class ActivityReqModel extends BaseClientReqModel {
	private String actSubject;
	private String sprType;
	private String actType;
	private String feeType;
	private double feeEst;
	private int planPeople;
	private Date actDate;
	private String actTime;
	private String areaName;
	private String areaAddress;
	private Location areaLocation;
	private String wordInput;
	private String openId;
	private String actId;
	private String nickName;
	private String contactNum;
	private int enrPeople;
	private String userId;

	public String getActSubject() {
		return actSubject;
	}
	public void setActSubject(String actSubject) {
		this.actSubject = actSubject;
	}
	public String getSprType() {
		return sprType;
	}
	public void setSprType(String sprType) {
		this.sprType = sprType;
	}
	public String getActType() {
		return actType;
	}
	public void setActType(String actType) {
		this.actType = actType;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public double getFeeEst() {
		return feeEst;
	}
	public void setFeeEst(double feeEst) {
		this.feeEst = feeEst;
	}
	public int getPlanPeople() {
		return planPeople;
	}
	public void setPlanPeople(int planPeople) {
		this.planPeople = planPeople;
	}
	public Date getActDate() {
		return actDate;
	}
	public void setActDate(Date actDate) {
		this.actDate = actDate;
	}
	public String getActTime() {
		return actTime;
	}
	public void setActTime(String actTime) {
		this.actTime = actTime;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaAddress() {
		return areaAddress;
	}
	public void setAreaAddress(String areaAddress) {
		this.areaAddress = areaAddress;
	}
	public Location getAreaLocation() {
		return areaLocation;
	}
	public void setAreaLocation(Location areaLocation) {
		this.areaLocation = areaLocation;
	}
	public String getWordInput() {
		return wordInput;
	}
	public void setWordInput(String wordInput) {
		this.wordInput = wordInput;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getActId() {
		return actId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getEnrPeople() {
		return enrPeople;
	}
	public void setEnrPeople(int enrPeople) {
		this.enrPeople = enrPeople;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public void setActId(String actId) {
		this.actId = actId;
	}
	
}
