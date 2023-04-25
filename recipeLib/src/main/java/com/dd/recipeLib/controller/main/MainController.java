package com.dd.recipeLib.controller.main;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipeLib/main")
public class MainController {

	@GetMapping
	public String index(Principal principal, Model model) {
		
		if(principal != null) {
			model.addAttribute("userId", principal.getName());
		}
		
		return "main/index";
	}
}
