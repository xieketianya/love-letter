package com.laoshe.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laoshe.base.LaosheResponse;
import com.laoshe.entity.UserInfo;
import com.laoshe.mapper.UserInfoMapper;
import com.laoshe.request.UserInfoModifyReq;
import com.laoshe.request.UserLoginReq;
import com.laoshe.response.UserInfoRes;
import com.laoshe.service.RedisService;
import com.laoshe.service.UserService;
import com.laoshe.utils.DataUtil;
import com.laoshe.utils.UUID;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserInfoMapper userInfoMapper;
	
	@Autowired
	RedisService redisService;

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
	public LaosheResponse modifyUser(UserInfoModifyReq userInfoModifyReq) {
		// TODO Auto-generated method stub
		return null;
	}

}
