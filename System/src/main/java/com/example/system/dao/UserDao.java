package com.example.system.dao;

import com.example.system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 用户对应的dao
 */
public interface UserDao extends JpaRepository<UserEntity, Integer> {

    /**
     * 根据userName password获取用户
     *
     * @param userName
     * @return
     */
    UserEntity findByUserNameAndPassWord(String userName, String passWord);

    /**
     * 根据用户名查找
     *
     * @param userName
     * @return
     */
    UserEntity findByUserName(String userName);

}
