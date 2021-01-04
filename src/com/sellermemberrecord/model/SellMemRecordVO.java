package com.sellermemberrecord.model;

import java.sql.*;

public class SellMemRecordVO implements java.io.Serializable {
	private String sellMemRecordId;
	private String sellMemId;
	private String sellMemRecordContent;
	private Timestamp sellMemRecordTime;
	private Integer sellMemRecordRead;

	public String getSellMemRecordId() {
		return sellMemRecordId;
	}

	public void setSellMemRecordId(String sellMemRecordId) {
		this.sellMemRecordId = sellMemRecordId;
	}

	public String getSellMemId() {
		return sellMemId;
	}

	public void setSellMemId(String sellMemId) {
		this.sellMemId = sellMemId;
	}

	public String getSellMemRecordContent() {
		return sellMemRecordContent;
	}

	public void setSellMemRecordContent(String sellMemRecordContent) {
		this.sellMemRecordContent = sellMemRecordContent;
	}

	public Timestamp getSellMemRecordTime() {
		return sellMemRecordTime;
	}

	public void setSellMemRecordTime(Timestamp sellMemRecordTime2) {
		this.sellMemRecordTime = sellMemRecordTime2;
	}

	public Integer getSellMemRecordRead() {
		return sellMemRecordRead;
	}

	public void setSellMemRecordRead(Integer sellMemRecordRead) {
		this.sellMemRecordRead = sellMemRecordRead;
	}
}
