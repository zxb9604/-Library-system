package com.example.system.util;

import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

public class DownLoadUtil {


    /**
     * 下载模板信息
     * 适用于windows和linux
     * @param response
     * @param templeteName
     * @throws IOException
     */
    public static void downloadTemplate(HttpServletResponse response, String templeteName) throws IOException {
        OutputStream outp = null;
        InputStream in =null;
        try {
            String fileName = templeteName; //要下载的模板文件
            if(templeteName!=null){
                if(!templeteName.endsWith(".xlsx")){
                    fileName = templeteName + ".xlsx";
                }
            }
            // 要下载的模板所在的绝对路径
            String ctxPath ="static/down/";
            //String ctxPath = request.getSession().getServletContext().getRealPath(File.separator) + File.separator + "template" + File.separator;
            String filedownload = ctxPath + fileName;
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            //使客户端浏览器，区分不同种类的数据,设置成application/octet-stream的代表二进制流，未知下载文件类型
            response.setContentType("application/octet-stream;charset=UTF-8");

            outp = response.getOutputStream();
            in = new ClassPathResource(filedownload).getInputStream();

            byte[] b = new byte[1024];
            int i = 0;
            while ((i = in.read(b)) > 0) {
                outp.write(b, 0, i);
            }
            outp.flush();
        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
                in = null;
            }
            if (outp != null) {
                outp.close();
                outp = null;
            }
        }
    }
}
