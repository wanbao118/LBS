package com.group.isoft.bearsport.clientmodel.user;

import com.group.isoft.bearsport.clientmodel.location.Location;
import com.group.isoft.bearsport.common.BaseClientReqModel;

public class UserReqModel extends BaseClientReqModel {
	private String code;
	private String nickName;
	private String gender;
	private String language;
	private String city;
	private String province;
	private String country;
	private String avatarUrl;
	private String openId;
	private String loginCity;
	private Location location;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getLoginCity() {
		return loginCity;
	}

	public void setLoginCity(String loginCity) {
		this.loginCity = loginCity;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
