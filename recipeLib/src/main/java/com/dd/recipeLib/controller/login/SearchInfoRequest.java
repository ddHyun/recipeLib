package com.dd.recipeLib.controller.login;

import lombok.*;

@Getter @Setter
public class SearchInfoRequest {

	private String userId;
	private String userNm;
	private String pwdRe;
	private String pwdReCheck;
	private String email;
}
