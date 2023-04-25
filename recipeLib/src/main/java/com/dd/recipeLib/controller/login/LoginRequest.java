package com.dd.recipeLib.controller.login;

import javax.validation.constraints.NotBlank;

import lombok.*;

@Getter @Setter
@ToString
public class LoginRequest {

	@NotBlank
	private String userId;
	
	@NotBlank
	private String pwd;
}
