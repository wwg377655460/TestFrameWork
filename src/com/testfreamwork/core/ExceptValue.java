package com.testfreamwork.core;

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

    public ExceptValue printJsonObject(){
        System.out.println(this.jsonObject.toString());
        return this;
    }

    public Estimate except(){
        return new Estimate(response, jsonObject);
    }
}
