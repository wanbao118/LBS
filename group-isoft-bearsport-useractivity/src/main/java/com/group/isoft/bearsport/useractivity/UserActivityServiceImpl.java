package com.group.isoft.bearsport.useractivity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group.isoft.bearsport.clientmodel.user.UserRespData;
import com.group.isoft.bearsport.clientmodel.user.UserRespModel;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityReqModel;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityRespModel;
import com.group.isoft.bearsport.model.user.User;
import com.group.isoft.bearsport.model.useractivity.UserActivity;
import com.group.isoft.bearsport.persist.user.UserMapper;
import com.group.isoft.bearsport.persist.userActivity.UserActivityMapper;
import com.group.isoft.bearsport.util.ErrorCode;

@Service
public class UserActivityServiceImpl implements IUserActivityService {

	@Resource
	UserActivityMapper userActivityMapper;

	@Resource
	UserMapper userMapper;
	
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

	public UserRespModel getJoinerListbyAcctId(UserActivityReqModel userActivityReqModel) {
		UserRespModel userRespModel = new UserRespModel();
		ArrayList<User> userList = (ArrayList<User>) userMapper.getJoinerListbyAcctId(userActivityReqModel.getActId());
		List<UserRespData> users = new ArrayList<UserRespData>();
		for(User user : userList) {
			UserRespData userRespData = new UserRespData();
			userRespData.setAvatarUrl(user.getAvatarUrl());
			userRespData.setCity(user.getCity());
			userRespData.setCountry(user.getCountry());
			userRespData.setCreditLevel(user.getCreditLevel());
			userRespData.setDescription(user.getDescription());
			userRespData.setFavType1(user.getFavType1());
			userRespData.setFavType2(user.getFavType2());
			userRespData.setFavType3(user.getFavType3());
			userRespData.setFirstLoginTime(user.getFirstLoginTime());
			userRespData.setGender(user.getGender());
			userRespData.setId(user.getId());
			userRespData.setLanguage(user.getLanguage());
			userRespData.setLastLoginTime(user.getLastLoginTime());
			userRespData.setLevel(user.getLevel());
			userRespData.setNickName(user.getNickName());
			userRespData.setOpenId(user.getOpenId());
			userRespData.setProvince(user.getProvince());
			userRespData.setUserId(user.getUserId());
			users.add(userRespData);
		}
		userRespModel.setListData(users);
		return userRespModel;
	}
}
