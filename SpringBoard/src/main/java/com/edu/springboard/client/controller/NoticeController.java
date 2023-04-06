package com.edu.springboard.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {
	
	@GetMapping("/notice/list")
	public ModelAndView noticeMain() {
		
		return new ModelAndView("notice/list");
	}
	
	@GetMapping("/notice/registform")
	public ModelAndView registForm() {
		
		return new ModelAndView("notice/regist");
	}
	
	@GetMapping("/notice/detail")
	public ModelAndView getDetail(int notice_idx) {
		
		//여기서 mav로 3,4단계 일을 시켜도 되지만 restful하게 쓰기 위해 하지 않는다
		ModelAndView mav= new ModelAndView("notice/detail");
		mav.addObject("notice_idx", notice_idx);
		
		return mav;
	}
	
}
