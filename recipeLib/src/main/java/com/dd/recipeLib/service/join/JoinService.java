package com.dd.recipeLib.service.join;

//import org.mindrot.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dd.recipeLib.controller.join.JoinRequest;
import com.dd.recipeLib.model.user.UserEntity;
import com.dd.recipeLib.model.user.UserRepository;

@Service
public class JoinService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	
	//회원가입
	public void process(JoinRequest joinRequest) {
		
		//비밀번호 암호화
		String pwd = passwordEncoder.encode(joinRequest.getPwd());
		
		//엔티티 DB에 저장
		UserEntity userEntity = UserEntity.builder()
															.userId(joinRequest.getUserId())
															.pwd(pwd)
															.userNm(joinRequest.getUserNm())
															.email(joinRequest.getEmail())
															.build();
		
		userRepository.save(userEntity);
	}
}
