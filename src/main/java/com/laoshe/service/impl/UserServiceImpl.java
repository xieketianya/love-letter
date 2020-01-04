package com.laoshe.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laoshe.base.LaosheResponse;
import com.laoshe.base.PageResult;
import com.laoshe.constant.CodeSet;
import com.laoshe.entity.UserInfo;
import com.laoshe.mapper.UserInfoMapper;
import com.laoshe.request.UserInfoModifyReq;
import com.laoshe.request.UserLoginReq;
import com.laoshe.response.UserInfoRes;
import com.laoshe.service.UserService;
import com.laoshe.utils.DataUtil;
import com.laoshe.utils.RedisUtil;
import com.laoshe.utils.UUID;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Autowired
	RedisUtil redisService;

	@Override
	public LaosheResponse<Object> login(UserLoginReq userLoginReq) throws Exception{
		UserInfo userInfo = userInfoMapper.selectByPhone(userLoginReq.getUserMobile());
		UserInfoRes userInfoRes = new UserInfoRes();
		if (userInfo == null) {
			userInfo = new UserInfo();
			userInfo.setUserMobile(userLoginReq.getUserMobile());
			//临时方案
			userInfo.setUserId(UUID.UU32());
			userInfoMapper.insertSelective(userInfo);
			userInfoRes.setIsNew("2");
		}
		String token = DataUtil.getToken();
		redisService.set(token,userInfo.getUserId(), Long.valueOf(7*24*3600));
		BeanUtils.copyProperties(userInfoRes, userInfo);
		userInfoRes.setToken(token);
		return LaosheResponse.successData(userInfoRes);
	}

	@Override
	public LaosheResponse loginOut(String userId) {
		redisService.remove(userId);
		return LaosheResponse.success("注销成功");
	}

	@Override
	public LaosheResponse modifyUser(UserInfoModifyReq userInfoModifyReq) throws Exception {
		UserInfo userInfo = userInfoMapper.selectByUserId(userInfoModifyReq.getUserId());
		if (userInfo == null) {
			LaosheResponse.error(CodeSet.USER_INFO_NOT_EXISTS, "用户不存在");
		}
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setId(userInfo.getId());
		BeanUtils.copyProperties(userInfo1, userInfoModifyReq);
		userInfoMapper.updateByPrimaryKeySelective(userInfo1);
		return LaosheResponse.success("修改成功");
	}
	@Override
	public LaosheResponse<UserInfo> querySelf(String userId){
		LaosheResponse<UserInfo> response = new LaosheResponse<UserInfo>();
		UserInfo userInfo = userInfoMapper.selectByUserId(userId);
		if (userInfo != null) {
			userInfo.setPassward(null);
		}
		response.setData(userInfo);
		response.setRetCode(CodeSet.SUCCESS_CODE);
		response.setRetMsg("查询成功");
		return response;
	}
	@Override
	public LaosheResponse<UserInfo> queryFriendInfo(String userId){
		LaosheResponse<UserInfo> response = new LaosheResponse<UserInfo>();
		UserInfo userInfo = userInfoMapper.selectByUserId(userId);
		if (userInfo != null) {
			userInfo.setUserMobile(null);
			userInfo.setPassward(null);
		}
		response.setData(userInfo);
		response.setRetCode(CodeSet.SUCCESS_CODE);
		response.setRetMsg("查询成功");
		return response;
	}

	@Override
	public PageResult<UserInfo> queryUserData() {
		PageResult<UserInfo> result = new PageResult<UserInfo>();
		List<UserInfo> userInfos = userInfoMapper.queryUserData();
		for (int i = 0; i < userInfos.size(); i++) {
			userInfos.get(i).setPassward(null);
			userInfos.get(i).setUserMobile(null);
		}
		result.setRows(userInfos);
		result.setRetCode(CodeSet.SUCCESS_CODE);
		result.setRetMsg("查询成功");
		return null;
	}

}
