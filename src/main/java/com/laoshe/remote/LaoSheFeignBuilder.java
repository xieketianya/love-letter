//package com.laoshe.remote;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import feign.Feign;
//import feign.Logger.Level;
//import feign.Request;
//import feign.Retryer;
//import feign.jackson.JacksonDecoder;
//import feign.jackson.JacksonEncoder;
//
//@Service
//public class LaoSheFeignBuilder {
//	
//	@Autowired
//	private Feign.Builder builder;
//	
//	@Autowired
//	private HttpParamBean httpParamBean;
//
//	public <T> T build(String url,Class<T> clazz){
//		T instance = builder.encoder(new JacksonEncoder()).decoder(new JacksonDecoder()).logLevel(Level.FULL)
//				.retryer(new Retryer.Default(100L, TimeUnit.SECONDS.toMillis(1), httpParamBean.getRetry()))
//				.options(new Request.Options(httpParamBean.getConnectTimeout(), httpParamBean.getReadTimeout()))
//				.target(clazz,url);
//		return instance;
//	}
//	
//}
