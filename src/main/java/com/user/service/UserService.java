package com.user.service;


import com.user.pojo.User;

/**
 * @author 赵婷
 */
public interface UserService {

    /**
     * 判断登录的合法性
     * @param userName
     * @param passWord
     * @return
     */
    boolean login(String userName, String passWord);

    /**
     * 通过username获得user信息
     * @param userName
     * @return
     */
    User getUserInfo(String userName);

    /**
     * 通过userId获得user信息
     * @param userId
     * @return
     */
    User queryById(Long userId);
}
