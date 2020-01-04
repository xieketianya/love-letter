package com.laoshe.request;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class LoveLetterByUser {
	
    private String userId;

    private String isChain;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getIsChain() {
        return isChain;
    }

    public void setIsChain(String isChain) {
        this.isChain = isChain == null ? null : isChain.trim();
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}