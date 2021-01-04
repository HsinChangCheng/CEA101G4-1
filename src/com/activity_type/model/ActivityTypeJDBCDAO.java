package com.activity_type.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.activity_product.model.ActivityProductVO;

import util.Util;

public class ActivityTypeJDBCDAO implements ActivityTypeDAO_interface {
	String driver = Util.DRIVER;
	String url = Util.URL;
	String userid = Util.USER;
	String passwd = Util.PASSWORD;
	private static final String INSERT_STMT = "INSERT INTO ACTIVITY_TYPE (ACT_TYPE_ID,ACT_TYPE_NAME) VALUES "
			+ "('AT' || LPAD(AT_SEQ.NEXTVAL, 3, '0'), ?)";
	private static final String GET_ALL_STMT = "SELECT ACT_TYPE_ID,ACT_TYPE_NAME FROM ACTIVITY_TYPE";
	private static final String GET_ONE_STMT = "SELECT ACT_TYPE_ID,ACT_TYPE_NAME FROM ACTIVITY_TYPE where ACT_TYPE_ID = ?";
	private static final String GET_Act_ByActivityType_STMT = "SELECT ACT_ID, SELL_MEM_ID, ACT_TYPE_ID, ACT_NAME, ACT_PRICE,ACT_DES,"
			+ "ACT_ADD FROM ACTIVITY_PRODUCT where ACT_TYPE_ID = ? order by ACT_ID";

//	private static final String DELETE_ACTIVITY_TYPE = "DELETE FROM ACTIVITY_TYPE where deptno = ?";
//	private static final String DELETE_DEPT = "DELETE FROM dept2 where deptno = ?";	

	private static final String UPDATE = "UPDATE ACTIVITY_TYPE set ACT_TYPE_NAME=? where ACT_TYPE_ID = ?";

	@Override
	public void insert(ActivityTypeVO activitytypeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, activitytypeVO.getAct_type_name());

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
	public void update(ActivityTypeVO activitytypeVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, activitytypeVO.getAct_type_name());
			pstmt.setString(2, activitytypeVO.getAct_type_id());

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

	public Set<ActivityProductVO> getActivityByActType(String act_type_id) {
		Set<ActivityProductVO> set = new LinkedHashSet<ActivityProductVO>();
		ActivityProductVO apVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_Act_ByActivityType_STMT);
			pstmt.setString(1, act_type_id);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				apVO = new ActivityProductVO();
				apVO.setAct_id(rs.getString("ACT_ID"));
				apVO.setSell_mem_id(rs.getString("SELL_MEM_ID"));
				apVO.setAct_type_id(rs.getString("ACT_TYPE_ID"));
				apVO.setAct_name(rs.getString("ACT_NAME"));
				apVO.setAct_price(rs.getDouble("ACT_PRICE"));
				apVO.setAct_des(rs.getString("ACT_DES"));
				apVO.setAct_add(rs.getString("ACT_ADD"));
				set.add(apVO); // Store the row in the vector
			}
	
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return set;
	}

	@Override
	public ActivityTypeVO findByPrimaryKey(String act_type_id) {
		ActivityTypeVO atVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, act_type_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// deptVO 也稱為 Domain objects
				atVO = new ActivityTypeVO();
				atVO.setAct_type_id(rs.getString("ACT_TYPE_ID"));
				atVO.setAct_type_name(rs.getString("ACT_TYPE_NAME"));

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
		return atVO;
	}

	@Override
	public void delete(ActivityTypeVO activitytypeVO) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ActivityTypeVO> getAll() {
		List<ActivityTypeVO> list = new ArrayList<ActivityTypeVO>();
		ActivityTypeVO atVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				atVO = new ActivityTypeVO();
				atVO.setAct_type_id(rs.getString("ACT_TYPE_ID"));
				atVO.setAct_type_name(rs.getString("ACT_TYPE_NAME"));
				list.add(atVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		ActivityTypeJDBCDAO dao = new ActivityTypeJDBCDAO();
		// 新增 ====================================
//		ActivityTypeVO atVO = new ActivityTypeVO();
//		atVO.setActivity_type_name("亞輯帶你高高飛");
//		dao.insert(atVO);
		// ========================================
		// 修改=====================================
//		ActivityTypeVO atVO2 = new ActivityTypeVO();
//		atVO2.setActivity_type_name("亞輯帶你高高飛");
//		atVO2.setActivity_type_id("AT006");
//		dao.update(atVO2);
		// 刪除=====================================

		// 查詢by PK================================
		ActivityTypeVO atVO3 = dao.findByPrimaryKey("AT001");
		System.out.println(atVO3.getAct_type_id());
		System.out.println(atVO3.getAct_type_name());
	
		System.out.println("---------------------");
		// 查詢 Getall==============================
//		List<ActivityTypeVO> list = dao.getAll();
//		for (ActivityTypeVO atVO : list) {
//			System.out.print(atVO.getActivity_type_name());
//			System.out.println();
//		}
		//查詢getByActivityType====================
//		Set<ActivityProductVO> set=dao.getActivityByActType("AT001");
//		for(ActivityProductVO apVO:set) {
//			
//			
//			System.out.println(apVO.getAct_id());
//			System.out.println(apVO.getSell_mem_id());
//			System.out.println(apVO.getAct_type_id());
//			System.out.println(apVO.getAct_name());
//			System.out.println(apVO.getAct_des());
//			System.out.println(apVO.getAct_add());
//			System.out.println("=========================");
//			
//		}

	}

}
