package com.souvenir_photo.model;

import java.util.List;


public interface SouvenirPhotoDAO_interface {
	
	public void insert(SouvenirPhotoVO souphVO);
	public void update(SouvenirPhotoVO souphVO);
	public void delete(String sou_photo_id);
	public SouvenirPhotoVO findByPrimaryKey(String sou_photo_id);
	public List<SouvenirPhotoVO> getAll();
	

}
