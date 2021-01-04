package com.room.model;

import java.util.List;
import java.util.Map;

public interface RoomDAO_interface {
    public void insert(RoomVO roomVO);
    public void update(RoomVO roomVO);
    public void delete(String roomId);
    public RoomVO findByPrimaryKey(String roomId);
    public List<RoomVO> getAll();
    
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//    public List<RoomVO> getFilter(Map<String, String[]> map); 
    
    public List<RoomVO> getByMemId(String sellMemId);
	
}
