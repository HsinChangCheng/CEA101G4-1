package com.souvenir_order_detail.model;
import java.io.Serializable;

public class SouvenirOrderDetailVO implements Serializable {
	private String sou_order_id;
	private String sou_id;
	private Integer sou_order_amount;
	private Integer sou_price;
	
	public String getSou_order_id() {
		return sou_order_id;
	}
	public void setSou_order_id(String sou_order_id) {
		this.sou_order_id = sou_order_id;
	}
	public String getSou_id() {
		return sou_id;
	}
	public void setSou_id(String sou_id) {
		this.sou_id = sou_id;
	}
	public Integer getSou_order_amount() {
		return sou_order_amount;
	}
	public void setSou_order_amount(Integer sou_order_amount) {
		this.sou_order_amount = sou_order_amount;
	}
	public Integer getSou_price() {
		return sou_price;
	}
	public void setSou_price(Integer sou_price) {
		this.sou_price = sou_price;
	}
	
}
