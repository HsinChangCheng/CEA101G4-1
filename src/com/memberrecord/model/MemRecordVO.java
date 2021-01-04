package com.memberrecord.model;

import java.sql.*;

public class MemRecordVO implements java.io.Serializable{
	private String memRecordId;
	private String memId;
	private String memRecordContent;
	private Timestamp memRecordTime;
	private Integer memRecordRead;

	public String getMemRecordId() {
		return memRecordId;
	}
	public void setMemRecordId(String memRecordId) {
		this.memRecordId = memRecordId;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemRecordContent() {
		return memRecordContent;
	}
	public void setMemRecordContent(String memRecordContent) {
		this.memRecordContent = memRecordContent;
	}
	public Timestamp getMemRecordTime() {
		return memRecordTime;
	}
	public void setMemRecordTime(Timestamp memRecordTime) {
		this.memRecordTime = memRecordTime;
	}
	public Integer getMemRecordRead() {
		return memRecordRead;
	}
	public void setMemRecordRead(Integer memRecordRead) {
		this.memRecordRead = memRecordRead;
	}	
}
