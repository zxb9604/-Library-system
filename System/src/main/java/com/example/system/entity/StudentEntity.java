package com.example.system.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
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
@Table(name = "student")
@ExcelTarget("StudentEntity")
public class StudentEntity implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空，请重新输入！")
    @Excel(name = "姓名")
    private String userName;
    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空，请重新输入！")
    @Excel(name = "密码")
    private String passWord;
    /**
     * 联系电话
     */
    @Excel(name = "电话号码")
    private String phone;
    /**
     * 邮箱
     */
    @Email
    @Excel(name="邮箱")
    private String email;
    /**
     * 注册时间
     */
    @Excel(name="注册时间",importFormat = "yyyy-MM-dd")
    private String rxsj;
    /**
     * 学院
     * */
    @Excel(name = "学院")
    private String college;
    /**
     * 专业
     * */
    @Excel(name = "专业")
    private String major;
    /**
     * 状态（是否记住密码,0为否，1为是，默认为否）
     */
    @Column(length = 1)
    private String psStatus= "0";
}
