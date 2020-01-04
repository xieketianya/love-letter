package com.laoshe.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.laoshe.entity.UserInfo;
@Mapper
public interface UserInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);


    UserInfo selectByPrimaryKey(Long id);
    
    UserInfo selectByPhone(String userMobile);
    
    UserInfo selectByUserId(String userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}