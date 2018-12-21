package com.lhf.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhf.entity.Notice;
import com.lhf.entity.NoticeSearch;
import com.lhf.entity.Pic;
import com.lhf.entity.PicSearch;
import com.lhf.repository.PicRepository;
import com.lhf.service.PicService;
@Service
public class PicServiceImpl implements PicService{
	@Autowired
	private PicRepository pRepository;
	@Override
	public Page<Pic> queryByDynamicSQLPage(PicSearch p, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.ASC, "picId");
		Pageable pageable = new PageRequest(page, size, sort);
		return pRepository.findAll(this.getWhereClause(p),pageable);
	}
	private Specification<Pic> getWhereClause(final PicSearch p) {
		return new Specification<Pic>() {
			@Override
			public Predicate toPredicate(Root<Pic> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合
				if (p.getPicCourse() != null && !"".equals(p.getPicCourse())) {
					exList.add(cb.like(root.<String>get("picCourse"), "%" +p.getPicCourse() + "%"));
				}
				if (p.getPicUrl() != null && !"".equals(p.getPicUrl())) {
					exList.add(cb.equal(root.get("picUrl").as(String.class), p.getPicUrl()));
				}
				return predicate;

		}
		};
	
	}
	@Override
	public int putPic(Pic p) {
		return pRepository.putPic(p);
	}

	@Override
	@Transactional
	public int deletePicByid(Integer picId) {	
		return pRepository.deletePicByid(picId);
	}

	@Override
	public int postPic(Pic p) {		
		return pRepository.postPic(p);
	}
	
}
