package com.group.isoft.bearsport.activity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.group.isoft.bearsport.clientmodel.activity.ActivityReqModel;
import com.group.isoft.bearsport.clientmodel.activity.ActivityRespData;
import com.group.isoft.bearsport.clientmodel.activity.ActivityRespModel;
import com.group.isoft.bearsport.clientmodel.location.Location;
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
		String actId = null;
		String maxActId = activityMapper.fetchMaxActId();

		if(StringUtils.isBlank(maxActId)){
			maxActId = "1";
		}

		Integer newActId = Integer.valueOf(maxActId) + 1;

		switch (newActId.toString().length()) {
		case 1:
			actId = "000" + newActId;
			break;
		case 2:
			actId = "00" + newActId;
			break;
		case 3:
			actId = "0" + newActId;
			break;
		case 4:
			actId = "0" + newActId;
			break;
		}

		activity.setId(Utils.getUUID());
		activity.setActId(actId);
		activity.setActStatus("A");
		activity.setActDate(activityReqModel.getActDate());
		activity.setActSubject(activityReqModel.getActSubject());
		activity.setActTime(activityReqModel.getActTime());
		activity.setActType(activityReqModel.getActType());
		activity.setAreaAddress(activityReqModel.getAreaAddress());

		if (null != activityReqModel.getAreaLocation()) {
			activity.setAreaLatitude(activityReqModel.getAreaLocation().getLatitude());
			activity.setArealongitude(activityReqModel.getAreaLocation().getLongitude());
		}

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
		activity.setNickName(activityReqModel.getNickName());
		activity.setContactNum(activityReqModel.getContactNum());
		activity.setEnrPeople(1);

		if (activityMapper.addActivity(activity)) {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("actId", activity.getActId());
			paramMap.put("userId", activity.getUserId());
			activityRespModel.setParams(paramMap);
			activityRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
		} else {
			activityRespModel.setResult(ErrorCode.RESPONSE_ERROR);
		}
		return activityRespModel;
	}

	public ActivityRespModel fetchActivity(ActivityReqModel activityReqModel) throws Exception {
		ActivityRespModel activityRespModel = new ActivityRespModel();
		List<Activity> activityList = new ArrayList<Activity>();
		List<ActivityRespData> activityRespDataList = new ArrayList<ActivityRespData>();
		activityList = activityMapper.queryActivityList();

		for (Activity activity : activityList) {
			ActivityRespData activityRespData = new ActivityRespData();
			activityRespData.setActId(activity.getActId());
			activityRespData.setActDate(activity.getActDate());
			activityRespData.setActSubject(activity.getActSubject());
			activityRespData.setActTime(activity.getActTime());
			activityRespData.setActType(activity.getActType());
			activityRespData.setAreaAddress(activity.getAreaAddress());
			Location areaLocation = new Location();
			areaLocation.setLatitude(activity.getAreaLatitude());
			areaLocation.setLongitude(activity.getArealongitude());
			activityRespData.setAreaLocation(areaLocation);
			activityRespData.setAreaName(activity.getAreaName());
			activityRespData.setEnrPeople(activity.getEnrPeople());
			activityRespData.setFeeEst(activity.getFee());
			activityRespData.setFeeType(activity.getFeeType());
			activityRespData.setOpenId(activity.getOpenId());
			activityRespData.setPlanPeople(activity.getPlanPeople());
			activityRespData.setSprType(activity.getSportType());
			activityRespData.setWordsInput(activity.getWordInput());
			activityRespData.setNickName(activity.getNickName());

			activityRespDataList.add(activityRespData);
		}

		activityRespModel.setListData(activityRespDataList);
		activityRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
		return activityRespModel;
	}

	public ActivityRespModel fetchActivityDetl(ActivityReqModel activityReqModel) throws Exception {
		ActivityRespModel activityRespModel = new ActivityRespModel();
		ActivityRespData activityRespData = new ActivityRespData();
		List<ActivityRespData> activityRespDataList = new ArrayList<ActivityRespData>();
		Activity activity = null;

		activity = activityMapper.fetchActDetlByActId(activityReqModel.getActId());

		if (null != activity) {
			activityRespData.setActDate(activity.getActDate());
			activityRespData.setActId(activity.getActId());
			activityRespData.setActSubject(activity.getActSubject());
			activityRespData.setActTime(activity.getActTime());
			activityRespData.setActType(activity.getActType());
			activityRespData.setAreaAddress(activity.getAreaAddress());
			Location areaLocation = new Location();
			areaLocation.setLatitude(activity.getAreaLatitude());
			areaLocation.setLongitude(activity.getArealongitude());
			activityRespData.setAreaLocation(areaLocation);
			activityRespData.setAreaName(activity.getAreaName());
			activityRespData.setEnrPeople(activity.getEnrPeople());
			activityRespData.setFeeEst(activity.getFee());
			activityRespData.setFeeType(activity.getFeeType());
			activityRespData.setOpenId(activity.getOpenId());
			activityRespData.setPlanPeople(activity.getPlanPeople());
			activityRespData.setSprType(activity.getSportType());
			activityRespData.setWordsInput(activity.getWordInput());
			activityRespData.setNickName(activity.getNickName());

			activityRespDataList.add(activityRespData);
			activityRespModel.setListData(activityRespDataList);
		}

		activityRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
		return activityRespModel;
	}

	public ActivityRespModel updateActivity(ActivityReqModel activityReqModel) throws Exception {
		ActivityRespModel activityRespModel = new ActivityRespModel();
		Activity activity = null;

		activity = activityMapper.fetchActDetlByActId(activityReqModel.getActId());

		if (null != activity) {
			activity.setEnrPeople(activity.getEnrPeople() + 1);
			int record = activityMapper.updateActivity(activity);

			if (record > 0) {
				activityRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
			}
		}
		return activityRespModel;
	}

}
