package com.activity_product.model;

public class ActivityProductVO implements java.io.Serializable{
	private String act_id;
	private String sell_mem_id;
	private String act_type_id;
	private String act_name;
	private Double act_price;
	private String act_des;
	private String act_add;
	public ActivityProductVO() {
		
	}
	public ActivityProductVO(String act_id, String sell_mem_id, String act_type_id, String act_name, Double act_price,
			String act_des, String act_add) {
		super();
		this.act_id = act_id;
		this.sell_mem_id = sell_mem_id;
		this.act_type_id = act_type_id;
		this.act_name = act_name;
		this.act_price = act_price;
		this.act_des = act_des;
		this.act_add = act_add;
	}
	
	public String getAct_id() {
		return act_id;
	}
	public void setAct_id(String act_id) {
		this.act_id = act_id;
	}
	public String getSell_mem_id() {
		return sell_mem_id;
	}
	public void setSell_mem_id(String sell_mem_id) {
		this.sell_mem_id = sell_mem_id;
	}
	public String getAct_type_id() {
		return act_type_id;
	}
	public void setAct_type_id(String act_type_id) {
		this.act_type_id = act_type_id;
	}
	public String getAct_name() {
		return act_name;
	}
	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}
	public Double getAct_price() {
		return act_price;
	}
	public void setAct_price(Double act_price) {
		this.act_price = act_price;
	}
	public String getAct_des() {
		return act_des;
	}
	public void setAct_des(String act_des) {
		this.act_des = act_des;
	}
	public String getAct_add() {
		return act_add;
	}
	public void setAct_add(String act_add) {
		this.act_add = act_add;
	}
}
