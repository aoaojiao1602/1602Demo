package com.xiaozuanfeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringCloudApplication
public class Applications {
	public static void main(String[] args) {
		SpringApplication.run(Applications.class, args);
	}
}
