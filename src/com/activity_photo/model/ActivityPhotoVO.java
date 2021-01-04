package com.activity_photo.model;

public class ActivityPhotoVO implements java.io.Serializable{
	private String act_photo_id;
	private String act_id;
	private byte[] act_photo;
	private String act_photo_content;
	
	
	public ActivityPhotoVO() {}
	public String getAct_photo_id() {
		return act_photo_id;
	}
	public void setAct_photo_id(String act_photo_id) {
		this.act_photo_id = act_photo_id;
	}
	public String getAct_id() {
		return act_id;
	}
	public void setAct_id(String act_id) {
		this.act_id = act_id;
	}
	public byte[] getAct_photo() {
		return act_photo;
	}
	public void setAct_photo(byte[] act_photo) {
		this.act_photo = act_photo;
	}
	public String getAct_photo_content() {
		return act_photo_content;
	}
	public void setAct_photo_content(String act_photo_content) {
		this.act_photo_content = act_photo_content;
	}

}
