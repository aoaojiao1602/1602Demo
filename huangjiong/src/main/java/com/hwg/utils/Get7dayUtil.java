package com.hwg.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.Configuration;

/**
 * @Description 获取过去七天日期 	
 * @author HJiong
 * @time 2018年11月1日 下午6:29:08
 */
@Configuration
public class Get7dayUtil {
	
	
	 public static ArrayList<String> test(int intervals ) {  
	       ArrayList<String> pastDaysList = new ArrayList<>();  
	       for (int i = intervals; i >=1; i--) {  
	           pastDaysList.add(getPastDate(i));  
	       }  
	       return pastDaysList;  
	   }
	 
	 
	 
	 	/**
	 	 * 	传入要获取之前的第几天
	 	 * @param past
	 	 * @return
	 	 */
	   public static String getPastDate(int past) {  
	       Calendar calendar = Calendar.getInstance(); //创建calendar
	       //设置calendar Calendar.DAY_OF_YEAR获取到今天是今年的第几天 再减去past
	       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
	       Date today = calendar.getTime();  //拿减去后的calendar获取时间
	       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	       String result = format.format(today);  
	       return result;  
	   }  

}
