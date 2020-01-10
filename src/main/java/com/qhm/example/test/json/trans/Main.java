package com.qhm.example.test.json.trans;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DustLive dustLive = new DustLive();


        /*Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        //System.out.println(time);
        //System.out.println(transToBoolean((byte)1));

        long time1 = new Date().getTime()/1000;
        System.out.println(time1);*/
        Long time = new Date().getTime()/1000;
        String apiSecret = "2221A1F341984A369A8AE5E90ADE2FB3";
        Map<String,Object> map = new HashMap<>();
        map.put("prjId",201007);
        map.put("devicdId","A6C0EDB660B1486E8EDBC864A5C2BD9B");
        map.put("frontArmLength",60);
        map.put("backArmLength",15.300000000000001);
        map.put("maxHeight",33.600000000000001);
        map.put("maxRange",0);
        map.put("maxWeight",5);
        map.put("maxMoment",null);
        map.put("ratedObliguity",0);
        map.put("multiple",2);
        map.put("minRange",0);
        map.put("armHeight",null);
        map.put("maxAngle",530);
        map.put("minAngle",-540);

        String a = "{\"prjId\":201007,\"devicdId\":\"A6C0EDB660B1486E8EDBC864A5C2BD9B\",\"frontArmLength\":60,\"backArmLength\":15.300000000000001,\"maxHeight\":33.600000000000001,\"maxRange\":0,\"maxWeight\":5,\"maxMoment\":null,\"ratedObliguity\":0,\"multiple\":2,\"minRange\":0,\"armHeight\":null,\"maxAngle\":530,\"minAngle\":-540}";
        String s1 = JSON.toJSONString(a);
        String body = JSON.toJSONString(map);
        //System.out.println(time);
       String s =  encryptMD5Encode(apiSecret + time + s1);
        //System.out.println(s);


        //精确两位有效数字
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        System.out.println(decimalFormat.format(1.2232323));

    }

    private static boolean transToBoolean(Byte byteValue){
        boolean b = false;
        if(byteValue != null){
            b = (byteValue != 0)? true : false;
        }
        return b;
    }

    public static String encryptMD5Encode(String originalString){
        if(StringUtils.isEmpty(originalString)) {
            return null;
        }else{
            return DigestUtils.md5Hex(originalString);
        }

    }


}
