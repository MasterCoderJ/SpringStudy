package com.edu.shopprac.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.shopprac.model.category.CategoryService;

@Controller
public class ProductController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/product/registform")
	public ModelAndView getForm() {
		
		List categoryList= categoryService.selectAll();
		
		ModelAndView mav= new ModelAndView("admin/product/regist");
		mav.addObject("categoryList", categoryList);
		
		return mav;
	}

}
