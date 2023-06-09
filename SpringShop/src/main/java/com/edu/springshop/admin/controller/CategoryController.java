package com.edu.springshop.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.springshop.domain.Category;

@Controller
public class CategoryController {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	//카테고리 관리 메인 요청
	@GetMapping("/category/main")
	public ModelAndView getMain() {
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("admin/category/category_main");
		return mav;
	}
	
	//수정 요청 처리
	@PostMapping("/category/edit")
	public ModelAndView edit(Category category) {
		
		logger.info("카테고리 내용은?"+category);
		
		ModelAndView mav= new ModelAndView();
		
		return null;
	}
	

}
