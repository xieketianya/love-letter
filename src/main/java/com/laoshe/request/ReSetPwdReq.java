package com.laoshe.request;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotBlank;


public class ReSetPwdReq implements Serializable{
	

    /**
	 * 
	 */
	private static final long serialVersionUID = -2091010431291152961L;
	@NotBlank(message = "密码不能为空")
	private String userPassword;
	@NotBlank(message = "手机号码不能为空")
	private String userPhone;
	@NotBlank(message = "验证码不能为空")
	private String verifyCode;

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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