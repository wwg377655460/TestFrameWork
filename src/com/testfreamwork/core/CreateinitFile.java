package com.testfreamwork.core;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wsdevotion on 15/11/21.
 */
public class CreateinitFile {

    public static void initFile(String baseurl){
        try {
            FileWriter fw = new FileWriter("doc.md", true);
            fw.write("# ");
            fw.write("接口文档");
            fw.write("\n");
            fw.write("\n");
            fw.write("`" + "接口url：" + baseurl + "`" + "\n");
            fw.write("\n");
            fw.write("\n");


            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
