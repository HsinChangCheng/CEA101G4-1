package com.activity_type.model;
import java.util.*;

import com.activity_product.model.ActivityProductVO;




public interface ActivityTypeDAO_interface {

	public void insert(ActivityTypeVO activitytypeVO);
	public void update(ActivityTypeVO activitytypeVO);
	public void delete(ActivityTypeVO activitytypeVO);
	public ActivityTypeVO findByPrimaryKey(String activity_type_id);
	public List<ActivityTypeVO> getAll();
	public Set<ActivityProductVO> getActivityByActType(String act_type_id);
}
