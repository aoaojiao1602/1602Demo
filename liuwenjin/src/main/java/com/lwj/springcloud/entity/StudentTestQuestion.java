/**
 * 
 */ 
package com.lwj.springcloud.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 项目名称：liuwenjin
 * 类名称：Studentquestion
 * 类描述：
 * 创建人：rain
 * 创建时间：2018年12月13日 下午2:17:36
 * 修改人：rain
 * 修改时间：2018年12月13日 下午2:17:36
 * 修改备注：
 * @version
 *
*/
@Entity
@Table(name = "studentTestQuestiontb")
@Getter
@Setter
/*学生测试题库表*/
public class StudentTestQuestion {
	@Id // 指定主键 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer stqId;
	@Column(columnDefinition="int comment '备注:题库id'")
	private Integer questiontbId;	
	@Column(columnDefinition="int comment '备注:测试信息id'")
	private Integer testId;		
	@Column(columnDefinition="int comment '备注:学生id'")
	private Integer studentId;	
	@Column(columnDefinition="varchar(100) comment '备注:考试答案'")
	private String answer;			
}
