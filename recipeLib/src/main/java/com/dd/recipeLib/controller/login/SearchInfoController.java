package com.dd.recipeLib.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dd.recipeLib.service.login.SearchInfoService;

//아이디/비밀번호 찾기용 컨트롤러
@Controller
@RequestMapping("/recipeLib/login/searchInfo")
public class SearchInfoController {
	
	@Autowired
	private SearchInfoService searchInfoService;
	@Autowired
	private SearchInfoValidator searchValidator;

	@GetMapping("/idSearch")
	public String idForm(Model model) {
		
		model.addAttribute("searchInfoRequest", new SearchInfoRequest());
		model.addAttribute("idSearch", true);
		
		return "login/searchInfo";
	}
	
	@GetMapping("/pwdSearch")
	public String pwdForm(Model model) {
		
		model.addAttribute("searchInfoRequest", new SearchInfoRequest());
		model.addAttribute("pwdSearch", true);
		
		return "login/searchInfo";
	}
	
	//아이디, 비밀번호 찾기 시 일치정보 유무 확인
	@PostMapping
	public String process(SearchInfoRequest searchInfoRequest, Errors errors, Model model) {
		
		searchValidator.validate(searchInfoRequest, errors);
		
		if(errors.hasErrors()) {
			
			if(searchInfoRequest.getUserNm() != null) {
				model.addAttribute("idSearch", true);
			}
			
			if(searchInfoRequest.getUserId() != null) {
				model.addAttribute("pwdSearch", true);
			}
			
			return "login/searchInfo";
		}
		
		boolean idSearch = false;	
		if(searchInfoRequest.getUserNm() != null) {//이름 파라미터가 있다면 id검색 링크임
			idSearch = true;
		}
		
		model.addAttribute("result", searchInfoService.process(searchInfoRequest));
		
		return (idSearch) ? "login/idResult" : "login/pwdResult"; 
	}
	
	@PostMapping("/changePwd")
	public String changePwd(SearchInfoRequest searchInfoRequest, Errors errors) {
		
		searchValidator.validate(searchInfoRequest, errors);
		
		if(errors.hasErrors()) {
			return "login/pwdResult";
		}
		return null;
		//r
	}
}
