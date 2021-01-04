package com.memberrecord.model;

import java.sql.*;
import java.sql.*;
import java.util.*;



public class MemRecordJDBCDAO implements MemRecordDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "JEFF";
	String passwd = "123456";

	private static final String INSERT_STMT = 
			"INSERT INTO member_record(member_record_id, mem_id, mem_record_content, mem_record_read)"
			+ " VALUES ('MR' ||LPAD(MEMREC_SEQ.NEXTVAL, 4, '0'), ?, ?, ?)";
	private static final String DELETE = "DELETE FROM member_record where member_record_id =?";
	private static final String UPDATE = 
			"UPDATE member_record set mem_id=?, mem_record_content=?, mem_record_read=?"
			+ " where member_record_id = ?";
	private static final String GET_ONE_STMT = 
			"SELECT mem_id, mem_record_content, mem_record_time, mem_record_read "
			+ "FROM member_record where member_record_id = ?";
	private static final String GET_ALL_STMT = 
			"SELECT member_record_id, mem_id, mem_record_content, mem_record_time, mem_record_read "
					+ "FROM member_record order by member_record_id";
	@Override
	public void insert(MemRecordVO memRecordVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, memRecordVO.getMemId());
			pstmt.setString(2, memRecordVO.getMemRecordContent());
			pstmt.setInt(3, memRecordVO.getMemRecordRead());
			
			pstmt.executeUpdate();

			// Handle any SQL errors
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
	public void update(MemRecordVO memRecordVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memRecordVO.getMemId());
			pstmt.setString(2, memRecordVO.getMemRecordContent());
			pstmt.setInt(3, memRecordVO.getMemRecordRead());
			pstmt.setString(4, memRecordVO.getMemRecordId());
			
			pstmt.executeUpdate();
			
			// Handle any SQL errors
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any driver errors
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
	public void delete(String memRecordId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			pstmt.setString(1, memRecordId);
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
	public MemRecordVO findByPrimaryKey(String memRecordId) {
		MemRecordVO memRecordVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, memRecordId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				memRecordVO = new MemRecordVO();
				memRecordVO.setMemRecordId(memRecordId);
				memRecordVO.setMemId(rs.getString("mem_id"));
				memRecordVO.setMemRecordContent(rs.getString("mem_record_content"));
				memRecordVO.setMemRecordTime(rs.getTimestamp("mem_record_time"));
				memRecordVO.setMemRecordRead(rs.getInt("mem_record_read"));
			}
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any driver errors
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
		return memRecordVO;

	}

	@Override
	public List<MemRecordVO> getAll() {
		List<MemRecordVO> list = new ArrayList<MemRecordVO>();
		MemRecordVO memRecordVO = null;

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
				memRecordVO = new MemRecordVO();
				memRecordVO.setMemRecordId(rs.getString("member_record_id"));
				memRecordVO.setMemId(rs.getString("mem_id"));
				memRecordVO.setMemRecordContent(rs.getString("mem_record_content"));
				memRecordVO.setMemRecordTime(rs.getTimestamp("mem_record_time"));
				memRecordVO.setMemRecordRead(rs.getInt("mem_record_read"));
				list.add(memRecordVO); // Store the row in the list
			}
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());			
			// Handle any driver errors
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

		MemRecordJDBCDAO dao = new MemRecordJDBCDAO();
		
//		 新增
		MemRecordVO memRecordVO1 = new MemRecordVO();
//		memRecordVO1.setMemRecordId("");
		memRecordVO1.setMemRecordContent("謝謝你愛我");
		memRecordVO1.setMemId("MEM003");
		memRecordVO1.setMemRecordRead(1);
		dao.insert(memRecordVO1);
		
		// 修改
//		MemRecordVO memRecordVO2 = new MemRecordVO();
//		memRecordVO2.setMemRecordId("MR0001");
//		memRecordVO2.setMemRecordContent("謝謝你愛我");
//		memRecordVO2.setMemId("MEM003");
//		memRecordVO2.setMemRecordRead(1);
//
//		dao.update(memRecordVO2);

		
		// 刪除
//		dao.delete("REP004");

		// 查詢
//		MemRecordVO memRecordVO3 = dao.findByPrimaryKey("MR0007");
//		System.out.print("PKey:"+ memRecordVO3.getMemRecordId() + "/");
//		System.out.print(memRecordVO3.getMemId() + "/");
//		System.out.print(memRecordVO3.getMemRecordContent() + "/");
//		System.out.print(memRecordVO3.getMemRecordTime() + "/");
//		System.out.print(memRecordVO3.getMemRecordRead() + "/");
//		System.out.println();
//		System.out.println("------------------------------------");

//		// 查詢
//		List<MemRecordVO> list = dao.getAll();
//		for (MemRecordVO aMR : list) {
//			System.out.print(aMR.getMemRecordId() + "/");
//			System.out.print(aMR.getMemId() + "/");
//			System.out.print(aMR.getMemRecordContent() + "/");
//			System.out.print(aMR.getMemRecordTime() + "/");
//			System.out.print(aMR.getMemRecordRead() + "/");
//
//			System.out.println();
//			System.out.println("-------------------------------------");
//		}
	}
}

