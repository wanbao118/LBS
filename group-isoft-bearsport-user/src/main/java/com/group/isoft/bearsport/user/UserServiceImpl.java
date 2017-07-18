package com.group.isoft.bearsport.user;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.group.isoft.bearsport.clientmodel.user.UserReqModel;
import com.group.isoft.bearsport.clientmodel.user.UserRespModel;
import com.group.isoft.bearsport.model.user.User;
import com.group.isoft.bearsport.persist.user.UserMapper;
import com.group.isoft.bearsport.util.ErrorCode;
import com.group.isoft.bearsport.util.Utils;

@Service
public class UserServiceImpl implements IUserService{

	@Resource
	UserMapper userMapper;

	public UserRespModel addUser(UserReqModel userReqModel) {
		UserRespModel userRespModel = new UserRespModel();
		User user = new User();

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
		return null;
	}

}
