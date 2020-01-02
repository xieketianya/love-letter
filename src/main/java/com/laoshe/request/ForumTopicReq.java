package com.laoshe.request;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.laoshe.base.BaseBean;

public class ForumTopicReq extends BaseBean{
  
   

	private String userId;

    private String title;
    
    private String topicType;
    
    private String loveId;
    
	private String isChain;
	
	private String loveUserId;
	
	private String loveLoveId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    
    public String getTopicType() {
		return topicType;
	}

	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}
	public String getLoveId() {
		return loveId;
	}

	public void setLoveId(String loveId) {
		this.loveId = loveId;
	}
	
	public String getIsChain() {
		return isChain;
	}

	public void setIsChain(String isChain) {
		this.isChain = isChain;
	}
	public String getLoveUserId() {
		return loveUserId;
	}

	public void setLoveUserId(String loveUserId) {
		this.loveUserId = loveUserId;
	}

	public String getLoveLoveId() {
		return loveLoveId;
	}

	public void setLoveLoveId(String loveLoveId) {
		this.loveLoveId = loveLoveId;
	}
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}