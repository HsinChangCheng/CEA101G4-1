package com.activity_photo.model;

import java.util.List;
import java.util.Set;


public class ActivityPhotoService {

	private ActivityPhotoDAO_interface dao;

	public ActivityPhotoService() {
		dao = new ActivityPhotoJDBCDAO();
	}

	public List<ActivityPhotoVO> getAll() {
		return dao.getAll();
	}

	public ActivityPhotoVO getOneActPho(String act_photo_id) {
		return dao.findByPrimaryKey(act_photo_id);
	}

	public Set<ActivityPhotoVO> getActPhoByActId(String act_id) {
		return dao.getActivityByActId(act_id);
	}
	public void upDatePhotoByActid(ActivityPhotoVO actphoVO) {
		dao.update_photo_by_act_photo_id(actphoVO);
	}

	public void deleteActPho(String act_photo_id) {
		dao.delete(act_photo_id);
	}
	public void insert(ActivityPhotoVO actphoVO) {
		dao.insert(actphoVO);
	}
	public void update(ActivityPhotoVO actphoVO) {
		dao.update(actphoVO);
	}
	
}
