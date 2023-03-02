package com.wk68.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wk68.interceptor.LoginInterceptor;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
    private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
        .addPathPatterns("/**").excludePathPatterns("/login","/phoneIsNull","/affirmVerificationCode",
        		"/updatePassword","/verificationCode","/chat-room/{username}","/myHandler");
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE");
	}
	
}
