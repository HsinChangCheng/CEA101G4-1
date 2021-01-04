package com.roomorder.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class RoomOrderService {
	
	private RoomOrderDAO_interface dao;
	
	public RoomOrderService( ) {
		dao = new RoomOrderJDBCDAO();
	}
	
	public RoomOrderVO addRoomOrder(String roomOrderId, String sellMemId, String memId, Timestamp roomOrderTime, Date checkInDate
			, Date checkOutDate, Timestamp expectArrTime, String roomOrderRemarks, Integer roomOrderSum, Integer roomOrderStatus
			, Integer roomPaymentStatus) {
		
		RoomOrderVO roomOrderVO = new RoomOrderVO();
		
		roomOrderVO.setRoomOrderId(roomOrderId);
		roomOrderVO.setSellMemId(sellMemId);
		roomOrderVO.setMemId(memId);
		roomOrderVO.setRoomOrderTime(roomOrderTime);
		roomOrderVO.setCheckInDate(checkInDate);
		roomOrderVO.setCheckOutDate(checkOutDate);
		roomOrderVO.setExpectArrTime(expectArrTime);
		roomOrderVO.setRoomOrderRemarks(roomOrderRemarks);
		roomOrderVO.setRoomOrderSum(roomOrderSum);
		roomOrderVO.setRoomOrderStatus(roomOrderStatus);
		roomOrderVO.setRoomPaymentStatus(roomPaymentStatus);
		dao.insert(roomOrderVO);	
		
		return roomOrderVO;
	}
	
	public RoomOrderVO updateRoomOrder(String roomOrderId, String sellMemId, String memId, Timestamp roomOrderTime, Date checkInDate
			, Date checkOutDate, Timestamp expectArrTime, String roomOrderRemarks, Integer roomOrderSum, Integer roomOrderStatus
			, Integer roomPaymentStatus) {
		
		RoomOrderVO roomOrderVO = new RoomOrderVO();
		
		roomOrderVO.setRoomOrderId(roomOrderId);
		roomOrderVO.setSellMemId(sellMemId);
		roomOrderVO.setMemId(memId);
		roomOrderVO.setRoomOrderTime(roomOrderTime);
		roomOrderVO.setCheckInDate(checkInDate);
		roomOrderVO.setCheckOutDate(checkOutDate);
		roomOrderVO.setExpectArrTime(expectArrTime);
		roomOrderVO.setRoomOrderRemarks(roomOrderRemarks);
		roomOrderVO.setRoomOrderSum(roomOrderSum);
		roomOrderVO.setRoomOrderStatus(roomOrderStatus);
		roomOrderVO.setRoomPaymentStatus(roomPaymentStatus);
		dao.update(roomOrderVO);	
		
		return roomOrderVO;
	}
	
	public void deleteRoomOrder(String roomOrderId) {
		dao.delete(roomOrderId);
	}
	
	public RoomOrderVO getOneRoomOrder(String roomOrderId) {
		return dao.findByPrimaryKey(roomOrderId);
	}
	
	public List<RoomOrderVO> getAll() {
		return dao.getAll();
	}

}
