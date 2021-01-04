package com.roomproductcollect.model;

import java.util.List;

import com.roomorderdetail.model.RoomOrderDetailVO;

	public interface RoomProductCollectDAO_interface {
		public void insert(String mem_id, String room_id);
		public void delete(String mem_id, String room_id);
		
		public List<RoomProductCollectVO> getAll();
		public List<String> findByMemId(String mem_id);
		public List<String> findByRoomId(String room_id);
		
		//計算收藏數
		public int countCollect(String room_id);
		
//	    public RoomProductCollectVO findByMemId(String mem_id);
//		public RoomProductCollectVO findByRoomId(String room_id);
	}
