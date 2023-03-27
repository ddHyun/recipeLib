package com.dd.recipeLib.controller.join;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recipeLib/join")
public class JoinController {

	@GetMapping("/form")
	public String form() {
		
		return "join/form";
	}
}