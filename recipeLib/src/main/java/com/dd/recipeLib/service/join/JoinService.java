package com.dd.recipeLib.service.join;

import org.mindrot.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.recipeLib.controller.join.JoinRequest;
import com.dd.recipeLib.model.user.UserEntity;
import com.dd.recipeLib.model.user.UserRepository;

@Service
public class JoinService {

	@Autowired
	private UserRepository userRepository;
	
	public void process(JoinRequest joinRequest) {
		
		//비밀번호 암호화
		String pwd = BCrypt.hashpw(joinRequest.getPwd().trim(), BCrypt.gensalt(12));
		
		//엔티티 DB에 저장
		UserEntity userEntity = UserEntity.builder()
															.id(joinRequest.getId())
															.pwd(pwd)
															.name(joinRequest.getName())
															.email(joinRequest.getEmail())
															.build();
		
		userRepository.save(userEntity);
	}
}
