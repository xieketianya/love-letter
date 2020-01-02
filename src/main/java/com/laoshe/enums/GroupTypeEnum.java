package com.laoshe.enums;

public enum GroupTypeEnum {
	
	GROUP_TYPE_MONEY("10001","财富组"),
	
	GROUP_TYPE_BUSINESS("10002","创业组");
	
	private String groupTypeId;
	
	private String groupTypeName;
	
	GroupTypeEnum(String groupTypeId,String groupTypeName){
		this.groupTypeId = groupTypeId;
		this.groupTypeName = groupTypeName;
	}
	
	public String getGroupTypeId() {
		return groupTypeId;
	}

	public void setGroupTypeId(String groupTypeId) {
		this.groupTypeId = groupTypeId;
	}

	public String getGroupTypeName() {
		return groupTypeName;
	}

	public void setGroupTypeName(String groupTypeName) {
		this.groupTypeName = groupTypeName;
	}

	
}
