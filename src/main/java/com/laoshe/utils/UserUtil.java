package com.laoshe.utils;

import javax.servlet.http.HttpServletRequest;

import com.laoshe.entity.UserInfo;


/**
 * @author hyw
 * 2018年11月18日
 */
public class UserUtil {
	public static UserInfo getUserInfo(HttpServletRequest request){
		UserInfo user = (UserInfo) request.getAttribute("userInfo");
		return user;
	}
}
