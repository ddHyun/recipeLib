package com.dd.recipeLib.controller.login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dd.recipeLib.service.login.LoginService;

@Controller
@RequestMapping("/recipeLib/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@GetMapping
	public String form(Model model) {
		
		LoginRequest loginRequest = new LoginRequest();
		model.addAttribute("loginRequest", loginRequest);
		
		return "login/form";
	}
	
	@PostMapping
	public String process(@Valid LoginRequest loginRequest, Errors errors, Model model) {
		
		loginService.process(loginRequest, errors);
		
		if(errors.hasErrors()) {
			return "login/form";
		}
				
		return "redirect:/recipeLib/main";
	}
}
