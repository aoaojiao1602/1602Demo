package com.xiaozuanfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@EnableFeignClients
@SpringCloudApplication
public class Applications {
	public static void main(String[] args) {
		SpringApplication.run(Applications.class, args);
	}
}
