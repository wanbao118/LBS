package com.group.isoft.bearsport.activity;

import com.group.isoft.bearsport.clientmodel.activity.ActivityReqModel;
import com.group.isoft.bearsport.clientmodel.activity.ActivityRespModel;

public interface IActivityService {
	 ActivityRespModel createActivity(ActivityReqModel activityReqModel) throws Exception;
}
