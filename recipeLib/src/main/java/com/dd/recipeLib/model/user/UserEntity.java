package com.dd.recipeLib.model.user;

import javax.persistence.*;

import com.dd.recipeLib.common.BaseEntity;

import lombok.*;

@Entity
@Table(name = "user")
@Getter @ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseEntity{

	@Id @GeneratedValue
	private Long idx;
	
	@Column(nullable = false, length=20)
	private String userId;
	
	@Column(nullable=false)
	private String pwd;
	
	@Column(nullable=false, length=20)
	private String userNm;
	
	@Column(nullable=false, length=50)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private UserType type = UserType.USER;
	
	@Column(nullable=false)
	private  boolean isDeleted = false;
	
	@Builder
	public UserEntity(Long idx, String userId, String pwd, String userNm, String email) {
		this.idx = idx;
		this.userId = userId;
		this.pwd = pwd;
		this.userNm = userNm;
		this.email = email;
	}	
}
