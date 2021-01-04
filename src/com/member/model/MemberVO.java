package com.member.model;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberVO implements java.io.Serializable {
	private String mem_id;
	private String mem_account;
	private String mem_pwd;
	private String mem_name;
	private Date mem_birth;
	private String mem_tel;
	private String mem_address;
	private String mem_mail;
	private String mem_id_number;
	private Integer mem_acc_status;
	private Integer mem_gender;
	private Timestamp mem_jointime;

	public MemberVO() {
	};

	public MemberVO(String mem_id, String mem_account, String mem_pwd, String mem_name, Date mem_birth, String mem_tel,
			String mem_address, String mem_mail, String mem_id_number, Integer mem_acc_status, Integer mem_gender,
			Timestamp mem_jointime) {
		super();
		this.mem_id = mem_id;
		this.mem_account = mem_account;
		this.mem_pwd = mem_pwd;
		this.mem_name = mem_name;
		this.mem_birth = mem_birth;
		this.mem_tel = mem_tel;
		this.mem_address = mem_address;
		this.mem_mail = mem_mail;
		this.mem_id_number = mem_id_number;
		this.mem_acc_status = mem_acc_status;
		this.mem_gender = mem_gender;
		this.mem_jointime = mem_jointime;
	}

	public String getMem_address() {
		return mem_address;
	}
	
	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}
	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_account() {
		return mem_account;
	}

	public void setMem_account(String mem_account) {
		this.mem_account = mem_account;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public Date getMem_birth() {
		return mem_birth;
	}

	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}

	public String getMem_mail() {
		return mem_mail;
	}

	public void setMem_mail(String mem_mail) {
		this.mem_mail = mem_mail;
	}

	public String getMem_id_number() {
		return mem_id_number;
	}

	public void setMem_id_number(String mem_id_number) {
		this.mem_id_number = mem_id_number;
	}

	public Integer getMem_acc_status() {
		return mem_acc_status;
	}

	public void setMem_acc_status(Integer mem_acc_status) {
		this.mem_acc_status = mem_acc_status;
	}

	public Integer getMem_gender() {
		return mem_gender;
	}

	public void setMem_gender(Integer mem_gender) {
		this.mem_gender = mem_gender;
	}

	public Timestamp getMem_jointime() {
		return mem_jointime;
	}

	public void setMem_jointime(Timestamp mem_jointime) {
		this.mem_jointime = mem_jointime;
	}

}
