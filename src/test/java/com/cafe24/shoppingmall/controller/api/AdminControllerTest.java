package com.cafe24.shoppingmall.controller.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.cafe24.shoppingmall.vo.ProductVo;
import com.cafe24.shoppingmall.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class AdminControllerTest {
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	// 상품리스트  요청 Test
	@Test
	public void testGetProductList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product"))
				.andExpect(status().isOk())
				.andDo(print());

	}

	// 상품하나만  요청 Test
	@Test
	public void testGetProductOne() throws Exception {

		Long productNo = 1L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/{no}", productNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	

	// 상품등록  Test
	@Test
	public void testAddProduct() throws Exception {
		ProductVo voMock = new ProductVo(1L, "모자", 30000L, "2019-07-11", true,
				false, true, 1L, 400L, "cap.html",
				2500L, 3L);
		
		ResultActions resultActions = 
				mockMvc
				.perform(post("/api/admin/product")
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상품수정  Test
	@Test
	public void testModifyProduct() throws Exception {
		ProductVo voMock = new ProductVo();
		voMock.setName("가죽자켓");
		voMock.setPrice(120000L);
		
		Long modifyNo = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/product/{modifyNo}", modifyNo)
				.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상품삭제  Test
	@Test
	public void testDeleteProduct() throws Exception {
		Long deleteNo = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/product/{deleteNo}", deleteNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상품검색리스트  요청 Test
	@Test
	public void testGetProductSearchList() throws Exception {
		String keyword = "cap";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/product/search?keyword={keyword}", keyword))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
	// ===================================================================================================
	
	// 주문리스트  요청 Test
	@Test
	public void testGetOrderList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order"))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
	// 주문한개  요청 Test
	@Test
	public void testGetOrderOne() throws Exception {

		Long orderNo = 1L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order/{no}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 상세주문  요청 Test
	@Test
	public void testGetOrderDetail() throws Exception {

		Long orderNo = 2L;
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order/detail/{no}", orderNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	
	// 입금확인체크  Test
	@Test
	public void testOrderDepositCheck() throws Exception {
		Long orderDetailNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/order/depositcheck/{orderDetailNo}", orderDetailNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 배송출발체크  Test
	@Test
	public void testOrderDeliveryCheck() throws Exception {
		Long orderDetailNo = 1L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(put("/api/admin/order/deliverycheck/{orderDetailNo}", orderDetailNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 주문검색리스트  요청 Test
	@Test
	public void testGetOrderSearchList() throws Exception {
		String keyword = "01040287755";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/order/search?keyword={keyword}", keyword))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
	// ======================================================================================
	
	// 회원관리
	
	// 회원리스트 요청 Test
	@Test
	public void testGetUserList() throws Exception {
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/user"))
				.andExpect(status().isOk())
				.andDo(print());

	}

	// 회원삭제  Test
	@Test
	public void testDeleteUser() throws Exception {
		Long deleteNo = 2L;
		
		ResultActions resultActions = 
				mockMvc
				.perform(delete("/api/admin/user/{deleteNo}", deleteNo))
				.andExpect(status().isOk())
				.andDo(print());
	}	
	
	// 회원정보수정  Test
	@Test
	public void testModifyUser() throws Exception {
		UserVo voMock = new UserVo();
		voMock.setPhone("01012345678");
		voMock.setGender("female");
		
		Long modifyNo = 2L;
		
		ResultActions resultActions = 
					mockMvc
					.perform(put("/api/admin/user/{modifyNo}", modifyNo)
					.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
					.andExpect(status().isOk())
					.andDo(print());
	}	
	
	// 회원검색리스트  요청 Test
	@Test
	public void testGetUserSearchList() throws Exception {
		String keyword = "박종억";
		ResultActions resultActions = 
				mockMvc
				.perform(get("/api/admin/user/search?keyword={keyword}", keyword))
				.andExpect(status().isOk())
				.andDo(print());

	}
	
}

