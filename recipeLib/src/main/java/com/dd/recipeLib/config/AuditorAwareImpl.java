package com.dd.recipeLib.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//작성자, 수정자 자동 등록 설정
public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String userId = "";
		if(authentication != null) {
			userId = authentication.getName();
		}
		
		return Optional.of(userId);
	}
}
