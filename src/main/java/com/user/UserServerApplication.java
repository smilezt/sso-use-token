package com.user;

import com.user.interceptor.SessionInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class UserServerApplication extends WebMvcConfigurerAdapter {
	public static void main(String[] args) {
		SpringApplication.run(UserServerApplication.class, args);
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor()).addPathPatterns("/user/*");
	}
	@Bean
	public SessionInterceptor sessionInterceptor(){
		return new SessionInterceptor();
	}
}