package com.edu.shopprac.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.shopprac.domain.Category;
import com.edu.shopprac.exception.CategoryException;
import com.edu.shopprac.model.category.CategoryService;
import com.edu.shopprac.util.Message;

@RestController
@RequestMapping("/rest")
public class RestCategoryController {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/category")
	public Message regist(Category category) {
		
		categoryService.insert(category);
		Message msg= new Message();
		
		msg.setMsg("카테고리 등록성공");
		
		return msg;
	}
	
	@GetMapping("/category")
	public List<Category> getList() {
		
		return categoryService.selectAll();
	}
	
	@PutMapping("/category")
	public ResponseEntity<Message> edit(@RequestBody Category category){
		
		logger.info("category is"+category);
		
		categoryService.update(category);
		
		Message message= new Message();
		message.setMsg("수정 성공");
		
		ResponseEntity<Message> entity= new ResponseEntity<Message>(message,HttpStatus.OK);
		
		return entity;
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<Message> handle(CategoryException e){
		Message msg= new Message();
		msg.setMsg(e.getMessage());
		
		ResponseEntity<Message> entity= new ResponseEntity<Message>(msg, HttpStatus.FAILED_DEPENDENCY);
		
		return entity;
	}
	
}
