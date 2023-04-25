package com.dd.recipeLib.controller.login;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SearchInfoValidator implements Validator{

@Override
	public boolean supports(Class<?> clazz) {
		return SearchInfoRequest.class.isAssignableFrom(clazz);
	}

@Override
	public void validate(Object target, Errors errors) {
		
	SearchInfoRequest searchRequest = (SearchInfoRequest) target;
		
		String userId = searchRequest.getUserId();
		String userNm = searchRequest.getUserNm();
		String email = searchRequest.getEmail();
		String pwdRe = searchRequest.getPwdRe();
		String pwdReCheck = searchRequest.getPwdReCheck();
		
		if(userNm != null && userNm.isBlank()) {
			errors.rejectValue("userNm", "NotBlank.userNm");
		}
		
		if(userId != null && userId.isBlank()) {
			errors.rejectValue("userId", "NotBlank.userId");
		}
		
		if(email.isBlank()) {
			errors.rejectValue("email", "NotBlank.email");
		}
		
		if(pwdRe != null) {
			if(pwdRe.isBlank()) {
				errors.rejectValue("pwdRe", "NotBlank.pwd");
			}
			if(!pwdRe.equals(pwdReCheck)) {
				errors.rejectValue("pwdReCheck", "NotEqual.pwdCheck");
			}
		}
	}
}
