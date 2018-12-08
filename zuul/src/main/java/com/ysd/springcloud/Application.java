package com.ysd.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 
 * @Description:   
 * @ClassName:     Application.java
 * @author         Mashuai
 * @Date           2018年8月24日 下午12:46:06
 * @Email          1119616605@qq.com
 */
@EnableZuulProxy
@SpringCloudApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
