package com.lwj.springcloud.config;


/**
 * 
 * @Description:   
 * @ClassName:     JsonResult.java 
 * @author         MaShuai 
 * @Date           2018年8月11日 下午3:49:20  
 * @Email          1119616605@qq.com
 */

public class JsonResult {
	private String status;
	private Object result;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	

}
