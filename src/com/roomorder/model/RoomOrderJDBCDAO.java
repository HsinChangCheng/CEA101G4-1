package com.roomorder.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import util.Util;

public class RoomOrderJDBCDAO implements RoomOrderDAO_interface{
	
	private static final String INSERT_STMT = 
			"INSERT INTO ROOM_ORDER(ROOM_ORDER_ID, SELL_MEM_ID, MEM_ID, ROOM_ORDER_TIME, CHECK_IN_DATE, CHECK_OUT, EXPECT_ARR_TIME, ROOM_ORDER_REMARKS, ROOM_ORDER_SUM, ROOM_ORDER_STATUS, ROOM_PAYMENT_STATUS) "
			+ "VALUES('RO' || LPAD(RO_SEQ.NEXTVAL, 3, '0'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
			"SELECT * FROM ROOM_ORDER";
	private static final String GET_ONE_STMT = 
			"SELECT * FROM ROOM_ORDER WHERE ROOM_ORDER_ID=?";
	private static final String DELETE = 
			"DELETE FROM ROOM_ORDER WHERE ROOM_ORDER_ID=?";
	private static final String UPDATE = 
			"UPDATE ROOM_ORDER SET , SELL_MEM_ID=?, MEM_ID=?, ROOM_ORDER_TIME=?, CHECK_IN_DATE=?, CHECK_OUT=?, EXPECT_ARR_TIME=?, ROOM_ORDER_REMARKS=?, "
			+ "ROOM_ORDER_SUM=?, ROOM_ORDER_STATUS=?, ROOM_PAYMENT_STATUS=? WHERE ROOM_ORDER_ID=? )";
	

	@Override
	public void insert(RoomOrderVO roomOrderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(Util.DRIVER);
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, roomOrderVO.getRoomOrderId());
			pstmt.setString(2, roomOrderVO.getSellMemId());
			pstmt.setString(3, roomOrderVO.getMemId());
			pstmt.setTimestamp(4, roomOrderVO.getRoomOrderTime());
			pstmt.setDate(5, roomOrderVO.getCheckInDate());
			pstmt.setDate(6, roomOrderVO.getCheckOutDate());
			pstmt.setTimestamp(6, roomOrderVO.getExpectArrTime());
//			pstmt.setInt(7, roomOrderVO.getRoomOrderRemarks());
			pstmt.setInt(7, roomOrderVO.getRoomOrderSum());
			pstmt.setInt(7, roomOrderVO.getRoomOrderStatus());
			pstmt.setInt(7, roomOrderVO.getRoomPaymentStatus());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public void update(RoomOrderVO roomOrderVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String roomOrderId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(Util.DRIVER);
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, roomOrderId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		
	}

	@Override
	public RoomOrderVO findByPrimaryKey(String roomOrderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomOrderVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
