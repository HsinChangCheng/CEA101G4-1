package com.souvenir_photo.model;

import java.io.Serializable;

public class SouvenirPhotoVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String sou_photo_id;
	private String sou_id;
	private byte[] sou_photo;
	private String sou_photo_content;
	
	
	public String getSou_photo_id() {
		return sou_photo_id;
	}
	public void setSou_photo_id(String sou_photo_id) {
		this.sou_photo_id = sou_photo_id;
	}
	public String getSou_id() {
		return sou_id;
	}
	public void setSou_id(String sou_id) {
		this.sou_id = sou_id;
	}
	public byte[] getSou_photo() {
		return sou_photo;
	}
	public void setSou_photo(byte[] sou_photo) {
		this.sou_photo = sou_photo;
	}
	public String getSou_photo_content() {
		return sou_photo_content;
	}
	public void setSou_photo_content(String sou_photo_content) {
		this.sou_photo_content = sou_photo_content;
	}
	
	

}
