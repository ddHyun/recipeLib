package com.dd.recipeLib.model.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, 
															QuerydslPredicateExecutor<UserEntity>{

//	@Query("select u from UserEntity u where u.id=:id")
	Optional<UserEntity> findByUserId(String userId);
	
	Optional<UserEntity> findByUserNmAndEmail(String userNm, String email);
	
	Optional<UserEntity> findByUserIdAndEmail(String userId, String email);
}
