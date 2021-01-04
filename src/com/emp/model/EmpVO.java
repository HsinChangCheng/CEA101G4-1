package com.emp.model;
import java.io.Serializable;

public class EmpVO implements Serializable{
	private String emp_id;
	private String emp_account;
	private String emp_pwd;
	private String emp_name;
	private Integer emp_acc_status;
	private Integer emp_gender;
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_account() {
		return emp_account;
	}
	public void setEmp_account(String emp_account) {
		this.emp_account = emp_account;
	}
	public String getEmp_pwd() {
		return emp_pwd;
	}
	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Integer getEmp_acc_status() {
		return emp_acc_status;
	}
	public void setEmp_acc_status(Integer emp_acc_status) {
		this.emp_acc_status = emp_acc_status;
	}
	public Integer getEmp_gender() {
		return emp_gender;
	}
	public void setEmp_gender(Integer emp_gender) {
		this.emp_gender = emp_gender;
	}
	
}
