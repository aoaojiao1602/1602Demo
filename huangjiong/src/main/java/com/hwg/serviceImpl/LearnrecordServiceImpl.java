package com.hwg.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwg.entity.Baoming;
import com.hwg.entity.Learnrecord;
import com.hwg.repository.LearnrecordDao;
import com.hwg.service.CourseService;
import com.hwg.service.LearnrecordService;
import com.hwg.utils.Get7dayUtil;
import com.netflix.discovery.converters.Auto;

/**
 * @Description 学习记录实体
 * @author gz
 */
@Service
public class LearnrecordServiceImpl implements LearnrecordService {

	@Autowired
	private LearnrecordDao lDao;//学习几记录Dao
	
	@Autowired
	Get7dayUtil getDate;//获取时间工具类
	
	@Autowired
	CourseService cService;
	
	@Autowired
	BaomingServiceImpl bService;
	/**
	 * 	 查询出学习记录 根据学生id and 课程编号及章节
	 * @return
	 */
	public Learnrecord findlearnrecord(String kcId,String xsId ,String zj) {
		return lDao.findlearnrecord(kcId, xsId,zj);
	}
	
	/**
	 * 根据学生id 及课程id、课程章节 查询出学习记录
	 * @return
	 *//*
	public Learnrecord getOneLearnrecord(String kcId,String xsId,String zj) {
		List<Learnrecord> list=lDao.findlearnrecord(kcId, xsId);
		for (Learnrecord lc : list) {
			if(lc.getLearnCourseRecord().equals(zj)) {
				return lc;
			}
		}
		return null;
	} */
	
	/**
	 * 	添加学生记录信息 
	 * @return
	 */
	@Transactional
	public Object addlearnrecord(Learnrecord lcModule) {
		//先查询出当前学生是否有过当前课程的学习记录
		Learnrecord lc=lDao.findlearnrecord(lcModule.getLearnCourseId(), lcModule.getLearnStuId(),lcModule.getLearnCourseRecord());
		if(lc!=null) {
				//如果当前传入的课程章节记录存在于表中
				if(lc.getLearnCourseRecord().equals(lcModule.getLearnCourseRecord())) {
					//如果当前传入time大于数据库中的time 则修改time
					if(lcModule.getLearnCourseTime()>lc.getLearnCourseTime()) {
						return lDao.updateBylrId(lcModule.getLearnCourseRecord(), lcModule.getLearnCourseTime(),lc.getLrId());
					}else {//不做任何操作
						return false;
					}
				}else {
					//未发现相同记录 执行添加
					return lDao.save(lcModule);
				}
		}else {//如果没有学习记录就添加
			return lDao.save(lcModule);
		}
	}

	/**
	 * 查询指定时间段的课程学习记录 返回课程id
	 * @return
	 */
	@SuppressWarnings("all")
	public List<Map<String, Object>> getLearnrecordByUpdateTime() {
		return lDao.getLearnrecordByUpdateTime(getDate.getPastDate(7), getDate.getPastDate(0));
	}

	
	/**
	 *    对集合进行降序排序
	 * @param list
	 * @return
	 */
	public static List<Map<String, Object>> paixu(List<Map<String, Object>> list,String key){
		Collections.sort(list, new Comparator<Map<String,Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
			//进行判断
			return (o2.get(key).toString()).compareTo(o1.get(key).toString());
			}
		});
		return list;
	}
	
	/**
	 * 查询出10条热门课程（最近一周）并且根据报名次数降序排序
	 * @return
	 */
	public Object getHotCourse(){
		List<Map<String, Object>> listMap=bService.findRm();
		List<Map<String, Object>> list=new ArrayList<>();
		paixu(listMap, "number");//调用排序方法 根据人数降序排序
		int xhWhere=0;
		if(listMap.size()>=10) {
			xhWhere=10;
		}else {
			xhWhere=listMap.size();
		}
		for (int i = 0; i <xhWhere; i++) {//循环十次查询课程
			Map<String, Object> map=new HashMap<>();
			map.put("number", Integer.parseInt(listMap.get(i).get("number").toString()));
			map.putAll((Map<String, Object>) cService.getCourseById(Integer.parseInt(listMap.get(i).get("course_id").toString())));
			list.add(map);
		}
		return list;
	}
	
	/**
	 * 查询出当前学生报名课程
	 * @return
	 */
	public List<Learnrecord> getLearnrecordByStuId(String stuId){
		return lDao.findLearnrecordByLearnStuId(stuId);
	}
	
	
	/**
	 * 查询课程信息 返回list集合
	 * @return
	 */
	public Object getLearnrecordBysid(String sid){
		List<Baoming> list=bService.findBaomingBystuId(Integer.parseInt(sid));
		List<Map<String, Object>> restMap=new ArrayList();
		for (Baoming bm : list) {
			Map<String, Object> map=(Map<String, Object>) cService.getCourseById(bm.getCourseId());
			restMap.add(map);
		}
		return restMap;
	}
	
	/**
	 * 查询指定课程的报名人数
	 * @return
	 */
	public Map<String, Object> getLearnrecordByCourseId(String cid){
		return lDao.findLearnrecordByLearnCourseId(cid);
	}
	
}
