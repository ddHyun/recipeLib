package com.dd.recipeLib.common;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.dd.recipeLib.controller")
public class ExceptionController {

	//오류메시지를 alert창에 띄우는 예외처리
	@ExceptionHandler(AlertException.class)
	public String handleAlertException(AlertException e, Model model) {
		
		String action = e.getAction();
		String target = e.getTarget() == null? "self" : e.getTarget();
		
		String script = "alert('"+e.getMessage()+"');";
		
		if(action != null) {
			if(action.equals("reload")) {
				script += target + ".location.reload();";
			}else if(action.equals("back")) {
				script += target + ".history.back();";
			}else {
				script += target + ".location.replace('" + action + "')";
			}
		}
		
		e.printStackTrace();
		model.addAttribute("script", script);
		
		return "common/scripts";
	}
	
	//미지정 예외처리
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException e, Model model) {
		model.addAttribute("message", e.getMessage());
		e.printStackTrace();
		
		return "common/errors";
	}
}
