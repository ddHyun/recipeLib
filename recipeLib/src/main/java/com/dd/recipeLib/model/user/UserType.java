package com.dd.recipeLib.model.user;

import lombok.Getter;

@Getter
public enum UserType {

	USER("사용자"), ADMIN("관리자"), SUPERADMIN("전체관리자");
	
	private String typeNm;
	
	UserType(String typeNm) {
		this.typeNm = typeNm;
	}
}
