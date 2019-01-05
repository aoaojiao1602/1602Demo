package com.hwg.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwg.entity.Baoming;
import com.hwg.repository.BaomingDao;
import com.hwg.service.BaomingService;

/**
 * @Description 报名记录业务接口实现类
 * @author HJiong
 * @time 2019年1月3日 下午11:59:47
 */
@Service
public class BaomingServiceImpl implements BaomingService{
	
	@Autowired
	private BaomingDao bdao;
	
	
	/**
	 * 根据学生id 及课程id查询出学习记录
	 * @return
	 */
	@Override
	public Baoming querylearnrecord(Integer kcId, Integer xsId) {
		// TODO Auto-generated method stub
		return bdao.findBaomingByCourseIdAndStuId(kcId, xsId);
	}
	
	/**
	 * 根据课程分组查询count
	 * @return
	 */
	public List<Map<String, Object>> findRm(){
		return bdao.findRm();
	}
	
	/**
	 * 查询指定课程报名记录
	 * @return
	 */
	@Override
	public List<Baoming> findBaomingByCourseId(Integer id) {
		// TODO Auto-generated method stub
		return bdao.findBaomingByCourseId(id);
	}
	
	/**
	 * 添加报名记录
	 * @param model
	 * @return
	 */
	@Override
	public Object addBaoming(Baoming model) {
		// TODO Auto-generated method stub
		return bdao.save(model);
	}

	/**
	 * 查询指定学生的报名记录
	 */
	@Override
	public List<Baoming> findBaomingBystuId(Integer sid) {
		// TODO Auto-generated method stub
		return bdao.findBaomingBystuIdOrderByCrateTimeDesc(sid);
	}

}
