package com.activity_period.model;

import java.util.List;
import java.util.Map;
import java.util.Set;



public interface ActivityPeriodDAO_interface {
	public void insert(ActivityPeriodVO actperVO);
    public void update(ActivityPeriodVO actperVO);
    public ActivityPeriodVO findByPrimaryKey(String act_period_id);
    public void delete(String act_period_id);
    public ActivityPeriodVO findbyaddress(ActivityPeriodVO act_period_id);
    public List<ActivityPeriodVO> getAll();
    public List<ActivityPeriodVO> getAll(Map<String, String[]> map);
//    public Set<ActivityPeriodVO> getEmpsByDeptno(ActivityPeriodVO actperVO);

}
