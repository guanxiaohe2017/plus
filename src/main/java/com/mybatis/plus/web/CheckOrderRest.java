package com.mybatis.plus.web;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.mybatis.plus.blh.CheckOrderBlh;
import com.mybatis.plus.entity.order.CheckOrder;
import com.mybatis.plus.mapper.order.CheckOrderMapper;
import com.mybatis.plus.service.CheckOrderService;
import com.mybatis.plus.web.client.DemoFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@RestController
@RequestMapping("/checkOrder")
public class CheckOrderRest {
    @Resource
    CheckOrderMapper checkOrderMapper;

    @Resource
    CheckOrderService checkOrderService;

    @Resource
    DemoFeignClient demoFeignClient;

    @Resource
    CheckOrderBlh checkOrderBlh;


    @RequestMapping("plusTest")
    public String feignTest(){
        StringBuilder sb = new StringBuilder();
        sb.append("调用远程接口开始=================》   ");
        sb.append(demoFeignClient.testFeign());
        sb.append("    《=================调用远程接口结束");
        return sb.toString();
    }

    @GetMapping(value = "invokeSql")
    public String invokeSql(String sqlString){
        List<HashMap<String,String>> hashMaps = checkOrderService.invokeSql(sqlString);


        return hashMaps.toString();
    }

    @GetMapping(value = "download")
    public void download(String sqlString, HttpServletResponse response) throws IOException {
        List<HashMap<String,String>> hashMaps = checkOrderService.invokeSql(sqlString);
//        Map<String, Object> row1 = new LinkedHashMap<>();
//        row1.put("姓名", "张三");
//        row1.put("年龄", 23);
//        row1.put("成绩", 88.32);
//        row1.put("是否合格", true);
//        row1.put("考试日期", DateUtil.date());
//
//        Map<String, Object> row2 = new LinkedHashMap<>();
//        row2.put("姓名", "李四");
//        row2.put("年龄", 33);
//        row2.put("成绩", 59.50);
//        row2.put("是否合格", false);
//        row2.put("考试日期", DateUtil.date());

        ArrayList<Map<String, Object>> rows = (ArrayList) hashMaps;



        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
        //out为OutputStream，需要写出到的目标流

        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
            //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition","attachment;filename=test.xls");
        ServletOutputStream out=response.getOutputStream();

        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(out);

//        checkOrderBlh.backup2(response);
    }
//
//    public String backup() {
//        try {
//            Runtime rt = Runtime.getRuntime();
//
//            // 调用 调用mysql的安装目录的命令
////            String commcand = getMysqlPath()+"/bin/mysqldump -h localhost -u"+Global.getConfig("jdbc.username")+" -p"+Global.getConfig("jdbc.password")+" -R "+Global.getConfig("jdbc.databaseName");
//            String commcand = getMysqlPath() + "/bin/mysqldump -h localhost -u" + "root" + " -p" + "123" + " -R " + "test";
//            Process child = rt.exec(commcand);
//            // 设置导出编码为utf-8。这里必须是utf-8
//            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
//            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流
//
//            InputStreamReader xx = new InputStreamReader(in, "utf-8");
//            // 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码
//
//            String inStr;
//            StringBuffer sb = new StringBuffer("");
//            String outStr;
//            // 组合控制台输出信息字符串
//            BufferedReader br = new BufferedReader(xx);
//            while ((inStr = br.readLine()) != null) {
//                sb.append(inStr + "\r\n");
//            }
//            outStr = sb.toString();
////            //设置名字
//            String fileName = "back" + ".sql";
//
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
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//
//    }
//
//    //获取数据库安装路径
//    public String getMysqlPath(){
//        String sql = "select @@basedir as basePath from dual";
//        List<HashMap<String,String>> hashMaps = checkOrderService.invokeSql(sql);
//        return hashMaps.get(0).get("basePath");
//    }




















    @RequestMapping("list")
    public String list(String id){
        List<CheckOrder> checkOrders = new ArrayList<>();
//        checkOrderService.saveBatch(checkOrders);
        checkOrderService.listCheckOrders();
        return "success";
    }

    @RequestMapping("list2")
    public String list2(){
//        List<CheckOrder> checkOrders = checkOrderMapper.selectList(new QueryWrapper<>());
        List<CheckOrder> checkOrders = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            CheckOrder checkOrder = new CheckOrder();
            checkOrder.setCheckOrderId("id" + i);
            checkOrder.setCreator("creator" + i);
            checkOrder.setDeviceId("deviceId" + i);
            checkOrder.setDeviceName("deviceName" + i);
            checkOrder.setOrderNo("orderNo" + i);
            checkOrder.setStatus("1");
            checkOrder.setSthId("sthId" + i);
            checkOrder.setSthName("sthName" + i);
            checkOrders.add(checkOrder);
        }
        checkOrderService.saveBatch(checkOrders,10);
        return "success";
    }

}
