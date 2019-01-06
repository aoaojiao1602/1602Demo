package com.hwg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.hwg.entity.Baoming;
import com.hwg.repository.LearnrecordDao;
import com.hwg.serviceImpl.BaomingServiceImpl;
import com.hwg.utils.JsonResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @Description 学生报名记录controller
 * @author HJiong
 * @time 2019年1月3日 下午11:57:51
 */
@RequestMapping("baoming")
@RestController
public class BaomingController {
	
	@Autowired
	private BaomingServiceImpl bService;
	
	@Autowired
	private LearnrecordDao lDao;
	
	/**
	 * 根据学生id 及课程id查询出学习记录
	 * @return
	 */
	@ApiImplicitParams({@ApiImplicitParam(name="kcId",value="课程的id",dataType="String"),@ApiImplicitParam(name="xsId",value="学生id",dataType="String")})
	@ApiOperation("查询出当前学生当前课程的报名记录")
	@RequestMapping(method=RequestMethod.GET)
	public Object getOneLearnrecord(Integer kcId,Integer xsId) {
		return bService.querylearnrecord(kcId, xsId);
	}
	
	/**
	 * 查询指定学生的报名记录
	 * @return
	 */
	@ApiImplicitParam(name="sid",value="学生id",dataType="Integer")
	@ApiOperation("查询出当前学生报名的课程")
	@GetMapping("/getByStu")
	public Object getByStu(Integer sid) {
		List<Baoming> bm=(List<Baoming>)bService.findBaomingBystuId(sid);
		if(bm.size()!=0) {
			return bm;
		}else {
			return null;
		}
		
	}
	
	/**
	 * 查询指定学生的报名记录
	 * @return
	 */
	@ApiImplicitParam(name="sid",value="学生id",dataType="Integer")
	@ApiOperation("查询出当前学生报名的课程（返回课程id）")
	@GetMapping("/getByStuRuturnId")
	public List<Integer> getByStuRuturnId(Integer sid){
		List<Baoming> bm=(List<Baoming>)bService.findBaomingBystuId(sid);
		List<Integer> list=new ArrayList<>();
		for (Baoming baoming : bm) {
			list.add(baoming.getCourseId());
		}
		return list;
	}
	
	
	/**
	 *  为指定学生添加报名记录
	 * @param model
	 * @return
	 */
	@PutMapping()
	public Object addBaoming(Baoming model) {
		return bService.addBaoming(model);
	}
	
	
}
