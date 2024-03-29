package com.cafe24.shoppingmall.config.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@PropertySource("classpath:com/cafe24/config/web/properties/multipart.properties")
public class FileUploadConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment env;
	//
	// Multipart Resolver
	//
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver
			= new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(env.getProperty("maxUploadSize", Integer.class));
		multipartResolver.setMaxInMemorySize(env.getProperty("maxInMemorySize", Integer.class));
		multipartResolver.setDefaultEncoding(env.getProperty("defaultEncoding"));
		
		return multipartResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("file:/cafe24-shoppingmall-uploads/");
	}
	
	
}
