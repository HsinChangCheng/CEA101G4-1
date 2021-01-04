package com.roomorderdetail.model;

import java.io.Serializable;

public class RoomOrderDetailVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String room_order_id;
	private String room_id;
	private Integer room_cur_price;
	
	
	public String getRoom_order_id() {
		return room_order_id;
	}
	public void setRoom_order_id(String room_order_id) {
		this.room_order_id = room_order_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public Integer getRoom_cur_price() {
		return room_cur_price;
	}
	public void setRoom_cur_price(Integer room_cur_price) {
		this.room_cur_price = room_cur_price;
	}
	
	
	
}
