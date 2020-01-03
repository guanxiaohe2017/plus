package com.mybatis.plus.blh;

import com.mybatis.plus.entity.order.CheckOrder;
import com.mybatis.plus.mapper.order.CheckOrderMapper;
import com.mybatis.plus.service.CheckOrderService;
import com.mybatis.plus.web.client.DemoFeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CheckOrderBlh {

    @Resource
    CheckOrderService checkOrderService;

    public void backup(HttpServletResponse response) {
        try {
            Runtime rt = Runtime.getRuntime();

            // 调用 调用mysql的安装目录的命令
            String commcand = getMysqlPath() + "/bin/mysqldump -h localhost -u" + "root" + " -p" + "123" + " -R " + "rm-ispd-fuwai1108";
            Process child = rt.exec(commcand);
            // 设置导出编码为utf-8。这里必须是utf-8
            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流

            InputStreamReader xx = new InputStreamReader(in, "utf-8");
            // 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码

            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // 组合控制台输出信息字符串
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
//            //设置名字
            String fileName = "back" + ".sql";

//            //创建文件
//            File file1 = new File("D://" + fileName);
//            if (!file1.exists()) {
//                file1.createNewFile();
//            }
//            //保存文件
//            FileOutputStream fout = new FileOutputStream("D://" + fileName);
//            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
//            writer.write(outStr);
//            writer.flush();
//            in.close();
//            xx.close();
//            br.close();
//            writer.close();
//            fout.close();
//            System.out.println("backup success!");

            response.setCharacterEncoding("UTF-8");
//            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
//            OutputStream os = response.getOutputStream();
            PrintWriter out = response.getWriter();
            out.print(outStr);
//            workbook.write(os);
            out.flush();
            out.close();
//            os.flush();
//            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void backup2(HttpServletResponse response) {
        String realPath = getMysqlPath();
        try {
            Runtime rt = Runtime.getRuntime();

            // 调用 调用mysql的安装目录的命令
            String commcand = realPath + "/bin/mysqldump -h localhost -u" +
                    "root" + " -p" + "123" + " -R " + "rm-ispd-fuwai1108 > " + realPath + "qwe.sql";
            rt.exec(commcand);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //设置文件路径
        File file = new File(realPath + "qwe.sql");
        if (file.exists()) {
            response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=" + "qwe.sql");
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    //获取数据库安装路径
    public String getMysqlPath(){
        String sql = "select @@basedir as basePath from dual";
        List<HashMap<String,String>> hashMaps = checkOrderService.invokeSql(sql);
        return hashMaps.get(0).get("basePath");
    }

}
