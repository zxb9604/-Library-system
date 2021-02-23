package com.example.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空，请重新输入！")
    private String userName;
    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空，请重新输入！")
    private String passWord;
    /**
     * 类型（用户类型,0为最高管理员，1为管理人员，2为普通用户）
     */
    @Column(length = 1)
    private String userType = "2";
    /**
     * 邮箱
     */
    @Email
    private String email;
    /**
     * 状态（是否记住密码,0为否，1为是，默认为否）
     */
    @Column(length = 1)
    private String psStatus= "0";
    /**
     * 注册时间
     */
    private String startTime;


}
