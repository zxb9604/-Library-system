package com.example.jpa.dao;

import com.example.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 符合SpringDataJpa的dao层接口规范：
 *      JpaRepository<操作的实体类型, 实体类中主键属性类型>
 *          *封装了基本的CRUD操作
 *      JpaSpecificationExecutor<操作的实体类型>
 *          *封装了复杂的查询（分页）
 */
public interface UserDao extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {

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
