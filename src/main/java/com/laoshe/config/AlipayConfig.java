package com.laoshe.config;

public class AlipayConfig {
		// 商户appid
		public static String APPID = "2018092361493208";
		// 私钥 pkcs8格式的
		public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCWuCV5VE/kK4Z1rhyzGJAKRHiISrld9anWZCCpuY7kA27RA+M+nxs8X4zF5fuPrc2CR5NOfgjKkYWO0qT9LcQMrNtb0ynhmazd6LuzdGr+gjjC4BVqyh6svMc7MF2wjXxce4JpO6EJUp3FWP4L9xful87CefSqdne5waeAkx8UmBRrq2UC0WsMDZinZhiofzfQrXNUijfOFSFxbnYMjvF7csi4RmvehrkrHTj7Xn8l5/SsTKDYQaCRUOo62MhLt96fCkO+fWRJiW5HtgX9byanjU+pQJGo8P9AOeDINdUBHIImg81wJ0prZTALMXmFx2UInPh03Q1/IKKijXI9VIdvAgMBAAECggEABDMJSEIjH7ZevrSlNBBBIygZO6LpW0bW/pQ3nMMAyjWWRtiW4k3IknwPDgyEX9J14WVhI1S7pfk8AWi5FBzMU5YVXo+ZoSGJAX3UjQF3YbP7JOLddeY/yIxR+MI2Og8XIfSHA6uXpwzYPIFoQqkVz54HMr/3IzC90T0mD50JxqcTJ7vgGOOY8cuVkmc64yI0Ez+r9azwLmgrt3O24mvlygnCQhul8YkBeJbTt+rkqJGyAHVGeDO2EUERjMVdgulhLJ3i4Z42cyC0tQFme1MNE7wholfXmn3V5Ls0vm+cv7kI7/mwwP8Yr8s4CQxwnaztCSjf+T5oyiURHcVak5ZwwQKBgQDIx4JicgGJoWktz03g3Os9Cw7eY7vYgMW773SEZ72Ilw3VmSckn1l8FzxCifW6R9pB4EyEzTD25C4a2wrRi09f6yCc29oy1XL1OYEAqnQCcZztWuqIkGWsmiZuFAez2btjXnifzPU/eRQ/2Cs3FpltrWATc1Oori8xFTt5sGnsPwKBgQDALAHHS5jyU0ue/8xUn/bKD2YNmgnWACcAnmA9nJOxhfb+WyPB5MG03OEzLyaD5CwubeOo39vpMMMVNwThruYZex/WnzCAnfwjk2EdViF/yhkhMCB82hhOpMzcvjl1pU6Fi2P2BepOZZJLSjsFSsrjJ/AwIpHNC5DPpaYKXRtY0QKBgQC9eLksWdXlobL2Dgm6SACeTI8tgwTD3VG8ds6IHLYZ7iKaDbuIre/uUKcHS9XeguwO+rJ7KIAqnU58/XSKJmMza1oNbNPO4OtpS2jXzgNIQxsKSp/FXC724Ume27whFznlHkPK2coeqg5X6ZFunR8RB2oBMPYj2qyiLx0/SyHKVQKBgBqN+jDv4VKa7/gooLOQ5ylEt3Vps7I+kyUivWnGGSKOwHKlZWuFkL7NRtEr0sam4PQJe0v6owi2FD76O1J0OJeMy/l8Rdd//TdtRh4nqLlf09kiLVsTSAiV/TkDkC0RiqgpesakSpxKrMx6lW1FyINbIXWFUWBkGL6YxTjpZL4BAoGBAIgQdIypZXULI/nX3Oc+t7HVDppIHKS06+w/hI7Ud5e1DRJQPRSAtMkg8lBWFsSS+zITORJgq1WMvxQY5id8eNHlS9G7U2qVS4SUPzUbTjmMPGPMoCt7gEdDuO55pAEiaR8lUOCU4jcb7Cjf6mHcyieHC+GON4VuVNzuoRDpWz6L";
		// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
		public static String notify_url = "http://154.92.17.14:8081/save-love/pay/notify";
		// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
		public static String return_url = "http://154.92.17.14:8081/save-love/pay/notify";
		// 请求网关地址
		public static String URL = "https://openapi.alipay.com/gateway.do";
		// 编码
		public static String CHARSET = "UTF-8";
		// 返回格式
		public static String FORMAT = "json";
		// 支付宝公钥
		public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2DH9+npey0cNvH/qhMiRlcl4mN5r7X08eqBXUZzMnsz9Q8X3yAG/h4TVB+SMjJsvTIGCZ5RkI4CvpfNwHwZIjuJEzRmSrhg1rJlKYK9ehb8SY6pelS7MZ+5PsWeWQ879f0mWG2RiaiaCPaH/zk3VsW50sqtmd9nj5Ey/BbhRk83cuzJqQIHJLHNsGVkwz9Iqsj6MzlHbCqE6t/iWC+pVmBOfr9x/2+wbWbTUmM8VVt5EetsWBWeZF3du4J/utspeWKRQBCDVhDLrVCx696ALXpN9N4iWOsfhjSPyOOPdDtUiKBMpC39d8hD+q3K9j6PFAEz8yExtV+6FjxmpiCEqMQIDAQAB";
		// 日志记录目录
		public static String log_path = "/log";
		// RSA2
		public static String SIGNTYPE = "RSA2";
}
