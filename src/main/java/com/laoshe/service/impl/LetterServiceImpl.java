package com.laoshe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.stereotype.Service;

import com.laoshe.base.LaosheResponse;
import com.laoshe.base.PageResult;
import com.laoshe.constant.CodeSet;
import com.laoshe.entity.LoveLetterInfo;
import com.laoshe.mapper.LoveLetterInfoMapper;
import com.laoshe.request.LoveLetterByUser;
import com.laoshe.request.QueryLoveLetterReq;
import com.laoshe.request.QuerySelfLoveLetterReq;
import com.laoshe.service.LetterService;
import com.laoshe.utils.RedisUtil;
import com.laoshe.utils.UUID;
@Service
public class LetterServiceImpl implements LetterService{
	
	@Autowired
	RedisUtil redisUtil;
	
	@Autowired
	LoveLetterInfoMapper loveLetterInfoMapper;
	//所有
	private final static String nearbyLetter = "nl";
	//男
	private final static String nearbyLetter_m = "nl_m";
	//女
	private final static String nearbyLetter_g = "nl_g";

	@Override
	public LaosheResponse addLoveLetter(LoveLetterInfo loveLetterInfo) {
		
		//临时方案
		loveLetterInfo.setBlockId(UUID.UU32());
		if (loveLetterInfo.getId() == null) {
			loveLetterInfoMapper.insertSelective(loveLetterInfo);
		}
		//上链过程
		//TODO
		
		loveLetterInfo.setIsChain("1");
		loveLetterInfoMapper.updateByPrimaryKeySelective(loveLetterInfo);
		//保存redis
		addToGeo(loveLetterInfo);
		redisUtil.add(loveLetterInfo.getBlockId(), loveLetterInfo);
		return LaosheResponse.success("上链成功");
	}
	
	@Override
	public LaosheResponse addLoveLetterToDb(LoveLetterInfo loveLetterInfo) {
		loveLetterInfo.setIsChain("0");
		loveLetterInfoMapper.insertSelective(loveLetterInfo);
		return LaosheResponse.success("保存成功");
	}
	/**
	 * 查询用户是否有未上链的数据
	 * 
	 * */
	@Override
	public LaosheResponse<LoveLetterInfo> queryNoToChainLetter(String userId){
		LaosheResponse<LoveLetterInfo> response = new LaosheResponse<LoveLetterInfo>();
		response.setRetCode(CodeSet.SUCCESS_CODE);
		response.setRetMsg("查询成功");
		response.setSuccess(true);
		LoveLetterByUser loveLetterByUser = new LoveLetterByUser();
		loveLetterByUser.setIsChain("0");
		loveLetterByUser.setUserId(userId);
		List<LoveLetterInfo> list = loveLetterInfoMapper.selectByUserId(loveLetterByUser);
		if (list.size() >0) {
			response.setData(list.get(0));
			return response;
		}
		response.setData(new LoveLetterInfo());
		return response;
	}
	@Override
	public PageResult<LoveLetterInfo> queryLoveLeterByUser(QuerySelfLoveLetterReq querySelfLoveLetterReq) {
		querySelfLoveLetterReq.setIsChain("1");
		if (querySelfLoveLetterReq.getPage() == null || querySelfLoveLetterReq.getPage() == 1) {
			querySelfLoveLetterReq.setPage(0);
		}else if(querySelfLoveLetterReq.getPage() >1){
			querySelfLoveLetterReq.setPage((querySelfLoveLetterReq.getPage()-1)*querySelfLoveLetterReq.getRows()-1);
		}
		List<LoveLetterInfo> list = loveLetterInfoMapper.selectByUser(querySelfLoveLetterReq);
		PageResult<LoveLetterInfo> pages = new PageResult<LoveLetterInfo>();
		pages.setRows(list);
		pages.setRetCode(CodeSet.SUCCESS_CODE);
		pages.setRetMsg("查询成功");
		return pages;
	}
	@Override
	public PageResult<LoveLetterInfo> queryNearbyLoveLetter(QueryLoveLetterReq queryLoveLetterReq) {
		String sex = null;
		if (queryLoveLetterReq.getUserSex() == null) {
			sex = nearbyLetter;
		}else if(queryLoveLetterReq.getUserSex().equals("1")){
			sex = nearbyLetter_m;
		}else if (queryLoveLetterReq.getUserSex().equals("2")) {
			sex = nearbyLetter_g;
		}else {
			sex = nearbyLetter;
		}
		GeoResults<RedisGeoCommands.GeoLocation<String>> results = getGeoInfo(sex, queryLoveLetterReq);
		List<GeoResult<RedisGeoCommands.GeoLocation<String>>> list =  results.getContent();
		String blockId = list.get(0).getContent().toString();
		
		return null;
	}
	public void addToGeo(LoveLetterInfo loveLetterInfo){
		String longitude = loveLetterInfo.getLongitude();
		String latitude = loveLetterInfo.getLatitude();
		Point point = new Point(Double.valueOf(longitude), Double.valueOf(latitude));
		RedisGeoCommands.GeoLocation<String> geoLocation = new RedisGeoCommands.GeoLocation<String>(loveLetterInfo.getBlockId(), point);
		redisUtil.addToGeo(nearbyLetter, geoLocation);
		if (loveLetterInfo.getUserSex() == "1") {
			redisUtil.addToGeo(nearbyLetter_m, geoLocation);
		}else{
			redisUtil.addToGeo(nearbyLetter_g, geoLocation);
		}
		
		
	}
	public GeoResults<RedisGeoCommands.GeoLocation<String>> getGeoInfo(String sex,QueryLoveLetterReq queryLoveLetterReq){
		Point point = new Point(Double.valueOf(queryLoveLetterReq.getLongitude()), Double.valueOf(queryLoveLetterReq.getLatitude()));
		Distance distance = new Distance(Double.valueOf(queryLoveLetterReq.getDistance()), RedisGeoCommands.DistanceUnit.METERS);
		Circle circle = new Circle(point, distance);
		RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs();
		args.includeDistance().includeCoordinates().sortAscending();
		return redisUtil.distant(sex, circle, args);
	}

}
