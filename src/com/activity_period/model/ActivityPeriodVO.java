package com.activity_period.model;

import java.sql.Timestamp;

public class ActivityPeriodVO implements java.io.Serializable {
	private String act_period_id;
	private String act_id;
	private Timestamp act_sign_start;
	private Timestamp act_sign_end;
	private Timestamp act_period_start;
	private Timestamp act_period_end;
	private Integer act_up_limit;
	private Integer act_low_limit;
	private Double act_cur_price;
	private Integer act_period_status;
	private Integer act_sign_sum;
	
	public ActivityPeriodVO() {}
	public String getAct_period_id() {
		return act_period_id;
	}
	public void setAct_period_id(String act_period_id) {
		this.act_period_id = act_period_id;
	}
	public String getAct_id() {
		return act_id;
	}
	public void setAct_id(String act_id) {
		this.act_id = act_id;
	}
	public Timestamp getAct_sign_start() {
		return act_sign_start;
	}
	public void setAct_sign_start(Timestamp act_sign_start) {
		this.act_sign_start = act_sign_start;
	}
	public Timestamp getAct_sign_end() {
		return act_sign_end;
	}
	public void setAct_sign_end(Timestamp act_sign_end) {
		this.act_sign_end = act_sign_end;
	}
	public Timestamp getAct_period_start() {
		return act_period_start;
	}
	public void setAct_period_start(Timestamp act_period_start) {
		this.act_period_start = act_period_start;
	}
	public Timestamp getAct_period_end() {
		return act_period_end;
	}
	public void setAct_period_end(Timestamp act_period_end) {
		this.act_period_end = act_period_end;
	}
	public Integer getAct_up_limit() {
		return act_up_limit;
	}
	public void setAct_up_limit(Integer act_up_limit) {
		this.act_up_limit = act_up_limit;
	}
	public Integer getAct_low_limit() {
		return act_low_limit;
	}
	public void setAct_low_limit(Integer act_low_limit) {
		this.act_low_limit = act_low_limit;
	}
	public Double getAct_cur_price() {
		return act_cur_price;
	}
	public void setAct_cur_price(Double act_cur_price) {
		this.act_cur_price = act_cur_price;
	}
	public Integer getAct_period_status() {
		return act_period_status;
	}
	public void setAct_period_status(Integer act_period_status) {
		this.act_period_status = act_period_status;
	}
	public Integer getAct_sign_sum() {
		return act_sign_sum;
	}
	public void setAct_sign_sum(Integer act_sign_sum) {
		this.act_sign_sum = act_sign_sum;
	}

	
	
}
