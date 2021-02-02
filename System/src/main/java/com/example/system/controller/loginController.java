package com.example.system.controller;

import com.example.system.dao.UserDao;
import com.example.system.entity.UserEntity;
import com.example.system.util.ResMesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class loginController {

    @Autowired
    UserDao userDao;

    @GetMapping("/")
    public String login(HttpSession session) {
        if (session.getAttribute("userName") == null){
            return "login";
        }
        return "index";
    }

    /**
     * 新人注册
     */
    @PostMapping("/register")
    @ResponseBody
    public String register(@Valid UserEntity userEntity, BindingResult br) {
        if (br.hasErrors()) {
            return ResMesUtil.build().resMesFail(br.getFieldError().getDefaultMessage());
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isEmpty(userEntity.getUserName())) {
            return ResMesUtil.build().resMesFail("用户名不能为空，请重新输入！");
        } else if (StringUtils.isEmpty(userEntity.getPassWord())) {
            return ResMesUtil.build().resMesFail("密码不能为空，请重新输入！");
        }

        userEntity.setStartTime(dtf.format(LocalDateTime.now()));
        UserEntity save = userDao.save(userEntity);
        if (save != null) {
            return ResMesUtil.build().success();
        } else {
            return ResMesUtil.build().fail();
        }
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(String userName, String passWord, String psStatus, HttpSession session) {
        UserEntity user = userDao.findByUserNameAndPassWord(userName, passWord);
        if (user != null) {
            session.setAttribute("userName",userName);
            session.setAttribute("userType",user.getUserType());
            user.setPsStatus(psStatus);
            UserEntity userEntity = userDao.saveAndFlush(user);
            if (userEntity != null) {
                return ResMesUtil.build().success();
            }

        }
        return ResMesUtil.build().resMesFail("用户名或密码不正确！");
    }
}
