package com.dd.recipeLib.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

//로그인 실패시 로직 설정
public class LoginFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		if(exception instanceof InternalAuthenticationServiceException || 
				exception instanceof BadCredentialsException	) {
			request.setAttribute("errMsg", "NotMatched.user");
		}
		
		request.getRequestDispatcher("/recipeLib/login").forward(request, response);
	}
}
