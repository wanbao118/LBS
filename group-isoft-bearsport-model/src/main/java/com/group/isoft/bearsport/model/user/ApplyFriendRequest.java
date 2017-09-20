package com.group.isoft.bearsport.model.user;

public class ApplyFriendRequest {
	private String openId;
	private String friendOpenId;
	private String relationshipStatus;
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getFriendOpenId() {
		return friendOpenId;
	}
	public void setFriendOpenId(String friendOpenId) {
		this.friendOpenId = friendOpenId;
	}
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
}
