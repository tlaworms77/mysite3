package com.example.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysite.repository.GalleryDao;
import com.example.mysite.vo.GalleryVo;

@Service
public class GalleryService {

	@Autowired
	private GalleryDao galleryDao;

	public List<GalleryVo> getGalleryList() {
		return galleryDao.getList();
	}
	
	public boolean uploadGalleryInformation(GalleryVo galleryVo) {
		return galleryDao.insert(galleryVo) == 1;
	}

	public boolean deleteGallery(long no) {
		return galleryDao.delete(no) == 1;
	}
	
}
