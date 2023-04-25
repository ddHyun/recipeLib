package com.dd.recipeLib.service.login;

import org.mindrot.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.dd.recipeLib.controller.login.LoginRequest;
import com.dd.recipeLib.model.user.UserEntity;
import com.dd.recipeLib.model.user.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public void process(LoginRequest loginRequest, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}
		
		//아이디, 비밀번호 일치 확인
		String userId = loginRequest.getUserId();
		UserEntity userEntity = userRepository.findByUserId(userId).orElse(null);

		if(userEntity != null) {//아이디 존재하지만
			boolean equal = BCrypt.checkpw(loginRequest.getPwd(), userEntity.getPwd());
			if(!equal) {//비밀번호가 일치하지 않는 경우
				errors.reject("NotMatched.user");
			}
		}else {//아이디 없을 경우
			errors.reject("NotExisted.user");
		}
		
//		if(userEntity == null || !equal) {//아이디 존재하지 않거나 비번이 일치하지 않을 경우
//			errors.rejectValue("user", "NotMatched.user");
//			errors.reject("NotMatched.user");
//		}
		
//		if(!equal) {
//			errors.rejectValue("pwd", "NotEqual.pwd");
//		}
	}
}
