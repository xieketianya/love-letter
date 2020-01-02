package com.laoshe.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.laoshe.entity.ImHistoryUser;
@Mapper
public interface ImHistoryUserMapper {


    int deleteByPrimaryKey(Long id);

    int insert(ImHistoryUser record);

    int insertSelective(ImHistoryUser record);

    ImHistoryUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImHistoryUser record);

    int updateByPrimaryKey(ImHistoryUser record);
}