package com.testfream.core;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by wsdevotion on 15/11/21.
 */
public class CreateFile {

    public static void createDoc(String url, String method, String name, Map<String, String> map, int code, String responseJson, String requestJson) {
        try {
            FileWriter fw = new FileWriter("doc.md", true);
            fw.write("## ");
            fw.write(name);
            fw.write("\n");
            fw.write("\n");
            fw.write("`" + method + " " + url + "`" + "\n");
            if (map.size() > 0) {
                fw.write("##### 请求体\n");
                fw.write("\n");
                fw.write("参数名 | 描述\n");
                fw.write("--- |---\n");
                for (String key : map.keySet()) {
                    fw.write(key + " |" + map.get(key) + " \n");
                }
            }
            fw.write("\n");
            fw.write("#####请求示例\n");
            fw.write("```\n");
            fw.write(ForJsonStr.format(requestJson) + "\n");
            fw.write("```\n");
            fw.write("##### 响应示例\n");
            fw.write("\n");
            fw.write("```\n");
            fw.write(code + " OK\n");
            fw.write(ForJsonStr.format(responseJson.toString()) + "\n");
            fw.write("```\n");
            fw.write("\n");
            fw.write("\n");


            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
