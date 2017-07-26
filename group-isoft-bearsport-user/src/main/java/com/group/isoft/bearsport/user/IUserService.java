package com.group.isoft.bearsport.user;

import com.group.isoft.bearsport.clientmodel.user.UserReqModel;
import com.group.isoft.bearsport.clientmodel.user.UserRespModel;

public interface IUserService {
    UserRespModel addUser(UserReqModel userReqModel) throws Exception;
    UserRespModel fetchUserList(UserReqModel userReqModel) throws Exception;
}
