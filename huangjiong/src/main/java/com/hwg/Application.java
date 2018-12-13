package com.hwg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;


@SpringCloudApplication // springBoot启动类
public class Application {
	   public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	   }
}
 