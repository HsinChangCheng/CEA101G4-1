package com.souvenir_product.model;

import java.util.*;


public interface SouvenirProductDAO_interface {

	
		public void insert(SouvenirProductVO soupVO);
		public void update(SouvenirProductVO soupVO);
		public void delete(String sou_id);
		public SouvenirProductVO findByPrimaryKey(String sou_id);
		public List<SouvenirProductVO> getAll();
}
