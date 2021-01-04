package com.emp_auth.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpAuthJDBCDAO implements EmpAuthDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "CEA101G4";
	String passwd = "CEA101G4";
	private static final String INSERT_STMT = "INSERT INTO EMP_AUTH(EMP_ID, FUNC_ID) VALUES(?,?)";
	private static final String GET_ALL_STMT = "SELECT * FROM EMP_AUTH ORDER BY EMP_ID";
	private static final String GET_ONE_STMT = "SELECT * FROM EMP_AUTH WHERE EMP_ID = ?";
	private static final String DELETE = "DELETE FROM EMP_AUTH WHERE EMP_ID = ? AND FUNC_ID = ?";
	@Override
	public void insert(EmpAuthVO emp_authVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, emp_authVO.getEmp_id());
			pstmt.setString(2, emp_authVO.getFunc_id());

		

			pstmt.executeUpdate();
			System.out.println("新增成功 insert method");

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
	public void delete(String emp_id, String func_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, emp_id);
			pstmt.setString(2, func_id);
			pstmt.executeUpdate();
			System.out.println("刪除成功 delete method");
			
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		} catch (Exception se) {
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
	public EmpAuthVO findByPrimaryKey(String emp_id) {
		// TODO Auto-generated method stub
		EmpAuthVO empauthVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, emp_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				empauthVO = new EmpAuthVO();
				empauthVO.setEmp_id(rs.getString("emp_id"));
				empauthVO.setFunc_id(rs.getString("func_id"));
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
		return empauthVO;
	}

	@Override
	public List<EmpAuthVO> getAll() {
		// TODO Auto-generated method stub
		List<EmpAuthVO> list = new ArrayList<EmpAuthVO>();
		EmpAuthVO emp_authVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				emp_authVO = new EmpAuthVO();
				emp_authVO.setEmp_id(rs.getString("emp_id"));
				emp_authVO.setFunc_id(rs.getString("func_id"));
				list.add(emp_authVO); // Store the row in the list
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
		EmpAuthJDBCDAO dao = new EmpAuthJDBCDAO();
		//新增
//		EmpAuthVO empauthVO1 = new EmpAuthVO();
//		empauthVO1.setEmp_id("EMP002");
//		empauthVO1.setFunc_id("AUTH003");
//		dao.insert(empauthVO1);
		//查詢
//		List<EmpAuthVO> list = dao.getAll();
//		for(EmpAuthVO aEmp_Auth : list) {
//			System.out.print(aEmp_Auth.getEmp_id() + ",");
//			System.out.println(aEmp_Auth.getFunc_id() + ",");
//			
//		}
		//刪除
		dao.delete("EMP001","AUTH001");
//		EmpAuthVO empauthVO3 = dao.findByPrimaryKey("EMP002");
//		System.out.print(empauthVO3.getFunc_id() + ",");
	}
}
