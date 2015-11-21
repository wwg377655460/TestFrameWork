# TestFreamWork
一个接口测试框架，对json数据和restful风格API有很好的支持，同时支持根据测试代码生成md格式的接口文档，提高了效率
> 使用了Java8 lambda表达式，使用方式
```
public static void main(String [] args){
        post("http://localhost/RestfulApi/index.php/api/sign", "你好", (request -> {
            MyJsonObject myJsonObject = new MyJsonObject();
            myJsonObject.put("name", "wer123", "姓名");
            request.setJson(myJsonObject.toString());
            return request.send_json();
        })).print_content();
        createDoc();
    }
```

> 可以使用get, post, put, delete方式传输数据,可以进行返回值校验，同时使用createDoc()方法可以根据
> 测试代码的信息生成md格式接口文档，比较方便
