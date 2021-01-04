package com.souvenir_discount_detail.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;


public class SouvenirDiscountDetailJDBCDAO implements SouvenirDiscountDetailDAO_interface {
	String driver = Util.DRIVER;
	String url = Util.URL;
	String userid = Util.USER;
	String passwd = Util.PASSWORD;
	
	private static final String INSERT_STMT =
			"INSERT INTO SOUVENIR_DISCOUNT_DETAIL(SOU_ID, SOU_DIS_ID, SOU_DIS_PRICE) VALUES (?, ?, ?)";
	private static final String UPDATE = 
			"UPDATE SOUVENIR_DISCOUNT_DETAIL SET SOU_DIS_PRICE=? where SOU_ID=? AND SOU_DIS_ID=?";
	private static final String GET_ONE_STMT = 
			"SELECT SOU_ID, SOU_DIS_ID , SOU_DIS_PRICE FROM SOUVENIR_DISCOUNT_DETAIL WHERE SOU_ID=? AND SOU_DIS_ID=?";
	private static final String GET_ALL_STMT = 
			"SELECT SOU_ID, SOU_DIS_ID , SOU_DIS_PRICE FROM SOUVENIR_DISCOUNT_DETAIL ORDER BY SOU_ID, SOU_DIS_ID";

	@Override
	public void insert(SouvenirDiscountDetailVO soddVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, soddVO.getSou_id());
			pstmt.setString(2, soddVO.getSou_dis_id());
			pstmt.setInt(3, soddVO.getSou_dis_price());
			
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(SouvenirDiscountDetailVO soddVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, soddVO.getSou_dis_price());
			pstmt.setString(2, soddVO.getSou_id());
			pstmt.setString(3, soddVO.getSou_dis_id());

			

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public SouvenirDiscountDetailVO findByPrimaryKey(String sou_id, String sou_dis_id) {

		SouvenirDiscountDetailVO soddVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, sou_id);
			 pstmt.setString(2, sou_dis_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				soddVO = new SouvenirDiscountDetailVO();

				soddVO.setSou_id(rs.getString("sou_id"));
				soddVO.setSou_dis_id(rs.getString("sou_dis_id"));
				soddVO.setSou_dis_price(rs.getInt("sou_dis_price"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return soddVO;
	}

	@Override
	public List<SouvenirDiscountDetailVO> getAll() {
		List<SouvenirDiscountDetailVO> list = new ArrayList<SouvenirDiscountDetailVO>();
		SouvenirDiscountDetailVO soddVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				soddVO = new SouvenirDiscountDetailVO();

				soddVO.setSou_id(rs.getString("sou_id"));
				soddVO.setSou_dis_id(rs.getString("sou_dis_id"));
				soddVO.setSou_dis_price(rs.getInt("sou_dis_price"));
				
				
				list.add(soddVO);
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

		SouvenirDiscountDetailJDBCDAO dao = new SouvenirDiscountDetailJDBCDAO();
		


//		增
//		SouvenirDiscountDetailVO soddVO1 = new SouvenirDiscountDetailVO();
//		soddVO1.setSou_id("SOU001");
//		soddVO1.setSou_dis_id("SD002");
//		soddVO1.setSou_dis_price(100);
//
//		
//		dao.insert(soddVO1);

		// 查詢
//		SouvenirDiscountDetailVO soddVO2 = dao.findByPrimaryKey("SOU001","SD001");
//		System.out.print(soddVO2.getSou_id() + ",");
//		System.out.print(soddVO2.getSou_dis_id() + ",");
//		System.out.print(soddVO2.getSou_dis_price() + ",");

		
		
		
//		System.out.println();
//		System.out.println("---------------------");

//		改
//		SouvenirDiscountDetailVO soddVO3 = new SouvenirDiscountDetailVO();
//
//		soddVO3.setSou_dis_price(300);
//		soddVO3.setSou_id("SOU001");
//		soddVO3.setSou_dis_id("SD002");
//
//		dao.update(soddVO3);

		// 查詢
		List<SouvenirDiscountDetailVO> list = dao.getAll();
		for (SouvenirDiscountDetailVO soddVO4 : list) {

			System.out.print(soddVO4.getSou_id() + ",");
			System.out.print(soddVO4.getSou_dis_id() + ",");
			System.out.print(soddVO4.getSou_dis_price() + ",");
	


			System.out.println();
		}

	}
}

