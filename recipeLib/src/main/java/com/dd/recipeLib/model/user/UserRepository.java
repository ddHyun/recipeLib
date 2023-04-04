package com.dd.recipeLib.model.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, 
															QuerydslPredicateExecutor<UserEntity>{

	@Query("select u from UserEntity u where u.id=id")
	Optional<UserEntity> findByUserid(String id);
}
