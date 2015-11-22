# 接口文档

`接口url：http://localhost/RestfulApi/index.php/`


## 邀请码

`get /Api/getplease`

#####请求示例
```

```
##### 响应示例

```
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
```


## 签到

`post /api/sign`
##### 请求体

参数名 | 描述
--- |---
name |姓名 
status |标识符 

#####请求示例
```
{
	"name":"wersdf123"
}
```
##### 响应示例

```
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
```


