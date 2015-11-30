package com.testframework.core;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wsdevotion on 15/11/21.
 */
public class TestFrameWork {

    private static String url = "";
    private static String baseUrl = "";
    private static JSONObject responseJson = new JSONObject();
    private static int code = 200;
    private static int arraynum = -1;
    private static int isenterArray = 0;//当前生成文档是否进入数组
    private static JSONObject responseArray = new JSONObject();
    private static String arraydata = ""; //json数组根节点数据
    private static String method = "";
    private static String name = "";
    private static String requestJson = "";
    private static Boolean isCreateFileDoc = true;
    private static Map<String, String> map = new HashMap<>();

    @Test
    public static Response get(String url, String name, Handle handle) {
        Request request = setInitMes(url, "GET", name);
        return handle.handle(request);
    }

    public static Response post(String url, String name, Handle handle) {
        Request request = setInitMes(url, "POST", name);
        return handle.handle(request);
    }

    public static Response put(String url, String name, Handle handle) {
        Request request = setInitMes(url, "PUT", name);
        return handle.handle(request);
    }

    public static Response delete(String url, String name, Handle handle) {
        Request request = setInitMes(url, "DELETE", name);
        return handle.handle(request);
    }

    public static void init(String base_url, String port, String appRoute) {
        if (port == null || port.equals("")) {
            TestFrameWork.baseUrl = base_url + "/" + appRoute;
        } else {
            TestFrameWork.baseUrl = base_url + ":" + port + "/" + appRoute;
        }

    }

    public static Request setInitMes(String url, String method, String name){
        Request request = new Request();
        TestFrameWork.method = method;
        TestFrameWork.name = name;
        TestFrameWork.url = url;
        request.setMethod(method);
        request.setUrlString(baseUrl + url);
        return request;
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static void setMap(Map<String, String> map) {
        TestFrameWork.map = map;
    }

    public static String getRequestJson() {
        return requestJson;
    }

    public static void setRequestJson(String requestJson) {
        TestFrameWork.requestJson = requestJson;
    }

    public static JSONObject getResponseJson() {
        return responseJson;
    }

    public static void setResponseJson(JSONObject responseJson) {
        TestFrameWork.responseJson = responseJson;
    }

    public static int getArraynum() {
        return arraynum;
    }

    public static void setArraynum(int arraynum) {
        TestFrameWork.arraynum = arraynum;
    }

    public static String getArraydata() {
        return arraydata;
    }

    public static void setArraydata(String arraydata) {
        TestFrameWork.arraydata = arraydata;
    }


    public static int getIsenterArray() {
        return isenterArray;
    }

    public static void setIsenterArray(int isenterArray) {
        TestFrameWork.isenterArray = isenterArray;
    }

    public static JSONObject getResponseArray() {
        return responseArray;
    }

    public static void setResponseArray(JSONObject responseArray) {
        TestFrameWork.responseArray = responseArray;
    }

    public static int getCode() {
        return code;
    }

    public static void setCode(int code) {
        TestFrameWork.code = code;
    }

    public static void initFile() {
        if (TestFrameWork.isCreateFileDoc) {
            CreateinitFile.initFile(baseUrl);
        }
    }

    public static void isCreateDoc(Boolean isCreateDoc) {
        if (!isCreateDoc) {
            TestFrameWork.isCreateFileDoc = false;
        }
    }

    public static void createDoc() {

        if (TestFrameWork.isCreateFileDoc) {
            CreateFile.createDoc(url, method, name, map, code, responseJson.toJSONString().replace("\\", ""), requestJson);
        }

    }

}
