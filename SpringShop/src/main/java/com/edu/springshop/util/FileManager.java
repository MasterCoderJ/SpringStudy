package com.edu.springshop.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springshop.domain.Pimg;
import com.edu.springshop.domain.Product;
import com.edu.springshop.exception.UploadException;

@Component
public class FileManager {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	//파일명 생성하기
	public String createFileName(String filename) {
		
		long time= System.currentTimeMillis();
		String ext= filename.substring(filename.lastIndexOf(".")+1, filename.length());
		
		return time+"."+ext;
	}
	
	//지정된 디렉토리로 파일 저장 path-> 저장될 디렉토리
	public void save(Product product, String dir) throws UploadException{
		
		MultipartFile[] photoList= product.getPhoto();
		
		List<Pimg> pimgList= new ArrayList<Pimg>();
		product.setPimgList(pimgList);
		
		logger.info("포토 배열은"+photoList);
		
		try {

			for(MultipartFile photo: photoList) {
				
				try {
					//응답속도가 너무 빨라 파일명이 같아지면 추후 에러가 나므로 쓰레드로 늦춰줌
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Pimg pimg= new Pimg();
				pimg.setProduct(product);//이 시점에 pk존재
				pimg.setFilename(createFileName(photo.getOriginalFilename()));
				
				//리스트에 pimg추가
				pimgList.add(pimg);
				
				photo.transferTo(new File(dir+pimg.getFilename()));
			}
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new UploadException("업로드 실패",e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new UploadException("업로드 실패",e);
		}

	}

}
