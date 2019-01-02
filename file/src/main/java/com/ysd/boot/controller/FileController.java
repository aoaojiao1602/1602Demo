package com.ysd.boot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ysd.boot.entity.FileM;
import com.ysd.boot.service.FileService;
import com.ysd.boot.utils.VideoAudioUtils;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;


/**
 * 
 * @Description:   Feign 文件上传服务提供者
 * @ClassName:     FileProviderController.java 
 * @author         Administrator 
 * @Date           2018年12月7日 下午11:57:21  
 * @Email          1119616605@qq.com
 */
@CrossOrigin
@RestController
public class FileController {
	
	@Autowired
	private FileService fileServicel;
			
	/**
     * 文件（二进制数据）下载
     * @param fileType 文件类型
     * @return
     */
    @RequestMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(String fileName,HttpServletRequest request ){
    	String classpath ="C:\\Users\\Administrator\\git\\1602Demo\\file\\src\\main\\resources\\db\\";	
    	String filePath=classpath+fileName;    	        
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> entity = null;
        InputStream in=null;
         try {
          in=new FileInputStream(new File(filePath));
            
          byte[] bytes = new byte[in.available()];
            
          String imageName=fileName;
           
          //处理IE下载文件的中文名称乱码的问题
          String header = request.getHeader("User-Agent").toUpperCase();
          if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
              imageName = URLEncoder.encode(imageName, "utf-8");
              imageName = imageName.replace("+", "%20");    //IE下载文件名空格变+号问题
          } else {
              imageName = new String(imageName.getBytes(), "iso-8859-1");
          }
            
          in.read(bytes);
           
          headers.add("Content-Disposition", "attachment;filename="+imageName);
            
          entity = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
           
      } catch (Exception e) {
          e.printStackTrace();
      }finally {
          if(in!=null) {
              try {
                  in.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
        
         return entity;
    }
    
    /***
	 * 查询所有文件信息
	 * @return
	 */
    @GetMapping("getAll")
	public List<FileM> getAll(){
		
		return fileServicel.getAll();
	}
    
}
