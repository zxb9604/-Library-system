package com.example.system.util;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

/**
 * 请求回应
 * */
public class ResMesUtil extends HashMap<Object,Object> {

    private static final String MES_SUCC = "success";
    private static final String MES_FAIL = "fail";

    private static final int CODE_FAIL = 400;
    private static final int CODE_SUCC = 200;

    public String success() {
        return resMes(MES_SUCC, CODE_SUCC);
    }
    public String fail() {
        return resMes(MES_FAIL, CODE_FAIL);
    }
    public String resMesFail(String mes) {
        return resMes(mes, CODE_FAIL);
    }
    private String resMes(String mes, int code) {
        this.put("mes", mes);
        this.put("code", code);
        return  new Gson().toJson(this);
    }

    public static ResMesUtil build() {
        return new ResMesUtil();
    }
}
