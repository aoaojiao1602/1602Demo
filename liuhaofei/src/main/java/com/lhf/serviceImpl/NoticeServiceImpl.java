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

import com.lhf.entity.Courses;
import com.lhf.entity.CoursesSearch;
import com.lhf.entity.Notice;
import com.lhf.entity.NoticeSearch;
import com.lhf.repository.NoticeRepository;
import com.lhf.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeRepository nRepository;
	@Override
	public int putNotice(Notice n) {
		// TODO Auto-generated method stub
		return nRepository.putNotice(n);
	}

	@Override
	public int deleteNoticeByid(Integer noticeId) {
		
		return nRepository.deleteNoticeByid(noticeId);
	}

	@Override
	public int postNotice(Notice n) {
		// TODO Auto-generated method stub
		return nRepository.postNotice(n);
	}

	@Override
	public Page<Notice> queryByDynamicSQLPage(NoticeSearch n, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.ASC, "noticeId");
		Pageable pageable = new PageRequest(page, size, sort);
		return nRepository.findAll(this.getWhereClause(n), pageable);
	}
	private Specification<Notice> getWhereClause(final NoticeSearch n) {
		return new Specification<Notice>() {
			@Override
			public Predicate toPredicate(Root<Notice> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();// 动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();// 动态SQL表达式集合
				if (n.getNoticeName() != null && !"".equals(n.getNoticeName())) {
					exList.add(cb.like(root.<String>get("noticeName"), "%" +n.getNoticeName() + "%"));
				}
				if (n.getNoticeCourse() != null && !"".equals(n.getNoticeCourse())) {
					exList.add(cb.equal(root.get("noticeCourse").as(String.class), n.getNoticeCourse()));
				}
				if (n.getNoticeContent() != null && !"".equals(n.getNoticeContent())) {
					exList.add(cb.equal(root.get("noticeContent").as(String.class), n.getNoticeContent()));
				}			
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date parse1 = null,parse2=null;
				if (n.getStartCreateTime() != null&& !"".equals(n.getStartCreateTime())) {
					try {
						parse1 = dateFormat.parse(n.getStartCreateTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					exList.add(cb.greaterThanOrEqualTo(root.<Date>get("noticeTime"), parse1));// 大于等于起始日期
				}
				if (n.getEndCreateTime() != null&& !"".equals(n.getEndCreateTime())) {
					try {
						parse2 = dateFormat.parse(n.getEndCreateTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					exList.add(cb.lessThanOrEqualTo(root.get("noticeTime").as(Date.class), parse2));// 小于等于截止日期
				}
				return predicate;

		}
		};
	
	}

}