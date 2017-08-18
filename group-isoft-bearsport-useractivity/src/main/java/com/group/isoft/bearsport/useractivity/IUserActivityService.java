package com.group.isoft.bearsport.useractivity;

import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityReqModel;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityRespModel;

public interface IUserActivityService {
	UserActivityRespModel addUserActivity(UserActivityReqModel userActivityReqModel) throws Exception;
	UserActivityRespModel deleteUserActivity(UserActivityReqModel userActivityReqModel) throws Exception;
}
