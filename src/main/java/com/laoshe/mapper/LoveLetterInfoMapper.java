package com.laoshe.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.laoshe.entity.LoveLetterInfo;
@Mapper
public interface LoveLetterInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(LoveLetterInfo record);

    int insertSelective(LoveLetterInfo record);

    LoveLetterInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoveLetterInfo record);

    int updateByPrimaryKey(LoveLetterInfo record);
}