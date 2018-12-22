package com.lhf.serviceImpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import com.lhf.entity.Hours;
import com.lhf.entity.HoursSearch;
import com.lhf.repository.HoursRepository;
import com.lhf.service.HoursService;

@Service
public class HoursServiceImpl implements HoursService{
	@Autowired
	private HoursRepository hRepository;

	//添加课时
	@Override
	@Transactional
	public int putHours(Hours h) {
		// TODO Auto-generated method stub
		return hRepository.putHours(h);
	}

	//删除课时
	@Override
	public int deleteHoursById(Integer hourId) {
		// TODO Auto-generated method stub
		return hRepository.deleteHoursById(hourId);
	}

	//修改课时
	@Override
	public int postHoursById(Hours h) {
		// TODO Auto-generated method stub
		return hRepository.postHoursById(h);
	}

	//查询课时
	@Override
	public Page<Hours> queryByDyHoursSQLPage(HoursSearch HSearch, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.ASC, "hourId");
		Pageable pageable = new PageRequest(page, size, sort);
		return hRepository.findAll(this.getWhereClause(HSearch), pageable);
	}

	private Specification<Hours> getWhereClause(final HoursSearch HSearch) {
		return new Specification<Hours>() {
			@Override
			public Predicate toPredicate(Root<Hours> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合
				if (HSearch.getHourCourse() != null && !"".equals(HSearch.getHourCourse())) {
					exList.add(cb.like(root.<String>get("hourCourse").as(String.class), HSearch.getHourCourse()));
				}
				if (HSearch.getHourParentId() !=0) {
					exList.add(cb.equal(root.get("hourParentId").as(String.class), HSearch.getHourParentId()));
				}
				if (HSearch.getHourName() != null && !"".equals(HSearch.getHourName())) {
					exList.add(cb.equal(root.get("hourName"), "%" + HSearch.getHourName() + "%"));
				}
				if (HSearch.getHour_xxx() != null && !"".equals(HSearch.getHour_xxx())) {
					exList.add(cb.equal(root.get("hour_xxx").as(String.class), HSearch.getHour_xxx()));
				}
				return predicate;
			}

		};
	}



	
	

	
	
}
