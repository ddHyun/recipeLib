package com.dd.recipeLib.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		//로그인&로그아웃 설정
		http.formLogin()
			.loginPage("/recipeLib/login")
//			.defaultSuccessUrl("/recipeLib/main")
			.successHandler(new LoginSuccessHandler())
			.usernameParameter("userId")
			.passwordParameter("pwd")
			.failureHandler(new LoginFailureHandler())
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/recipeLib/logout"))
			.logoutSuccessUrl("/recipeLib/main");
		
		//페이지별 접근제한 설정
		http.authorizeHttpRequests()
			.mvcMatchers("/recipeLib/main", "/recipeLib/login/**", "/recipeLib/join").permitAll()//모든 사용자 접근 허용
			.mvcMatchers("/recipeLib/admin/**").hasAnyRole("ADMIN", "SUPERADMIN")	//해당role만 접근 허용
			.anyRequest().authenticated();											//기타 페이지 : 로그인 후 이용 가능
		
		//인증되지 않은 사용자 접속시 설정
		http.exceptionHandling()
			.authenticationEntryPoint(new CustomAuthenticationEntryPoint());
		
		return http.build();
	}
	
	//인증 필요없는 부분 설정(정적자원들)
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		
		return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/uploads/**");
	}
	
	//비밀번호 인코딩 -> BCrypt 사용
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
