package com.dd.recipeLib.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.recipeLib.controller.login.SearchInfoRequest;
import com.dd.recipeLib.model.user.UserEntity;
import com.dd.recipeLib.model.user.UserRepository;

@Service
public class SearchInfoService {

	@Autowired
	private UserRepository userRepository;
	
	public String process(SearchInfoRequest searchInfoRequest) {
		
		String userNm = searchInfoRequest.getUserNm();
		String email = searchInfoRequest.getEmail();
		String userId = searchInfoRequest.getUserId();
//		String result = "";
		UserEntity userEntity;
		
		if(userNm != null) {//id찾기
			userEntity = userRepository.findByUserNmAndEmail(userNm, email).orElse(null);
		}else {
			userEntity = userRepository.findByUserIdAndEmail(userId, email).orElse(null);
			
		}
			
//		if(userId != null) {//비밀번호찾기
//		}
//		
//			if(userEntity != null) {
//				result = userEntity.getUserId();
//			}else {
//				result = "noResult";
//			}
//		
//			
//			if(userEntity != null) {
//				result = userEntity.getUserId();
//			}else {
//				result = "noResult";
//			}
		
		return (userEntity != null) ? userEntity.getUserId() : "noResult";
	}
}
