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

### v1.1.20191119 增加jwt token
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

