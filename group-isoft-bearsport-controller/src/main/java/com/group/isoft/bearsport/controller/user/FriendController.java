package com.group.isoft.bearsport.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group.isoft.bearsport.clientmodel.user.UserReqModel;
import com.group.isoft.bearsport.clientmodel.user.UserRespModel;
import com.group.isoft.bearsport.user.IUserService;
import com.group.isoft.bearsport.util.ErrorCode;

@Controller
@RequestMapping("/friend")
public class FriendController {
	private static final Logger sysLogger = Logger.getLogger("customer");
	
	@Resource
	IUserService userService;
	
	@RequestMapping(value = "/makeFriend", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public Object makeFriends(final HttpServletRequest request, final HttpServletResponse response, @RequestBody UserReqModel userReqModel) {
//		String openId = userReqModel.getParams().get("openId");
		String friendOpenId = userReqModel.getParams().get("friendOpenId");
		boolean success = false;
		try {
			success = userService.makeFriends(userReqModel);
		} catch (Exception e) {
			sysLogger.error("failed to add friend", e);
		}
		UserRespModel userRespModel = new UserRespModel();
		Map<String, String> params = new HashMap<String, String>();
		if(success) {
			params.put("friendOPenId", friendOpenId);
			userRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
		}else {
			userRespModel.setResult(ErrorCode.RESPONSE_ERROR);
		}
		return userRespModel;
	}
	
	@RequestMapping(value = "/friends", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getFriendList(@RequestParam String currentUserId, final HttpServletRequest request, final HttpServletResponse response) {
		UserRespModel userRespModel = null;
		try {
			UserReqModel userReqModel = new UserReqModel();
			userReqModel.setOpenId(currentUserId);
			userRespModel = userService.FetchFriendList(userReqModel);
			userRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
		} catch (Exception e) {
			sysLogger.error("failed to get friend list", e);
			userRespModel = new UserRespModel();
			userRespModel.setResult(ErrorCode.RESPONSE_ERROR);
		}
		return userRespModel;
	}
	
	@RequestMapping(value="/friendRequestApproval", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody
	public Object approveFriendRequest(final HttpServletRequest request, final HttpServletResponse response, @RequestBody UserReqModel userReqModel) {
		UserRespModel userRespModel = null;
		try {
			userRespModel = userService.updateRelationshipStatus(userReqModel);
		} catch (Exception e) {
			sysLogger.error("failed to approve friend request", e);
			userRespModel = new UserRespModel();
			userRespModel.setResult(ErrorCode.RESPONSE_ERROR);
		}
		return userRespModel;
	}
	
	@RequestMapping(value="/friendRequestList", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Object getFriendRequestList(@RequestParam String currentUserId, final HttpServletRequest request, final HttpServletResponse response) {
		UserRespModel userRespModel = null;
		try {
			UserReqModel userReqModel = new UserReqModel();
			userReqModel.getParams().put("openId", currentUserId);
			userRespModel = userService.fetchMakeFriendApplications(userReqModel);
			userRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
		} catch (Exception e) {
			sysLogger.error("failed to get friend request list", e);
			userRespModel = new UserRespModel();
			userRespModel.setResult(ErrorCode.RESPONSE_ERROR);
		}
		return userRespModel;
	}
}
