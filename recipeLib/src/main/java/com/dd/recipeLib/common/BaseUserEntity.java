package com.dd.recipeLib.common;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public class BaseUserEntity extends BaseEntity{

	@CreatedBy
	@Column(updatable=false)
	private String createdBy;
	
	@LastModifiedBy
	@Column(insertable=false)
	private String modifiedBy;
}
