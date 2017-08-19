package com.group.isoft.bearsport.persist.userActivity;

import com.group.isoft.bearsport.model.useractivity.ActivityJoinerInfo;
import com.group.isoft.bearsport.model.useractivity.UserActivity;

public interface UserActivityMapper {
	Boolean addUserActivity(UserActivity userActivity);
	UserActivity fetchUserActivityByUidAndActId(String actId, String userId);
	int updateUserActivity(UserActivity userActivity);
	ActivityJoinerInfo getActivityJoinersbyAcctId(String actId);
}
