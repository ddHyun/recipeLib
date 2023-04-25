package com.dd.recipeLib.common;

import org.springframework.stereotype.Component;

//아이디 검색결과 중 일부 **로 치환하는 bean
@Component
public class StringLib {
	
	public String masking(String str, int spos, String ch) {
		
			int noOfch = str.length() - spos - 1;
			
			String newStr = str.substring(0, spos) + ch.repeat(noOfch);
			
			return newStr;
	}
}
