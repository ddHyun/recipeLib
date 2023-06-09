package com.dd.recipeLib.common;

public class AlertException extends RuntimeException{

	//js 추가동작 유무에 따라 reload 또는 해당 url
	private String action = null;
	
	private String target = null;
	
	public AlertException(String message) {
		this(message, "self", null);
	}
	
	public AlertException(String message, String action) {
		this(message, "self", action);
	}
	
	public AlertException(String message, String target, String action) {
		super(message);
		this.target = target;
		this.action = action;
	}
	
	public String getAction() {
		return action;
	}
	
	public String getTarget() {
		return target;
	}
}
