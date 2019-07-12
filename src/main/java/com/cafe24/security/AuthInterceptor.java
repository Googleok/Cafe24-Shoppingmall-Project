package com.cafe24.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cafe24.shoppingmall.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception{
		// 1. handler 종류 확인
		// 종류의 두가지  HandlerMethod, DefaultServletHandler
		// handlermethod가 아닌 assets 나 image 파일들이 interceptor에 걸리지 않게 설정해주는 것
		if(handler instanceof HandlerMethod == false ) {
			return true;
		}
		
		// 2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		// 3. Method의 @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		// 4. method에 @Auth가 없는 경우, 즉 인증이 필요 없는 요청
		if(auth == null) {
			return true;
		}
		
		// 5. @Auth가 있는 경우이므로, 세션이 있는지 체크
		HttpSession session = request.getSession();
		if(session == null) {
			// 로그인 화면으로 이동
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		// 6. 세션이 존재하면 유효한 유저인지 확인
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if (authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		// 7. admin일 경우
		String role = auth.role().toString();
		if("ADMIN".equals(role)) {
			// admin임을 알 수 있는 조건을 작성한다.
			// ex ) 서비스의 id가 admin이면 admin이다.
			if("admin".equals(authUser.getId()) == false) {
				response.sendRedirect(request.getContextPath());
				return false;
			}
		}

		// 8. 접근허가, 즉 메서드를 실행하도록 함
		return true;
	}
}
