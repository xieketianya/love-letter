//package com.laoshe.remote.client;
//
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.alibaba.fastjson.JSONObject;
//import com.laoshe.request.LoveChainTopicReq;
//
//import feign.Headers;
//import feign.Param;
//import feign.RequestLine;
//@Headers("Accept:application/json")
//public interface LoveChainFeign {
//	
//	@Headers("Content-Type:application/json")
//	@RequestLine("GET /lnotes/{lnid}")
//	JSONObject querylnotes(@Param("lnid") String lnid);
//	
//	
//	@Headers("Content-Type:application/json")
//	@RequestLine("POST /lnotes")
//	JSONObject addlnotes(@RequestBody LoveChainTopicReq loveChainTopicReq);
//	
//}
