package com.group.isoft.bearsport.controller.userActivity;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityReqModel;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityRespModel;
import com.group.isoft.bearsport.useractivity.IUserActivityService;
import com.group.isoft.bearsport.util.OperationCode;

@Controller
@RequestMapping("/userActivity")
public class UserActivityController {
	private static final Logger sysLogger = Logger.getLogger("customer");

	@Resource
	IUserActivityService userActivityService;

	@RequestMapping(value = "/userActivityMaintain", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Object userActivityMaintain(final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody UserActivityReqModel userActivityRequest) throws Exception {
		UserActivityRespModel userActivityRespModel = new UserActivityRespModel();

		if (userActivityRequest.getOperationCode().equals(OperationCode.ACTIVITY_APPLY)) {
			userActivityRespModel = applyActivity(userActivityRequest);
		} 

		return userActivityRespModel;
	}

	private UserActivityRespModel applyActivity(UserActivityReqModel userActivityRequest) throws Exception {
		return userActivityService.addUserActivity(userActivityRequest);
	}
	
}
