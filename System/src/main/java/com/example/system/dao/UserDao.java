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
     * 根据记住密码选项
     *
     * @param id,psStatus
     * @return
     */
    /*@Query(value = "update user set psStatus?psStatus where id =:id",nativeQuery = true)
    String updatepsStatus(Integer id, String psStatus);*/

}
