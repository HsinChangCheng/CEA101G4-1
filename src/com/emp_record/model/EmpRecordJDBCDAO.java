package com.emp_record.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.activity_photo.model.ActivityPhotoJDBCDAO;
import com.activity_photo.model.ActivityPhotoVO;

import util.Util;

public class EmpRecordJDBCDAO implements EmpRecordDAO_interface {
	String driver = Util.DRIVER;
	String url = Util.URL;
	String userid = Util.USER;
	String passwd = Util.PASSWORD;
	private static final String INSERT_STMT = "INSERT INTO EMP_RECORD(EMP_RECORD_ID, EMP_ID, EMP_RECORD_CONTENT, EMP_RECORD_READ)"
			+ "VALUES('ER' || LPAD(EMPR_SEQ.NEXTVAL, 3, '0'), ?,?,?)";
	private static final String GET_ALL_STMT = "SELECT EMP_RECORD_ID, EMP_ID,EMP_RECORD_TIME, EMP_RECORD_CONTENT, EMP_RECORD_READ FROM EMP_RECORD";
	private static final String GET_ONE_STMT = "SELECT  EMP_ID,EMP_RECORD_TIME, EMP_RECORD_CONTENT, EMP_RECORD_READ FROM EMP_RECORD where EMP_RECORD_ID = ?";
//	private static final String GET_Mem_ByDeptno_STMT = "SELECT empno,ename,job,to_char(hiredate,'yyyy-mm-dd') hiredate,sal,comm,deptno FROM emp2 where deptno = ? order by empno";
//	
//	private static final String DELETE_ACTIVITY_TYPE = "DELETE FROM ACTIVITY_TYPE where deptno = ?";
	private static final String DELETE = "DELETE FROM EMP_RECORD where EMP_RECORD_ID = ?";

	private static final String UPDATE = "UPDATE EMP_RECORD set EMP_ID=?, EMP_RECORD_CONTENT=?, EMP_RECORD_READ=? where EMP_RECORD_ID=?";

	@Override
	public void insert(EmpRecordVO empreVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, empreVO.getEmp_id());
			pstmt.setString(2, empreVO.getEmp_record_content());
			pstmt.setInt(3, empreVO.getEmp_record_read());
//			

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
	public void update(EmpRecordVO empreVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, empreVO.getEmp_id());
			pstmt.setString(2, empreVO.getEmp_record_content());
			pstmt.setInt(3, empreVO.getEmp_record_read());
			pstmt.setString(4, empreVO.getEmp_record_id());

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
	public void delete(String emp_record_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, emp_record_id);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. " + excep.getMessage());
				}
			}
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public EmpRecordVO findByPrimaryKey(String emp_record_id) {
		EmpRecordVO empreVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, emp_record_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				empreVO = new EmpRecordVO();
				
				empreVO.setEmp_id(rs.getString("EMP_ID"));
				empreVO.setEmp_record_time(rs.getTimestamp("EMP_RECORD_TIME"));
				empreVO.setEmp_record_content(rs.getString("EMP_RECORD_CONTENT"));
				empreVO.setEmp_record_read(rs.getInt("EMP_RECORD_READ"));

				
			}
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
		return empreVO;
	}

	@Override
	public List<EmpRecordVO> getAll() {
		List<EmpRecordVO> list = new ArrayList<EmpRecordVO>();
		EmpRecordVO empreVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				empreVO = new EmpRecordVO();
				empreVO.setEmp_record_id(rs.getString("EMP_RECORD_ID"));
				empreVO.setEmp_id(rs.getString("EMP_ID"));
				empreVO.setEmp_record_time(rs.getTimestamp("EMP_RECORD_TIME"));
				empreVO.setEmp_record_content(rs.getString("EMP_RECORD_CONTENT"));
				empreVO.setEmp_record_read(rs.getInt("EMP_RECORD_READ"));

				list.add(empreVO);
			}
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
		EmpRecordJDBCDAO dao = new EmpRecordJDBCDAO();
		// 新增=======================================================
//		EmpRecordVO empreVO = new EmpRecordVO();
//		empreVO.setEmp_id("EMP001");
//		empreVO.setEmp_record_content("傑哥天體營 歡迎大家加入");
//		empreVO.setEmp_record_read(0);
//		dao.insert(empreVO);
		// 修改=======================================================
//		EmpRecordVO empreVO2 = new EmpRecordVO();
//		empreVO2.setEmp_id("EMP002");
//		empreVO2.setEmp_record_content("你的專題要不行了吧");
//		empreVO2.setEmp_record_read(1);
//		empreVO2.setEmp_record_id("ER003");
//		dao.update(empreVO2);
		// 刪除=======================================================
//		dao.delete("ER004");
		// 查詢 getAll================================================
//		List<EmpRecordVO> list = dao.getAll();
//		for (EmpRecordVO aEmpre : list) {
//			System.out.println(aEmpre.getEmp_record_id());
//			System.out.println(aEmpre.getEmp_id());
//			System.out.println(aEmpre.getEmp_record_time());
//			System.out.println(aEmpre.getEmp_record_content());
//			System.out.println(aEmpre.getEmp_record_read());
//
//			System.out.println("==============================");
//		}
		//查詢getByPK=================================================
		EmpRecordVO empreVO3 = dao.findByPrimaryKey("ER001");
		System.out.println(empreVO3.getEmp_id());
		System.out.println(empreVO3.getEmp_record_time());
		System.out.println(empreVO3.getEmp_record_content());
		System.out.println(empreVO3.getEmp_record_read());
		System.out.println("==============================");
		
	}
}
