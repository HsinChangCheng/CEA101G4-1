package com.souvenir_type.model;

import java.util.*;

import util.Util;

import java.sql.*;



public class SouvenirTypeJDBCDAO implements SouvenirTypeDAO_interface{
	String driver = Util.DRIVER;
	String url = Util.URL;
	String userid = Util.USER;
	String passwd = Util.PASSWORD;
	
	private static final String INSERT_STMT = "INSERT INTO SOUVENIR_TYPE(SOU_TYPE_ID, SOU_TYPE_NAME)" + " VALUES ('ST' || LPAD(ST_SEQ.NEXTVAL, 3, '0'),?)";
	private static final String UPDATE = "UPDATE SOUVENIR_TYPE set SOU_TYPE_NAME=? where SOU_TYPE_ID=?";
	private static final String DELETE = "DELETE FROM SOUVENIR_TYPE where SOU_TYPE_ID = ?";
	private static final String GET_ONE_STMT = "SELECT SOU_TYPE_ID, SOU_TYPE_NAME FROM SOUVENIR_TYPE where SOU_TYPE_ID = ?";
	private static final String GET_ALL_STMT = "SELECT  SOU_TYPE_ID, SOU_TYPE_NAME FROM SOUVENIR_TYPE order by SOU_TYPE_ID";
	
		
	@Override
	public void insert(SouvenirTypeVO soutVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

//			pstmt.setString(1, soutVO.getSou_type_id());
			pstmt.setString(1, soutVO.getSou_type_name());
		
			

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
	public void update(SouvenirTypeVO soutVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, soutVO.getSou_type_name());
			pstmt.setString(2, soutVO.getSou_type_id());

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
	public void delete(String sou_type_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, sou_type_id);
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
	public SouvenirTypeVO findByPrimaryKey(String sou_type_id) {

		SouvenirTypeVO soutVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, sou_type_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
			
				soutVO = new SouvenirTypeVO();
				soutVO.setSou_type_id(rs.getString("sou_type_id"));
				soutVO.setSou_type_name(rs.getString("sou_type_name"));
							
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
		return soutVO;
	}

	@Override
	public List<SouvenirTypeVO> getAll() {
		List<SouvenirTypeVO> list = new ArrayList<SouvenirTypeVO>();
		SouvenirTypeVO soutVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
			
				soutVO = new SouvenirTypeVO();
				soutVO.setSou_type_id(rs.getString("sou_type_id"));
				soutVO.setSou_type_name(rs.getString("sou_type_name"));
				list.add(soutVO);
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

		SouvenirTypeJDBCDAO dao = new SouvenirTypeJDBCDAO();
		
		dao.delete("ST006");

		
//		增
		SouvenirTypeVO soutVO3 = new SouvenirTypeVO();
		soutVO3.setSou_type_name("水果啦");
		dao.insert(soutVO3);
		
		
		// 查詢
		SouvenirTypeVO soutVO1 = dao.findByPrimaryKey("ST002");
		System.out.print(soutVO1.getSou_type_id() + ",");
		System.out.print(soutVO1.getSou_type_name() + ",");
		System.out.println();
		System.out.println("---------------------");
		
		
//		改
		SouvenirTypeVO soutVO2 = new SouvenirTypeVO();
		soutVO2.setSou_type_id("ST001");
		soutVO2.setSou_type_name("可以了啦這個很好種類");
		dao.update(soutVO2);

		// 查詢
		List<SouvenirTypeVO> list = dao.getAll();
		for (SouvenirTypeVO aSod : list) {
			System.out.print(aSod.getSou_type_id() + ",");
			System.out.print(aSod.getSou_type_name() + ",");

			System.out.println();
		}
	}
}
