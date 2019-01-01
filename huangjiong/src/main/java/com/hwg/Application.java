package com.hwg;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @Descripti5n 项目启动类（sprintCloud）
 * @author HJiong
 * @time 2018年12月14日 上午12:14:49
 */
@EnableSwagger2
@EnableFeignClients
@SpringCloudApplication // sprintCloud启动类
public class Application {
	   public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	   }
}
 