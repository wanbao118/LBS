package com.group.isoft.bearsport.persist.user;

import java.util.List;

import com.group.isoft.bearsport.model.user.User;


public interface UserMapper
{
    boolean addUser(User user);

    int updateUser(User user);

    User fetchUserDetlByUserId(String userId);

    List<User> queryUserByParams(User user);

    List<User> queryUserByParamsCount(User user);
}
