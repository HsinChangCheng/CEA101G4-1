package com.roomphoto.model;

public class RoomPhotoVO {
	private String roomPhotoId;
	private String roomId;
	private byte[] roomPhoto;
	private String roomPhotoContent;
	
	public String getRoomPhotoId() {
		return roomPhotoId;
	}
	public void setRoomPhotoId(String roomPhotoId) {
		this.roomPhotoId = roomPhotoId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public byte[] getRoomPhoto() {
		return roomPhoto;
	}
	public void setRoomPhoto(byte[] roomPhoto) {
		this.roomPhoto = roomPhoto;
	}
	public String getRoomPhotoContent() {
		return roomPhotoContent;
	}
	public void setRoomPhotoContent(String roomPhotoContent) {
		this.roomPhotoContent = roomPhotoContent;
	}
	
}
