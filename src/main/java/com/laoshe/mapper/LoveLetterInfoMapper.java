package com.laoshe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.laoshe.entity.LoveLetterInfo;
import com.laoshe.request.LoveLetterByUser;
import com.laoshe.request.QuerySelfLoveLetterReq;
@Mapper
public interface LoveLetterInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(LoveLetterInfo record);

    int insertSelective(LoveLetterInfo record);

    LoveLetterInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoveLetterInfo record);

    int updateByPrimaryKey(LoveLetterInfo record);
    
    List<LoveLetterInfo> selectByUserId(LoveLetterByUser loveLetterByUser);
    
    List<LoveLetterInfo> selectByUser(QuerySelfLoveLetterReq querySelfLoveLetterReq);
}