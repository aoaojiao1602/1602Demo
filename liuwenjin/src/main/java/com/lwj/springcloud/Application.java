package com.lwj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @Description:   
 * @ClassName:     Application.java
 * @author         Mashuai
 * @Date           2018年8月22日 下午3:08:10
 * @Email          1119616605@qq.com
 */
//@EnableHystrix  === ( @EnableCircuitBreaker )
//@EnableEurekaClient === ( @EnableDiscoveryClient )
//@SpringBootApplication
//@SpringCloudApplication //=== ( @SpringBootApplication + @EnableDiscoveryClient + @EnableCircuitBreaker)
@SpringCloudApplication // ===( @EnableEurekaClient + @EnableHystrix + @SpringBootApplication )pom.xml必须引Eureka、Hystrix依赖
@EnableSwagger2
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
