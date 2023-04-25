package com.dd.recipeLib.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

//인증되지 않은 사용자가 페이지(또는 리소스) 요청시 unauthorizedError 발생 관련 실제구현 클래스
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		 response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		//인증되지 않은 사용자가 권한 없는 페이지 접근시 main으로 이동
//		response.sendRedirect(request.getContextPath()+"/main");
//		response.sendRedirect("/recipeLib/main");
	}
}
