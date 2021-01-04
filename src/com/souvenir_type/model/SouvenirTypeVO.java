package com.souvenir_type.model;

import java.io.Serializable;

public class SouvenirTypeVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String sou_type_id;
	private String sou_type_name;
	public String getSou_type_id() {
		return sou_type_id;
	}
	public void setSou_type_id(String sou_type_id) {
		this.sou_type_id = sou_type_id;
	}
	public String getSou_type_name() {
		return sou_type_name;
	}
	public void setSou_type_name(String sou_type_name) {
		this.sou_type_name = sou_type_name;
	}

}
