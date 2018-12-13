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

/**
 * 类名: entitysearch 说明: TODO 作者: 大娃 邮件: 1558936588@qq.com 时间: 2018年11月16日
 * 下午11:04:34 版本: V1.0 公司: 葫芦岛葫芦山葫芦科技有限公司
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
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
	private Date endTime;
	private Integer isLockout;
}
