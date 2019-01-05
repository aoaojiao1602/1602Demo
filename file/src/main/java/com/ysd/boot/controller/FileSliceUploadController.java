package com.ysd.boot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.boot.entity.FileM;
import com.ysd.boot.entity.FileSlice;
import com.ysd.boot.service.FileService;
import com.ysd.boot.utils.PropUtil;
import com.ysd.boot.utils.SliceUtil;
import com.ysd.boot.utils.VideoAudioUtils;
@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileSliceUploadController {
	
	@Autowired
	private FileService fileService;
	
	/**
	 * D:\1602Demo\file\src\main\resources\1602Demo\
	 * http://localhost:8080/file/beforeUpload
	 * 文件上传之前的准备工作
	 * @param name
	 * @param totalSize
	 * @param lastModified
	 * @return
	 */
	@RequestMapping("/beforeUpload")
	public Map<String, Object> beforeUpload(@RequestBody FileSlice fileSlice) {
		System.out.println("beforeUpload fileSlice=>"+fileSlice);
		int slice = 0;//文件是否续传
		String uuid = "";//文件唯一标志
		Map<String, Object> result = new HashMap<String, Object>();
		//根据文件信息查询文件是否续传
		uuid = PropUtil.queryUUIDbyFileinfo(fileSlice.getName(), fileSlice.getTotalSize());
		System.err.println(uuid);
		System.err.println(fileSlice.getFid());
		if(uuid == null) {//新文件上传			
			
			uuid = PropUtil.createUUIDbyFileinfo(fileSlice.getName(), fileSlice.getTotalSize());
			fileSlice.setFid(uuid);//新文件ID
			fileSlice.setPoint(0L);//新文件断点从头开始
			System.out.println("新文件上传=>"+fileSlice);
			//新文件传输开始,把FileSlice传输状态记录在磁盘
			PropUtil.createFileSlice(fileSlice);
			result.put("slice", 0);//新文件
			result.put("uuid", uuid);//文件唯一标志
			result.put("fileSlice", fileSlice);//文件上传状态
			return result;
			
		}else {			
			fileSlice = PropUtil.queryFileSliceByFid(uuid);//查询出文件上次传输断点位置
			System.out.println("FileSliceUploadController.beforeUpload(FileSlice) 断点续传=>"+fileSlice);
			result.put("slice", 1);//断点续传
			result.put("uuid", uuid);//文件唯一标志
			result.put("fileSlice", fileSlice);//文件上传状态
			return result;
		}
	}
	
	 //http://localhost:8080/file/sliceUpload
	//大文件分片上传,支持断点续传
    @RequestMapping("/sliceUpload")
	public Object sliceUpload(@RequestParam(value="myfile",required=false) MultipartFile myfile,@RequestParam(value="fid",required=true) String fid){
		String name = myfile.getName();//form表单中参数名称
		String originalFilename = myfile.getOriginalFilename();//得到上传文件的名称
		System.out.println("表单中文件参数名称 name=>"+name);
		System.out.println("上传的文件原始名称 originalfileName=>"+originalFilename);
		System.out.println("文件 fid=>"+fid);
		String msg  = "文件大小=>"+myfile.getSize();
		FileSlice fileSlice = PropUtil.queryFileSliceByFid(fid);//查询出文件上次传输断点位置
		byte[] sliceData = null;//本次上传的字节数据
		try {
			sliceData = myfile.getBytes();//本次上传的字节数据
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		FileSlice resultSlice = SliceUtil.writeSlice(fileSlice, sliceData);
		PropUtil.updateFileSlice(resultSlice);//更新传输状态
		int slice = 1;//文件是否续传
		String uuid = fid;//文件唯一标志
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("slice", 1);//断点续传
		result.put("uuid", uuid);//文件唯一标志
		result.put("fileSlice", resultSlice);//更新后的文件上传状态
		return result;
	}
    //http://localhost:8080/file/sliceUploadOver
   	//文件分片上传,传输完毕.删除所有传输状态记录
    @RequestMapping("/sliceUploadOver")
   	public Object sliceUploadOver(@RequestBody FileSlice fileSlice){
    	System.out.println("sliceUploadOver fileSlice=>"+fileSlice);    	
    	//根据文件信息,删除文件的UUID;并删除记录在fileslice.properties文件信息
    	PropUtil.deleteUUIDbyFileinfo(fileSlice.getName(), fileSlice.getTotalSize());
    	//删除uuid.properties文件
    	PropUtil.deleteFileSlice(fileSlice.getFid());
    	
    	String classpath ="D:\\1602Demo\\file\\src\\main\\resources\\static\\";
    	
    	FileM fileM=new FileM();
    	String suffix = fileSlice.getName().substring(fileSlice.getName().lastIndexOf("."));//后缀	
   		if (suffix.equals(".mp4")||suffix.equals(".mp3")) {
   			fileM.setFileName(fileSlice.getFid()+suffix);
			fileM.setFileOldName(fileSlice.getName());
			fileM.setFileSize(fileSlice.getTotalSize()+"b");
			Integer sc=	VideoAudioUtils.getVideoSecond(classpath+fileSlice.getFid()+suffix);
			fileM.setFileTime(sc.toString());//文件时长
			fileM.setFileType(suffix);
			fileM.setFileUrl(classpath);
		}else {
			fileM.setFileName(fileSlice.getFid()+suffix);
			fileM.setFileOldName(fileSlice.getName());
			fileM.setFileSize(fileSlice.getTotalSize()+"b");
			fileM.setFileType(suffix);
			fileM.setFileUrl(classpath);
		}
   		
    	Integer a=fileService.insertFileByFile(fileM);
    	
    	Map<String, Object> result = new HashMap<String, Object>();
   		result.put("slice", 1);//断点续传
   		result.put("uuid", fileSlice.getFid());//文件唯一标志
   		result.put("fileSlice", fileSlice);//更新后的文件上传状态
   		return result;
   	}

}
