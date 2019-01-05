package com.ysd.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SpringCloud-Oauth2 认证授权服务中心
 * @author MaShuai
 *
 */
@EnableFeignClients
@EnableSwagger2
@SpringCloudApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
