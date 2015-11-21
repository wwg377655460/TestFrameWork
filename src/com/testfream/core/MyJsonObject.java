package com.testfream.core;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wsdevotion on 15/11/21.
 */
public class MyJsonObject {

    JSONObject jsonObject = new JSONObject();
    public void put(String key, Object val, String name){
        jsonObject.put(key, val);
        TestFream.getMap().put(key, name);
    }

    @Override
    public String toString() {
        String str = jsonObject.toString();
        TestFream.setRequestJson(str);
        return str;
    }
}
