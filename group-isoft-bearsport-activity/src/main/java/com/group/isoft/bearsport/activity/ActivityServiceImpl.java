package com.group.isoft.bearsport.activity;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group.isoft.bearsport.clientmodel.activity.ActivityReqModel;
import com.group.isoft.bearsport.clientmodel.activity.ActivityRespModel;
import com.group.isoft.bearsport.model.activity.Activity;
import com.group.isoft.bearsport.persist.activity.ActivityMapper;
import com.group.isoft.bearsport.util.ErrorCode;
import com.group.isoft.bearsport.util.Utils;

@Service
public class ActivityServiceImpl implements IActivityService {

	@Resource
	ActivityMapper activityMapper;

	public ActivityRespModel createActivity(ActivityReqModel activityReqModel) throws Exception {

		ActivityRespModel activityRespModel = new ActivityRespModel();
		Activity activity = new Activity();

		activity.setId(Utils.getUUID());
		activity.setActId("0001");
		activity.setActStatus("A");
		activity.setActDate(activityReqModel.getActDate());
		activity.setActSubject(activityReqModel.getActSubject());
		activity.setActTime(activityReqModel.getActTime());
		activity.setActType(activityReqModel.getActType());
		activity.setAreaAddress(activityReqModel.getAreaAddress());
		activity.setAreaLatitude(activityReqModel.getAreaLocation().getLatitude());
		activity.setArealongitude(activityReqModel.getAreaLocation().getLongitude());
		activity.setAreaName(activityReqModel.getAreaName());
		activity.setCreateDate(new Timestamp(System.currentTimeMillis()));
		activity.setFee(activityReqModel.getFeeEst());
		activity.setFeeType(activityReqModel.getFeeType());
		activity.setHeat("0");
		activity.setOpenId(activityReqModel.getOpenId());
		activity.setUserId("0001");
		activity.setPlanPeople(activityReqModel.getPlanPeople());
		activity.setSportType(activityReqModel.getSprType());
		activity.setWordInput(activityReqModel.getWordInput());

		if (activityMapper.addActivity(activity)) {
			activityRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
		} else {
			activityRespModel.setResult(ErrorCode.RESPONSE_ERROR);
		}
		return activityRespModel;
	}

}
