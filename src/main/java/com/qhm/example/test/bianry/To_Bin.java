package com.qhm.example.test.bianry;

import com.qhm.example.test.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class To_Bin {

    public static void main(String[] args) {
        /*String s = "aaaaa";
        String[] split = s.split("==");
        for(String str:split){
            System.out.println(str);
            log.info("Setting resource leak detector level to {}",s);
        }*/


        String s= "abc";
        s = s + 1 + 2;
        s = s +(2+2);
        s.concat("1").concat("2");
        s.concat(""+ 2 + 2);
        //System.out.println(s);


        int k = 1024;
        int q = 256+1024;
       System.out.println(q & k);


       Map<String,Object> map = new HashMap<String, Object> ();
       map.put("aa",1);
       map.put("bb",2);
        Set<String> strings = map.keySet();


        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("IP地址：" + addr.getHostAddress() + "，主机名：" + addr.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        String days = DateUtil.getDays();
        System.out.println(days);
        System.out.println(1+"dasdasd");

        StringBuilder sb = new StringBuilder();
        sb.append("{" +
                "\"deviceType\":" );
        sb.append(1);
        sb.append(",\"deviceSn\":\"");
        sb.append(1234566666);
        sb.append("\",\"pageNum\":");
        sb.append(1);
        sb.append(",\"pageSize\":");
        sb.append(5);
        sb.append(",\"endTime\":");
        sb.append(new Date().getTime());
        sb.append(",\"startTime\":");
        sb.append(new Date().getTime()-15000);
        sb.append(
                "" +
                        "}");
       System.out.println(sb);

       String prefix = "thirdDock:driverFile:general:*";
       System.out.print(StringUtils.replace(prefix,"*","aaa"));


    }

    //十进制转换为2进制




}
