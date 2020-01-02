package com.laoshe.response;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UserLoveRes {
	private Long id;

    private String userId;

    private String loveNickName;

	private String loveStatus;

    private Date loveDate;

    private Date breakDate;

    private Date reLoveDate;

	private String loveImgSmallUrl;
    
    private String loveImgLargeUrl;
    
    private String remark;
    
    private String remark1;
    
    private String remark2;
    
    private String birthday;
    
    private String email;

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLoveNickName() {
        return loveNickName;
    }

    public void setLoveNickName(String loveNickName) {
        this.loveNickName = loveNickName == null ? null : loveNickName.trim();
    }
    public String getLoveStatus() {
		return loveStatus;
	}

	public void setLoveStatus(String loveStatus) {
		this.loveStatus = loveStatus;
	}

	public Date getLoveDate() {
		return loveDate;
	}

	public void setLoveDate(Date loveDate) {
		this.loveDate = loveDate;
	}

	public Date getBreakDate() {
		return breakDate;
	}

	public void setBreakDate(Date breakDate) {
		this.breakDate = breakDate;
	}

	public Date getReLoveDate() {
		return reLoveDate;
	}

	public void setReLoveDate(Date reLoveDate) {
		this.reLoveDate = reLoveDate;
	}
	public String getLoveImgSmallUrl() {
		return loveImgSmallUrl;
	}

	public void setLoveImgSmallUrl(String loveImgSmallUrl) {
		this.loveImgSmallUrl = loveImgSmallUrl;
	}

	public String getLoveImgLargeUrl() {
		return loveImgLargeUrl;
	}

	public void setLoveImgLargeUrl(String loveImgLargeUrl) {
		this.loveImgLargeUrl = loveImgLargeUrl;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}