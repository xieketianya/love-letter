package com.laoshe.base;

import java.io.Serializable;

import com.laoshe.constant.CodeSet;

public class LaosheResponse<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String retCode;

	protected String retMsg;
	
	protected T data;
	
	protected boolean success;
	
	public LaosheResponse(){
		this.retCode = CodeSet.SYSTEM_ERR_CODE;
		this.retMsg = "处理失败";
		this.success = false;
	}
	public static LaosheResponse success(String msg){
		LaosheResponse result = new LaosheResponse();
		result.setSuccess(true);
		result.setRetCode(CodeSet.SUCCESS_CODE);
		result.setRetMsg(msg);
		return result;
	}
	public static LaosheResponse error(String msg){
		LaosheResponse result = new LaosheResponse();
		result.setSuccess(false);
		result.setRetCode(CodeSet.SYSTEM_ERR_CODE);
		result.setRetMsg(msg);
		return result;
	}
	public String getRetCode() {
		return retCode;
	}
    
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
