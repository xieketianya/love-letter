package com.laoshe.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laoshe.base.LaosheResponse;
import com.laoshe.base.PageResult;
import com.laoshe.constant.CodeSet;
import com.laoshe.entity.LoveLetterInfo;
import com.laoshe.entity.UserInfo;
import com.laoshe.request.QuerySelfLoveLetterReq;
import com.laoshe.request.UserLoginReq;
import com.laoshe.service.UserService;
import com.laoshe.utils.RedisUtil;
import com.laoshe.utils.UserUtil;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    RedisUtil redisService;
    
    @Autowired
    UserService userService;
    /**
     * 用户登录和注册功能
     * 
     * */
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
    /**
     * 用户注销功能
     * 
     * */
    @ResponseBody
    @RequestMapping(value = "/loginout", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public LaosheResponse<?> loginOut(HttpServletRequest request) throws Exception{
    	UserInfo userInfo = UserUtil.getUserInfo(request);
    	if (userInfo == null) {
			return LaosheResponse.error(CodeSet.USER_INFO_FAIL, "用户登录态失效");
		}
    	return userService.loginOut(userInfo.getUserId());
    }
    /**
     * 查询个人信息
     * */
    @ResponseBody
    @RequestMapping(value = "/query-self", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public LaosheResponse<?> querySelf(HttpServletRequest request) throws Exception{
    	UserInfo userInfo = UserUtil.getUserInfo(request);
    	if (userInfo == null) {
			return LaosheResponse.error(CodeSet.USER_INFO_FAIL, "用户登录态失效");
		}
    	return userService.querySelf(userInfo.getUserId());
    }
    /**
     * 查询聊天好友信息
     * */
    @ResponseBody
    @RequestMapping(value = "/friend-info", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public LaosheResponse<?> queryFriendInfo(@RequestParam String userId,HttpServletRequest request) throws Exception{
    	UserInfo userInfo = UserUtil.getUserInfo(request);
    	if (userInfo == null) {
			return LaosheResponse.error(CodeSet.USER_INFO_FAIL, "用户登录态失效");
		}
    	return userService.queryFriendInfo(userInfo.getUserId());
    }
    
    /**
     * 查询星空用户
     * */
    @ResponseBody
    @RequestMapping(value = "/query-userData", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public PageResult<UserInfo> queryLoveLeterByUser() throws Exception{
    	return userService.queryUserData();
    }
}
