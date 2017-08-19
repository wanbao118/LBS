package com.group.isoft.bearsport.clientmodel.userActivity;

import java.util.List;

import com.group.isoft.bearsport.common.BaseClientRespModel;

public class UserActivityRespModel extends BaseClientRespModel{
	
	private List<UserActivityRespData> listData;

	public List<UserActivityRespData> getListData() {
		return listData;
	}

	public void setListData(List<UserActivityRespData> listData) {
		this.listData = listData;
	}

}
