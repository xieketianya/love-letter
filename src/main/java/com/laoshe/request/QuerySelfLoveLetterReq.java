package com.laoshe.request;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.laoshe.base.BaseBean;

public class QuerySelfLoveLetterReq extends BaseBean{
    
    private String userId;

	private String isChain;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIsChain() {
		return isChain;
	}

	public void setIsChain(String isChain) {
		this.isChain = isChain;
	}
	
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}