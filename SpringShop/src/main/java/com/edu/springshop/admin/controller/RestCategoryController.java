package com.edu.springshop.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springshop.domain.Category;
import com.edu.springshop.exception.CategoryException;
import com.edu.springshop.model.category.CategoryService;
import com.edu.springshop.util.Message;

@RestController
@RequestMapping("/rest")
public class RestCategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	//등록요청 처리
	@PostMapping("/category")
	public Message regist(Category category) {
		
		//3단계 
		categoryService.insert(category);
		Message message= new Message();
		message.setMsg("카테고리 등록성공");
		
		return message;
	}
	
	//목록요청 처리
	@GetMapping("/category")
	public List<Category> getList(){
		
		//3단계
		return categoryService.selectAll();
	}
	
	//수정 요청처리
	//@ResponseBody: 자바객체 --> JSON
	//@RequestBody: JSON --> 자바객체
	
	@PutMapping("/category")
	public ResponseEntity<Message> edit(@RequestBody Category category){
		
		logger.info("category is"+ category);
		logger.warn("category is"+ category);
		logger.error("category is"+ category);
		
		//3단계
		categoryService.update(category);
		
		Message message= new Message();
		message.setMsg("수정 성공");
		
		ResponseEntity<Message> entity= null;
		entity= new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}
	
	//삭제요청처리
	//@PathVariable-> 경로에 변수가 껴있음
	@DeleteMapping("/category/{category_idx}") //{?변수명 값}를 표시하지 않을경우 디렉토리로 인식, 스프링은 변수로 인식할 필요가 있음
	public ResponseEntity<Message> del(@PathVariable int category_idx){
		logger.info("넘겨받은 category_idx는"+category_idx);
		
		//3단계 일시키기
		categoryService.delete(category_idx);
		
		Message message= new Message();
		message.setMsg("삭제 성공");
		
		ResponseEntity<Message> entity= null;
		entity= new ResponseEntity<Message>(message, HttpStatus.OK);

		return entity;
	}
	
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<Message> handel(CategoryException e) {
		Message message= new Message();
		message.setMsg(e.getMessage());
		
		//HTTP 응답정보를 보다 세밀하게 구성하고 싶다면, 응답 메시지를 구성할 수 있는 객체를 지원함
		ResponseEntity<Message> entity= null;
		entity= new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		return entity;
	}

}
