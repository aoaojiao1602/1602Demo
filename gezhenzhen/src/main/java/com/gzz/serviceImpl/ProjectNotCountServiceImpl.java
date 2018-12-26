package com.gzz.serviceImpl;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gzz.repository.ProjectNotCountReopsitory;
import com.gzz.service.ProjectNotCountService;
@Service
public class ProjectNotCountServiceImpl implements ProjectNotCountService {
	@Autowired
	private ProjectNotCountReopsitory reopsitory;
	//对主题进行点踩，查询当前用户是否对该主题进行点踩
	@Transactional
	public int getProjectNotCountByUid(Integer projectNotCountUid, Integer projectNotCountProjectId) {
		return reopsitory.getProjectNotCountByUid(projectNotCountUid, projectNotCountProjectId);
	}
	//如果该用户对该主题进行过点踩则再次操作时取消点踩
	@Transactional
	public int deleteProjectNotCountByUid(Integer projectNotCountUid, Integer projectNotCountProjectId) {
		return reopsitory.deleteProjectNotCountByUid(projectNotCountUid, projectNotCountProjectId);
	}
	//如果该用户对该主题没有进行过点踩则对该主题进行点踩
	@Transactional
	public int putProjectNotCount(Integer projectNotCountUid, Integer projectNotCountProjectId) {
		return reopsitory.putProjectNotCount(projectNotCountUid, projectNotCountProjectId);
	}
	@Transactional
	//查询当前用户有没有对主题进行过点赞
	public int getUidNotCount(Integer projectNotCountProjectId,Integer projectNotCountUid) {
		return reopsitory.getUidNotCount(projectNotCountProjectId, projectNotCountUid);
	}

}
