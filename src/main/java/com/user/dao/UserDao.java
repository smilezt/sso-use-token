package com.user.dao;

import com.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 赵婷
 */
@Repository
@Mapper
public interface UserDao {

    /**
     * 根据username查询user信息
     * @param userName
     * @return
     */
    User query(String userName);

    /**
     * 根据userId查询user信息
     * @param userId
     * @return
     */
    User queryById(Long userId);
}
