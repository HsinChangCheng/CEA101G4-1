package com.activity_order.model;

import java.util.List;
import java.util.Set;





public class ActivityOrderService {
	private ActivityOrderDAO_interface dao;

	public ActivityOrderService() {
		dao = new ActivityOrderJDBCDAO();
	}

	public List<ActivityOrderVO> getAll() {
		return dao.getAll();
	}

	public ActivityOrderVO getOneDept(String act_order_id) {
		return dao.findByPrimaryKey(act_order_id);
	}

//	public Set<ActivityOrderVO> getEmpsByDeptno(String act_order_id) {
//		return dao.getEmpsByDeptno(act_order_id);
//	}
//
//	public void deleteDept(Integer deptno) {
//		dao.delete(deptno);
//	}
}


