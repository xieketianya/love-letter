package com.laoshe.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.laoshe.service.RedisService;
@Service
public class SendMsgUtil {
	
	private static Logger logger = LoggerFactory.getLogger(SendMsgUtil.class);
	
	@Value("${aliyun.accessKeyId}")
	public String accessKeyId;
	
	@Value("${aliyun.accessSecret}")
	public String accessSecret;
	
	@Value("${aliyun.signName}")
	public String signName;
	
	@Value("${aliyun.templateCode}")
	public String templateCode;
	
	@Autowired
	private RedisService redisService;
	
    public  Boolean SendMsg(String mobile) {
     // 创建DefaultAcsClient实例并初始化
	 DefaultProfile profile = DefaultProfile.getProfile("default", accessKeyId, accessSecret);
     IAcsClient client = new DefaultAcsClient(profile);
     String authCode = UUID.random6();
     String sendCode = "{code:"+authCode+"}";
     CommonRequest request = new CommonRequest();
     request.setMethod(MethodType.POST);
     request.setDomain("dysmsapi.aliyuncs.com");
     request.setVersion("2017-05-25");
     request.setAction("SendSms");
     request.putQueryParameter("TemplateParam", sendCode);
     request.putQueryParameter("PhoneNumbers", mobile);
     request.putQueryParameter("SignName", "营销助手");
     request.putQueryParameter("TemplateCode", templateCode);
     try {
         CommonResponse response = client.getCommonResponse(request);
         logger.info("阿里云短信发送结果:{}", JSON.toJSON(response));
         String code = JSONObject.parseObject(response.getData()).getString("Code");
         if ("OK".equals(code)) {
        	 redisService.set(mobile, authCode, Long.valueOf(60*5));
        	 return true;
		}else{
			 return false;
		}
     } catch (ServerException e) {
         logger.error("调用aliyun发送短信异常", e);
     } catch (ClientException e) {
    	 logger.error("调用aliyun发送短信异常", e);
     }
     return null;
    }
}
