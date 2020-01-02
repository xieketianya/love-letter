package com.laoshe.entity;

import java.util.Date;

public class LoveLetterInfo {
    private Long id;

    private String blockId;

    private String userId;

    private String userSex;

    private String loveContent;

    private String longitude;

    private String latitude;

    private String isChain;

    private Date createTime;

    private Date chainTime;

    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId == null ? null : blockId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getLoveContent() {
        return loveContent;
    }

    public void setLoveContent(String loveContent) {
        this.loveContent = loveContent == null ? null : loveContent.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getIsChain() {
        return isChain;
    }

    public void setIsChain(String isChain) {
        this.isChain = isChain == null ? null : isChain.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getChainTime() {
        return chainTime;
    }

    public void setChainTime(Date chainTime) {
        this.chainTime = chainTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}