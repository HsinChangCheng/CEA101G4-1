package com.activity_photo.model;

import java.util.List;
import java.util.Set;



public interface ActivityPhotoDAO_interface {
	public void insert(ActivityPhotoVO actphoVO);
    public void update(ActivityPhotoVO actphoVO);
    public void update_photo_by_act_photo_id(ActivityPhotoVO actphoVO);
    public  ActivityPhotoVO findByPrimaryKey(String act_photo_id);
    public void delete(String act_id);
    public List<ActivityPhotoVO> getAll();
    public Set<ActivityPhotoVO> getActivityByActId(String act_id);
}
