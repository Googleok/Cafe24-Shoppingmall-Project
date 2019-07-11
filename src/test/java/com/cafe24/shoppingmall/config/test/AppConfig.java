package com.cafe24.shoppingmall.config.test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"com.cafe24.shoppingmall.service", "com.cafe24.shoppingmall.repository","com.cafe24.shoppingmall.aspect"})
@Import({DBConfig.class, MyBatisConfig.class})
public class AppConfig {
}
