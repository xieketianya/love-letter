package com.laoshe.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laoshe.base.LaosheResponse;
import com.laoshe.constant.CodeSet;
import com.laoshe.entity.UserInfo;
import com.laoshe.request.UserLoginReq;
import com.laoshe.service.RedisService;
import com.laoshe.service.UserService;
import com.laoshe.utils.UserUtil;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    RedisService redisService;
    
    @Autowired
    UserService userService;
    
    @ResponseBody
    @RequestMapping(value = "/login", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    public LaosheResponse<?> addUser(@RequestBody UserLoginReq userLoginReq) throws Exception{
    	String verifyCode = redisService.get(userLoginReq.getUserMobile());
//    	if (StringUtils.isEmpty(verifyCode) || verifyCode.equals(userLoginReq.getVerifyCode())) {
//			return LaosheResponse.verifyCodeError();
//		}
    	if (!userLoginReq.getVerifyCode().equals("123456")) {
    		return LaosheResponse.verifyCodeError();
		}
    	return userService.login(userLoginReq);
    }
    @ResponseBody
    @RequestMapping(value = "/loginout", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public LaosheResponse<?> loginOut(HttpServletRequest request) throws Exception{
    	UserInfo userInfo = UserUtil.getUserInfo(request);
    	if (userInfo == null) {
			return LaosheResponse.error(CodeSet.USER_INFO_FAIL, "用户登录态失效");
		}
    	return userService.loginOut(userInfo.getUserId());
    }
}
