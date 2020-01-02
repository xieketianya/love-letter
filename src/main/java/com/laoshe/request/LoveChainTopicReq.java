package com.laoshe.request;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class LoveChainTopicReq{
  
    private String lnid;

	private String timestr;
    
    private String lndata;
    
    public String getLnid() {
		return lnid;
	}

	public void setLnid(String lnid) {
		this.lnid = lnid;
	}

	public String getTimestr() {
		return timestr;
	}

	public void setTimestr(String timestr) {
		this.timestr = timestr;
	}

	public String getLndata() {
		return lndata;
	}

	public void setLndata(String lndata) {
		this.lndata = lndata;
	}
	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}