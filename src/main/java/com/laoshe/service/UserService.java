package com.laoshe.service;

import com.laoshe.base.LaosheResponse;
import com.laoshe.request.UserInfoModifyReq;
import com.laoshe.request.UserLoginReq;

public interface UserService {
	public LaosheResponse<Object> login(UserLoginReq userLoginReq) throws Exception;
	
	public LaosheResponse modifyUser(UserInfoModifyReq userInfoModifyReq);

	LaosheResponse loginOut(String userId);
}
