package com.hwg.service;

import java.util.List;

import com.hwg.entity.Baoming;

/**
 * @Description 报名记录业务接口
 * @author HJiong
 * @time 2019年1月3日 下午11:58:24
 */
public interface BaomingService {
	
	/**
	 * 	 查询出学习记录 根据学生id and 课程编号
	 * @return
	 */
	public Baoming querylearnrecord(Integer kcId,Integer xsId);
	
	/**
	 * 查询指定课程报名记录
	 * @return
	 */
	public List<Baoming> findBaomingByCourseId(Integer id);
	
	/**
	 * 添加
	 * @param model
	 * @return
	 */
	public Object addBaoming(Baoming model);
	
	/**
	 * 查询指定学生的报名记录
	 * @param sid
	 * @return
	 */
	public Object findBaomingBystuId(Integer sid);

}
