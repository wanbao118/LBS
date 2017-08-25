package com.group.isoft.bearsport.activity;

import com.group.isoft.bearsport.clientmodel.activity.ActivityReqModel;
import com.group.isoft.bearsport.clientmodel.activity.ActivityRespModel;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityReqModel;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityRespModel;

public interface IActivityService {
	 ActivityRespModel createActivity(ActivityReqModel activityReqModel) throws Exception;
	 ActivityRespModel fetchActivity(ActivityReqModel activityReqModel) throws Exception;
	 ActivityRespModel fetchActivityDetl(ActivityReqModel activityReqModel) throws Exception;
	 ActivityRespModel updateActivity(ActivityReqModel activityReqModel) throws Exception;
	 ActivityRespModel fetchActivityListByOpenId(ActivityReqModel activityReqModel) throws Exception;
}
