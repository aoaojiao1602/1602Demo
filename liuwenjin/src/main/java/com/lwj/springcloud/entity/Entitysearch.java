/**
 * 
 */
package com.lwj.springcloud.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * 项目名称：SpringBootJpa
 * 类名称：entitysearch
 * 类描述：
 * 创建人：rain
 * 创建时间：2018年11月16日 下午11:04:34
 * 修改人：rain
 * 修改时间：2018年11月16日 下午11:04:34
 * 修改备注：
 * @version
 *
*/
@Data
public class Entitysearch {
	private String name;
	private String sex;
	private Integer minAge;
	private Integer maxAge;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startBirthday;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endBirthday;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startUpdateTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endUpdateTime;
	//开始时间
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
	//结束时间
	private Date endTime;
	//题型
	private String tx;
	private Integer page;
	private Integer rows;
	private Integer isLockout;
}
