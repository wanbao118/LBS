package com.group.isoft.bearsport.persist.userActivity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.group.isoft.bearsport.model.useractivity.ActivityJoinerInfo;
import com.group.isoft.bearsport.model.useractivity.UserActivity;

public interface UserActivityMapper {
	Boolean addUserActivity(UserActivity userActivity);
	UserActivity fetchUserActivityByUidAndActId(@Param("actId")String actId, @Param("openId")String openId);
	int updateUserActivity(UserActivity userActivity);
	ActivityJoinerInfo getActivityJoinersbyAcctId(String actId);
	List<UserActivity> getUserActivityDetlByActId(String actId);
}
