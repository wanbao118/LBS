package com.group.isoft.bearsport.clientmodel.user;

import java.util.List;

import com.group.isoft.bearsport.common.BaseClientRespModel;

public class UserRespModel extends BaseClientRespModel {
    private List<UserRespData> listData;

	public List<UserRespData> getListData() {
		return listData;
	}

	public void setListData(List<UserRespData> listData) {
		this.listData = listData;
	}
}
