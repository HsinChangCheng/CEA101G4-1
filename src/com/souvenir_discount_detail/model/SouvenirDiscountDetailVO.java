package com.souvenir_discount_detail.model;


import java.io.Serializable;

public class SouvenirDiscountDetailVO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private String sou_id; 
	private String sou_dis_id; 
	private Integer sou_dis_price;
	public String getSou_id() {
		return sou_id;
	}
	public void setSou_id(String sou_id) {
		this.sou_id = sou_id;
	}
	public String getSou_dis_id() {
		return sou_dis_id;
	}
	public void setSou_dis_id(String sou_dis_id) {
		this.sou_dis_id = sou_dis_id;
	}
	public Integer getSou_dis_price() {
		return sou_dis_price;
	}
	public void setSou_dis_price(Integer sou_dis_price) {
		this.sou_dis_price = sou_dis_price;
	}
	
	
}
