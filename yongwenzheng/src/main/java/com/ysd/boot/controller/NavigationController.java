package com.ysd.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.entity.Navigation;
import com.ysd.boot.service.NavigationService;
import com.ysd.boot.tool.Result;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/navigation",name="导航模块")
public class NavigationController {

	@Autowired
	private NavigationService navigationService;
	
	/**
	 * 添加导航信息
	 * @param navName
	 */
	@ApiOperation(value="获取导航信息", notes="添加导航信息")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "navName", value = "导航名称", required = true, dataType = "String", paramType = "query"),
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
	})
	@PutMapping(value="/addNavigation",name="添加导航")
	  public Object addNavigation(@RequestParam String navName,@RequestParam String access_token) {
		Result result=new Result();
		if (navigationService.addNavigation(navName)>0) {
			result.setState(1);
			result.setMsg("添加成功");
			
		} else {
			result.setState(0);
			result.setMsg("添加失败");
		}
		return result;
		  
	  }
	 
	 
	 /**
	   * 通过id删除导航信息
	   * @param navId
	   * @return
	   */
	@ApiOperation(value="获取导航信息", notes="通过id删除导航信息")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "navId", value = "导航id", required = true, dataType = "Integer", paramType = "query"),
	@ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
    })
	@DeleteMapping("/deleteNavigation")
	  public Object deleteNavigation(@RequestParam Integer navId,@RequestParam String access_token) {
		
		Result result=new Result();
		if (navigationService.deleteNavigation(navId)>0) {
			result.setState(1);
			result.setMsg("删除成功");
			
		} else {
			result.setState(0);
			result.setMsg("删除失败");
		}
		return result;
	}
	  
	  
	  /***
	   * 通过id修改导航信息
	   * @param navId
	   * @param navName
	   * @return
	   */
    	@ApiOperation(value="获取导航信息", notes="通过id修改导航信息")
    	@ApiImplicitParams({
    		@ApiImplicitParam(name = "navId", value = "导航id", required = true, dataType = "Integer", paramType = "query"),
         	@ApiImplicitParam(name = "navName", value = "导航名称", required = true, dataType = "String", paramType = "query"),
    	    @ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
    	})
    	@PostMapping("/updateNavigation")
	  public Object updateNavigation(@RequestParam Integer navId,@RequestParam String navName,@RequestParam String access_token) {
    		Result result=new Result();
    		if (navigationService.updateNavigation(navId, navName)>0) {
    			result.setState(1);
    			result.setMsg("修改成功");
    			
    		} else {
    			result.setState(0);
    			result.setMsg("修改失败");
    		}
    		return result;
    		
    	}
	  
	  
	  /**
	   * 得到所有导航信息
	   * @return
	   */
    @ApiOperation(value="获取导航信息", notes="得到所有导航信息")
    @ApiImplicitParam(name = "access_token", value = "token", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getALLNavigationList") 
    public Object getALLNavigationList(@RequestParam String access_token) {
    	
    	return navigationService.getALLNavigationList();
    }
}
