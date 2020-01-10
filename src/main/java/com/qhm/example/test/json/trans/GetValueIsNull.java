package com.qhm.example.test.json.trans;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class GetValueIsNull {

    public static void main(String[] args) {
        String jsonString = "{\"title\":null,\"name\":\"dfs\"}";
        String s1 = JSONObject.toJSONString(jsonString, SerializerFeature.WriteMapNullValue);
        JSONObject json = JSONObject.parseObject(s1);
        //String s = JSONObject.toJSONString(json, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
       // System.out.println(s);

    }
}
