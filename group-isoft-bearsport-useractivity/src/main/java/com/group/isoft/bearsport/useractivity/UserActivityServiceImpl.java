package com.group.isoft.bearsport.useractivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityReqModel;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityRespData;
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

		Date joinDate = new Date();
		userActivity.setActId(userActivityReqModel.getActId());
		userActivity.setDetail(userActivityReqModel.getJoinRemark());
		userActivity.setJoinDate(joinDate);
		userActivity.setJoinerName(userActivityReqModel.getJoinerName());
		userActivity.setJoinTime(joinDate.getHours() + ":" + joinDate.getMinutes());
		userActivity.setJoinerType(userActivityReqModel.getJoinerType());
		userActivity.setStatus(1);
		//userActivity.setUserId(userActivityReqModel.getUserId());
		userActivity.setOpenId(userActivityReqModel.getOpenId());
		userActivity.setCancelDate(null);
		userActivity.setCancelTime("");
		userActivity.setCancelReason("");
		userActivity.setCancelRemark("");

		if (null != userActivityMapper.fetchUserActivityByUidAndActId(userActivity.getActId(), userActivity.getOpenId())) {
			userActivityRespModel.setResult(ErrorCode.RESPONSE_ERROR);
			List<String> errorCodeList = new ArrayList<String>();

			errorCodeList.add(ErrorCode.ACT_HAVE_JOINED);
			userActivityRespModel.setErrorCode(errorCodeList);
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
				userActivityReqModel.getActId(), userActivityReqModel.getOpenId());
		
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

	public UserActivityRespModel getActivityJoinerInfo(UserActivityReqModel userActivityReqModel) throws Exception {
		UserActivityRespModel respModel = new UserActivityRespModel();
		List<UserActivity> userActivityList = userActivityMapper.getUserActivityDetlByActId(userActivityReqModel.getActId());

		List<UserActivityRespData> userActivityRespDataList = new ArrayList<UserActivityRespData>();

		for(UserActivity userActivity : userActivityList) {
			UserActivityRespData userActivityRespData = new UserActivityRespData();
			userActivityRespData.setUsername(userActivity.getJoinerName());
			userActivityRespData.setJoinDate(userActivity.getJoinDate());
			userActivityRespData.setJoinTime(userActivity.getJoinTime());
			userActivityRespData.setRemark(userActivity.getDetail());
			userActivityRespDataList.add(userActivityRespData);
		}

		respModel.setListData(userActivityRespDataList);
		respModel.setResult(ErrorCode.RESPONSE_SUCCESS);

		return respModel;
	}

}
