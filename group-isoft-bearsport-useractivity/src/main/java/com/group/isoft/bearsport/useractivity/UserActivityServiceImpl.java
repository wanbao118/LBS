package com.group.isoft.bearsport.useractivity;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityReqModel;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityRespModel;
import com.group.isoft.bearsport.model.useractivity.UserActivity;
import com.group.isoft.bearsport.persist.userActivity.UserActivityMapper;
import com.group.isoft.bearsport.util.ErrorCode;

@Service
public class UserActivityServiceImpl implements IUserActivityService {

	@Resource
	UserActivityMapper userActivityMapper;

	public UserActivityRespModel addUserActivity(UserActivityReqModel userActivityReqModel) throws Exception {
		UserActivityRespModel userActivityRespModel = new UserActivityRespModel();
		UserActivity userActivity = new UserActivity();

		userActivity.setActId(userActivityReqModel.getActId());
		userActivity.setDetail(userActivityReqModel.getJoinRemark());
		userActivity.setJoinDate(userActivityReqModel.getJoinDate());
		userActivity.setJoinerName(userActivityReqModel.getJoinerName());
		userActivity.setJoinTime(userActivityReqModel.getJoinTime());
		userActivity.setStatus(1);
		userActivity.setUserId(userActivityReqModel.getUserId());
		userActivity.setCancelDate(null);
		userActivity.setCancelTime("");
		userActivity.setCancelReason("");
		userActivity.setCancelRemark("");

		if (null != userActivityMapper.fetchUserActivityByUidAndActId(userActivity.getActId(), userActivity.getUserId())) {
			userActivityRespModel.setResult(ErrorCode.RESPONSE_ERROR);
		} else {
			if (userActivityMapper.addUserActivity(userActivity)) {
				userActivityRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
			} else {
				userActivityRespModel.setResult(ErrorCode.RESPONSE_ERROR);
			}
		}
		return userActivityRespModel;
	}

	public UserActivityRespModel deleteUserActivity(UserActivityReqModel userActivityReqModel) throws Exception {
		UserActivityRespModel userActivityRespModel = new UserActivityRespModel();
		UserActivity userActivity ;

		userActivity = userActivityMapper.fetchUserActivityByUidAndActId(
				userActivityReqModel.getActId(), userActivityReqModel.getUserId());
		
		if (null != userActivity) {
			userActivity.setCancelDate(userActivityReqModel.getCancelDate());
			userActivity.setCancelReason(userActivityReqModel.getCancelReason());
			userActivity.setCancelTime(userActivityReqModel.getCancelTime());
			userActivity.setCancelRemark(userActivityReqModel.getCancelRemark());

			int recordNum = userActivityMapper.updateUserActivity(userActivity);

			if  (recordNum > 0) {
				userActivityRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
			} else {
				userActivityRespModel.setResult(ErrorCode.RESPONSE_ERROR);
			}
		} else {
			userActivityRespModel.setResult(ErrorCode.RESPONSE_ERROR);
		}
		return userActivityRespModel;
	}

}
