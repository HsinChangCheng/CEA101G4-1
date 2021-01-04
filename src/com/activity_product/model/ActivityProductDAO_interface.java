package com.activity_product.model;

import java.util.List;
import java.util.Set;



public interface ActivityProductDAO_interface {
	public void insert(ActivityProductVO actpVO);
    public void update(ActivityProductVO actpVO);
    public ActivityProductVO findByPrimaryKey(String act_id);
    public void delete(String act_id);
    public List<ActivityProductVO> getAll();
    public List<ActivityProductVO> getAllbySellMemId(String sell_mem_id);
}
