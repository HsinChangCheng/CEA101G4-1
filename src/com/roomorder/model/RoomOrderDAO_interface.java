package com.roomorder.model;

import java.util.List;

public interface RoomOrderDAO_interface {
    public void insert(RoomOrderVO roomOrderVO);
    public void update(RoomOrderVO roomOrderVO);
    public void delete(String roomOrderId);
    public RoomOrderVO findByPrimaryKey(String roomOrderId);
    public List<RoomOrderVO> getAll();
    // 萬用複合查詢(傳入參數型態Map)(回傳 List)
    // public List<RoomOrderVO> getAll(Map<String, String[]> map); 
	

}
