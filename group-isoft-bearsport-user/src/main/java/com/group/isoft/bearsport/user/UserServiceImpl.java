package com.group.isoft.bearsport.user;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

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
			user = userMapper.fetchUserDetlByOpenId(userReqModel.getOpenId());
			user.setCreditLevel(String.valueOf(Integer.parseInt(user.getCreditLevel()) + 1));
			user.setLevel(String.valueOf(Integer.parseInt(user.getLevel()) + 1));

			int recordNum = userMapper.updateUser(user);

			if (recordNum > 0) {
				userRespModel.setResult(ErrorCode.RESPONSE_SUCCESS);
			} else {
				userRespModel.setResult(ErrorCode.RESPONSE_ERROR);
			}		
		} else {
			user = new User();
			user.setId(Utils.getUUID());
			user.setUserId("0001");
	
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
		UserRespData userRespData = new UserRespData();
		List<UserRespData> userDataList = new ArrayList<UserRespData>();

		if (null != user) {
			BeanUtils.copyProperties(user, userRespData);
			userDataList.add(userRespData);

			userResponseModel.setResult(ErrorCode.RESPONSE_SUCCESS);
			userResponseModel.setListData(userDataList);
		}

		return userResponseModel;
	}

}
