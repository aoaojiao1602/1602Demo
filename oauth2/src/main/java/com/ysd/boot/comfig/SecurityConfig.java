package com.ysd.boot.comfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.ysd.boot.service.impl.UserDetailsServiceImpl;

@Configuration
/*@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)*/
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	// 拦截所有请求,使用httpBasic方式登陆
	
	  @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService);
	    }
	  
	  
	// 配置HttpSecurity 拦截资源
		protected void configure(HttpSecurity http) throws Exception {
			//所有请求都需要SpringSecurity认证授权
			http.authorizeRequests().antMatchers("/**").fullyAuthenticated()
			.and().csrf().disable()
			.formLogin();
		
		}
	
	
	
}
