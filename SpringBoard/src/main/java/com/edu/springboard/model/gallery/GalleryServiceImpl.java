package com.edu.springboard.model.gallery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edu.springboard.domain.Gallery;
import com.edu.springboard.domain.Photo;
import com.edu.springboard.exception.FileUploadException;
import com.edu.springboard.exception.GalleryException;
import com.edu.springboard.exception.PhotoException;
import com.edu.springboard.model.util.FileManager;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("jdbcGalleryDAO")
	private GalleryDAO galleryDAO;
	
	@Autowired
	@Qualifier("jdbcPhotoDAO")
	private PhotoDAO photoDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List selectAll() {
		return galleryDAO.selectAll();
	}

	@Override
	public Gallery select(int gallery_idx) throws GalleryException{
		return galleryDAO.select(gallery_idx);
	}

	@Override
	public void regist(Gallery gallery, String path) throws FileUploadException, GalleryException, PhotoException{
		//filemanager 시키기
		fileManager.save(gallery, path);
		
		//gallery dao 시키기
		//mybatis의 selectkey에 의해 insert문 수행 이후에는 GalleryDTO의
		//gallery_idx의 값이 이미 채워져 있을것임
		logger.info("insert이전의 Gallery_idx값"+gallery.getGallery_idx());
		galleryDAO.insert(gallery);
		logger.info("insert이후의 Gallery_idx값"+gallery.getGallery_idx());
		
		//FileManager에 의해 채워진 photoList활용
		List<Photo> photoList= gallery.getPhotoList();
		
		//photo dao 시키기
		for(int i=0; i<photoList.size();i++) {
			Photo photo= photoList.get(i);
			photo.setGallery(gallery);//fk를 위하여..넣어주기
			photoDAO.insert(photo);
		}
		
	}

	@Override
	public void update(Gallery gallery) {
	}

	@Override
	public void delete(int gallery_idx) {
	}

}
