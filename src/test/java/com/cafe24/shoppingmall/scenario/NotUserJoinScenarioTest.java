package com.cafe24.shoppingmall.scenario;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cafe24.shoppingmall.config.test.AppConfig;
import com.cafe24.shoppingmall.config.test.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class NotUserJoinScenarioTest {

}
