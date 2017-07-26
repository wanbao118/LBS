package com.group.isoft.bearsport.model.user;

import java.sql.Timestamp;

public class User {
	private String id;
	private String userId;
	private String nickName;
	private String gender;
	private String language;
	private String city;
	private String province;
	private String country;
	private String avatarUrl;
	private String description;
	private String level;
	private String creditLevel;
	private String favType1;
	private String favType2;
	private String favType3;
	private Timestamp firstLoginTime;
	private Timestamp lastLoginTime;
	private String openId;
	private String latitude;
	private String longitude;
	private String loginCity;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getCreditLevel() {
		return creditLevel;
	}
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}
	public String getFavType1() {
		return favType1;
	}
	public void setFavType1(String favType1) {
		this.favType1 = favType1;
	}
	public String getFavType2() {
		return favType2;
	}
	public void setFavType2(String favType2) {
		this.favType2 = favType2;
	}
	public String getFavType3() {
		return favType3;
	}
	public void setFavType3(String favType3) {
		this.favType3 = favType3;
	}
	public Timestamp getFirstLoginTime() {
		return firstLoginTime;
	}
	public void setFirstLoginTime(Timestamp firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLoginCity() {
		return loginCity;
	}
	public void setLoginCity(String loginCity) {
		this.loginCity = loginCity;
	}

}
