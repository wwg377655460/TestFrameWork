package com.testfreamwork.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wsdevotion on 15/11/21.
 */
public class Estimate {

    Response response = null;
    JSONObject jsonObject = null;
    JSONObject saveAllJsonObject = null;
    JSONArray jsonArray = null;

    public Estimate(Response response, JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        this.response = response;
    }

    public Estimate equalInt(String name, Integer val) {
        Integer v = null;
        try {
            v = jsonObject.getInteger(name);
        } catch (Exception ignored) {

        }
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalInt", val + "", s, v + "");
        }

        return this;
    }

    public Estimate equalInt(String name, Integer val, String meg) {
        Integer v = null;
        try {
            v = jsonObject.getInteger(name);
        } catch (Exception ignored) {

        }
        TestFreamWork.getMap().put(name, meg);
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalInt", val + "", s, v + "");
        }

        return this;
    }

    public Estimate equalDouble(String name, Double val) {
        Double v = null;
        try {
            v = jsonObject.getDouble(name);
        } catch (Exception ignored) {

        }
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalDouble", val + "", s, v + "");
        }

        return this;
    }

    public Estimate equalDouble(String name, Double val, String meg) {
        Double v = null;
        try {
            v = jsonObject.getDouble(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TestFreamWork.getMap().put(name, meg);
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalDouble", val + "", s, v + "");
        }

        return this;
    }

    public Estimate equalStr(String name, String val) {
        String v = null;
        try {
            v = jsonObject.getString(name);
        } catch (Exception ignored) {

        }
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalStr", val + "", s, v + "");
        }

        return this;
    }

    public Estimate equalStr(String name, String val, String meg) {
        String v = null;
        try {
            v = jsonObject.getString(name);
        } catch (Exception ignored) {

        }
        TestFreamWork.getMap().put(name, meg);
        enterData(name, val);
        if (v == null || !v.equals(val)) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalStr", val + "", s, v + "");
        }

        return this;
    }

    public Estimate isInt(String name) {
        Object v = null;
        try {
            v = jsonObject.get(name);
        } catch (Exception ignored) {

        }
        enterData(name, "Integer.class");
        try {
            Integer.parseInt(v == null ? "" : v.toString());
        } catch (Exception e) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("isInt", "Integer", s, "String");
        }


        return this;
    }

    public Estimate isInt(String name, String meg) {
        Object v = null;
        try {
            v = jsonObject.get(name);
        } catch (Exception ignored) {

        }
        TestFreamWork.getMap().put(name, meg);
        enterData(name, "Integer.class");
        try {
            Integer.parseInt(v == null ? "" : v.toString());
        } catch (Exception e) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("isInt", "Integer", s, "String");

        }


        return this;
    }

    public Estimate isDouble(String name) throws Exception {
        Object v = null;
        try {
            v = jsonObject.get(name);
        } catch (Exception ignored) {

        }
        enterData(name, "Double.class");
        try {
            Double.parseDouble(v == null ? "" : v.toString());
        } catch (Exception e) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("isDouble", "Double", s, "String");
        }
        return this;
    }

    public Estimate isDouble(String name, String meg) throws Exception {
        Object v = null;
        try {
            v = jsonObject.get(name);
        } catch (Exception ignored) {

        }
        TestFreamWork.getMap().put(name, meg);
        enterData(name, "Double.class");
        try {
            Double.parseDouble(v == null ? "" : v.toString());
        } catch (Exception e) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("isDouble", "Double", s, "String");
            e.printStackTrace();
        }
        return this;
    }

    public Estimate isRegex(String name, String regex) {
        String v = null;
        try {
            v = jsonObject.getString(name);
        } catch (Exception e) {
            v = "";
        }
        enterData(name, "正则:" + regex);

        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String s = ste.getFileName() + ": Line " + ste.getLineNumber();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(v);
        if (!matcher.matches()) {
            System.out.println("---------------------------------------");
            System.out.println(s);
            System.out.println("Actual => " + v);
            System.out.println("正则表达式匹配错误");
            System.out.println("---------------------------------------");
        }

        return this;

    }

    public Estimate isRegex(String name, String regex, String meg) {
        String v = null;
        try {
            v = jsonObject.getString(name);
        } catch (Exception e) {
            v = "";
        }
        TestFreamWork.getMap().put(name, meg);
        enterData(name, "正则:" + regex);

        StackTraceElement ste = new Throwable().getStackTrace()[1];
        String s = ste.getFileName() + ": Line " + ste.getLineNumber();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(v);
        if (!matcher.matches()) {
            System.out.println("---------------------------------------");
            System.out.println(s);
            System.out.println("Actual => " + v);
            System.out.println("正则表达式匹配错误");
            System.out.println("---------------------------------------");
        }

        return this;

    }


    public Estimate equalCode(int code) {
        TestFreamWork.setCode(code);
        if (response.getCode() != code) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            this.printMes("equalCode", code + "", s, response.getCode() + "");
        }

        return this;
    }

    public Estimate getJsonArray(String except) {
        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray(except);
        } catch (Exception ignored) {

        }
        TestFreamWork.setArraydata(except);
        if (jsonArray == null) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            printMes("getJsonArray", "Array", s, "NULL");
        } else {
            this.jsonArray = jsonArray;

        }

        return this;
    }

    public Estimate isArrayNum(int num) {
        TestFreamWork.setArraynum(num);
        if (jsonArray == null) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            printMes("isArrayNum", num + "", s, "NULL");
        } else {
            if (jsonArray.size() != num) {
                StackTraceElement ste = new Throwable().getStackTrace()[1];
                String s = ste.getFileName() + ": Line " + ste.getLineNumber();
                printMes("isArrayNum", num + "", s, jsonArray.size() + "");
            }
        }

        return this;

    }

    public Estimate isArrayKey() {
        if (jsonArray == null) {
            TestFreamWork.setIsenterArray(1);//json进入数组
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String s = ste.getFileName() + ": Line " + ste.getLineNumber();
            printMes("isArrayKey", ">=1", s, "NULL");
            return this;
        } else {
            if (jsonArray.size() == 0) {
                StackTraceElement ste = new Throwable().getStackTrace()[1];
                String s = ste.getFileName() + ": Line " + ste.getLineNumber();
                printMes("isArrayKey", ">=1", s, jsonArray.size() + "");
                return this;
            } else {
                TestFreamWork.setIsenterArray(1);//json进入数组
                this.saveAllJsonObject = this.jsonObject;
                this.jsonObject = jsonArray.getJSONObject(0);
                return this;
            }
        }
    }

    private static void enterData(String key, Object val) {
        if (TestFreamWork.getIsenterArray() == 0) {
            TestFreamWork.getResponseJson().put(key, val);
        } else {
            TestFreamWork.getResponseArray().put(key, val);
        }
    }

    public Estimate isArrayEnd() {
        String arraydata = TestFreamWork.getArraydata();
        JSONObject arrayjson = TestFreamWork.getResponseArray();
        JSONArray array = new JSONArray();
        if (TestFreamWork.getArraynum() != -1) {
            for (int i = 0; i < 1; i++) {
                array.add(i, arrayjson.toString());
            }
        } else {
            array.add(arrayjson.toString());
            array.add("{...}");
        }

        this.jsonObject = this.saveAllJsonObject;
        TestFreamWork.getResponseJson().put(arraydata, array);
        TestFreamWork.setArraydata("");
        TestFreamWork.getResponseArray().clear();
        TestFreamWork.setIsenterArray(0);

        return this;
    }

    public Estimate printJsonObject() {
        System.out.println(this.jsonObject.toString());
        return this;
    }

    private void printMes(String method, String except, String meg, String actual) {

        System.out.println("---------------------------------------");
        System.out.println(meg);
        System.out.println("error => " + method);
        System.out.println("Except => " + except);
        System.out.println("Actual => " + actual);
        System.out.println("---------------------------------------");
    }

    private static String getLineInfo() {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + ": Line " + ste.getLineNumber();
    }
}
