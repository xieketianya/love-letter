package com.laoshe.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laoshe.base.LaosheResponse;
import com.laoshe.base.PageResult;
import com.laoshe.constant.CodeSet;
import com.laoshe.entity.LoveLetterInfo;
import com.laoshe.entity.UserInfo;
import com.laoshe.request.QueryLoveLetterReq;
import com.laoshe.request.QuerySelfLoveLetterReq;
import com.laoshe.service.LetterService;
import com.laoshe.service.UserService;
import com.laoshe.utils.RedisUtil;
import com.laoshe.utils.UserUtil;

@Controller
@RequestMapping(value = "/love")
public class LetterController {
    @Autowired
    RedisUtil redisService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    LetterService letterService;
    /**
     * 保存情书并 上链
     * 
     * */
    @ResponseBody
    @RequestMapping(value = "/save-to-chain", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    public LaosheResponse<?> addUser(@RequestBody LoveLetterInfo loveLetterInfo,HttpServletRequest request) throws Exception{
    	UserInfo userInfo = UserUtil.getUserInfo(request);
    	if (userInfo == null) {
			return LaosheResponse.error(CodeSet.USER_INFO_FAIL, "用户登录态失效");
		}
    	return letterService.addLoveLetter(loveLetterInfo);
    }
    /**
     * 保存至草稿箱
     * */
    @ResponseBody
    @RequestMapping(value = "/save", method = {RequestMethod.POST}, produces = {"application/json;charset=UTF-8"})
    public LaosheResponse<?> addUserToDb(@RequestBody LoveLetterInfo loveLetterInfo,HttpServletRequest request) throws Exception{
    	UserInfo userInfo = UserUtil.getUserInfo(request);
    	if (userInfo == null) {
			return LaosheResponse.error(CodeSet.USER_INFO_FAIL, "用户登录态失效");
		}
    	return letterService.addLoveLetterToDb(loveLetterInfo);
    }
    /**
     * 查询未上链的数据
     * */
    @ResponseBody
    @RequestMapping(value = "/query-not-chain", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public LaosheResponse<?> queryNoToChainLetter(HttpServletRequest request) throws Exception{
    	UserInfo userInfo = UserUtil.getUserInfo(request);
    	if (userInfo == null) {
			return LaosheResponse.error(CodeSet.USER_INFO_FAIL, "用户登录态失效");
		}
    	return letterService.queryNoToChainLetter(userInfo.getUserId());
    }
    /**
     * 查询附近的情书
     * */
    @ResponseBody
    @RequestMapping(value = "/query-nearby", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public PageResult<LoveLetterInfo> queryNearbyLoveLetter(@RequestBody QueryLoveLetterReq queryLoveLetterReq,HttpServletRequest request) throws Exception{
    	UserInfo userInfo = UserUtil.getUserInfo(request);
    	PageResult<LoveLetterInfo> pages = new PageResult<LoveLetterInfo>();
    	if (userInfo == null) {
    		pages.setRetCode(CodeSet.USER_INFO_FAIL);
    		pages.setRetMsg("用户登录态失效");
			return pages;
		}
    	if (queryLoveLetterReq.getPage() == null || queryLoveLetterReq.getRows() == null) {
    		pages.setRetCode(CodeSet.VERIFY_CODE_ERROR);
    		pages.setRetMsg("rows和page不能为空");
			return pages;
		}
    	return letterService.queryNearbyLoveLetter(queryLoveLetterReq);
    }
    /**
     * 查询自己的情书
     * */
    @ResponseBody
    @RequestMapping(value = "/query-self", method = {RequestMethod.GET}, produces = {"application/json;charset=UTF-8"})
    public PageResult<LoveLetterInfo> queryLoveLeterByUser(@RequestBody QuerySelfLoveLetterReq querySelfLoveLetterReq,HttpServletRequest request) throws Exception{
    	UserInfo userInfo = UserUtil.getUserInfo(request);
    	PageResult<LoveLetterInfo> pages = new PageResult<LoveLetterInfo>();
    	if (userInfo == null) {
    		pages.setRetCode(CodeSet.USER_INFO_FAIL);
    		pages.setRetMsg("用户登录态失效");
			return pages;
		}
    	if (querySelfLoveLetterReq.getPage() == null || querySelfLoveLetterReq.getRows() == null) {
    		pages.setRetCode(CodeSet.VERIFY_CODE_ERROR);
    		pages.setRetMsg("rows和page不能为空");
			return pages;
		}
    	return letterService.queryLoveLeterByUser(querySelfLoveLetterReq);
    }
}
