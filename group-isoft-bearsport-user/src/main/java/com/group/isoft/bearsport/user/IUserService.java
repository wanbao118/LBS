package com.group.isoft.bearsport.user;

import com.group.isoft.bearsport.clientmodel.user.UserReqModel;
import com.group.isoft.bearsport.clientmodel.user.UserRespModel;

public interface IUserService {
    UserRespModel addUser(UserReqModel userReqModel) throws Exception;
    UserRespModel fetchUserList(UserReqModel userReqModel) throws Exception;
    UserRespModel fetchUserByOpenId(UserReqModel userReqModel) throws Exception;
    UserRespModel updateUser(UserReqModel userReqModel) throws Exception;
    UserRespModel FetchFriendList(UserReqModel userReqModel) throws Exception;
    boolean makeFriends(UserReqModel userReqModel) throws Exception;
    UserRespModel updateRelationshipStatus(UserReqModel userReqModel) throws Exception;
    UserRespModel fetchMakeFriendApplications(UserReqModel userReqModel) throws Exception;
}
