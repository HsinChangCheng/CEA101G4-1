package com.souvenir_discount.model;

import java.util.*;


public interface SouvenirDiscountDAO_interface {
	
	public void insert(SouvenirDiscountVO sodVO);
	public void update(SouvenirDiscountVO sodVO);
	public void delete(String sou_dis_id);
	public SouvenirDiscountVO findByPrimaryKey(String sou_dis_id);
	public List<SouvenirDiscountVO> getAll();
	}



