package com.laoshe.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.laoshe.base.BaseBean;
import com.laoshe.base.PageResult;
import com.laoshe.constant.CodeSet;

/**
 * 该类为分页插件工具类
 * @author hyw
 * 2018年11月18日
 */
public class PageUtil {
	
	public static <T> Page<T> Init(Class<T> clazz,BaseBean base){
		if (base.getRows() == 0) {
			base.setRows(10);
		}
		Page<T> page = PageHelper.startPage(base.getPage(), base.getRows());
		return page;
	}
	public static <T> PageResult<T> packaged(Page<T> page){
		PageResult<T> result = new PageResult<T>();		
		result.setRows(page.getResult());
		result.setTotal(page.getTotal());
		result.setRetCode(CodeSet.SUCCESS_CODE);
		result.setRetMsg("查询成功");
		result.setSuccess(true);
		return result;
		
	}
}
