package com.souvenir_product_like_record.model;

import java.util.*;


public interface SouvenirProductLikeRecordDAO_interface {
	
	public void insert(SouvenirProductLikeRecordVO souprVO);
	public void delete(String sou_id, String mem_id);
	public SouvenirProductLikeRecordVO findByPrimaryKey(String sou_id);
	public List<SouvenirProductLikeRecordVO> getAll();

}
