package com.dd.recipeLib.controller.join;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class JoinRequest {

	private Long idx;
	@NotBlank @Size(min=6)
	private String id;
	@NotBlank @Size(min=8, max=15)
	@Pattern(regexp = "^([a-zA-Z].+)(\\w{7,14})")
	private String pwd;
	private String pwdCheck;
	@NotBlank
	private String name;
	@NotBlank @Email
	private String email;
	@AssertTrue
	private boolean agree;
}
