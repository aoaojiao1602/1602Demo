/**
 * 
 */ 
package com.lwj.springcloud.tools; 
/**
 * 项目名称：liuwenjin
 * 类名称：Random
 * 类描述：
 * 创建人：rain
 * 创建时间：2018年12月21日 下午7:28:33
 * 修改人：rain
 * 修改时间：2018年12月21日 下午7:28:33
 * 修改备注：
 * @version
 *
*/

import java.util.ArrayList;
import java.util.List;


/** 
 * 类名: Random  
 * 说明: TODO  
 * 作者: 大娃   
 * 邮件: 1558936588@qq.com  
 * 时间: 2018年12月21日 下午7:28:33  
 * 版本: V1.0   
 * 公司:  葫芦岛葫芦山葫芦科技有限公司  
*/

public class Random {

	/** 
	 * http://localhost:8080/main
	  * 作者: 大娃   
	  * 邮件: 1558936588@qq.com  
	  * 时间: 2018年12月21日 下午7:28:33  
	  * 版本: V1.0   
	 */
	public static List<Integer> GetRandomIsRepeat(int num,List<Integer> list) {
		List<Integer> oidlist=new ArrayList<Integer>();
		 while(oidlist.size()<num) {
			  int tmp=(int)(Math.random()*list.size());//产生1-10的随机数
			  boolean flag=true;
				for (int j = 0; j <oidlist.size(); j++) {
					if (oidlist.get(j)==list.get(tmp)) {
						flag=false;
						break;
					}else {
						flag=true;
					}
				}
				if (flag) {
					 oidlist.add(list.get(tmp));
				}
			 
		}
		  System.err.println(oidlist);
		  return oidlist;
	}
}
