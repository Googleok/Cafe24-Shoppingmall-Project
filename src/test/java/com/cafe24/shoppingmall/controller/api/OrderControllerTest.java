package com.cafe24.shoppingmall.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.shoppingmall.config.test.AppConfig;
import com.cafe24.shoppingmall.config.test.WebConfig;
import com.cafe24.shoppingmall.vo.OrderVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class OrderControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	// 주문내역  요청 Test
	@Test
	public void testGetOrderOne() throws Exception {

		String id = "whddjr2225";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/order/{id}", id))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상세주문  요청 Test
	@Test
	public void testGetOrderDetail() throws Exception {

		Long orderNo = 2L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/order/detail/{no}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상품주문 Test
	@Test
	public void testProductOrder() throws Exception {
		Long authUser = 1L;
		OrderVo voMock = new OrderVo(1L, "박종억", "1234", "01040287755", "whddjr2225@naver.com",
				"서울시 관악구", "2019-07-12", "빨리요", 2500L, 185000L, authUser);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/order")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	// 상품결제 Test
	@Test
	public void testPayOrder() throws Exception {
		Long orderNo = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/order/payment/{orderNo}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}
}
