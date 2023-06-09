package com.dd.recipeLib.controller.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dd.recipeLib.model.user.UserEntity;
import com.dd.recipeLib.model.user.UserRepository;

@Component
public class JoinValidator implements Validator{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		//유효성 검사 대상을 JoinRequest로 한정시키기
		return JoinRequest.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		
		//Object -> 커맨드객체 형변환
		JoinRequest joinRequest = (JoinRequest)target;

		//오류문구는 messages에서 관리
		//아이디 중복 여부
		String userId = joinRequest.getUserId().trim();
		if(userId != null && !userId.isBlank()) {			
			UserEntity userEntity = userRepository.findByUserId(userId).orElse(null);
			if(userEntity != null && userId.equals(userEntity.getUserId())) {
				errors.rejectValue("userId", "Duplicated.userId");
			}
		}
		
		//비밀번호 일치여부
		String pwd = joinRequest.getPwd();
		String pwdCheck = joinRequest.getPwdCheck(); 
		if(!pwd.isBlank() && !pwdCheck.isBlank() && !pwd.equals(pwdCheck)) {
			errors.rejectValue("pwdCheck", "NotEqual.pwdCheck");
		}
	}
}
