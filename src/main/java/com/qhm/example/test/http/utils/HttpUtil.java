package com.qhm.example.test.http.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HttpUtil {

    /*//正式
    private static final String SUPPLY_KEY_ID = "a46e2dc4-acd7-468f-8688-935143f895dd";
    private static final String SUPPLY_KEY_SECRET = "pnyQ1UyDyrKcnStCw1Wk0PuxC9xdHqKX6wVE";
    private static final String PROJECT_KEY_ID = "bb3f3359-5712-4ea9-9eae-3a88d409e5ab";
    private static final String PROJRECT_KEY_SECRET = "291wHUAXEgFg9CpKQb6Keif4hM7hDBUrVhhw";*/

    //测试
    private static final String SUPPLY_KEY_ID = "e6fe9dd5-58af-11e8-857d-00163e32d704";
    private static final String SUPPLY_KEY_SECRET = "Ny35o694RgXURrNQ7hCBbI4wyearCWxx7H4n";
    private static final String PROJECT_KEY_ID = "1b0f28a4-a5a8-4ea8-ae1a-3b80d6e72397";
    private static final String PROJRECT_KEY_SECRET = "RMSRvZBhviBiWlddbXil5EqVQhkHJ0WJUbH7";

    public static void main(String[] args) {
        //String s = "{\"apiKey\":\"920319ffd11f419d924feb8adae6700a\",\"projectCode\":\"XM20160390\",\"engCode\":\"44030120161209001\",\"apiVersion\":\"1.0\"}";
        //strToMap(s);

        /*String time = getUnixTime();
        String randomStr = getRandomStr(10);
        System.out.println(randomStr);
        System.out.println(time);
        System.out.println(SUPPLY_KEY_ID+"_"+PROJECT_KEY_ID);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(randomStr)
                .append("_")
                .append(time)
                .append("_")
                .append(SUPPLY_KEY_SECRET)
                .append("_")
                .append(PROJRECT_KEY_SECRET);
        //System.out.println(stringBuilder.toString());
        String s = encryptSHA1Encode(stringBuilder.toString());
        System.out.println(s);*/
        //String str = encryptMD5Encode("010819050085");
        //String str1 = "5E46CE07-DD71-445D-B237-744C9160603C";
        //System.out.println(str1+str1.length());
       // System.out.println(str);

        /*List<Object> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("kk","ccc");
        list.add(map);
        String s = JSONObject.toJSONString(list);
        System.out.println(s);*/

        /*double angle=Math.random()*45;
        DecimalFormat df = new DecimalFormat( "0.00" );
        double dubAngle = Double.parseDouble(df.format(angle));
        Map<String, Double> stringDoubleMap = direction2Angle();

        System.out.println(stringDoubleMap.get("东北偏北"));*/

     //System.out.println(encryptMD5Encode("1578135"));

        /*System.out.println(towerAlarmToString(16777216));
        System.out.println(towerAlarmToString(16777216).length());
        System.out.println(towerAlarmToString(16777216).indexOf("1"));*/

        /*DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String format = decimalFormat.format(2.22154651);
        System.out.println(format);*/

        String s = "01111111111111";
        System.out.println(s.substring(1,s.length()));
    }


    public static String doPost(String url){
        String s = "{\"apiKey\":\"920319ffd11f419d924feb8adae6700a\",\"projectCode\":\"XM20160390\",\"engCode\":\"44030120161209001\",\"apiVersion\":\"1.0\"}";

        return null;
    }

    public static String getUnixTime(){
        String s = Long.toString(new Date().getTime()/1000);
        return s;
    }

    public static void strToMap(String s){
        Map map = JSONObject.parseObject(s, Map.class);
        System.out.println(map.get("apiKey"));
    }

    /**
     * @description: 调用SHA1加密
     * @author: qhm
     * @Version: 1.0
     */
    public static String encryptSHA1Encode(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }else{
            return DigestUtils.sha1Hex(str);
        }
    }

    public static String encryptMD5Encode(String str){
        if(StringUtils.isEmpty(str)){
            return null;
        }else{
            String s = DigestUtils.md5Hex(str).toUpperCase();
            StringBuilder strBuf = new StringBuilder(s);
            strBuf.insert(8,'-').insert(13,'-').insert(18,'-').insert(23,'-');

            return strBuf.toString();
        }
    }

    /**
     * @description: 生成指定长度随机字符串
     * @author: qhm
     * @date:
     * @Version: 1.0
     */
    public static String getRandomStr(int length){
        String base="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int randomNum;
        char randomChar;
        Random random = new Random();
        // StringBuffer类型的可以append增加字符
        StringBuffer str = new StringBuffer();

        for (int i = 0; i < length; i++) {
            // 可生成[0,n)之间的整数，获得随机位置
            randomNum = random.nextInt(base.length());
            // 获得随机位置对应的字符
            randomChar = base.charAt(randomNum);
            // 组成一个随机字符串
            str.append(randomChar);
        }
        return str.toString();
    }

    /**
     *
     * @return
     */
    public static Map<String,Double> direction2Angle(){
        Map<String,Double> map = new HashMap<>();
        double angle=Math.random()*45;
        DecimalFormat df = new DecimalFormat( "0.00" );
        double dubAngle = Double.parseDouble(df.format(angle));
        map.put("正北",0d);
        map.put("东北偏北",0+dubAngle);
        map.put("东北偏东",90-dubAngle);
        map.put("正东",90d);
        map.put("东南偏东",90+dubAngle);
        map.put("东南偏南",180-dubAngle);
        map.put("正南",180d);
        map.put("西南偏南",180+dubAngle);
        map.put("西南偏西",270-dubAngle);
        map.put("正西",270d);
        map.put("西北偏西",270+dubAngle);
        map.put("西北偏北",360-dubAngle);
        return map;
    }

    /**
     * @Description: 塔机预警码/报警码转换为二进制 <br/>
     * @Params: i:报警码/预警码 ; length:转换后的字符串长度
     * @Author:  qhm    <br/>
     * @Date: 2019/8/29 9:15 <br/>
     * @Version: 1.0 <br/>
     */
    public static StringBuilder towerAlarmToString(Integer i){
        if(i !=null) {
            if(i != 0){
                String s = Integer.toBinaryString(i);
                StringBuilder stringBuilder = new StringBuilder(s);
                StringBuilder reverse = stringBuilder.reverse();
                return reverse;
            }else{
                return new StringBuilder();
            }
        }else{
            return null;
        }
    }


}
