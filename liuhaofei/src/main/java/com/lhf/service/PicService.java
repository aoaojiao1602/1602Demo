package com.lhf.service;

import org.springframework.data.domain.Page;

import com.lhf.entity.Notice;
import com.lhf.entity.NoticeSearch;
import com.lhf.entity.Pic;
import com.lhf.entity.PicSearch;

public interface PicService {
	//分页查询课程
	public Page<Pic> queryByDynamicSQLPage(PicSearch p,Integer page,Integer size);
	//添加图片
	public int putPic(Pic p);
	//删除图片
	public int deletePicByid(Integer picId);
	//修改图片
	public int postPic(Pic p);
}
