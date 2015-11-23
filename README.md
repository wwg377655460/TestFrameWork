# TestFreamWork

###TestFreamWork是Java编写的测试框架
>特点:
>1. 使用了Java8 lambda表达式
>2. 使用get, post, put, delete方式传输数据, 返回值校验，同时可以根据测试数据生成相应的md格式文档
>
## Quickly Start
> 导入相应的jar包 [TestFreamWork](https://github.com/wwg377655460/TestFreamWork/raw/master/out/artifacts/TestFreamWork/TestFreamWork.jar)和依赖包 FastJson.jar
> 导入成功就可以运行了
> 静态导入文件
```
import static com.testfreamwork.core.TestFreamWork.*;
```
> 发送一个post请求
```
public static void main(String [] args){
        post("http://localhost/RestfulApi/index.php/api/sign", "登录", (request -> {
            MyJsonObject myJsonObject = new MyJsonObject();
            myJsonObject.put("name", "wer123", "姓名");
            request.setJson(myJsonObject.toString());
            return request.send_json();
        })).print_content();
    }
```
> post函数第一个参数表示要发送的地址，第二个参数表示API接口的作用，第三个参数发送请求
> 发送请求时我们可以使用MyJsonObject对象传入我们的信息，它继承了JsonObject对象，使用request.setJson()方法设置json字符串，用request.send_json()方法表示传送的信息是jsonges，它返回一个Response对象，我们打印它的返回值
> 如果我们在函数后增加一个createDoc()方法，它会根据测试代码的内容生成md格式的接口文档



```
## 登录

`post http://localhost/RestfulApi/index.php/api/sign`
##### 请求体

参数名 | 描述
--- |---
name |姓名 

#####请求示例
\```
{
	"name":"wer123"
}
\```
##### 响应示例

\```
200 OK
{
	
}
\```
```

> 反斜杠是为了方便表示加的，程序不会生成
###说明文档
> 传输方式:get post put delete



```
get("http://localhost/RestfulApi/index.php/api/sign", "登录", (request -> {
           request.send_param();
        })).print_content();
    }

post("http://localhost/RestfulApi/index.php/api/sign", "登录", (request -> {
			request.send_json();
           //request.send_param();
        })).print_content();
    }

put("http://localhost/RestfulApi/index.php/api/sign", "登录", (request -> {
           request.send_json();
           //request.send_param();
        })).print_content();
    }

delete("http://localhost/RestfulApi/index.php/api/sign", "登录", (request -> {
           request.send_json();
           //request.send_param();
        })).print_content();
    }
```



> 使用MyJsonObject或JsonObject封装数据,MyJsonObject的put()函数可以传输参数的解释，其他的方法都相同 
####request

```
MyJsonObject myJsonObject = new MyJsonObject();
myJsonObject.put("name", "wer123", "姓名");

JsonObject jsonObject = new JsonObject();
jsonObject.put("name", "wer123", "姓名");
```
> 如果使用了json数据就要使用request.setJson()方法传入json字符串，用request.send_json()发送请求  
> 如果要用一般的方法发送请求，需要把对象封装在Map对象里，用request.setParameters()方法传入map对象，用request.send_param()方法发送  



```
Map<String, String> map = new HashMap<String, String>();
map.put("name", "wer123");
map.put("phone", "121");
request.setParameters(map);
return request.send_param();
```
> request对象提供了一些方法



```
request.setAccept();
request.setContentsType();
request.setCookie();
request.setDefaultContentEncoding();
```
> get post put delete 方法返回Response对象


```
get("http://localhost/RestfulApi/index.php/api/sign", "登录", (request -> {
            return request.send_param();
        })).print_content();

print_content()   //打印返回内容
print_code()      //打印状态码
print_content_type()   //答应返回值类型
```
  
####对返回数据进行校验
> 对返回值校验只支持Json格式的数据


```
get("/api/getplease", "邀请码", (request -> {
            return request.send_param();
        })).getJson().except().equalStr("status", "1");
```
>使用getJson()和except()可以进入校验   
>**校验的方法**

```
printJsonObject()  //打印json字符串的值
equalInt()
equalDouble()
equalStr()   //参数第一个为校验值的name，第二个参数为期望值，第三个为可选参数为name的说明，可以在接口文档里生成
isInt()
isDouble()  //第一个参数为期望值，第二个为可选参数为name的说明，可以在接口文档里生成
isRegex()   //参数第一个为校验值的name，第二个参数为正则，第三个为可选参数为name的说明，可以在接口文档里生成
```
>**错误信息**   
>如果真实值和期望值不符将会报错，但不影响下面的值的检验，接口文档只会和校验代码有关，和接口的正确性没有关系

```
---------------------------------------
testfream.java: Line 119
Actual => 123
正则表达式匹配错误
---------------------------------------
```
> 错误信息会显示错误的行数，期望值和实际值  
> 对Json数组的检验  
> 使用getJsonArray("data").isArrayKey()开始进行数组校验，也可以用  getJsonArray("data").isArrayNum(2).isArrayKey()进行数组个数的判断，它会影响接口文档的生成，data表示json的键  


```
{"status":1, "data":[...]}
```
> > isArrayKey()后面与对json字符串的校验相同(相当于现在的json值就是数值内第一个json字符串)，但一定要用isArrayEnd()方法结尾，isArrayEnd()方法让当前的字符串又变为以前的Json对象，但是只能获取上一层的json对象(数组内部的数组执行isArrayKey()方法后最外层的json对象会丢失),如果要校验多个json数组检验获取返回的Response对象，进行多次校验  
###与Junit的结合
> 使用Junit框架我们可以在测试方法之前初始化一些信息


```
 @BeforeClass
    public static void setup(){
        init("http://localhost", "", "RestfulApi/index.php/");
        initFile();
    }
```
> init()方法可以初始化url信息(第一个参数是ip地址，第二个参数是端口号，第三个参数是项目根目录地址)，现在我们在传送信息时url只需要加上后面的地址就行了   


```
get("/api/sign", "登录", (request -> {
            return request.send_param();
        })).print_content();
```
> initFile()方法可以生成接口文档的基本信息   
> ###功能完善
> 1. 可以控制文档的生成
> isCreateDoc(false);
> 在执行之前调用isCreateDoc(false)方法将不会生成文档，使用Junit框架时可以放在@BeforeClass注释的函数initFile()方法前，不让生成文档，在测试完成后将false改成true就可以开始生成文档  
> 2. 实现了对一些敏感参数的封装
> 3. 完成了对返回状态码不等于200情况的处理，用户可以对其他状态码返回的数据进行校验
> 
#####下面给出一个Demo

```
	@BeforeClass
    public static void setup(){
        init("http://localhost", "", "RestfulApi/index.php/");
        initFile();
    }

	@Test
    public void sign(){
        post("/api/sign", "签到", (request -> {
            MyJsonObject myJsonObject = new MyJsonObject();
            myJsonObject.put("name", "wersdf123", "姓名");
            request.setJson(myJsonObject.toString());
            Response response = request.send_json();
            return response;
        })).getJson().except().equalStr("status", "1", "标识符").getJsonArray("data").isArrayNum(2).isArrayKey().equalStr("name", "wer123").equalInt("position", 1).isArrayEnd();

	createDoc();
	}


	@Test
    public void please(){
        get("/Api/getplease", "邀请码", (request -> {
            Response response = request.send_param();
            return response;
        })).getJson().except().equalStr("status", "1").
            getJsonArray("data").isArrayKey().isInt("id").isRegex("num", "[0-9a-zA-Z|-]").isArrayEnd();


        createDoc();

    }
```
> 执行测试方法，可以得到相应的错误提示来判断接口是否正确，同时会生成相应的接口文档   


```
# 接口文档

`接口url：http://localhost/RestfulApi/index.php/`


## 邀请码

`get /Api/getplease`

#####请求示例
/```

/```
##### 响应示例

/```
200 OK
{
	"data":[
		"{
			"num":"正则:[
				0-9a-zA-Z|-
			]",
			"id":"Integer.class"
		}",
		"{
			...
		}"
	],
	"status":"1"
}
/```


## 签到

`post /api/sign`
##### 请求体

参数名 | 描述
--- |---
name |姓名 
status |标识符 

#####请求示例
/```
{
	"name":"wersdf123"
}
/```
##### 响应示例

/```
200 OK
{
	"data":[
		"{
			"name":"wer123",
			"position":1
		}"
	],
	"status":"1"
}
/```



```