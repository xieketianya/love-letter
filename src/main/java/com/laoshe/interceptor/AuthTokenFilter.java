package com.laoshe.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laoshe.entity.UserInfo;
import com.laoshe.mapper.UserInfoMapper;
import com.laoshe.utils.RedisUtil;

@Component
public class AuthTokenFilter implements Filter {
	
	private static Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

	
	@Autowired
	private UserInfoMapper userMapper;
	
	@Autowired
	RedisUtil redisService;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		logger.info("拦截到的请求信息:{}",req.getRequestURI()+",token:"+req.getHeader("token"));
		String token = req.getHeader("token");
		String userId = redisService.get(token);
		UserInfo user = userMapper.selectByUserId(userId);
		if (user != null) {
			logger.info("用户登录成功：{}",user);
			request.setAttribute("userInfo", user);
			chain.doFilter(request, response);
		}else {
			logger.info("登录态已过期！");
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
