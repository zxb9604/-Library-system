package com.example.system.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.alibaba.fastjson.JSONObject;
import com.example.system.dao.StudentDao;
import com.example.system.entity.StudentEntity;
import com.example.system.util.ExcelUtil;
import com.example.system.util.ResMesUtil;
import com.example.system.util.DownLoadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@Controller
public class AddController {

    private Logger log = LoggerFactory.getLogger(AddController.class);
    @Autowired
    StudentDao studentDao;

    @PostMapping("/addUser")
    @ResponseBody
    public String addUser(StudentEntity studentEntity) {
        System.out.println(studentEntity);
        StudentEntity save = studentDao.save(studentEntity);
        System.out.println(save);
        if (save != null) {
            return ResMesUtil.build().success();
        } else {
            return ResMesUtil.build().fail();
        }
    }

    @PostMapping("/checkname")
    @ResponseBody
    public String checkname(String username) {
        StudentEntity byUserName = studentDao.findByUserName(username);
        System.out.println(byUserName);
        if (byUserName != null) {
            return ResMesUtil.build().success();
        }
        return ResMesUtil.build().fail();
    }

    /**
     * 学生批量导入模板下载
     */
    @GetMapping("/down")
    public void down(HttpServletResponse response) throws IOException {
        DownLoadUtil.downloadTemplate(response, "xsdr.xlsx");
    }

    /**
     * 学生批量导入
     */
    @GetMapping("/xsImportExcel")
    public String importExcel(MultipartFile file) {

        ImportParams importParams = new ImportParams();
        // 数据处理
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);
        // 需要验证
        importParams.setNeedVerify(false);
        try {
            ExcelImportResult<StudentEntity> result = ExcelImportUtil.importExcelMore(file.getInputStream(), StudentEntity.class, importParams);

            List<StudentEntity> studentList = result.getList();
            for (StudentEntity student : studentList) {
                log.info("从Excel导入数据到数据库的详细为 ：{}", JSONObject.toJSONString(student));
                //保存到mysql
                StudentEntity save = studentDao.save(student);
                if (save == null) {
                    log.error("保存失败");
                    return ResMesUtil.build().resMesFail("保存失败");
                }
                //查出自增id
                //TbCommpanyExample tbCommpanyExample = new TbCommpanyExample();
                // tbCommpanyExample.createCriteria().andCompanyNameEqualTo(commpany.getCompanyName());
                // long id = tbCommpanyMapper.selectByExample(tbCommpanyExample).get(0).getId();
                // commpany.setId(id);
                //保存到redis
                //redisUtils.sSet("company",JSONObject.parseObject(JSONObject.toJSONString(commpany)));
            }
            log.info("从Excel导入数据一共 {} 行 ", studentList.size());
        } catch (Exception e) {
            log.error("导入失败：{}", e.getMessage());
            return ResMesUtil.build().resMesFail("导入失败");
        }
         return ResMesUtil.build().success();
    }
}