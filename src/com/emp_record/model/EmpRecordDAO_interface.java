package com.emp_record.model;

import java.util.List;



public interface EmpRecordDAO_interface {
	  public void insert(EmpRecordVO empreVO);
      public void update(EmpRecordVO  empreVO);
      public void delete(String emp_record_id );
      public EmpRecordVO  findByPrimaryKey(String emp_record_id);
      public List<EmpRecordVO > getAll();
      

}
