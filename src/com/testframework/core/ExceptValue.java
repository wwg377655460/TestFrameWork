package com.testframework.core;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by wsdevotion on 15/11/23.
 */
public class ExceptValue {

    private Response response;
    private JSONObject jsonObject;

    public ExceptValue(Response response, JSONObject jsonObject) {
        this.response = response;
        this.jsonObject = jsonObject;
    }

    /*
    打印json对象
     */
    public ExceptValue printJsonObject(){
        System.out.println(this.jsonObject.toString());
        return this;
    }

    /**
     * 返回值校验
     * @return 返回Estimate对象
     */
    public Estimate except(){
        return new Estimate(response, jsonObject);
    }
}
