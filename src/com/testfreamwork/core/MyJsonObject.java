package com.testfreamwork.core;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wsdevotion on 15/11/21.
 */
public class MyJsonObject {

    JSONObject jsonObject = new JSONObject();
    public void put(String key, Object val, String name){
        jsonObject.put(key, val);
        TestFreamWork.getMap().put(key, name);
    }

    @Override
    public String toString() {
        String str = jsonObject.toString();
        TestFreamWork.setRequestJson(str);
        return str;
    }
}
