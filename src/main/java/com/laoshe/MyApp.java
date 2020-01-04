package com.laoshe;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.laoshe.interceptor.AuthTokenFilter;

@SpringBootApplication
@ComponentScan(basePackages = { "com.laoshe" })
@EnableAutoConfiguration
public class MyApp {
	private static Logger logger = LoggerFactory.getLogger(MyApp.class);

	@Autowired
	private AuthTokenFilter filter;

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(filter);
		// 设置（模糊）匹配的url
		List<String> urlPatterns = new ArrayList();
		urlPatterns.add("/user/loginout");
		urlPatterns.add("/user/query-self");
		urlPatterns.add("/user/friend-info");
		urlPatterns.add("/love/save-to-chain");
		urlPatterns.add("/love/save");
		urlPatterns.add("/love/query-not-chain");
		urlPatterns.add("/love/query-nearby");
		urlPatterns.add("/love/query-self");
		registrationBean.setUrlPatterns(urlPatterns);

		registrationBean.setOrder(1);
		registrationBean.setEnabled(true);
		return registrationBean;
	}
	public static void main(String[] args) {
		logger.info("程序开始启动");
		SpringApplication.run(MyApp.class, args);
	}
}
