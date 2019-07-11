package com.cafe24.shoppingmall.config.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"com.cafe24.shoppingmall.controller"})
@Import({MVCConfig.class, /*SecurityConfig.class,*/ MessageConfig.class, /*FileUploadConfig.class,*/ SwaggerConfig.class})
public class WebConfig {
	
	
}
