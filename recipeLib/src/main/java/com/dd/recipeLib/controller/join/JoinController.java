package com.dd.recipeLib.controller.join;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dd.recipeLib.service.join.JoinService;

@Controller
@RequestMapping("/recipeLib/join")
public class JoinController {
	
	@Autowired
	private JoinValidator joinValidator;
	@Autowired
	private JoinService joinService;

	@GetMapping()
	public String form(Model model) {
		JoinRequest joinRequest = new JoinRequest();
		model.addAttribute("joinRequest", joinRequest);
		return "join/form";
	}
	
	@PostMapping()
	public String process(@Valid JoinRequest joinRequest, Errors errors) {
		
		joinValidator.validate(joinRequest, errors);
		
		if(errors.hasErrors()) {
			return "join/form";
		}
		
		joinService.process(joinRequest);
		
		return "redirect:/recipeLib/login/form";
	}
}
