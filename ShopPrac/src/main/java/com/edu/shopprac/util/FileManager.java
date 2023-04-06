package com.edu.shopprac.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.shopprac.domain.Pimg;
import com.edu.shopprac.domain.Product;
import com.edu.shopprac.exception.UploadException;

@Component
public class FileManager {
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	public String createFileName(String filename) {
		
		long time= System.currentTimeMillis();
		String ext= filename.substring(filename.lastIndexOf(".")+1, filename.length());
		
		return time+"."+ext;
	}
	
	
	public void save(Product product, String dir) throws UploadException{
		
		MultipartFile[] photoList= product.getPhoto();
		
		List<Pimg> pimgList= new ArrayList<Pimg>();
		product.setPimgList(pimgList);
		
		logger.info("포토 배열"+photoList);
		
		try {
			for(MultipartFile photo: photoList) {
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Pimg pimg= new Pimg();
				pimg.setProduct(product);
				pimg.setFilename(createFileName(photo.getOriginalFilename()));
				
				pimgList.add(pimg);
				
				photo.transferTo(new java.io.File(dir+pimg.getFilename()));
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
