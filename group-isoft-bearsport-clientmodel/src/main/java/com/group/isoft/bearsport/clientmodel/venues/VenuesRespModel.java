package com.group.isoft.bearsport.clientmodel.venues;

import java.util.List;

import com.group.isoft.bearsport.common.BaseClientRespModel;

public class VenuesRespModel extends BaseClientRespModel {
	private  List<VenuesRespData> listData;

	public List<VenuesRespData> getListData() {
		return listData;
	}

	public void setListData(List<VenuesRespData> listData) {
		this.listData = listData;
	}
	
}
