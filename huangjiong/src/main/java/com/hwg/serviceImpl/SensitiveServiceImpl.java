package com.hwg.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwg.entity.Sensitive;
import com.hwg.repository.SensitiveDao;
import com.hwg.service.SensitiveService;

/**
 * @Description 敏感词业务实现类
 * @author HJiong
 * @time 2019年1月4日 上午11:06:00
 */
@Service
public class SensitiveServiceImpl implements SensitiveService{
	
	@Autowired
	private SensitiveDao sDao;
	
	/**
	 * 添加敏感词
	 */
	@Override
	public Object addSensitive(Sensitive model) {
		// TODO Auto-generated method stub
		return sDao.save(model);
	}

	/**
	 * 查询所有
	 */
	@Override
	public List<Sensitive> getAll() {
		// TODO Auto-generated method stub
		return sDao.findAll();
	}
	
	/**
	 * 删除敏感词汇
	 */
	public void delete(Sensitive entity) {
		sDao.delete(entity);
	}

}
