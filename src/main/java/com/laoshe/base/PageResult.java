package com.laoshe.base;

import java.util.List;

public class PageResult<T> extends LaosheResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<T> rows;

	private Long total;
	
	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
