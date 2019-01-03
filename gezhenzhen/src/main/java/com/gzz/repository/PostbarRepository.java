package com.gzz.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.Postbar;

public interface PostbarRepository extends JpaRepository<Postbar, Integer> {
	
	/*
	 * 发布帖子
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbartb(u_id,postbar_title,postbar_content,postbar_create_time)values"
			+ "(?1,?2,?3,now())", nativeQuery = true)
	public int putPostbar(Integer uId, String postbarTitle,String postbarContent);
	
	/*
	 * 修改本人发布的帖子
	 */
	@Modifying
	@Transactional
	@Query(value = "update postbartb set postbar_title=?1,postbar_content=?2 where postbar_id=?3 and u_id=?4", nativeQuery = true)
	public int postPostbar (String postbarTitle,String postbarContent, Integer postbarId, Integer uId);
	
	/*
	 * 查询主题数
	 */
	@Query(value="select count(*) from postbartb where u_id=?1", nativeQuery=true)
	public int getPostbarTitleCount(Integer uId);
	
	/*
	 * 查询帖子主题
	 */
	@Query(value="SELECT * FROM postbartb WHERE u_id=?1 ORDER BY postbar_create_time DESC LIMIT 0,5", nativeQuery=true)
	public List<Postbar> getPostbarTitle(Integer uId);
	
	/*public Page<Postbar> findAll(Pageable pageable);*/
	
	/*
	 * 查询获赞数
	 * by uId
	 */
	@Query(value="SELECT COUNT(*) FROM postbar_goodtb WHERE postbar_good_postbar_id IN(SELECT postbar_id FROM postbartb WHERE u_id=?1)", nativeQuery=true)
	public int getGoodCountByuId(Integer uId);
	
	/*
	 * 查询主贴内容
	 */
	@Query(value="select * from postbartb where postbar_id=?1", nativeQuery=true)
	public Postbar getPostbar(Integer postbarId);
	
	/*
	 * 首页精彩讨论
	 */
	@Query(value="SELECT DISTINCT p.*,(SELECT COUNT(*) FROM postbar_replytb WHERE postbar_reply_postbar_id=p.postbar_id) AS a FROM postbartb p LEFT JOIN postbar_replytb r ON p.postbar_id=r.postbar_reply_postbar_id WHERE DATE_SUB(CURDATE(), INTERVAL 30 DAY)<= DATE(postbar_create_time) ORDER BY a DESC LIMIT 0,1", nativeQuery=true)
	public Postbar getHotPostbar();
	
	/**
	 * 个人中心主贴分页
	 * @param uId
	 * @param pageable
	 * @return
	 */
	@Query(value="SELECT * FROM postbartb WHERE u_id =?1", nativeQuery=true)
	public Page<Postbar> getPostbarPageByuId(Integer uId,Pageable pageable);
	
}
