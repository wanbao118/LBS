package com.group.isoft.bearsport.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.group.isoft.bearsport.clientmodel.location.Location;
import com.group.isoft.bearsport.clientmodel.user.UserReqModel;
import com.group.isoft.bearsport.clientmodel.user.UserRespData;
import com.group.isoft.bearsport.clientmodel.user.UserRespModel;
import com.group.isoft.bearsport.model.user.User;
import com.group.isoft.bearsport.persist.user.UserMapper;
import com.group.isoft.bearsport.util.ErrorCode;
import com.group.isoft.bearsport.util.Utils;

@Service
public class UserServiceImpl implements IUserService{

	@Resource
	UserMapper userMapper;

	public UserRespModel addUser(UserReqModel userReqModel) throws Exception {
		UserRespModel userRespModel = new UserRespModel();
		User user;

		user = userMapper.fetchUserDetlByOpenId(userReqModel.getOpenId());

		if (user != null) {
			//user = userMapper.fetchUserDetlByOpenId(userReqModel.getOpenId());
			user.setCreditLevel(String.valueOf(Integer.parseInt(user.getCreditLevel()) + 1));
			user.setLevel(String.valueOf(Integer.parseInt(user.getLevel()) + 1));
			user.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
			user.setLatitude(userReqModel.getLocation().getLatitude());
			user.setLongitude(userReqModel.getLocation().getLongitude());

			int recordNum = userMapper.updateUser(user);

			if (recordNum > 0) {
				userRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
			} else {
				userRespModel.setResult(ErrorCode.RESPONSE_ERROR);
			}		
		} else {
			String userId = null;
			String maxUserId = userMapper.fetchMaxUserId();

			if(StringUtils.isBlank(maxUserId)){
				maxUserId = "0";
			}
			
			Integer newUserId = Integer.valueOf(maxUserId) + 1;

			switch (newUserId.toString().length()) {
			case 1:
				userId = "000" + newUserId;
				break;
			case 2:
				userId = "00" + newUserId;
				break;
			case 3:
				userId = "0" + newUserId;
				break;
			case 4:
				userId = "0" + newUserId;
				break;
			}

			user = new User();
			user.setId(Utils.getUUID());
			user.setUserId(userId);
	
			user.setAvatarUrl(userReqModel.getAvatarUrl());
			user.setCity(userReqModel.getCity());
			user.setCountry(userReqModel.getCountry());
			user.setGender(userReqModel.getGender());
			user.setLanguage(userReqModel.getLanguage());
			user.setNickName(userReqModel.getNickName());
			user.setProvince(userReqModel.getProvince());
			user.setOpenId(userReqModel.getOpenId());
			user.setDescription("");
			user.setCreditLevel("1");
			user.setLevel("1");
			user.setFavType1("");
			user.setFavType2("");
			user.setFavType3("");
			user.setFirstLoginTime(new Timestamp(System.currentTimeMillis()));
			user.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
			user.setLongitude(userReqModel.getLocation().getLongitude());
			user.setLatitude(userReqModel.getLocation().getLatitude());
			user.setLoginCity(userReqModel.getLoginCity());

			if (userMapper.addUser(user)) {
				userRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
			} else {
				userRespModel.setResult(ErrorCode.RESPONSE_ERROR);
			}
		}
		return userRespModel;
	}

	public UserRespModel fetchUserByOpenId(UserReqModel userReqModel) throws Exception {
		UserRespModel userResponseModel = new UserRespModel();
		User user = userMapper.fetchUserDetlByOpenId(userReqModel.getOpenId());

		List<UserRespData> userDataList = new ArrayList<UserRespData>();

		if (null != user) {
			UserRespData userRespData = new UserRespData();

			userRespData.setId(user.getId());
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
			userRespData.setLanguage(user.getLanguage());
			userRespData.setLastLoginTime(user.getLastLoginTime());
			userRespData.setLevel(user.getLevel());
			userRespData.setNickName(user.getNickName());
			userRespData.setOpenId(user.getOpenId());
			userRespData.setProvince(user.getProvince());
			userRespData.setUserId(user.getUserId());
			Location location = new Location();
			location.setLatitude(user.getLatitude());
			location.setLongitude(user.getLongitude());
			userRespData.setLocation(location);
			userDataList.add(userRespData);

			userResponseModel.setResult(ErrorCode.RESPONSE_SUCCESS);
			userResponseModel.setListData(userDataList);
		}

		return userResponseModel;
	}

	public UserRespModel fetchUserList(UserReqModel userReqModel) throws Exception {
		UserRespModel userRespModel = new UserRespModel();
		List<User> userList = new ArrayList<User>();
		List<UserRespData> userRespDataList = new ArrayList<UserRespData>();
		userList = userMapper.queryUserList();
		
		for (User user : userList) {
			UserRespData userRespData = new UserRespData();
			userRespData.setId(user.getId());
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
			userRespData.setLanguage(user.getLanguage());
			userRespData.setLastLoginTime(user.getLastLoginTime());
			userRespData.setLevel(user.getLevel());
			userRespData.setNickName(user.getNickName());
			userRespData.setOpenId(user.getOpenId());
			userRespData.setProvince(user.getProvince());
			userRespData.setUserId(user.getUserId());
			Location location = new Location();
			location.setLatitude(user.getLatitude());
			location.setLongitude(user.getLatitude());
			userRespData.setLocation(location);

			userRespDataList.add(userRespData);
		}

		userRespModel.setListData(userRespDataList);
		userRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);

		return userRespModel;
	}

	public UserRespModel updateUser(UserReqModel userReqModel) throws Exception {
		User user = userMapper.fetchUserDetlByOpenId(userReqModel.getOpenId());
		UserRespModel userRespModel = new UserRespModel();

		user.setAvatarUrl(userReqModel.getAvatarUrl());
		user.setCity(userReqModel.getCity());
		user.setCountry(userReqModel.getCountry());
		user.setGender(userReqModel.getGender());
		user.setLanguage(userReqModel.getLanguage());
		user.setNickName(userReqModel.getNickName());
		user.setProvince(userReqModel.getProvince());
		user.setDescription(userReqModel.getDescription());
		user.setLoginCity(userReqModel.getLoginCity());

		int recordNum = userMapper.updateUser(user);

		if (recordNum > 0) {
			userRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
		} else {
			userRespModel.setResult(ErrorCode.RESPONSE_ERROR);
		}	
		return userRespModel;
	}

	public boolean makeFriends(String openId, String friendOpenId) throws Exception {
		return userMapper.addFriend(openId, friendOpenId);
	}
	
	public UserRespModel FetchFriendList(UserReqModel userReqModel) throws Exception{
		 List<User> users = userMapper.fetchFriendList(userReqModel.getOpenId());
		 UserRespModel userRespModel = new UserRespModel();
		 List<UserRespData> listData = new ArrayList<UserRespData>();
		 for(User user : users) {
			 UserRespData userData = new UserRespData();
			 userData.setAvatarUrl(user.getAvatarUrl());
			 userData.setCity(user.getCity());
			 userData.setCountry(user.getCountry());
			 userData.setCreditLevel(user.getCreditLevel());
			 userData.setDescription(user.getDescription());
			 userData.setFavType1(user.getFavType1());
			 userData.setFavType2(user.getFavType2());
			 userData.setFavType3(user.getFavType3());
			 userData.setFirstLoginTime(user.getFirstLoginTime());
			 userData.setGender(user.getGender());
			 userData.setId(user.getId());
			 userData.setLanguage(user.getLanguage());
			 userData.setLastLoginTime(user.getLastLoginTime());
			 userData.setLevel(user.getLevel());
			 userData.setNickName(user.getNickName());
			 userData.setOpenId(user.getOpenId());
			 userData.setProvince(user.getProvince());
			 userData.setUserId(user.getUserId());
			 Location location = new Location();
			 location.setLatitude(user.getLatitude());
			 location.setLongitude(user.getLongitude());
			 userData.setLocation(location);
			 listData.add(userData);
		 }
		 userRespModel.setListData(listData);
		 return userRespModel;
	}
	
	public UserRespModel updateRelationshipStatus(UserReqModel userReqModel) throws Exception{
		String openId = userReqModel.getParams().get("openId");
		String friendOpenId = userReqModel.getParams().get("friendOpenId");
		String relationshipStatus = userReqModel.getParams().get("relationshipStatus");
		int recordNum = userMapper.updateRelationshipStatus(openId, friendOpenId, relationshipStatus);
		UserRespModel userRespModel = new UserRespModel();
		if(recordNum > 0) {
			userRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
		}else {
			userRespModel.setResult(ErrorCode.RESPONSE_ERROR);
		}
		return userRespModel;
	}
	
	public UserRespModel fetchMakeFriendApplications(UserReqModel userReqModel) throws Exception{
		String openId = userReqModel.getParams().get("openId");
		List<User> users = userMapper.fetchMakeFriendApplications(openId);
		UserRespModel userRespModel = new UserRespModel();
		List<UserRespData> listData = new ArrayList<UserRespData>();
		for(User user : users) {
			UserRespData userData = new UserRespData();
			 userData.setAvatarUrl(user.getAvatarUrl());
			 userData.setCity(user.getCity());
			 userData.setCountry(user.getCountry());
			 userData.setCreditLevel(user.getCreditLevel());
			 userData.setDescription(user.getDescription());
			 userData.setFavType1(user.getFavType1());
			 userData.setFavType2(user.getFavType2());
			 userData.setFavType3(user.getFavType3());
			 userData.setFirstLoginTime(user.getFirstLoginTime());
			 userData.setGender(user.getGender());
			 userData.setId(user.getId());
			 userData.setLanguage(user.getLanguage());
			 userData.setLastLoginTime(user.getLastLoginTime());
			 userData.setLevel(user.getLevel());
			 userData.setNickName(user.getNickName());
			 userData.setOpenId(user.getOpenId());
			 userData.setProvince(user.getProvince());
			 userData.setUserId(user.getUserId());
			 Location location = new Location();
			 location.setLatitude(user.getLatitude());
			 location.setLongitude(user.getLongitude());
			 userData.setLocation(location);
			 listData.add(userData);
		}
		userRespModel.setListData(listData);
		 return userRespModel;
	}
}
