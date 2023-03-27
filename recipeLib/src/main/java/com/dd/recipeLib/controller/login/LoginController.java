package com.dd.recipeLib.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipeLib/login")
public class LoginController {

	@GetMapping("/form")
	public String form() {
		return "login/form";
	}
}
