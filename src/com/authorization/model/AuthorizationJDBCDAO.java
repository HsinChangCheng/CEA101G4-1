package com.authorization.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AuthorizationJDBCDAO implements AuthorizationDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "CEA101G4";
	String passwd = "CEA101G4";
	private static final String INSERT_STMT =  "INSERT INTO AUTHORIZATION(FUNC_ID, FUNC_NAME) VALUES('AUTH' || LPAD(AUTH_SEQ.NEXTVAL, 3, '0'), ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM AUTHORIZATION ORDER BY FUNC_ID";
	private static final String GET_ONE_STMT = "SELECT * FROM AUTHORIZATION WHERE FUNC_ID = ?";
	private static final String DELETE = "DELETE FROM AUTHORIZATION WHERE FUNC_ID = ?";
	private static final String UPDATE = "UPDATE AUTHORIZATION SET FUNC_NAME = ? WHERE FUNC_ID = ?";
	@Override
	public void insert(AuthorizationVO authorizationVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, authorizationVO.getFunc_name());

		

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
	public void update(AuthorizationVO authorizationVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, authorizationVO.getFunc_name());
			pstmt.setString(2, authorizationVO.getFunc_id());
			
			pstmt.executeUpdate();
			System.out.println("更新成功 update method");

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
	public void delete(String func_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, func_id);
			
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
	public AuthorizationVO findByPrimaryKey(String func_id) {
		// TODO Auto-generated method stub
		AuthorizationVO authorizationVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, func_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				authorizationVO = new AuthorizationVO();
				authorizationVO.setFunc_id(rs.getString("func_id"));
				authorizationVO.setFunc_name(rs.getString("func_name"));
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
		return authorizationVO;
	}
	@Override
	public List<AuthorizationVO> getAll() {
		// TODO Auto-generated method stub
		List<AuthorizationVO> list = new ArrayList<AuthorizationVO>();
		AuthorizationVO authorizationVO = null;

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
				authorizationVO = new AuthorizationVO();
				authorizationVO.setFunc_id(rs.getString("func_id"));
				authorizationVO.setFunc_name(rs.getString("func_name"));
				list.add(authorizationVO); // Store the row in the list
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
		AuthorizationJDBCDAO dao = new AuthorizationJDBCDAO();
		//新增
//		AuthorizationVO authorizationVO1 = new AuthorizationVO();
//		authorizationVO1.setFunc_name("刪除權限");
//		dao.insert(authorizationVO1);
		//查詢
//		List<AuthorizationVO> list = dao.getAll();
//		for(AuthorizationVO aAuthorization : list) {
//			System.out.print(aAuthorization.getFunc_id() + ",");
//			System.out.println(aAuthorization.getFunc_name());
//			
//		}
		//刪除
//		dao.delete("AUTH006");
		//改
//		AuthorizationVO authorizationVO2 = new AuthorizationVO();
//		authorizationVO2.setFunc_id("AUTH006");
//		authorizationVO2.setFunc_name("刪除權限2");
//		dao.update(authorizationVO2);
	}
}
