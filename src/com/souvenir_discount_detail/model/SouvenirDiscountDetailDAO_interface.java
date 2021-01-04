package com.souvenir_discount_detail.model;

import java.util.List;


public interface SouvenirDiscountDetailDAO_interface {
	
	public void insert(SouvenirDiscountDetailVO soddVO);
	public void update(SouvenirDiscountDetailVO soddVO);
	public SouvenirDiscountDetailVO findByPrimaryKey(String sou_id,String sou_dis_id);
	public List<SouvenirDiscountDetailVO> getAll();
	

}
