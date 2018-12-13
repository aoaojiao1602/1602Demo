package com.lwj.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @Description:   Swagger配置类
 * @ClassName:     Swagger2Config.java 
 * @author         MaShuai 
 * @Date           2018年8月11日 下午4:00:28  
 * @Email          1119616605@qq.com
 */
@Configuration
//@EnableSwagger2
public class Swagger2Config {
	@Bean
	public Docket createRestApi() {
		//扫描控制器中Swagger2的注解
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.lwj.springcloud.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	//API描述信息
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SpringCloud 刘文金组 api文档")
				.description("MS:简单优雅的restful风格.Spring官方Maven仓库 https://repo.spring.io/milestone")
				.termsOfServiceUrl("https://repo.spring.io/milestone")
				.version("1.0")
				.build();
	}

}
