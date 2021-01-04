package com.souvenir_discount.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class SouvenirDiscountVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String sou_dis_id; 
	private String sou_dis_name; 
	private Timestamp sou_dis_start; 
	private Timestamp sou_dis_end; 
	private Double sou_dis_status;
	public String getSou_dis_id() {
		return sou_dis_id;
	}
	public void setSou_dis_id(String sou_dis_id) {
		this.sou_dis_id = sou_dis_id;
	}
	public String getSou_dis_name() {
		return sou_dis_name;
	}
	public void setSou_dis_name(String sou_dis_name) {
		this.sou_dis_name = sou_dis_name;
	}
	public Timestamp getSou_dis_start() {
		return sou_dis_start;
	}
	public void setSou_dis_start(Timestamp sou_dis_start) {
		this.sou_dis_start = sou_dis_start;
	}
	public Timestamp getSou_dis_end() {
		return sou_dis_end;
	}
	public void setSou_dis_end(Timestamp sou_dis_end) {
		this.sou_dis_end = sou_dis_end;
	}
	public Double getSou_dis_status() {
		return sou_dis_status;
	}
	public void setSou_dis_status(Double sou_dis_status) {
		this.sou_dis_status = sou_dis_status;
	}
	
	

	
	
}
