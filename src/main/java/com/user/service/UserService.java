package com.user.service;


import com.user.pojo.User;

/**
 * @author 赵婷
 */
public interface UserService {

    boolean login(String userName, String passWord);

    User getUserInfo(String userName);

    User queryById(Long userId);
}
