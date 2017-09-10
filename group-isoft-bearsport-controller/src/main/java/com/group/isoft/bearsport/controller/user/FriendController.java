package com.group.isoft.bearsport.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public Object makeFriends(final HttpServletRequest request, final HttpServletResponse response, @RequestBody UserReqModel userReqModel, HttpSession session) {
		String openId = (String)session.getAttribute("currentUserId");
		String friendOpenId = userReqModel.getParams().get("friendOpenId");
		boolean success = false;
		try {
			success = userService.makeFriends(openId, friendOpenId);
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
	public Object getFriendList(final HttpServletRequest request, final HttpServletResponse response, HttpSession session) {
		UserRespModel userRespModel = null;
		try {
			String currentUserId = (String) session.getAttribute("currentUserId");
			UserReqModel userReqModel = new UserReqModel();
			userReqModel.setOpenId(currentUserId);
			userRespModel = userService.FetchFriendList(userReqModel);
		} catch (Exception e) {
			sysLogger.error("failed to get friend list", e);
		}
		return userRespModel;
	}
}
