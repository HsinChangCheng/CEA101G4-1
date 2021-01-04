package com.activity_period.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import jdbc.util.CompositeQuery.jdbcUtil_CompositeQuery_Activity_Period;
import util.Util;

public class ActivityPeriodJDBCDAO implements ActivityPeriodDAO_interface {
	String driver = Util.DRIVER;
	String url = Util.URL;
	String userid = Util.USER;
	String passwd = Util.PASSWORD;

	private static final String INSERT_STMT = "INSERT INTO ACTIVITY_PERIOD(ACT_PERIOD_ID, ACT_ID, ACT_SIGN_START, ACT_SIGN_END, "
			+ "ACT_PERIOD_START, ACT_PERIOD_END, ACT_UP_LIMIT, ACT_LOW_LIMIT, ACT_CUR_PRICE,ACT_PERIOD_STATUS, ACT_SIGN_SUM)"
			+"VALUES('AP' || LPAD(AP_SEQ.NEXTVAL, 3, '0'), ?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT ACT_PERIOD_ID, ACT_ID, ACT_SIGN_START, ACT_SIGN_END," 
						+ "ACT_PERIOD_START, ACT_PERIOD_END, ACT_UP_LIMIT, ACT_LOW_LIMIT, ACT_CUR_PRICE,ACT_PERIOD_STATUS, ACT_SIGN_SUM FROM ACTIVITY_PERIOD";
	private static final String GET_ONE_STMT = "SELECT ACT_PERIOD_ID, ACT_ID, ACT_SIGN_START, ACT_SIGN_END," 
						+ "ACT_PERIOD_START, ACT_PERIOD_END, ACT_UP_LIMIT, ACT_LOW_LIMIT, ACT_CUR_PRICE,ACT_PERIOD_STATUS, ACT_SIGN_SUM FROM ACTIVITY_PERIOD where ACT_PERIOD_ID = ?";
//	private static final String GET_Mem_ByDeptno_STMT = "SELECT empno,ename,job,to_char(hiredate,'yyyy-mm-dd') hiredate,sal,comm,deptno FROM emp2 where deptno = ? order by empno";
//	
//	private static final String DELETE_ACTIVITY_TYPE = "DELETE FROM ACTIVITY_TYPE where deptno = ?";
//	private static final String DELETE = "DELETE FROM MEMBER1 where MEM_ID = ?";	

	private static final String UPDATE = "UPDATE  ACTIVITY_PERIOD set ACT_ID=?, ACT_SIGN_START=?, ACT_SIGN_END=?,"
			+ "ACT_PERIOD_START=?, ACT_PERIOD_END=?, ACT_UP_LIMIT=?, ACT_LOW_LIMIT=?, ACT_CUR_PRICE=?,ACT_PERIOD_STATUS=?, ACT_SIGN_SUM=? where ACT_PERIOD_ID=?";

	@Override
	public void insert(ActivityPeriodVO actperVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, actperVO.getAct_id());
			pstmt.setTimestamp(2, actperVO.getAct_sign_start());
			pstmt.setTimestamp(3, actperVO.getAct_sign_end());
			pstmt.setTimestamp(4, actperVO.getAct_period_start());
			pstmt.setTimestamp(5, actperVO.getAct_period_end());
			pstmt.setInt(6, actperVO.getAct_up_limit());
			pstmt.setInt(7, actperVO.getAct_low_limit());
			pstmt.setDouble(8, actperVO.getAct_cur_price());
			pstmt.setInt(9, actperVO.getAct_period_status());
			pstmt.setInt(10, actperVO.getAct_sign_sum());
			
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
	public void update(ActivityPeriodVO actperVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, actperVO.getAct_id());
			pstmt.setTimestamp(2, actperVO.getAct_sign_start());
			pstmt.setTimestamp(3, actperVO.getAct_sign_end());
			pstmt.setTimestamp(4, actperVO.getAct_period_start());
			pstmt.setTimestamp(5, actperVO.getAct_period_end());
			pstmt.setInt(6, actperVO.getAct_up_limit());
			pstmt.setInt(7, actperVO.getAct_low_limit());
			pstmt.setDouble(8, actperVO.getAct_cur_price());
			pstmt.setInt(9, actperVO.getAct_period_status());
			pstmt.setInt(10, actperVO.getAct_sign_sum());
			pstmt.setString(11, actperVO.getAct_period_id());
			
			pstmt.executeUpdate();
			
			

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
	public ActivityPeriodVO findByPrimaryKey(String act_period_id) {
		ActivityPeriodVO actperVO=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, act_period_id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				actperVO=new ActivityPeriodVO();
				actperVO.setAct_period_id(rs.getString("act_period_id"));
				actperVO.setAct_id(rs.getString("act_id"));
				actperVO.setAct_sign_start(rs.getTimestamp("act_sign_start"));
				actperVO.setAct_sign_end(rs.getTimestamp("act_sign_end"));
				actperVO.setAct_period_start(rs.getTimestamp("act_period_end"));
				actperVO.setAct_period_end(rs.getTimestamp("act_period_end"));
				actperVO.setAct_up_limit(rs.getInt("act_up_limit"));
				actperVO.setAct_low_limit(rs.getInt("act_low_limit"));
				actperVO.setAct_cur_price(rs.getDouble("act_cur_price"));
				actperVO.setAct_period_status(rs.getInt("act_period_status"));
				actperVO.setAct_sign_sum(rs.getInt("act_sign_sum"));
				
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
		return actperVO;
	}

	@Override
	public void delete(String act_period_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActivityPeriodVO findbyaddress(ActivityPeriodVO act_period_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityPeriodVO> getAll() {
		List<ActivityPeriodVO>list=new ArrayList<ActivityPeriodVO>();
		ActivityPeriodVO actperVO=null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				actperVO=new ActivityPeriodVO();
				actperVO.setAct_period_id(rs.getString("act_period_id"));
				actperVO.setAct_id(rs.getString("act_id"));
				actperVO.setAct_sign_start(rs.getTimestamp("act_sign_start"));
				actperVO.setAct_sign_end(rs.getTimestamp("act_sign_end"));
				actperVO.setAct_period_start(rs.getTimestamp("act_period_end"));
				actperVO.setAct_period_end(rs.getTimestamp("act_period_end"));
				actperVO.setAct_up_limit(rs.getInt("act_up_limit"));
				actperVO.setAct_low_limit(rs.getInt("act_low_limit"));
				actperVO.setAct_cur_price(rs.getDouble("act_cur_price"));
				actperVO.setAct_period_status(rs.getInt("act_period_status"));
				actperVO.setAct_sign_sum(rs.getInt("act_sign_sum"));
				list.add(actperVO);
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
	public List<ActivityPeriodVO> getAll(Map<String, String[]> map) {
		List<ActivityPeriodVO> list = new ArrayList<ActivityPeriodVO>();
		ActivityPeriodVO actperVO = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			
			con = DriverManager.getConnection(url, userid, passwd);
			String finalSQL = "SELECT * FROM ACTIVITY_PERIOD "
		          + jdbcUtil_CompositeQuery_Activity_Period.get_WhereCondition(map)
		          + "order by act_period_id";
			pstmt = con.prepareStatement(finalSQL);
			System.out.println("●●finalSQL(by DAO) = "+finalSQL);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				actperVO=new ActivityPeriodVO();
				actperVO.setAct_period_id(rs.getString("act_period_id"));
				actperVO.setAct_id(rs.getString("act_id"));
				actperVO.setAct_sign_start(rs.getTimestamp("act_sign_start"));
				actperVO.setAct_sign_end(rs.getTimestamp("act_sign_end"));
				actperVO.setAct_period_start(rs.getTimestamp("act_period_end"));
				actperVO.setAct_period_end(rs.getTimestamp("act_period_end"));
				actperVO.setAct_up_limit(rs.getInt("act_up_limit"));
				actperVO.setAct_low_limit(rs.getInt("act_low_limit"));
				actperVO.setAct_cur_price(rs.getDouble("act_cur_price"));
				actperVO.setAct_period_status(rs.getInt("act_period_status"));
				actperVO.setAct_sign_sum(rs.getInt("act_sign_sum"));
				list.add(actperVO);
			}
	
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
		return list;
	}
	public static void main(String[] args) {
		ActivityPeriodJDBCDAO dao=new ActivityPeriodJDBCDAO();
		// 新增 ====================================
//		ActivityPeriodVO actperVO = new ActivityPeriodVO();
//		actperVO.setAct_id("ACT001");
//		actperVO.setAct_sign_start(java.sql.Timestamp.valueOf("2020-11-10 15:00:00"));
//		actperVO.setAct_sign_end(java.sql.Timestamp.valueOf("2020-11-13 15:00:00"));
//		actperVO.setAct_period_start(java.sql.Timestamp.valueOf("2020-11-20 15:00:00"));
//		actperVO.setAct_period_end(java.sql.Timestamp.valueOf("2020-11-20 17:00:00"));
//		actperVO.setAct_up_limit(20);
//		actperVO.setAct_low_limit(5);
//		actperVO.setAct_cur_price(2000D);
//		actperVO.setAct_period_status(1);
//		actperVO.setAct_sign_sum(16);
//		dao.insert(actperVO);
		//修改=====================================
//		ActivityPeriodVO actperVO2 = new ActivityPeriodVO();
//		actperVO2.setAct_id("ACT003");
//		actperVO2.setAct_sign_start(java.sql.Timestamp.valueOf("2020-03-10 15:00:00"));
//		actperVO2.setAct_sign_end(java.sql.Timestamp.valueOf("2020-04-13 15:00:00"));
//		actperVO2.setAct_period_start(java.sql.Timestamp.valueOf("2020-06-20 15:00:00"));
//		actperVO2.setAct_period_end(java.sql.Timestamp.valueOf("2020-07-20 17:00:00"));
//		actperVO2.setAct_up_limit(222);
//		actperVO2.setAct_low_limit(101);
//		actperVO2.setAct_cur_price(36600D);
//		actperVO2.setAct_period_status(1);
//		actperVO2.setAct_sign_sum(300);
//		actperVO2.setAct_period_id("AP007");
//		dao.update(actperVO2);
		//查詢 getByPK=============================
//		ActivityPeriodVO actperVO3 = dao.findByPrimaryKey("AP003");
//		System.out.println(actperVO3.getAct_id());
//		System.out.println(actperVO3.getAct_sign_start());
//		System.out.println(actperVO3.getAct_sign_end());
//		System.out.println(actperVO3.getAct_period_start());
//		System.out.println(actperVO3.getAct_period_end());
//		System.out.println(actperVO3.getAct_up_limit());
//		System.out.println(actperVO3.getAct_low_limit());
//		System.out.println(actperVO3.getAct_cur_price());
//		System.out.println(actperVO3.getAct_period_status());
//		System.out.println(actperVO3.getAct_sign_sum());
		//查詢 getAll================================
		List<ActivityPeriodVO>list=dao.getAll();
		for(ActivityPeriodVO aActPer:list) {
			
			System.out.println(aActPer.getAct_id());
			System.out.println(aActPer.getAct_sign_start());
			System.out.println(aActPer.getAct_sign_end());
			System.out.println(aActPer.getAct_period_start());
			System.out.println(aActPer.getAct_period_end());
			System.out.println(aActPer.getAct_up_limit());
			System.out.println(aActPer.getAct_low_limit());
			System.out.println(aActPer.getAct_cur_price());
			System.out.println(aActPer.getAct_period_status());
			System.out.println(aActPer.getAct_sign_sum());
			System.out.println("=============================");
		}
		
	}

}
