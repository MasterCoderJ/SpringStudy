package com.edu.springboard.model.gallery;

import java.util.List;

import com.edu.springboard.domain.Gallery;

public interface GalleryService {
	
	public List selectAll();
	public Gallery select(int gallery_idx);
	public void regist(Gallery gallery, String path); //insert뿐 아니라 upload까지 해야함
	public void update(Gallery gallery);//DB수정 뿐 아니라 사진도 변경
	public void delete(int gallery_idx);//DB삭제뿐 아니라 파일도 지워야함


}
