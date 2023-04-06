package com.edu.shopprac.admin.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.shopprac.domain.Product;
import com.edu.shopprac.model.product.ProductService;
import com.edu.shopprac.util.Message;

@RestController
@RequestMapping("/rest")
public class RestProductController {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductService productService;
	

	@PostMapping("/product")
	public ResponseEntity<Message> regist(Product product, HttpServletRequest request){
		
		ServletContext application= request.getSession().getServletContext();
		String path= application.getRealPath("/resources/data/");
		
		productService.regist(product, path);
		
		Message message= new Message();
		message.setMsg("등록");
		
		ResponseEntity<Message> entity= new ResponseEntity<Message>(message,HttpStatus.OK);
		
		return entity;
	}
 
	
	@ExceptionHandler(com.edu.shopprac.exception.UploadException.class)
	public ResponseEntity<Message> handle(com.edu.shopprac.exception.UploadException e){
		
		Message message= new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity<Message> entity= new ResponseEntity<Message>(message,HttpStatus.BAD_GATEWAY);
		
		return entity;
	}
	
	@ExceptionHandler(com.edu.shopprac.exception.PimgException.class)
	public ResponseEntity<Message> handle(com.edu.shopprac.exception.PimgException e){
		
		Message message= new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity<Message> entity= new ResponseEntity<Message>(message,HttpStatus.BAD_GATEWAY);
		
		return entity;
	}
	
	@ExceptionHandler(com.edu.shopprac.exception.ProductException.class)
	public ResponseEntity<Message> handle(com.edu.shopprac.exception.ProductException e){
		
		Message message= new Message();
		message.setMsg(e.getMessage());
		
		ResponseEntity<Message> entity= new ResponseEntity<Message>(message,HttpStatus.BAD_GATEWAY);
		
		return entity;
	}

}
