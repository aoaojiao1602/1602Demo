package com.gzz.service;

public interface ProjectNotCountService {
	//查询当前用户有没有对主题进行过点赞
	public int getUidNotCount(Integer projectNotCountProjectId,Integer projectNotCountUid);
	//对主题进行点踩，查询当前用户是否对该主题进行点踩
	public int getProjectNotCountByUid(Integer projectNotCountUid,Integer projectNotCountProjectId);
	//如果该用户对该主题进行过点踩则再次操作时取消点踩
	public int deleteProjectNotCountByUid(Integer projectNotCountUid,Integer projectNotCountProjectId);
	//如果该用户对该主题没有进行过点踩则对该主题进行点踩
	public int putProjectNotCount(Integer projectNotCountUid,Integer projectNotCountProjectId);

}
