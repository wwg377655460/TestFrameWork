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

    private String urlString;

    private int defaultPort;

    private String file;

    private String host;

    private String path;

    private JSONObject jsonObject = null;

    private int port;

    public ExceptValue getJson() {
        JSONObject jsonObject = JSON.parseObject(this.content);
        this.setJsonObject(jsonObject);
        ExceptValue exceptValue = new ExceptValue(this, jsonObject);
        return exceptValue;
    }


    private String protocol;

    private String query;

    private String ref;

    private String userInfo;

    private String contentEncoding;

    private String content;

    private String contentType;

    private int code;

    private String message;

    private String method;

    private int connectTimeout;

    private int readTimeout;

    public Vector<String> contentCollection;

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

    protected void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public void print_content() {
        System.out.print(content);
    }

    public void print_content_type() {
        System.out.print(this.contentType);
    }

    public void print_code() {
        System.out.print(this.code);
    }


    protected void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    protected void setDefaultPort(int defaultPort) {
        this.defaultPort = defaultPort;
    }

    protected void setFile(String file) {
        this.file = file;
    }

    protected void setHost(String host) {
        this.host = host;
    }

    protected void setPath(String path) {
        this.path = path;
    }

    protected void setPort(int port) {
        this.port = port;
    }

    protected void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    protected void setQuery(String query) {
        this.query = query;
    }

    protected void setRef(String ref) {
        this.ref = ref;
    }

    protected void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    protected void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    protected void setContent(String content) {
        this.content = content;
    }

    protected void setContentType(String contentType) {
        this.contentType = contentType;
    }

    protected void setCode(int code) {
        this.code = code;
    }

    protected void setMessage(String message) {
        this.message = message;
    }

    protected void setMethod(String method) {
        this.method = method;
    }

    protected void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    protected void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    protected void setContentCollection(Vector<String> contentCollection) {
        this.contentCollection = contentCollection;
    }
}