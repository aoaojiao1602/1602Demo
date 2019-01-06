package com.hwg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hwg.entity.Learnrecord;
import com.hwg.serviceImpl.LearnrecordServiceImpl;
import com.hwg.utils.JsonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @Description 课程学习记录控制器层
 * @author HJiong
 * @time 2018年12月27日 下午10:40:15
 */
@RequestMapping("learnrecord")
@RestController
@Api("课程学习记录服务器接口")
public class LearnrecordController {
	
	@Autowired
	private LearnrecordServiceImpl lservice;

	/**
	 * 	添加学生学习记录
	 */
	@ApiOperation("添加学生章节学习记录(如果存在记录执行修改操作)")
	@ApiImplicitParam(name="lcModule",value="学习记录实体对象")
	@RequestMapping(method=RequestMethod.PUT)
	public Object addlearnrecord(Learnrecord lcModule) {
		return lservice.addlearnrecord(lcModule);
	}
	
	
	
	/**
	   *   查询指定时间段的课程学习记录 
	 * @return
	 */
	@ApiOperation("查询出七天的课程报名记录")
	@RequestMapping(method=RequestMethod.GET,value="byTime")
	public List<Map<String, Object>> getLearnrecordByUpdateTime(){
		List<Map<String, Object>> list=lservice.getLearnrecordByUpdateTime();
		return list;
	}
	
	
	/**
	 * 查询出10条热门课程(最近一周)
	 * @return
	 */
	@ApiOperation("查询出10条热门课程(最近一周,降序排序)")
	@GetMapping(value="/getHotCourse")
	public Object getHotCourse(){
		return lservice.getHotCourse();
	}
	
	/**
	 * 查询出当前学生报名课程
	 * @return
	 */
	@GetMapping("getLearnrecordByStuId")
	@ApiOperation("查询出当前学生报名课程")
	@ApiImplicitParam(name="stuId",value="学生id")
	public List<Learnrecord> getLearnrecordByStuId(String stuId){
		return lservice.getLearnrecordByStuId(stuId);
	}
	
	
	/**
	 * 查询课程信息 返回list集合
	 * @return
	 */
	@GetMapping("getLearnrecordBysid")
	@ApiOperation("查询出当前学生报名课程(返回课程信息)")
	@ApiImplicitParam(name="stuId",value="学生id")
	public Object getLearnrecordBycid(String stuId){
		return lservice.getLearnrecordBysid(stuId);
	}
	
	/**
	 * 查询当前课程章节学习记录
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/findlearnrecord")
	public Object findlearnrecord(String kcId,String xsId,String zj) {
		JsonResult rst=new JsonResult();
		if(lservice.findlearnrecord(kcId, xsId, zj)==null) {
			rst.setResult(false);
			rst.setStatus("没有找到数据");
		}
		else {
			rst.setResult(lservice.findlearnrecord(kcId, xsId, zj));
		}
		return rst;
	}
	
}
