# travel
###基于SSM的旅游信息管理系统

####1.项目分前后台
1.前台
地址：http://localhost/index
账号：user  密码：123456

1.后台
地址：http://localhost/login
账号：root  密码：123456
| 前台模块  | 首页   |旅游路线|旅游景点|餐饮住宿|旅游车票|旅游保险|旅游攻略|注意事项|数据分析|

| 后台模块  | 旅游路线|旅游景点|旅游酒店|旅游车票|旅游保险|旅游策略|订单管理|留言管理|数据分析|

#前台
##首页模块：
###1.登录
**redirectAttributes: 专门用于重定向之后还能带参数跳转的的工具类**[redirectAttributes](https://zhuanlan.zhihu.com/p/21353217?refer=pengsong-java)  

第一种：
`redirectAttributes.addAttributie("prama",value);`
例如:
 
    redirectAttributes.addAttributie("prama1",value1);
    redirectAttributes.addAttributie("prama2",value2);
    return:"redirect：/path/list"     
以上重定向的方法等同于 `return:"redirect：/path/list？prama1=value1&prama2=value2 "` ，
注意这种方法直接将传递的参数暴露在链接地址上，非常的不安全，慎用。    

第二种：
`redirectAttributes.addFlashAttributie("prama",value); `
这种方法是隐藏了参数，链接地址上不直接暴露，但是能且只能在重定向的 “页面” 获取prama参数值。  
其原理就是放到session中，session在跳到页面后马上移除对象。
如果是重定向一个controller中是获取不到该prama属性值的。
除非在controller中用`(@RequestPrama(value = "prama")String prama)`注解，采用传参的方式。页面获值例如：  


    redirectAttributes.addFlashAttributie("prama1",value1);
    
    redirectAttributes.addFlashAttributie("prama2",value2);
    
    return:"redirect：/path/list.jsp" 
    
###2.注册

#后台
##用户管理模块：
###1.添加用户: