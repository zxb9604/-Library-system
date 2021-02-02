package com.example.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class jumpController {

    @GetMapping("/jump/{path}")
    public String jumpHtml(@PathVariable String path, HttpSession session) {
        if (session.getAttribute("userName") == null) {
            return "login";
        }
        if (!StringUtils.isEmpty(path)) {
            return path;
        }
        return "index";
    }

}
