package com.roomorder.model;

import java.sql.Date;
import java.sql.Timestamp;

public class RoomOrderVO {
	private String roomOrderId;
	private String sellMemId;
	private String memId;
	private Timestamp roomOrderTime;
	private Date checkInDate;
	private Date checkOutDate;
	private Timestamp expectArrTime;
	private String roomOrderRemarks;
	private Integer roomOrderSum;
	private Integer roomOrderStatus;
	private Integer roomPaymentStatus;
	
	public String getRoomOrderId() {
		return roomOrderId;
	}
	public void setRoomOrderId(String roomOrderId) {
		this.roomOrderId = roomOrderId;
	}
	public String getSellMemId() {
		return sellMemId;
	}
	public void setSellMemId(String sellMemId) {
		this.sellMemId = sellMemId;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public Timestamp getRoomOrderTime() {
		return roomOrderTime;
	}
	public void setRoomOrderTime(Timestamp roomOrderTime) {
		this.roomOrderTime = roomOrderTime;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public Timestamp getExpectArrTime() {
		return expectArrTime;
	}
	public void setExpectArrTime(Timestamp expectArrTime) {
		this.expectArrTime = expectArrTime;
	}
	public String getRoomOrderRemarks() {
		return roomOrderRemarks;
	}
	public void setRoomOrderRemarks(String roomOrderRemarks) {
		this.roomOrderRemarks = roomOrderRemarks;
	}
	public Integer getRoomOrderSum() {
		return roomOrderSum;
	}
	public void setRoomOrderSum(Integer roomOrderSum) {
		this.roomOrderSum = roomOrderSum;
	}
	public Integer getRoomOrderStatus() {
		return roomOrderStatus;
	}
	public void setRoomOrderStatus(Integer roomOrderStatus) {
		this.roomOrderStatus = roomOrderStatus;
	}
	public Integer getRoomPaymentStatus() {
		return roomPaymentStatus;
	}
	public void setRoomPaymentStatus(Integer roomPaymentStatus) {
		this.roomPaymentStatus = roomPaymentStatus;
	}
	
}
