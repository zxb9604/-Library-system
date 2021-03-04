package com.example.system.dao;

import com.example.system.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<StudentEntity,Integer> {

    /**
     * 用户添加时验证用户名
     * @param username
     * @return String
     * */
    StudentEntity findByUserName(String username);
}
