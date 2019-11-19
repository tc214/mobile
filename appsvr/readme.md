## Spring Security demo

 
 
 
## 使用方式

使用了 h2 数据库内存模式  启动程序后`ddl.sql`和`dml.sql` 会自动初始化数据库。 数据库中会初始化一个用户`test` 密码为`123456` 的用户。 

## 接口说明

### 登录接口
api-name: 
```  
  http://localhost:8080/process
```

参数(form-data)：
username: ***,
password: ***  

resp:
```  
success:
{
    "httpStatus": 200,
    "data": {
        "userId": 1,
        "username": "test",
        "encodePassword": "[PROTECT]",
        "age": 18
    },
    "msg": "登录成功",
    "identifier": ""
}

failure:
{
    "httpStatus": 401,
    "data": null,
    "msg": "登录失败",
    "identifier": "-9999"
}
```  

### v1.1.201911191100 增加jwt token
```  
{
    "httpStatus": 200,
    "data": {
        "user": {
            "userId": 1,
            "username": "test",
            "encodePassword": "[PROTECT]",
            "age": 18
        },
        "token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJhbGwiLCJhdWQiOiJ0ZXN0Iiwicm9sZXMiOiJbXCJ1c2VyXCJdIiwiaXNzIjoiZmVsb3JkLmNuIiwiZXhwIjoiMjAxOS0xMi0xOSAxMTowNToyMyIsImlhdCI6IjIwMTktMTEtMTkgMTE6MDU6MjMiLCJqdGkiOiJjNzM5MjM3NC1lZWVjLTQ1M2UtODM3Mi01ZjJhOGFiMGE2ZmMifQ.LCE5eppJkq_TjLuKsnOXl3iQ4ec8_yDXuxdalCXv0PQ3_e1aQD7lWkUvK7F-uOPJwOvFQ1_RW4gtbeUQe-xuaIIkDn-kKeZ8fKYT7lRF8kC6rLCvhj5fpl7nAy35JPeCOp_WBJNIVjMM8tHN5apY7z8Zoglpf0-_xkzgCXA1xNw"
    },
    "msg": "登录成功",
    "identifier": ""
}
```  

如果未登录状态，访问受限接口，后台会返回一个html：
```  
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Please sign in</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	<link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet"
		crossorigin="anonymous" />
</head>

<body>
	<div class="container">
		<form class="form-signin" method="post" action="/process">
			<h2 class="form-signin-heading">Please sign in</h2>
			<p>
				<label for="username" class="sr-only">Username</label>
				<input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
				<p>
					<label for="password" class="sr-only">Password</label>
					<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>
</body>

</html>
```  


###　v1.1.201911191128  
解决诉求：访问未授权的接口，系统默认的跳转是一个重定向。
对于前后端分离的项目，需要直接返回自定义的JSON数据。










