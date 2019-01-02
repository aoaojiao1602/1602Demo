package com.hwg.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * @Description poi导出excel
 * @author HJiong
 * @time 2018年12月31日 下午9:02:18
 * 
 * 需要传入要导出的数据列及对应列表头以map集合形式 如：map.put('studentId,学生id')
 * 此方法可帮助我们 指定导出哪些列
 */
public class ExcelCreate {

	/**
	 * 创建EXCEL文件,并把集合数据写入
	 * 
	 * @param list
	 * @throws IOException
	 */
	public static void createExcel(OutputStream response,String fileName,Map<String, String> titles,List<?> list) throws IOException {
		Workbook workbook = null;
		workbook = createWorkbook(fileName,titles,list);
         //下载输出流  
	  	workbook.write(response);  
	}
	
	/**
	 * 创建workbook
	 * @param fileName excel文件名
	 * @param titles 导出字段及表头
	 * @param list 导出数据
	 * @return
	 * @throws IOException
	 */
	public static Workbook createWorkbook(String fileName,Map<String, String> titles,List<?> list) throws IOException {
		Set<String> keys=titles.keySet();//将表头key（字段）加入set集合
		
		XSSFWorkbook workbook = new XSSFWorkbook();// 创建2003版本excel
		Sheet sheet=null;//创建sheet表
		if(fileName.equals("")||fileName==null) {
			sheet = workbook.createSheet(fileName); 
		}else {
			sheet = workbook.createSheet(); 
		}
		
		Row row = sheet.createRow(0);// 创建第一行(表头)
		Cell cell = null;//创建列
		int KEYI=0;//表示下标(创建列)
		for (String key : keys) {
			sheet.setColumnWidth(KEYI, 5000);//设置列宽
			cell=row.createCell(KEYI);//创建当前列
			cell.setCellType(CellType.STRING);// 设置单元格类型为文本
			cell.setCellValue(titles.get(key));//根据当前key取value 设值
			KEYI++;
		}
		for (int i = 0; i < list.size(); i++) {//创建内容 循环调用
			row = getRtData(workbook,sheet, i + 1, list, keys);
		}
		/*Sheet sheet = workbook.createSheet(fileName);// 创建一个sheet表,并设置表名称
		// 创建表头字段
		Row row = sheet.createRow(0);// 创建索引为0的Row对象
		String[] header = Title;
		int head_length = header.length;
		Cell[] cells = new HSSFCell[head_length];
		// 填入表头的值
		for (int i = 0; i < cells.length; i++) {
			cells[i] = row.createCell(i);// 创建一个单元格对象
			cells[i].setCellType(CellType.STRING);// 设置单元格类型为文本
			cells[i].setCellValue(header[i]);
		}

		for (int i = 0; i < list.size(); i++) {
			row = this.getRtData(workbook,sheet, i + 1, list, head_length);
		}*/
		return workbook;
	}
	
	/**
	 * 写入数据
	 * @param workbook
	 * @param sheet
	 * @param i
	 * @param list
	 * @param keys
	 * @return
	 */
	private static Row getRtData(Workbook workbook,Sheet sheet, int i, List<?> list,
			Set<String> keys) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		/*HSSFCellStyle style= (HSSFCellStyle) workbook.createCellStyle();
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFillForegroundColor(HSSFColor.RED.index);*///红色单元格样式
		Row row = sheet.createRow(i);//创建第i行
		// 设计cell的格式
		for (int j = 0; j < keys.size(); j++) { //先创建好列
			row.createCell(j);// 创建一个单元格对象
			row.getCell(j).setCellType(CellType.STRING);// 设置单元格类型为文本
		}
		//反射 取属性
		Object beanObj = list.get(i - 1);// 从下标为0开始
		Class clazz=beanObj.getClass();
		try {  
			Object obj=clazz.newInstance();//实例化对象
			int KEYJ=0;//下标
			for (String key : keys) {
				Field field = obj.getClass().getDeclaredField(key);//获得属性 
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);  //获得属性get方法
	            Method getMethod = pd.getReadMethod(); 
	            if (getMethod != null) {  
                    //System.out.println(beanObj+"的字段是:"+field.getName()+"，类型是："+field.getType()+"，取到的值是： "+getMethod.invoke(beanObj));   
	            	if(getMethod.invoke(beanObj)!=null){
	            		//判断属性类型 并设置单元格类型
	                	if(field.getType().toString().equals("class java.lang.Integer")){	
	                		row.getCell(KEYJ).setCellValue((Integer) getMethod.invoke(beanObj));
	                	}
	                	if(field.getType().toString().equals("class java.lang.String")){
	                    	row.getCell(KEYJ).setCellValue((String) getMethod.invoke(beanObj));
	                	}
	                	if("class java.sql.Timestamp".equals(field.getType().toString())){
	                		row.getCell(KEYJ).setCellValue(sdf.format(getMethod.invoke(beanObj)));
	                	}
	                	if(field.getType().toString().equals("class java.lang.Double")){
	                		row.getCell(KEYJ).setCellValue((Double)getMethod.invoke(beanObj));
	                	}
	                }
                	
                }
	            KEYJ++;
			}
		  
        } catch (IllegalAccessException e) {  
             e.printStackTrace();  
        } catch (IllegalArgumentException e) {  
             e.printStackTrace();  
        } catch (InvocationTargetException e) {  
             e.printStackTrace();  
        } catch (IntrospectionException e) {  
             e.printStackTrace();  
        } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return row;
	}
	
	
	/**
	 * 
	 * 响应文件
	 * @param response
	 * @param workbook
	 * @param filename
	 */
	public static void downloadExcel(HttpServletResponse response,
			Workbook workbook, String filename) {
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		try {
			response.setHeader("Content-Disposition", "attachment; filename="
					+ URLEncoder.encode(filename + ".xls", "utf-8"));
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			workbook.write(stream);
			response.setContentLength(stream.size());
			stream.writeTo(response.getOutputStream());
			stream.close();
			response.getOutputStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
