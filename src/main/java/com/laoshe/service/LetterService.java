package com.laoshe.service;

import com.laoshe.base.LaosheResponse;
import com.laoshe.base.PageResult;
import com.laoshe.entity.LoveLetterInfo;
import com.laoshe.request.QueryLoveLetterReq;
import com.laoshe.request.QuerySelfLoveLetterReq;

public interface LetterService {
	
	public LaosheResponse addLoveLetter(LoveLetterInfo loveLetterInfo);
	
	public PageResult<LoveLetterInfo> queryNearbyLoveLetter(QueryLoveLetterReq queryLoveLetterReq);

	LaosheResponse addLoveLetterToDb(LoveLetterInfo loveLetterInfo);
	//根据用户查询是否有未上链的数据
	LaosheResponse<LoveLetterInfo> queryNoToChainLetter(String userId);

	PageResult<LoveLetterInfo> queryLoveLeterByUser(QuerySelfLoveLetterReq querySelfLoveLetterReq);
}
