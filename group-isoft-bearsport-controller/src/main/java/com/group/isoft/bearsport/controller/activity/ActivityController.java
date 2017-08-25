package com.group.isoft.bearsport.controller.activity;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.isoft.bearsport.activity.IActivityService;
import com.group.isoft.bearsport.clientmodel.activity.ActivityReqModel;
import com.group.isoft.bearsport.clientmodel.activity.ActivityRespModel;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityReqModel;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityRespModel;
import com.group.isoft.bearsport.useractivity.IUserActivityService;
import com.group.isoft.bearsport.util.ErrorCode;
import com.group.isoft.bearsport.util.OperationCode;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	private static final Logger sysLogger = Logger.getLogger("customer");

	@Resource
	IActivityService activityService;
	
	@Resource
	IUserActivityService userActivityService;

	@RequestMapping(value = "/activityMaintain", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Object activityMaintain(final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody ActivityReqModel activityRequest) throws Exception {
		ActivityRespModel activityRespModel = new ActivityRespModel();

		if (activityRequest.getOperationCode().equals(OperationCode.ACT_CREATE)) {
			activityRespModel = createActivity(activityRequest);
		} else if (activityRequest.getOperationCode().equals(OperationCode.ACT_FETCH)) {
			activityRespModel = getActivityList(activityRequest);
		} else if (activityRequest.getOperationCode().equals(OperationCode.ACT_FETCH_DETL)) {
			activityRespModel = getActivityDetail(activityRequest);
		} else if (activityRequest.getOperationCode().equals(OperationCode.ACT_FETCH_OPENID)) {
			activityRespModel = getActivityListByOpenId(activityRequest);
		}
		return activityRespModel;
	}

	private ActivityRespModel createActivity(@RequestBody ActivityReqModel activityRequest) throws Exception {
		ActivityRespModel activityRespModel = new ActivityRespModel();
		UserActivityRespModel userActivityRespModel = new UserActivityRespModel();
		UserActivityReqModel userActivityReqModel = new UserActivityReqModel();

		activityRespModel = activityService.createActivity(activityRequest);

		if (activityRespModel.getResult().equalsIgnoreCase(ErrorCode.RESPONSE_SUCCESS)) {
			userActivityReqModel.setActId(activityRespModel.getParams().get("actId"));
			userActivityReqModel.setUserId(activityRespModel.getParams().get("userId"));

			userActivityReqModel.setJoinDate(new Date());

			//add field in the DB and pass from FE
			userActivityReqModel.setJoinerName(activityRequest.getNickName());
			userActivityReqModel.setJoinTime(new Date().getHours() + ":" + new Date().getMinutes());
			userActivityReqModel.setJoinerType("0");
			userActivityReqModel.setJoinRemark(activityRequest.getWordInput());
			userActivityRespModel = userActivityService.addUserActivity(userActivityReqModel);

			if (userActivityRespModel.getResult().equalsIgnoreCase(ErrorCode.RESPONSE_ERROR)) {
				activityRespModel.setResult(ErrorCode.RESPONSE_ERROR);
			}
		}

		return activityRespModel;
	}

	private ActivityRespModel getActivityList(@RequestBody ActivityReqModel activityRequest) throws Exception {
		return activityService.fetchActivity(activityRequest);
	}

	private ActivityRespModel getActivityListByOpenId(@RequestBody ActivityReqModel activityRequest) throws Exception {
		return activityService.fetchActivityListByOpenId(activityRequest);
	}

	private ActivityRespModel getActivityDetail(@RequestBody ActivityReqModel activityRequest) throws Exception {
		return activityService.fetchActivityDetl(activityRequest);
	}

}
