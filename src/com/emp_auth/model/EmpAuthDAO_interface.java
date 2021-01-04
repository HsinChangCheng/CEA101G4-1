package com.emp_auth.model;
import java.util.List;

public interface EmpAuthDAO_interface {
	public void insert(EmpAuthVO emp_authVO);
    public void delete(String emp_id, String func_id);
    public EmpAuthVO findByPrimaryKey(String emp_id);
    public List<EmpAuthVO> getAll();
}