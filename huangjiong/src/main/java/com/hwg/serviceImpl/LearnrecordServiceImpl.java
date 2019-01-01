package com.hwg.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwg.entity.Learnrecord;
import com.hwg.repository.LearnrecordDao;
import com.hwg.service.LearnrecordService;
import com.hwg.utils.Get7dayUtil;

/**
 * @Description 学习记录实体
 * @author gz
 */
@Service
public class LearnrecordServiceImpl implements LearnrecordService {

	@Autowired
	private LearnrecordDao lDao;
	
	@Autowired
	Get7dayUtil getDate;
	/**
	 * 	 查询出学习记录 根据学生id and 课程编号及章节
	 * @return
	 */
	public Object querylearnrecord(String kcId,String xsId) {
		return lDao.findlearnrecord(kcId, xsId);
	}
	
	/**
	 * 根据学生id 及课程id、课程章节 查询出学习记录
	 * @return
	 */
	public Learnrecord getOneLearnrecord(String kcId,String xsId,String zj) {
		List<Learnrecord> list=lDao.findlearnrecord(kcId, xsId);
		for (Learnrecord lc : list) {
			if(lc.getLearnCourseRecord().equals(zj)) {
				return lc;
			}
		}
		return null;
	} 
	
	/**
	 * 	添加学生记录信息 
	 * @return
	 */
	@Transactional
	public Object addlearnrecord(Learnrecord lcModule) {
		//先查询出当前学生是否有过当前课程的学习记录
		List<Learnrecord> list=lDao.findlearnrecord(lcModule.getLearnCourseId(), lcModule.getLearnStuId());
		if(list.size()>0) {
			for (Learnrecord lc : list) {
				//如果当前传入的课程记录存在于表中
				if(lc.getLearnCourseRecord().equals(lcModule.getLearnCourseRecord())) {
					//如果当前传入time大于数据库中的time 则修改time
					if(lcModule.getLearnCourseTime()>lc.getLearnCourseTime()) {
						return lDao.updateBylrId(lcModule.getLearnCourseRecord(), lcModule.getLearnCourseTime(),lc.getLrId());
					}else {//不做任何操作
						return false;
					}
				}
			}
			//循环结束 未发现相同记录 执行添加
			return lDao.save(lcModule);
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
		System.err.println(list);
		return list;
	}
	
	/**
	 * 查询出10条热门课程（最近一周）并且根据报名次数降序排序
	 * @return
	 */
	public List<String> getHotCourse(){
		List<Map<String, Object>> listMap=this.getLearnrecordByUpdateTime();
		paixu(listMap, "number");//调用排序方法 根据人数降序排序
		List<String> list=new ArrayList<>();
		for (int i = 0; i < 10; i++) {//循环十次查询课程
			//此处调用查询课程
			//list.add(课程)
		list.add("什么什么凑字课"+i);
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
	
}
