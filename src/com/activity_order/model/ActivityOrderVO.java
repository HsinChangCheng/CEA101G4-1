package com.activity_order.model;

public class ActivityOrderVO implements java.io.Serializable{
	private String act_order_id;
	private String mem_id;
	private String act_period_id;
	private Integer act_order_amount;
	private Double act_sum_price;
	private Integer act_order_status;
	private Integer act_payment_status;
	private String act_order_remarks;
	
	public ActivityOrderVO() {}

	public String getAct_order_id() {
		return act_order_id;
	}

	public void setAct_order_id(String act_order_id) {
		this.act_order_id = act_order_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getAct_period_id() {
		return act_period_id;
	}

	public void setAct_period_id(String act_period_id) {
		this.act_period_id = act_period_id;
	}

	public Integer getAct_order_amount() {
		return act_order_amount;
	}

	public void setAct_order_amount(Integer act_order_amount) {
		this.act_order_amount = act_order_amount;
	}

	public Double getAct_sum_price() {
		return act_sum_price;
	}

	public void setAct_sum_price(Double act_sum_price) {
		this.act_sum_price = act_sum_price;
	}

	public Integer getAct_order_status() {
		return act_order_status;
	}

	public void setAct_order_status(Integer act_order_status) {
		this.act_order_status = act_order_status;
	}

	public Integer getAct_payment_status() {
		return act_payment_status;
	}

	public void setAct_payment_status(Integer act_payment_status) {
		this.act_payment_status = act_payment_status;
	}

	public String getAct_order_remarks() {
		return act_order_remarks;
	}

	public void setAct_order_remarks(String act_order_remarks) {
		this.act_order_remarks = act_order_remarks;
	}

	
	
}
