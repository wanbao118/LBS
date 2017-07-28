package com.group.isoft.bearsport.clientmodel.venues;

import com.group.isoft.bearsport.clientmodel.location.Location;
import com.group.isoft.bearsport.common.BaseClientReqModel;

public class VenuesReqModel extends BaseClientReqModel {
	private String title;
	private String uid;
	private String address;
	private String telephone;
	private String overall_rating;
	private double price;
	private String environment_rating;
	private String service_rating;
	private String detail_url;
	private String latitude;
	private String longitude;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getOverall_rating() {
		return overall_rating;
	}
	public void setOverall_rating(String overall_rating) {
		this.overall_rating = overall_rating;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getEnvironment_rating() {
		return environment_rating;
	}
	public void setEnvironment_rating(String environment_rating) {
		this.environment_rating = environment_rating;
	}
	public String getService_rating() {
		return service_rating;
	}
	public void setService_rating(String service_rating) {
		this.service_rating = service_rating;
	}
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
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

}
