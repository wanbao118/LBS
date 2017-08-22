package com.group.isoft.bearsport.model.activity;

import java.sql.Timestamp;
import java.util.Date;

public class Activity {
	private String id;
	private String actId;
	private String actType;
	private String feeType;
	private int planPeople;
	private String sportType;
	private Date actDate;
	private String actTime;
	private String userId;
	private String openId;
	private String heat;
	private Timestamp createDate;
	private String actStatus;
	private double fee;
	private String areaName;
	private String areaAddress;
	private String areaLatitude;
	private String areaLongitude;
	private String wordInput;
	private String actSubject;
	private String nickName;
	private String contactNum;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActId() {
		return actId;
	}
	public void setActId(String actId) {
		this.actId = actId;
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
	public int getPlanPeople() {
		return planPeople;
	}
	public void setPlanPeople(int planPeople) {
		this.planPeople = planPeople;
	}
	public String getSportType() {
		return sportType;
	}
	public void setSportType(String sportType) {
		this.sportType = sportType;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getHeat() {
		return heat;
	}
	public void setHeat(String heat) {
		this.heat = heat;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getActStatus() {
		return actStatus;
	}
	public void setActStatus(String actStatus) {
		this.actStatus = actStatus;
	}
	public double getFee() {
		return fee;
	}
	public String getAreaLongitude() {
		return areaLongitude;
	}
	public void setAreaLongitude(String areaLongitude) {
		this.areaLongitude = areaLongitude;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getAreaName() {
		return areaName;
	}
	public String getActSubject() {
		return actSubject;
	}
	public void setActSubject(String actSubject) {
		this.actSubject = actSubject;
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
	public String getAreaLatitude() {
		return areaLatitude;
	}
	public void setAreaLatitude(String areaLatitude) {
		this.areaLatitude = areaLatitude;
	}
	public String getArealongitude() {
		return areaLongitude;
	}
	public void setArealongitude(String areaLongitude) {
		this.areaLongitude = areaLongitude;
	}
	public String getWordInput() {
		return wordInput;
	}
	public void setWordInput(String wordInput) {
		this.wordInput = wordInput;
	}
	
}
