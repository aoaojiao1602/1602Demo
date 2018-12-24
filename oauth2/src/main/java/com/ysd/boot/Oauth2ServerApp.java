package com.ysd.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * SpringCloud-Oauth2 认证授权服务中心
 * @author MaShuai
 *
 */
@EnableFeignClients
@SpringCloudApplication 
public class Oauth2ServerApp {
	public static void main(String[] args) {
		SpringApplication.run(Oauth2ServerApp.class, args);
	}
}
