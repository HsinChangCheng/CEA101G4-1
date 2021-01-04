package com.emp.model;

import java.util.List;



public interface EmpDAO_interface {
	public void insert(EmpVO empVO);
    public void delete(String emp_id);
    public EmpVO findByPrimaryKey(String emp_id);
    public void update(EmpVO empVO);
    public List<EmpVO> getAll();
    public EmpVO findByAccount(String emp_account);

}
