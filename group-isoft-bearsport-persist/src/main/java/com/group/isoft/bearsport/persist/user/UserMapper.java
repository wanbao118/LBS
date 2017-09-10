package com.group.isoft.bearsport.persist.user;

import java.util.List;

import com.group.isoft.bearsport.model.user.User;


public interface UserMapper
{
    boolean addUser(User user);

    int updateUser(User user);

    User fetchUserDetlByUserId(String userId);

    User fetchUserDetlByOpenId(String openId);

    List<User> queryUserList();

    String fetchMaxUserId();
    
    boolean addFriend(String openId, String FriendOpenId);
    
    List<User> fetchFriendList(String openId);
    
}
