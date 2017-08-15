package com.group.isoft.bearsport.persist.userActivity;

import com.group.isoft.bearsport.model.useractivity.UserActivity;

public interface UserActivityMapper {
	Boolean addUserActivity(UserActivity userActivity);
	int fetchUserActivityByUidAndActId(UserActivity userActivity);
}
