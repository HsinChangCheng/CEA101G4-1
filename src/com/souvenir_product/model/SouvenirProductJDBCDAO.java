package com.souvenir_product.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class SouvenirProductJDBCDAO implements SouvenirProductDAO_interface {
	String driver = Util.DRIVER;
	String url = Util.URL;
	String userid = Util.USER;
	String passwd = Util.PASSWORD;

	private static final String INSERT_STMT = "INSERT INTO SOUVENIR_PRODUCT(SOU_ID, SOU_TYPE_ID, SOU_NAME, SOU_PRICE, SOU_ON_DATE, SOU_OFF_DATE,SOU_LIKE_COUNT,SOU_DES,SOU_STATUS)"
			+ " VALUES ('SOU' || LPAD(SOU_SEQ.NEXTVAL, 3, '0'),?,?,?,?,?,?,?,?)";
	private static final String UPDATE = 
 	"UPDATE SOUVENIR_PRODUCT set SOU_TYPE_ID=?, SOU_NAME=?, SOU_PRICE=?, SOU_ON_DATE=?, SOU_OFF_DATE=?, SOU_LIKE_COUNT=? ,SOU_DES=? ,SOU_STATUS=? where SOU_ID=?";
	private static final String DELETE = "DELETE FROM SOUVENIR_PRODUCT where SOU_ID = ?";
	private static final String GET_ONE_STMT = "SELECT SOU_ID, SOU_TYPE_ID, SOU_NAME, SOU_PRICE, SOU_ON_DATE, SOU_OFF_DATE,  SOU_LIKE_COUNT, SOU_DES, SOU_STATUS FROM SOUVENIR_PRODUCT where SOU_ID = ?";
	private static final String GET_ALL_STMT = "SELECT SOU_ID, SOU_TYPE_ID, SOU_NAME, SOU_PRICE, SOU_ON_DATE, SOU_OFF_DATE,  SOU_LIKE_COUNT, SOU_DES, SOU_STATUS FROM SOUVENIR_PRODUCT order by SOU_ID";


	@Override
	public void insert(SouvenirProductVO soupVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, soupVO.getSou_type_id());
			pstmt.setString(2, soupVO.getSou_name());
			pstmt.setInt(3, soupVO.getSou_price());
			pstmt.setTimestamp(4, soupVO.getSou_on_date());
			pstmt.setTimestamp(5, soupVO.getSou_off_date());
			pstmt.setInt(6, soupVO.getSou_like_count());
			pstmt.setString(7, soupVO.getSou_des());
			pstmt.setInt(8, soupVO.getSou_status());

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
	public void update(SouvenirProductVO soupVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, soupVO.getSou_type_id());
			pstmt.setString(2, soupVO.getSou_name());
			pstmt.setInt(3, soupVO.getSou_price());
			pstmt.setTimestamp(4, soupVO.getSou_on_date());
			pstmt.setTimestamp(5, soupVO.getSou_off_date());
			pstmt.setInt(6, soupVO.getSou_like_count());
			pstmt.setString(7, soupVO.getSou_des());
			pstmt.setInt(8, soupVO.getSou_status());
			pstmt.setString(9, soupVO.getSou_id());
			

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
	public void delete(String sou_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, sou_id);
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
	public SouvenirProductVO findByPrimaryKey(String sou_id) {

		SouvenirProductVO soupVO = null;
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

				soupVO = new SouvenirProductVO();
				soupVO.setSou_id(rs.getString("sou_id"));
				soupVO.setSou_type_id(rs.getString("sou_type_id"));
				soupVO.setSou_name(rs.getString("sou_name"));
				soupVO.setSou_price(rs.getInt("sou_price"));
				soupVO.setSou_on_date(rs.getTimestamp("sou_on_date"));
				soupVO.setSou_off_date(rs.getTimestamp("sou_off_date"));
				soupVO.setSou_like_count(rs.getInt("sou_like_count"));
				soupVO.setSou_des(rs.getString("sou_des"));
				soupVO.setSou_status(rs.getInt("sou_status"));

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
		return soupVO;
	}

	@Override
	public List<SouvenirProductVO> getAll() {
		List<SouvenirProductVO> list = new ArrayList<SouvenirProductVO>();
		SouvenirProductVO soupVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				soupVO = new SouvenirProductVO();

				soupVO.setSou_id(rs.getString("sou_id"));
				soupVO.setSou_type_id(rs.getString("sou_type_id"));
				soupVO.setSou_name(rs.getString("sou_name"));
				soupVO.setSou_price(rs.getInt("sou_price"));
				soupVO.setSou_on_date(rs.getTimestamp("sou_on_date"));
				soupVO.setSou_off_date(rs.getTimestamp("sou_off_date"));
				soupVO.setSou_like_count(rs.getInt("sou_like_count"));
				soupVO.setSou_des(rs.getString("sou_des"));
				soupVO.setSou_status(rs.getInt("sou_status"));
				list.add(soupVO);
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

		SouvenirProductJDBCDAO dao = new SouvenirProductJDBCDAO();
		
		dao.delete("SOU004");

//		增
		SouvenirProductVO soupVO1 = new SouvenirProductVO();
		soupVO1.setSou_type_id("ST004");
		soupVO1.setSou_name("糖果");
		soupVO1.setSou_price(100);
		soupVO1.setSou_on_date(java.sql.Timestamp.valueOf("2020-12-5 6:30:00"));
		soupVO1.setSou_off_date(java.sql.Timestamp.valueOf("2020-12-12 6:30:00"));
		soupVO1.setSou_like_count(20);
		soupVO1.setSou_des("不錯啦");
		soupVO1.setSou_status(0);
		
		dao.insert(soupVO1);

		// 查詢
//		SouvenirProductVO soupVO2 = dao.findByPrimaryKey("SOU005");
//		System.out.print(soupVO2.getSou_id() + ",");
//		System.out.print(soupVO2.getSou_type_id() + ",");
//		System.out.print(soupVO2.getSou_name() + ",");
//		System.out.print(soupVO2.getSou_price() + ",");
//		System.out.print(soupVO2.getSou_on_date() + ",");
//		System.out.print(soupVO2.getSou_off_date() + ",");
//		System.out.print(soupVO2.getSou_like_count() + ",");
//		System.out.print(soupVO2.getSou_des() + ",");
//		System.out.print(soupVO2.getSou_status() + ",");
//
//		System.out.println();
//		System.out.println("---------------------");

//		改
//		SouvenirProductVO soupVO3 = new SouvenirProductVO();
//		soupVO3.setSou_id("SOU002");
//
//		soupVO3.setSou_type_id("ST002");
//		soupVO3.setSou_name("糖果");
//		soupVO3.setSou_price(100);
//		soupVO3.setSou_on_date(java.sql.Timestamp.valueOf("2020-12-5 6:30:00"));
//		soupVO3.setSou_off_date(java.sql.Timestamp.valueOf("2020-12-12 6:30:00"));
//		soupVO3.setSou_like_count(20);
//		soupVO3.setSou_des("啦");
//		soupVO3.setSou_status(0);
//		dao.update(soupVO3);

		// 查詢
		List<SouvenirProductVO> list = dao.getAll();
		for (SouvenirProductVO soupVO4 : list) {

			System.out.print(soupVO4.getSou_id() + ",");
			System.out.print(soupVO4.getSou_type_id() + ",");
			System.out.print(soupVO4.getSou_name() + ",");
			System.out.print(soupVO4.getSou_price() + ",");
			System.out.print(soupVO4.getSou_on_date() + ",");
			System.out.print(soupVO4.getSou_off_date() + ",");
			System.out.print(soupVO4.getSou_like_count() + ",");
			System.out.print(soupVO4.getSou_des() + ",");
			System.out.print(soupVO4.getSou_status() + ",");


			System.out.println();
		}

	}
}
