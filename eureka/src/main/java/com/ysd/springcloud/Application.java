package com.ysd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @Description:   
 * @ClassName:     Application.java
 * @author         Mashuai
 * @Date           2018年8月22日 下午2:22:42
 * @Email          1119616605@qq.com
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
