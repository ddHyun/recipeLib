package com.dd.recipeLib.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		boolean isUser = authentication.getAuthorities().stream()
									.anyMatch(r -> r.getAuthority().equals("ROLE_USER"));
		String url = "/recipeLib/main";
		
		if(!isUser) {
			url = "/recipeLib/admin";
		}
		
		response.sendRedirect(url);
	}
}
