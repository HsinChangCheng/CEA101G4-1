package com.authorization.model;
import java.io.Serializable;

public class AuthorizationVO implements Serializable{
	private String func_id;
	private String func_name;
	public String getFunc_id() {
		return func_id;
	}
	public void setFunc_id(String func_id) {
		this.func_id = func_id;
	}
	public String getFunc_name() {
		return func_name;
	}
	public void setFunc_name(String func_name) {
		this.func_name = func_name;
	}
}
