package com.activity_period.model;

import java.util.List;
import java.util.Map;



public class ActivityPeriodService {
	private ActivityPeriodDAO_interface dao;

	public ActivityPeriodService() {
		dao = new ActivityPeriodJDBCDAO();
	}

	public List<ActivityPeriodVO> getAll() {
		return dao.getAll();
	}

	public ActivityPeriodVO getOneActPeriod(String act_period_id) {
		return dao.findByPrimaryKey(act_period_id);
	}
	public List<ActivityPeriodVO> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
	

//	public void deleteActType(String act_type_id) {
//		dao.delete(act_type_id);
//	}
}
