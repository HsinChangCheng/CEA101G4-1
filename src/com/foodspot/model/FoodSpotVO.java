package com.foodspot.model;

import java.io.Serializable;
import java.sql.Date;

public class FoodSpotVO implements Serializable{
	private String fas_id;
	private String sell_mem_id;
	private String fas_spot_name;
	private String fas_add;
	private String fas_des;
	private byte[] fas_photo;
	private Double fas_latitude;
	private Double fas_longitud;
	
	public String getFas_id() {
		return fas_id;
	}
	public void setFas_id(String fas_id) {
		this.fas_id = fas_id;
	}
	public String getSell_mem_id() {
		return sell_mem_id;
	}
	public void setSell_mem_id(String sell_mem_id) {
		this.sell_mem_id = sell_mem_id;
	}
	public String getFas_spot_name() {
		return fas_spot_name;
	}
	public void setFas_spot_name(String fas_spot_name) {
		this.fas_spot_name = fas_spot_name;
	}
	public String getFas_add() {
		return fas_add;
	}
	public void setFas_add(String fas_add) {
		this.fas_add = fas_add;
	}
	public String getFas_des() {
		return fas_des;
	}
	public void setFas_des(String fas_des) {
		this.fas_des = fas_des;
	}
	public byte[] getFas_photo() {
		return fas_photo;
	}
	public void setFas_photo(byte[] fas_photo) {
		this.fas_photo = fas_photo;
	}
	public Double getFas_latitude() {
		return fas_latitude;
	}
	public void setFas_latitude(Double fas_latitude) {
		this.fas_latitude = fas_latitude;
	}
	public Double getFas_longitud() {
		return fas_longitud;
	}
	public void setFas_longitud(Double fas_longitud) {
		this.fas_longitud = fas_longitud;
	}
	
}