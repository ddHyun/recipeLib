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
	private String id;
	
	@Column(nullable=false)
	private String pwd;
	
	@Column(nullable=false, length=20)
	private String name;
	
	@Column(nullable=false, length=50)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private UserType type = UserType.USER;
	
	@Builder
	public UserEntity(Long idx, String id, String pwd, String name, String email) {
		this.idx = idx;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}	
}
