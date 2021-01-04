package com.emp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmpDAO implements EmpDAO_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CEA101G4DB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO EMP(EMP_ID, EMP_ACCOUNT, EMP_PWD, EMP_NAME, EMP_ACC_STATUS, EMP_GENDER) VALUES('EMP' || LPAD(EMP_SEQ.NEXTVAL, 3, '0'), ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT EMP_ID, EMP_ACCOUNT, EMP_PWD, EMP_NAME, EMP_ACC_STATUS, EMP_GENDER FROM EMP";
	private static final String GET_ONE_STMT = "SELECT EMP_ID, EMP_ACCOUNT, EMP_PWD, EMP_NAME, EMP_ACC_STATUS, EMP_GENDER FROM EMP WHERE EMP_ID = ?";
	private static final String DELETE = "DELETE FROM EMP WHERE EMP_ID = ?";
	private static final String UPDATE = "UPDATE EMP SET EMP_ACCOUNT = ?, EMP_PWD = ?, EMP_NAME = ?, EMP_ACC_STATUS = ?, EMP_GENDER = ? WHERE EMP_ID = ?";

	@Override
	public void insert(EmpVO empVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, empVO.getEmp_account());
			pstmt.setString(2, empVO.getEmp_pwd());
			pstmt.setString(3, empVO.getEmp_name());
			pstmt.setInt(4, empVO.getEmp_acc_status());
			pstmt.setInt(5, empVO.getEmp_gender());
			pstmt.executeUpdate();

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
	public void update(EmpVO empVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, empVO.getEmp_account());
			pstmt.setString(2, empVO.getEmp_pwd());
			pstmt.setString(3, empVO.getEmp_name());
			pstmt.setInt(4, empVO.getEmp_acc_status());
			pstmt.setInt(5, empVO.getEmp_gender());
			pstmt.setString(6, empVO.getEmp_id());


			pstmt.executeUpdate();

			// Handle any driver errors
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
	public void delete(String emp_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, emp_id);


			pstmt.executeUpdate();

			// Handle any driver errors
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
	public EmpVO findByPrimaryKey(String emp_id) {

		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, emp_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				empVO = new EmpVO();
				empVO.setEmp_id(rs.getString("emp_id"));
				empVO.setEmp_account(rs.getString("emp_account"));
				empVO.setEmp_pwd(rs.getString("emp_pwd"));
				empVO.setEmp_name(rs.getString("emp_name"));
				empVO.setEmp_acc_status(rs.getInt("emp_acc_status"));
				empVO.setEmp_gender(rs.getInt("emp_gender"));
			}

			// Handle any driver errors
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
		return empVO;
	}

	@Override
	public List<EmpVO> getAll() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO empVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				empVO = new EmpVO();
				empVO.setEmp_id(rs.getString("emp_id"));
				empVO.setEmp_account(rs.getString("emp_account"));
				empVO.setEmp_pwd(rs.getString("emp_pwd"));
				empVO.setEmp_name(rs.getString("emp_name"));
				empVO.setEmp_acc_status(rs.getInt("emp_acc_status"));
				empVO.setEmp_gender(rs.getInt("emp_gender"));
				list.add(empVO); // Store the row in the list
			}

			// Handle any driver errors
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
//	public static void main(String[] args) {
//		EmpDAO dao = new EmpDAO();
//		//新增
//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEmp_id("EMP005");
//		empVO1.setEmp_account("EMP005");
//		empVO1.setEmp_pwd("136593");
//		empVO1.setEmp_name("繼元");
//		empVO1.setEmp_acc_status(1);
//		empVO1.setEmp_gender(0);	
//		dao.insert(empVO1);
		//查詢
//		List<EmpVO> list = dao.getAll();
//		for(EmpVO aEmp : list) {
//			System.out.print(aEmp.getEmp_id() + ",");
//			System.out.print(aEmp.getEmp_account() + ",");
//			System.out.print(aEmp.getEmp_pwd() + ",");
//			System.out.print(aEmp.getEmp_name() + ",");
//			System.out.print(aEmp.getEmp_acc_status() + ",");
//			System.out.println(aEmp.getEmp_gender());
//		}
		//刪除
//		dao.delete("EMP004");
//		EmpVO emp_authVO3 = dao.findByPrimaryKey("EMP002");
//		System.out.print(emp_authVO3.getEmp_id() + ",");
//	}
}
