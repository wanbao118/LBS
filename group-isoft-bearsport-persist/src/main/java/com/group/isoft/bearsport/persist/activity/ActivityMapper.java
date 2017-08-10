package com.group.isoft.bearsport.persist.activity;

import java.util.List;

import com.group.isoft.bearsport.model.activity.Activity;

public interface ActivityMapper {
	 boolean addActivity(Activity activity);
	 List<Activity> queryActivityList();
	 String fetchMaxActId();
}
