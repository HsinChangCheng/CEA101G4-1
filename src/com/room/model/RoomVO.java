package com.room.model;

import java.sql.Date;
import java.sql.Timestamp;

public class RoomVO implements java.io.Serializable{
	private String roomId;
	private String sellMemId;
	private String roomName;
	private Integer roomPrice;
	private Integer roomCapacity;
	private Timestamp roomOnTime;
	private String roomDes;
	private Integer roomCollect;
	private Integer roomStatus;
	
	
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getSellMemId() {
		return sellMemId;
	}
	public void setSellMemId(String sellMemId) {
		this.sellMemId = sellMemId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}
	public Integer getRoomCapacity() {
		return roomCapacity;
	}
	public void setRoomCapacity(Integer roomCapacity) {
		this.roomCapacity = roomCapacity;
	}
	public Timestamp getRoomOnTime() {
		return roomOnTime;
	}
	public void setRoomOnTime(Timestamp roomOnTime) {
		this.roomOnTime = roomOnTime;
	}
	public String getRoomDes() {
		return roomDes;
	}
	public void setRoomDes(String roomDes) {
		this.roomDes = roomDes;
	}
	public Integer getRoomCollect() {
		return roomCollect;
	}
	public void setRoomCollect(Integer roomCollect) {
		this.roomCollect = roomCollect;
	}
	public Integer getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(Integer roomStatus) {
		this.roomStatus = roomStatus;
	}
}
