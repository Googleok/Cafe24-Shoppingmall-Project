package com.cafe24.shoppingmall.controller.api;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Ignore;
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
import com.cafe24.shoppingmall.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, WebConfig.class})
@WebAppConfiguration
public class UserControllerTest {

		private MockMvc mockMvc;
		
		@Autowired
		private WebApplicationContext webApplicationContext;
	
		@Before
		public void setup() {
			mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		}
		
		
		@Test
		public void testJoin() throws Exception{
			UserVo voMock = new UserVo(1L, "whddjr2225", "Whddjr129", "박종억", "01040287755", "whddjr2225@naver.com", "1993-11-02", "MALE");
	
			ResultActions resultActions =
					mockMvc
					.perform(post("/api/user/join")
					.contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(voMock)))
					.andExpect(status().isOk())
					.andDo(print());
		}
		
		@Test
		public void testCheckEmail() throws Exception {
		
			String userEmail = "qkrwhddjr3@gmail.com";
			
			ResultActions resultActions = 
					mockMvc
					.perform(get("/api/user/checkemail?email={email}", userEmail))
					.andExpect(status().isOk())
					.andDo(print());
	
		}
	
		@Test
		public void testUserLogin() throws Exception{
			UserVo userVo = new UserVo();
			   
			// 1. Normal User's Login Data
			userVo.setEmail("whddjr2225@naver.com");
			userVo.setPassword("Whddjr129");
			   
			ResultActions resultActions = 
			        mockMvc
			        .perform(post("/api/user/login")
			        .contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo))); // 없는 url
			            
			resultActions
		    .andExpect(status().isOk())
		    .andDo(print());
		   
		   // 2. Invalidation in Email :
		   userVo.setEmail("whddjr222");
		   userVo.setPassword("Whddjr129");
		   
		   resultActions = 
		            mockMvc
		            .perform(post("/api/user/login")
		            .contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo))); // 없는 url
		            
		   resultActions
	       .andExpect(status().isBadRequest())
	       .andDo(print())
	       .andExpect(jsonPath("$.result", is("fail")));
		   
		   // 3. Invalidation in Password :
		   userVo.setEmail("whddjr2225@naver.com");
		   userVo.setPassword("Whddjr");
		   
		   resultActions = 
		            mockMvc
		            .perform(post("/api/user/login")
		            .contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(userVo))); // 없는 url
		            
		   resultActions
	       .andExpect(status().isBadRequest())
	       .andDo(print())
	       .andExpect(jsonPath("$.result", is("fail")));
		   
	   }



}
