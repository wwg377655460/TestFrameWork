package com.testfreamwork.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Vector;

/**
 * HTTP响应对象
 *
 * @author OUWCH
 */
public class Response {

    String urlString;

    int defaultPort;

    String file;

    String host;

    String path;

    private JSONObject jsonObject = null;

    int port;

    public Response getJson(){
        JSONObject jsonObject = JSON.parseObject(this.content);
        this.setJsonObject(jsonObject);
        return this;
    }


    public Estimate except(){
        Estimate estimate = new Estimate(this, jsonObject);
        return estimate;
    }



    String protocol;

    String query;

    String ref;

    String userInfo;

    String contentEncoding;

    String content;

    String contentType;

    int code;

    String message;

    String method;

    int connectTimeout;

    int readTimeout;

    Vector<String> contentCollection;

    public String getContent() {
        return content;
    }

    public String getContentType() {
        return contentType;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Vector<String> getContentCollection() {
        return contentCollection;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public String getMethod() {
        return method;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public String getUrlString() {
        return urlString;
    }

    public int getDefaultPort() {
        return defaultPort;
    }

    public String getFile() {
        return file;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public int getPort() {
        return port;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getQuery() {
        return query;
    }

    public String getRef() {
        return ref;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public void print_content(){
        System.out.print(this.content);
    }

    public void print_content_type(){
        System.out.print(this.contentType);
    }

    public void print_code(){
        System.out.print(this.code);
    }
}