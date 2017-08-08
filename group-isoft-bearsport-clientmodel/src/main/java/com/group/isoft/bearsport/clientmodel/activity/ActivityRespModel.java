package com.group.isoft.bearsport.clientmodel.activity;

import java.util.List;

import com.group.isoft.bearsport.common.BaseClientRespModel;

public class ActivityRespModel extends BaseClientRespModel {
	private List<ActivityRespData> listData;

	public List<ActivityRespData> getListData() {
		return listData;
	}

	public void setListData(List<ActivityRespData> listData) {
		this.listData = listData;
	}
}
