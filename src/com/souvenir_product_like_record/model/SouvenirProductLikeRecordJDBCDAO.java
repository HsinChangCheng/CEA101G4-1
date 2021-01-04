package com.souvenir_product_like_record.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;



public class SouvenirProductLikeRecordJDBCDAO implements SouvenirProductLikeRecordDAO_interface{
	String driver = Util.DRIVER;
	String url = Util.URL;
	String userid = Util.USER;
	String passwd = Util.PASSWORD;
	
	private static final String INSERT_STMT = "INSERT INTO SOUVENIR_PRODUCT_LIKE_RECORD(SOU_ID, MEM_ID)" + " VALUES (?,?)";
	private static final String DELETE = "DELETE FROM SOUVENIR_PRODUCT_LIKE_RECORD where SOU_ID = ? AND MEM_ID = ?";
	private static final String GET_ONE_STMT = "SELECT SOU_ID, MEM_ID FROM SOUVENIR_PRODUCT_LIKE_RECORD where SOU_ID = ?";
	private static final String GET_ALL_STMT = "SELECT SOU_ID, MEM_ID FROM SOUVENIR_PRODUCT_LIKE_RECORD order by SOU_ID";
	
		
	@Override
	public void insert(SouvenirProductLikeRecordVO souprVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, souprVO.getSou_id());
			pstmt.setString(2, souprVO.getMem_id());
		
			

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
	public void delete(String sou_id, String mem_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, sou_id);
			pstmt.setString(2, mem_id);
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
	public SouvenirProductLikeRecordVO findByPrimaryKey(String sou_id) {

		SouvenirProductLikeRecordVO souprVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, sou_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
			
				souprVO = new SouvenirProductLikeRecordVO();
				souprVO.setSou_id(rs.getString("sou_id"));
				souprVO.setMem_id(rs.getString("mem_id"));
			}

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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
		return souprVO;
	}

	@Override
	public List<SouvenirProductLikeRecordVO> getAll() {
		List<SouvenirProductLikeRecordVO> list = new ArrayList<SouvenirProductLikeRecordVO>();
		SouvenirProductLikeRecordVO souprVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
			
				souprVO = new SouvenirProductLikeRecordVO();
				souprVO.setSou_id(rs.getString("sou_id"));
				souprVO.setMem_id(rs.getString("mem_id"));
				list.add(souprVO);
			}

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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
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
		return list;
	}
	public static void main(String[] args) {

		SouvenirProductLikeRecordJDBCDAO dao = new SouvenirProductLikeRecordJDBCDAO();
		
		dao.delete("SOU001", "MEM001");

		
//		增
		SouvenirProductLikeRecordVO souprVO3 = new SouvenirProductLikeRecordVO();
		
		souprVO3.setSou_id("SOU001");
		souprVO3.setMem_id("MEM002");
		dao.insert(souprVO3);
		
		
		// 查詢
		SouvenirProductLikeRecordVO souprVO = dao.findByPrimaryKey("SOU001");
		System.out.print(souprVO.getSou_id() + ",");
		System.out.print(souprVO.getMem_id() + ",");
		System.out.println();
		System.out.println("---------------------");
		
		


		// 查詢
		List<SouvenirProductLikeRecordVO> list = dao.getAll();
		for (SouvenirProductLikeRecordVO souprVO2 : list) {
			System.out.print(souprVO2.getSou_id() + ",");
			System.out.print(souprVO2.getMem_id ()+ ",");

			System.out.println();
		}
	}
}

