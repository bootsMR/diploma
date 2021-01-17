var navs = [{
	"title" : "后台首页",
	"icon" : "&#xe600;",
	"href" : "/manager/main",
	"spread" : false
}
, {
	"title" : "用户管理",
	"icon" : "&#xe600;",
	"href" : "",
	"spread" : false,
	"children" : [
		{
			"title" : "注册用户",
			"icon" : "&#xe612;",
			"href" : "/manager/userList",
			"spread" : false
		},
		{
			"title" : "系统用户",
			"icon" : "&#xe612;",
			"href" : "/manager/adminList",
			"spread" : false
		}
	]
}
,{
	"title" : "内容管理",
	"icon" : "&#xe600;",
	"href" : "",
	"spread" : false,
	"children" : [
		{
			"title" : "旅游路线",
			"icon" : "&#xe631;",
			"href" : "/manager/travelRouteList",
			"spread" : false
		},
        {
            "title" : "景点管理",
            "icon" : "&#xe631;",
            "href" : "/manager/scenicSpotList",
            "spread" : false
        },
		{
            "title" : "酒店管理",
            "icon" : "&#xe631;",
            "href" : "/manager/hotelList",
            "spread" : false
        },
        {
            "title" : "留言管理",
            "icon" : "&#xe631;",
            "href" : "/manager/messageList",
            "spread" : false
        },
        {
            "title" : "保险管理",
            "icon" : "&#xe631;",
            "href" : "/manager/insuranceList",
            "spread" : false
        }
	]
}
,{
    "title" : "业务管理",
    "icon" : "&#xe600;",
    "href" : "",
    "spread" : false,
    "children" : [
        {
            "title" : "订单管理",
            "icon" : "&#xe631;",
            "href" : "/manager/orderList",
            "spread" : false
        }
    ]
}
]