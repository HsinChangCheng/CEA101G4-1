package com.sell.model;

import java.sql.Date;
import java.sql.Timestamp;

public class SellVO implements java.io.Serializable {
	private String sellMemId;
	private String sellMemAccount;
	private String sellMemPwd;
	private String sellMemName;
	private Date sellMemBirth;
	private String sellMemTel;
	private String sellRoomName;
	private String sellMemAddress;
	private Double sellLatitude;
	private Double sellLongitud;
	private String sellMemMail;
	private String sellMemIdNumber;
	private Integer sellAccStatus;
	private Integer sellGender;
	private Timestamp sellJointime;
	
	public String getSellMemId() {
		return sellMemId;
	}
	public void setSellMemId(String sellMemId) {
		this.sellMemId = sellMemId;
	}
	public String getSellMemAccount() {
		return sellMemAccount;
	}
	public void setSellMemAccount(String sellMemAccount) {
		this.sellMemAccount = sellMemAccount;
	}
	public String getSellMemPwd() {
		return sellMemPwd;
	}
	public void setSellMemPwd(String sellMemPwd) {
		this.sellMemPwd = sellMemPwd;
	}
	public String getSellMemName() {
		return sellMemName;
	}
	public void setSellMemName(String sellMemName) {
		this.sellMemName = sellMemName;
	}
	public Date getSellMemBirth() {
		return sellMemBirth;
	}
	public void setSellMemBirth(Date sellMemBirth) {
		this.sellMemBirth = sellMemBirth;
	}
	public String getSellMemTel() {
		return sellMemTel;
	}
	public void setSellMemTel(String sellMemTel) {
		this.sellMemTel = sellMemTel;
	}
	public String getSellRoomName() {
		return sellRoomName;
	}
	public void setSellRoomName(String sellRoomName) {
		this.sellRoomName = sellRoomName;
	}
	public String getSellMemAddress() {
		return sellMemAddress;
	}
	public void setSellMemAddress(String sellMemAddress) {
		this.sellMemAddress = sellMemAddress;
	}
	public Double getSellLatitude() {
		return sellLatitude;
	}
	public void setSellLatitude(Double sellLatitude) {
		this.sellLatitude = sellLatitude;
	}
	public Double getSellLongitud() {
		return sellLongitud;
	}
	public void setSellLongitud(Double sellLongitud) {
		this.sellLongitud = sellLongitud;
	}
	public String getSellMemMail() {
		return sellMemMail;
	}
	public void setSellMemMail(String sellMemMail) {
		this.sellMemMail = sellMemMail;
	}
	public String getSellMemIdNumber() {
		return sellMemIdNumber;
	}
	public void setSellMemIdNumber(String sellMemIdNumber) {
		this.sellMemIdNumber = sellMemIdNumber;
	}
	public Integer getSellAccStatus() {
		return sellAccStatus;
	}
	public void setSellAccStatus(Integer sellAccStatus) {
		this.sellAccStatus = sellAccStatus;
	}
	public Integer getSellGender() {
		return sellGender;
	}
	public void setSellGender(Integer sellGender) {
		this.sellGender = sellGender;
	}
	public Timestamp getSellJointime() {
		return sellJointime;
	}
	public void setSellJointime(Timestamp sellJointime) {
		this.sellJointime = sellJointime;
	}
	
	@Override
	public String toString() {
		return "SellVO [sellMemId=" + sellMemId + ", sellMemAccount=" + sellMemAccount + ", sellMemPwd=" + sellMemPwd
				+ ", sellMemName=" + sellMemName + ", sellMemBirth=" + sellMemBirth + ", sellMemTel=" + sellMemTel
				+ ", sellRoomName=" + sellRoomName + ", sellMemAddress=" + sellMemAddress + ", sellLatitude="
				+ sellLatitude + ", sellLongitud=" + sellLongitud + ", sellMemMail=" + sellMemMail
				+ ", sellMemIdNumber=" + sellMemIdNumber + ", sellAccStatus=" + sellAccStatus + ", sellGender="
				+ sellGender + ", sellJointime=" + sellJointime + "]";
	}
	
}
