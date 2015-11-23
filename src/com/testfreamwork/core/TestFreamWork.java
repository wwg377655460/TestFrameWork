package com.testfreamwork.core;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by wsdevotion on 15/11/21.
 */
public class TestFreamWork {

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
        Request request = new Request();
        TestFreamWork.method = "get";
        TestFreamWork.name = name;
        TestFreamWork.url = url;
        request.setMethod("GET");
        request.setUrlString(baseUrl + url);
        return handle.handle(request);
    }

    public static Response post(String url, String name, Handle handle) {
        Request request = new Request();
        TestFreamWork.method = "post";
        TestFreamWork.name = name;
        TestFreamWork.url = url;
        request.setMethod("POST");
        request.setUrlString(baseUrl + url);
        return handle.handle(request);
    }

    public static Response put(String url, String name, Handle handle) {
        Request request = new Request();
        TestFreamWork.method = "put";
        TestFreamWork.name = name;
        TestFreamWork.url = url;
        request.setMethod("PUT");
        request.setUrlString(baseUrl + url);
        return handle.handle(request);
    }

    public static Response delete(String url, String name, Handle handle) {
        Request request = new Request();
        TestFreamWork.method = "delete";
        TestFreamWork.name = name;
        TestFreamWork.url = url;
        request.setMethod("DELETE");
        request.setUrlString(baseUrl + url);
        return handle.handle(request);
    }

    public static void init(String base_url, String port, String appRoute) {
        if (port == null || port.equals("")) {
            TestFreamWork.baseUrl = base_url + "/" + appRoute;
        } else {
            TestFreamWork.baseUrl = base_url + ":" + port + "/" + appRoute;
        }

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static void setMap(Map<String, String> map) {
        TestFreamWork.map = map;
    }

    public static String getRequestJson() {
        return requestJson;
    }

    public static void setRequestJson(String requestJson) {
        TestFreamWork.requestJson = requestJson;
    }

    public static JSONObject getResponseJson() {
        return responseJson;
    }

    public static void setResponseJson(JSONObject responseJson) {
        TestFreamWork.responseJson = responseJson;
    }

    public static int getArraynum() {
        return arraynum;
    }

    public static void setArraynum(int arraynum) {
        TestFreamWork.arraynum = arraynum;
    }

    public static String getArraydata() {
        return arraydata;
    }

    public static void setArraydata(String arraydata) {
        TestFreamWork.arraydata = arraydata;
    }


    public static int getIsenterArray() {
        return isenterArray;
    }

    public static void setIsenterArray(int isenterArray) {
        TestFreamWork.isenterArray = isenterArray;
    }

    public static JSONObject getResponseArray() {
        return responseArray;
    }

    public static void setResponseArray(JSONObject responseArray) {
        TestFreamWork.responseArray = responseArray;
    }

    public static int getCode() {
        return code;
    }

    public static void setCode(int code) {
        TestFreamWork.code = code;
    }

    public static void initFile() {
        if (TestFreamWork.isCreateFileDoc) {
            CreateinitFile.initFile(baseUrl);
        }
    }

    public static void isCreateDoc(Boolean isCreateDoc) {
        if (!isCreateDoc) {
            TestFreamWork.isCreateFileDoc = false;
        }
    }

    public static void createDoc() {
//        System.out.print(baseUrl + url);
//        System.out.print(name);
//        System.out.print(requestJson);
//        System.out.print(map);

        if (TestFreamWork.isCreateFileDoc) {
            CreateFile.createDoc(url, method, name, map, code, responseJson.toJSONString().replace("\\", ""), requestJson);
        }

    }

}
