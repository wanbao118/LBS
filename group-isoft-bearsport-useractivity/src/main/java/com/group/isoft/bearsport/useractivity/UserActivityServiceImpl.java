package com.group.isoft.bearsport.useractivity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group.isoft.bearsport.clientmodel.userActivity.ActivityJoiner;
import com.group.isoft.bearsport.clientmodel.userActivity.ActivityJoinerDetl;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityReqModel;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityRespData;
import com.group.isoft.bearsport.clientmodel.userActivity.UserActivityRespModel;
import com.group.isoft.bearsport.model.useractivity.ActivityJoinerInfo;
import com.group.isoft.bearsport.model.useractivity.Joiner;
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
		userActivity.setJoinerType(userActivityReqModel.getJoinerType());
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

	public UserActivityRespModel getActivityJoinerInfo(UserActivityReqModel userActivityReqModel) throws Exception {
		UserActivityRespModel respModel = new UserActivityRespModel();
		List<UserActivity> userActivityList = userActivityMapper.getUserActivityDetlByActId(userActivityReqModel.getActId());

		List<UserActivityRespData> userActivityRespDataList = new ArrayList<UserActivityRespData>();
/*				ActivityJoinerDetl detail = new ActivityJoinerDetl();
		detail.setEnrPeople(info.getJoiners().size());
		detail.setPlanPeople(info.getPlanPeople());
		UserActivityRespData userActivityRespData = new UserActivityRespData();
		
		ArrayList<Joiner> joiners = (ArrayList<Joiner>) info.getJoiners();
		List<ActivityJoiner> actJoiners = new ArrayList<ActivityJoiner>();
*/
		for(UserActivity userActivity : userActivityList) {
			UserActivityRespData userActivityRespData = new UserActivityRespData();
			userActivityRespData.setUesrId(userActivity.getUserId());
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
