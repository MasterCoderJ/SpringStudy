package com.edu.springshop.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//회원과 관련된 요청을 처리하는 하위 컨트롤러
@Controller
public class MemberController {
	
	@GetMapping("/member/joinform")
	public ModelAndView getJoinForm() {
		
		return new ModelAndView("shop/member/joinform");
		
	}

}
