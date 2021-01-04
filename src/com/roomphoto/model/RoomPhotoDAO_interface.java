package com.roomphoto.model;

import java.util.List;

public interface RoomPhotoDAO_interface {
	
	public void insert(RoomPhotoVO roomPhotoVO);
	public void update(RoomPhotoVO roomPhotoVO);
	public void delete(String roomPhotoId);
	public RoomPhotoVO findByPrimaryKey(String roomPhotoId);
	public List<RoomPhotoVO> getAll();
    // 萬用複合查詢(傳入參數型態Map)(回傳 List)
    // public List<RoomPhotoVO> getAll(Map<String, String[]> map); 
	public List<RoomPhotoVO> getByRoomId(String roomId);

}
