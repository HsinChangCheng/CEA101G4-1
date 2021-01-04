package com.souvenir_order.model;
import java.io.Serializable;
import java.sql.Timestamp;

public class SouvenirOrderVO implements Serializable {
	private String sou_order_id;
	private String emp_id;
	private String mem_id;
	private Timestamp sou_order_date;
	private String sou_receiver_name;
	private String sou_receiver_address;
	private String sou_receiver_phone;
	private Integer sou_shipment_fee;
	private Integer sou_order_sum_price;
	private String sou_order_remarks;
	private Integer sou_shipping_method;
	private Integer sou_order_status;
	private Integer sou_payment_status;
	private Integer sou_shipment_status;
	
	public String getSou_order_id() {
		return sou_order_id;
	}
	public void setSou_order_id(String sou_order_id) {
		this.sou_order_id = sou_order_id;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public Timestamp getSou_order_date() {
		return sou_order_date;
	}
	public void setSou_order_date(Timestamp sou_order_date) {
		this.sou_order_date = sou_order_date;
	}
	public String getSou_receiver_name() {
		return sou_receiver_name;
	}
	public void setSou_receiver_name(String sou_receiver_name) {
		this.sou_receiver_name = sou_receiver_name;
	}
	public String getSou_receiver_address() {
		return sou_receiver_address;
	}
	public void setSou_receiver_address(String sou_receiver_address) {
		this.sou_receiver_address = sou_receiver_address;
	}
	public String getSou_receiver_phone() {
		return sou_receiver_phone;
	}
	public void setSou_receiver_phone(String sou_receiver_phone) {
		this.sou_receiver_phone = sou_receiver_phone;
	}
	public Integer getSou_shipment_fee() {
		return sou_shipment_fee;
	}
	public void setSou_shipment_fee(Integer sou_shipment_fee) {
		this.sou_shipment_fee = sou_shipment_fee;
	}
	public Integer getSou_order_sum_price() {
		return sou_order_sum_price;
	}
	public void setSou_order_sum_price(Integer sou_order_sum_price) {
		this.sou_order_sum_price = sou_order_sum_price;
	}
	public String getSou_order_remarks() {
		return sou_order_remarks;
	}
	public void setSou_order_remarks(String sou_order_remarks) {
		this.sou_order_remarks = sou_order_remarks;
	}
	public Integer getSou_shipping_method() {
		return sou_shipping_method;
	}
	public void setSou_shipping_method(Integer sou_shipping_method) {
		this.sou_shipping_method = sou_shipping_method;
	}
	public Integer getSou_order_status() {
		return sou_order_status;
	}
	public void setSou_order_status(Integer sou_order_status) {
		this.sou_order_status = sou_order_status;
	}
	public Integer getSou_payment_status() {
		return sou_payment_status;
	}
	public void setSou_payment_status(Integer sou_payment_status) {
		this.sou_payment_status = sou_payment_status;
	}
	public Integer getSou_shipment_status() {
		return sou_shipment_status;
	}
	public void setSou_shipment_status(Integer sou_shipment_status) {
		this.sou_shipment_status = sou_shipment_status;
	}
	
	
}
