package com.emp_record.model;

import java.sql.Timestamp;

public class EmpRecordVO implements java.io.Serializable{
	private String emp_record_id;
	private String emp_id;
	private Timestamp emp_record_time;
	private String emp_record_content;
	private Integer emp_record_read;
	public EmpRecordVO() {}
	public String getEmp_record_id() {
		return emp_record_id;
	}
	public void setEmp_record_id(String emp_record_id) {
		this.emp_record_id = emp_record_id;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public Timestamp getEmp_record_time() {
		return emp_record_time;
	}
	public void setEmp_record_time(Timestamp emp_record_time) {
		this.emp_record_time = emp_record_time;
	}
	public String getEmp_record_content() {
		return emp_record_content;
	}
	public void setEmp_record_content(String emp_record_content) {
		this.emp_record_content = emp_record_content;
	}
	public Integer getEmp_record_read() {
		return emp_record_read;
	}
	public void setEmp_record_read(Integer emp_record_read) {
		this.emp_record_read = emp_record_read;
	}
}
