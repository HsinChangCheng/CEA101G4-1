package com.souvenir_product_like_record.model;

import java.io.Serializable;


public class SouvenirProductLikeRecordVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String sou_id;
	private String mem_id;
	public String getSou_id() {
		return sou_id;
	}
	public void setSou_id(String sou_id) {
		this.sou_id = sou_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	

}
