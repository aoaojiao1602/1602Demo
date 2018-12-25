package com.lwj.springcloud.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.lwj.springcloud.websocket.SpringBootHandshakeInterceptor;
import com.lwj.springcloud.websocket.SpringBootWebSocketHandler;

/**
 * 项目名称：mavenDemo_Lwj
 * 类名称：MyWebSocketConfig
 * 类描述：
 * 创建人：rain
 * 创建时间：2018年10月30日 上午10:06:35
 * 修改人：rain
 * 修改时间：2018年10月30日 上午10:06:35
 * 修改备注：
 * @version
 *
*/
@Configuration
@EnableWebSocket //启动WebSocket服务器
public class SpringBootConfigurer implements WebMvcConfigurer, WebSocketConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//允许所有域名下的客户端以任意请求方式跨域访问本项目下的任意URL
		registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
	}

	
	/* (非 Javadoc) 
	 * <p>Title: configurePathMatch</p> 
	 * <p>Description: </p> 
	 * @param configurer 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#configurePathMatch(org.springframework.web.servlet.config.annotation.PathMatchConfigurer) 
	*/
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// TODO Auto-generated method stub
		/**
		 * configurePathMatch(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: configureContentNegotiation</p> 
	 * <p>Description: </p> 
	 * @param configurer 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#configureContentNegotiation(org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer) 
	*/
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO Auto-generated method stub
		/**
		 * configureContentNegotiation(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: configureAsyncSupport</p> 
	 * <p>Description: </p> 
	 * @param configurer 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#configureAsyncSupport(org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer) 
	*/
	
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		// TODO Auto-generated method stub
		/**
		 * configureAsyncSupport(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: configureDefaultServletHandling</p> 
	 * <p>Description: </p> 
	 * @param configurer 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer) 
	*/
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		/**
		 * configureDefaultServletHandling(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: addFormatters</p> 
	 * <p>Description: </p> 
	 * @param registry 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addFormatters(org.springframework.format.FormatterRegistry) 
	*/
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		/**
		 * addFormatters(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: addInterceptors</p> 
	 * <p>Description: </p> 
	 * @param registry 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry) 
	*/
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		/**
		 * addInterceptors(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: addResourceHandlers</p> 
	 * <p>Description: </p> 
	 * @param registry 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry) 
	*/
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		/**
		 * addResourceHandlers(这里用一句话描述这个方法的作用)
		*/
		/*registry.addResourceHandler("/**").addResourceLocations("/");*/
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/");
	}

	
	/* (非 Javadoc) 
	 * <p>Title: addViewControllers</p> 
	 * <p>Description: </p> 
	 * @param registry 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry) 
	*/
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		/**
		 * addViewControllers(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: configureViewResolvers</p> 
	 * <p>Description: </p> 
	 * @param registry 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#configureViewResolvers(org.springframework.web.servlet.config.annotation.ViewResolverRegistry) 
	*/
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		/**
		 * configureViewResolvers(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: addArgumentResolvers</p> 
	 * <p>Description: </p> 
	 * @param argumentResolvers 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addArgumentResolvers(java.util.List) 
	*/
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO Auto-generated method stub
		/**
		 * addArgumentResolvers(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: addReturnValueHandlers</p> 
	 * <p>Description: </p> 
	 * @param returnValueHandlers 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#addReturnValueHandlers(java.util.List) 
	*/
	
	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		/**
		 * addReturnValueHandlers(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: configureMessageConverters</p> 
	 * <p>Description: </p> 
	 * @param converters 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#configureMessageConverters(java.util.List) 
	*/
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		/**
		 * configureMessageConverters(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: extendMessageConverters</p> 
	 * <p>Description: </p> 
	 * @param converters 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#extendMessageConverters(java.util.List) 
	*/
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		/**
		 * extendMessageConverters(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: configureHandlerExceptionResolvers</p> 
	 * <p>Description: </p> 
	 * @param exceptionResolvers 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#configureHandlerExceptionResolvers(java.util.List) 
	*/
	
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		/**
		 * configureHandlerExceptionResolvers(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: extendHandlerExceptionResolvers</p> 
	 * <p>Description: </p> 
	 * @param exceptionResolvers 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#extendHandlerExceptionResolvers(java.util.List) 
	*/
	
	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO Auto-generated method stub
		/**
		 * extendHandlerExceptionResolvers(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: getValidator</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#getValidator() 
	*/
	
	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
		/**
		 * getValidator(这里用一句话描述这个方法的作用)
		*/
		
	}

	
	/* (非 Javadoc) 
	 * <p>Title: getMessageCodesResolver</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#getMessageCodesResolver() 
	*/
	
	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO Auto-generated method stub
		return null;
		/**
		 * getMessageCodesResolver(这里用一句话描述这个方法的作用)
		*/
		
	}


	
	/* (非 Javadoc) 
	 * <p>Title: registerWebSocketHandlers</p> 
	 * <p>Description: </p> 
	 * @param registry 
	 * @see org.springframework.web.socket.config.annotation.WebSocketConfigurer#registerWebSocketHandlers(org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry) 
	*/
	@Autowired
	private SpringBootWebSocketHandler handler;
	@Autowired
	private SpringBootHandshakeInterceptor handshakeInterceptor;
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
			//-------------------- 允许跨域访问WebSocket ------------------------
		      String[] allowsOrigins = {"*"};//允许连接的域,只能以http或https开头 
		      /**
		  	 * http://localhost:8080
		  	 * http://localhost:8080/index.html
		  	 */
		      //7. 设置websocket服务器地址     ws://localhost:8080/SpringBootWebSocketupdateStudentExamInfo
			registry.addHandler(handler, "/webSocketjoin").addInterceptors(handshakeInterceptor).setAllowedOrigins(allowsOrigins);
//			registry.addHandler(handler, "/SpringBootWebSocket/sockjs").addInterceptors(handshakeInterceptor).setAllowedOrigins(allowsOrigins).withSockJS();//兼容以前老版本的sockJS
			
		}


	
}
