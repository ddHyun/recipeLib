package com.dd.recipeLib.controller.join;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dd.recipeLib.common.AlertException;
import com.dd.recipeLib.service.join.JoinService;

@Controller
@RequestMapping("/recipeLib/join")
public class JoinController {
	
	@Autowired
	private JoinValidator joinValidator;
	@Autowired
	private JoinService joinService;

	@GetMapping
	public String form(Model model) {
		
		JoinRequest joinRequest = new JoinRequest();
		model.addAttribute("joinRequest", joinRequest);
		
		return "join/form";
	}
	
	@PostMapping
	public String process(@Valid JoinRequest joinRequest, Errors errors, Model model) {
		
		joinValidator.validate(joinRequest, errors);
		
		if(errors.hasErrors()) {
			return "join/form";
		}
		
		try {
			joinService.process(joinRequest);
			String script = "alert('축! 회원가입~ 로그인 페이지로 이동!'); location.href='/recipeLib/login'";
			model.addAttribute("script", script);
		} catch (AlertException e) {
			new AlertException("처리 도중 문제가 발생했습니다. 관리자에게 문의 바랍니다.");
			e.printStackTrace();
		}
				
		return "common/scripts";
	}
}
