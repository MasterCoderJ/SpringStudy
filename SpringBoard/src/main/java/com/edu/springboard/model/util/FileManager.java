package com.edu.springboard.model.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.domain.Photo;

@Component
public class FileManager {
	
	public String getExt(String path) {
		
		int lastIndex= path.lastIndexOf(".");
		String ext= path.substring(lastIndex+1, path.length());
		
		return ext;//확장자 반환
	}
	
	//파일명 얻기
	public String createFileName(String path) {
		long time= System.currentTimeMillis();
		String filename= time+"."+getExt(path);
		
		return filename;
	}
	
	//서버에 저장
	//서버의 하드디스크 풀 경로를 두번째 인수로 넘겨야한다(realPath 넘겨야함)
	public void save(Gallery gallery, String path) throws com.edu.springboard.exception.FileUploadException {
		MultipartFile[] photo= gallery.getPhoto();
		
		//galleryDTO의 비어있는 photoList를 여기서 채우자
		List<Photo> photoList= new ArrayList<Photo>();
		gallery.setPhotoList(photoList);
		
		try {
			for(int i=0; i<photo.length; i++) {
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				String filename= createFileName(photo[i].getOriginalFilename());
				Photo dto= new Photo();
				dto.setFilename(filename);
				photoList.add(dto);
				photo[i].transferTo(new File(path+filename));
				
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new com.edu.springboard.exception.FileUploadException("파일 저장 실패", e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
