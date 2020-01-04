package com.laoshe.service;

import com.laoshe.base.LaosheResponse;
import com.laoshe.base.PageResult;
import com.laoshe.entity.UserInfo;
import com.laoshe.request.UserInfoModifyReq;
import com.laoshe.request.UserLoginReq;

public interface UserService {
	public LaosheResponse<Object> login(UserLoginReq userLoginReq) throws Exception;
	
	public LaosheResponse modifyUser(UserInfoModifyReq userInfoModifyReq) throws Exception;

	LaosheResponse loginOut(String userId);

	LaosheResponse<UserInfo> querySelf(String userId);

	LaosheResponse<UserInfo> queryFriendInfo(String userId);
	
	PageResult<UserInfo> queryUserData();
}
