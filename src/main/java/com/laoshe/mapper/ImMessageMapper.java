package com.laoshe.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.laoshe.entity.ImMessage;
@Mapper
public interface ImMessageMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ImMessage record);

    int insertSelective(ImMessage record);

    ImMessage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ImMessage record);

    int updateByPrimaryKey(ImMessage record);
}