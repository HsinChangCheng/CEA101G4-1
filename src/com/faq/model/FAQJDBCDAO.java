package com.faq.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class FAQJDBCDAO implements FAQDAO_interface {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String userid = "CEA101G4";
	private static final String passwd = "CEA101G4";
	
	private static final String INSERT_STMT =
			"INSERT INTO FAQ(FAQ_ID, FAQ_QUESTION, FAQ_ANSWER)"
			+ " VALUES ('FAQ' || LPAD(FAQ_SEQ.NEXTVAL, 3, '0'),?,?)";
	private static final String UPDATE = 
			"UPDATE FAQ set FAQ_QUESTION=?,FAQ_ANSWER=? where FAQ_ID=?";
	private static final String DELETE = 
			"DELETE FROM FAQ where FAQ_ID = ?";
	private static final String GET_ONE_STMT =
			"SELECT FAQ_ID, FAQ_QUESTION, FAQ_ANSWER FROM FAQ where FAQ_ID = ?";
	private static final String GET_ALL_STMT =
			"SELECT FAQ_ID, FAQ_QUESTION, FAQ_ANSWER FROM FAQ order by FAQ_ID";

	@Override
	public void insert(FAQVO faqVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			
			pstmt.setString(1, faqVO.getFaq_question());
			pstmt.setString(2, faqVO.getFaq_answer());
			
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
	public void update(FAQVO faqVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, faqVO.getFaq_question());
			pstmt.setString(2, faqVO.getFaq_answer());
			pstmt.setString(3, faqVO.getFaq_id());
			
			

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
	public void delete(String faq_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1,faq_id);

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
	public FAQVO findByPrimaryKey(String faq_id) {

		FAQVO faqVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, faq_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
			
				faqVO = new FAQVO();
				faqVO.setFaq_id(rs.getString("faq_id"));
				faqVO.setFaq_question(rs.getString("faq_question"));
				faqVO.setFaq_answer(rs.getString("faq_answer"));
				
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
		return faqVO;
	}
	@Override
	public List<FAQVO> getAll() {
		List<FAQVO> list = new ArrayList<FAQVO>();
		FAQVO faqVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
			
				faqVO = new FAQVO();
				faqVO.setFaq_id(rs.getString("faq_id"));
				faqVO.setFaq_question(rs.getString("faq_question"));
				faqVO.setFaq_answer(rs.getString("faq_answer"));
				
				list.add(faqVO);
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

		FAQJDBCDAO dao = new FAQJDBCDAO();

//      新增
//		FAQVO faqVO1 = new FAQVO();
//		faqVO1.setFaq_question("可以提前入住嗎");
//		faqVO1.setFaq_answer("可以!");
//		
//		dao.insert(faqVO1);
	
//      修改
//		FAQVO faqVO2 = new FAQVO();
//		faqVO2.setFaq_id("FAQ002");
//		faqVO2.setFaq_question("可以打小何嗎");
//		faqVO2.setFaq_answer("當然可以!");
//
//		dao.update(faqVO2);
		
//      刪除
//		dao.delete("FAQ001");
		
		// 查詢
//		FAQVO faqVO3 = dao.findByPrimaryKey("FAQ002");
//		System.out.print(faqVO3.getFaq_id() + ",");
//		System.out.print(faqVO3.getFaq_question() + ",");
//		System.out.print(faqVO3.getFaq_answer());
//		System.out.println("");
//		System.out.println("---------------------");
		
		// 查詢
//		List<FAQVO> list = dao.getAll();
//		for (FAQVO aEmp : list) {
//		System.out.print(aEmp.getFaq_id() + ",");
//		System.out.print(aEmp.getFaq_question() + ",");
//		System.out.print(aEmp.getFaq_answer() );
//		System.out.println();
//		}
	}


}
