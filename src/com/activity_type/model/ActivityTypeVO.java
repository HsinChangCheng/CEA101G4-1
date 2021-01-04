package com.activity_type.model;

public class ActivityTypeVO implements java.io.Serializable{
	private String act_type_id;
	private String act_type_name;
	public ActivityTypeVO() {};
	public ActivityTypeVO(String act_type_id, String act_type_name) {
		super();
		this.act_type_id = act_type_id;
		this.act_type_name = act_type_name;
	}
	public String getAct_type_id() {
		return act_type_id;
	}
	public void setAct_type_id(String act_type_id) {
		this.act_type_id = act_type_id;
	}
	public String getAct_type_name() {
		return act_type_name;
	}
	public void setAct_type_name(String act_type_name) {
		this.act_type_name = act_type_name;
	}
	
}
