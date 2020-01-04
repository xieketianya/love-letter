package com.laoshe.request;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;


public class UserLoginReq implements Serializable{
	

    /**
	 * 
	 */
	private static final long serialVersionUID = -2091010431291152961L;

	@NotBlank(message = "用户名不能为空")
	private String userMobile;
	@NotBlank(message = "验证码不能为空")
	private String verifyCode;

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}