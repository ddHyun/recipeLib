package com.dd.recipeLib.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dd.recipeLib.model.user.UserEntity;
import com.dd.recipeLib.model.user.UserRepository;

//인증된 유저 조회, 정보를 담기 위한 클래스
@Service
public class UserInfoService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findByUserId(userId)	.orElseThrow();
		
		return User.builder()
							.username(userEntity.getUserId())
							.password(userEntity.getPwd())
							.roles(userEntity.getType().toString())
							.build();
	}
}
