package com.ysd.boot.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.boot.entity.FileM;
import com.ysd.boot.service.FileService;
import com.ysd.boot.utils.VideoAudioUtils;

/**
 * Spring Boot HelloWorld 案例
 */
@CrossOrigin
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	
	@Autowired
	private FileService fileService;
	

    //小文件直接上传
    @RequestMapping("/upload")
	public Object upload(@RequestParam(value="myfile",required=false) MultipartFile myfile,@RequestParam(value="desc",required=false) String desc){
    	
    	
    	
    	String name = myfile.getName();//form表单中参数名称
		String originalFilename = myfile.getOriginalFilename();//得到上传文件的名称		
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));//后缀	
    	String fileName =UUID.randomUUID().toString().replaceAll("-", "")+suffix;
    	String classpath ="D:\\1602Demo\\file\\src\\main\\resources\\db\\";
    	
		try {
			OutputStream output = new FileOutputStream(new File(classpath+fileName));
			IOUtils.copy(myfile.getInputStream(), output);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		FileM fileM=new FileM();
    	
    	if (suffix.equals(".mp4")||suffix.equals(".mp3")) {
   			fileM.setFileName(fileName);
			fileM.setFileOldName(originalFilename);
			fileM.setFileSize(myfile.getSize()+"b");
			Integer sc=	VideoAudioUtils.getVideoSecond(classpath+fileName);
			fileM.setFileTime(sc.toString());//文件时长
			fileM.setFileType(suffix);
			fileM.setFileUrl(classpath);
		}else {
			fileM.setFileName(fileName);
			fileM.setFileOldName(originalFilename);
			fileM.setFileSize(myfile.getSize()+"b");
			fileM.setFileType(suffix);
			fileM.setFileUrl(classpath);
		}
		
    	String result;
		if (fileService.insertFileByFile(fileM)>0) {
			result="springcloud-file上传成功:   "+fileName;
		} else {
			result="springcloud-file上传失败:   "+fileName;
		}
		return result;
	}
    
    
     
   
}
