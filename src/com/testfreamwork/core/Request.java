package com.testfreamwork.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * HTTP请求对象
 *
 * @author OUWCH
 */
public class Request {
    private String defaultContentEncoding;

    public Request() {
        this.defaultContentEncoding = Charset.defaultCharset().name();
    }

    private String method;


    private Map<String, String> propertys = new HashMap<>();


    private Map<String, String> parameters = new HashMap<>();

    private String json = "";

    private String urlString = "";


    /**
     * 发送HTTP请求
     *
     * @return 响映对象
     * @throws IOException
     */
    public Response send_param() {
        HttpURLConnection urlConnection = null;
        try {
            if (method.equalsIgnoreCase("GET") && parameters != null) {
                StringBuffer param = new StringBuffer();
                int i = 0;
                for (String key : parameters.keySet()) {
                    if (i == 0)
                        param.append("?");
                    else
                        param.append("&");
                    param.append(key).append("=").append(parameters.get(key));
                    i++;
                }
                urlString += param;
            }
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod(method);
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setUseCaches(false);

            if (propertys != null)
                for (String key : propertys.keySet()) {
                    urlConnection.addRequestProperty(key, propertys.get(key));
                }

            if ((method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("DELETE")) && parameters != null) {
                StringBuffer param = new StringBuffer();
                for (String key : parameters.keySet()) {
                    param.append("&");
                    param.append(key).append("=").append(parameters.get(key));
                }
                urlConnection.getOutputStream().write(param.toString().getBytes());
                urlConnection.getOutputStream().flush();
                urlConnection.getOutputStream().close();
            }

            return this.makeContent(urlString, urlConnection);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public Response send_json() {
        HttpURLConnection urlConnection = null;
        try {
            if (method.equalsIgnoreCase("GET") && json != null && !json.equals("")) {
                return null;
            }
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod(method);
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setUseCaches(false);

            if (propertys != null)
                for (String key : propertys.keySet()) {
                    urlConnection.addRequestProperty(key, propertys.get(key));
                }

            if ((method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("DELETE")) && parameters != null) {
                String param = json;
                urlConnection.getOutputStream().write(param.getBytes());
                urlConnection.getOutputStream().flush();
                urlConnection.getOutputStream().close();
            }

            return this.makeContent(urlString, urlConnection);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 得到响应对象
     *
     * @param urlConnection
     * @return 响应对象
     * @throws IOException
     */
    private Response makeContent(String urlString,
                                 HttpURLConnection urlConnection) throws IOException {
        Response Responseer = new Response();
        String ecod = this.defaultContentEncoding;
        InputStream in = null;
        try {
            if (urlConnection.getResponseCode() == 200) {
                in = urlConnection.getInputStream();
            } else {
                in = urlConnection.getErrorStream();
            }
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(in));
            Responseer.contentCollection = new Vector<String>();
            StringBuffer temp = new StringBuffer();
            String line = bufferedReader.readLine();
            while (line != null) {
                Responseer.contentCollection.add(line);
                temp.append(line).append("\r\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

            ecod = urlConnection.getContentEncoding();
            if (ecod == null)
                ecod = this.defaultContentEncoding;

            Responseer.setUrlString(urlString);

            Responseer.setDefaultPort(urlConnection.getURL().getDefaultPort());
            Responseer.setFile(urlConnection.getURL().getFile());
            Responseer.setHost(urlConnection.getURL().getHost());
            Responseer.setPath(urlConnection.getURL().getPath());
            Responseer.setPort(urlConnection.getURL().getPort());
            Responseer.setProtocol(urlConnection.getURL().getProtocol());
            Responseer.setQuery(urlConnection.getURL().getQuery());
            Responseer.setRef(urlConnection.getURL().getRef());
            Responseer.setUserInfo(urlConnection.getURL().getUserInfo());

            Responseer.setContent(StrUtil.decode(new String(temp.toString().getBytes(), ecod)));
            Responseer.setContentEncoding(ecod);
            Responseer.setCode(urlConnection.getResponseCode());
            Responseer.setMessage(urlConnection.getResponseMessage());
            Responseer.setContentType(urlConnection.getContentType());
            Responseer.setMethod(urlConnection.getRequestMethod());
            Responseer.setConnectTimeout(urlConnection.getConnectTimeout());
            Responseer.setReadTimeout(urlConnection.getReadTimeout());

            return Responseer;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }
    }

    /**
     * 默认的响应字符集
     */
    public Object getDefaultContentEncoding() {
        return this.defaultContentEncoding;
    }

    /**
     * 设置默认的响应字符集
     */
    public Request setDefaultContentEncoding(String defaultContentEncoding) {
        this.defaultContentEncoding = defaultContentEncoding;
        return this;
    }


    /**
     * 设置默认的传输类型
     */
    public Request setContentsType(String ContentsType) {
        propertys.put("Content-Type", ContentsType);
        return this;
    }

    /**
     * 设置Cookie
     */
    public Request setCookie(String Cookie) {
        propertys.put("Set-Cookie", Cookie);
        return this;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public Request setAccept(String accept) {
        propertys.put("Accept", accept);
        return this;
    }

    public String getUrlString() {
        return urlString;
    }

    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
 