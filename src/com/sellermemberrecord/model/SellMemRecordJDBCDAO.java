package com.sellermemberrecord.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellMemRecordJDBCDAO implements SellMemRecordDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "JEFF";
	String passwd = "123456";

	private static final String INSERT_STMT = 
			"INSERT INTO seller_member_record(sell_mem_record_id, sell_mem_id, sell_record_content, sell_record_read)"
			+ " VALUES ('SELR' || LPAD(SELREC_SEQ.NEXTVAL, 3, '0'), ?, ?, ?)";
	private static final String DELETE = "DELETE FROM seller_member_record where sell_mem_record_id =?";
	private static final String UPDATE = 
			"UPDATE seller_member_record set sell_mem_id=?, sell_record_content=?, sell_record_read=?"
			+ " where sell_mem_record_id = ?";
	private static final String GET_ONE_STMT = 
			"SELECT sell_mem_id, sell_record_content, sell_record_time, sell_record_read "
			+ "FROM seller_member_record where sell_mem_record_id = ?";
	private static final String GET_ALL_STMT = 
			"SELECT sell_mem_record_id, sell_mem_id, sell_record_content, sell_record_time, sell_record_read "
			+ "FROM seller_member_record order by sell_mem_record_id";

	@Override
	public void insert(SellMemRecordVO sellMemRecordVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, sellMemRecordVO.getSellMemId());
			pstmt.setString(2, sellMemRecordVO.getSellMemRecordContent());
			pstmt.setInt(3, sellMemRecordVO.getSellMemRecordRead());

			pstmt.executeUpdate();

			// Handle any SQL errors
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public void update(SellMemRecordVO sellMemRecordVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, sellMemRecordVO.getSellMemId());
			pstmt.setString(2, sellMemRecordVO.getSellMemRecordContent());
			pstmt.setInt(3, sellMemRecordVO.getSellMemRecordRead());
			pstmt.setString(4, sellMemRecordVO.getSellMemRecordId());

			pstmt.executeUpdate();

			// Handle any SQL errors
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public void delete(String sellMemRecordId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			pstmt.setString(1, sellMemRecordId);
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
	public SellMemRecordVO findByPrimaryKey(String sellMemRecordId) {
		SellMemRecordVO sellMemRecordVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, sellMemRecordId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				sellMemRecordVO = new SellMemRecordVO();
				sellMemRecordVO.setSellMemRecordId(sellMemRecordId);
				sellMemRecordVO.setSellMemId(rs.getString("sell_mem_id"));
				sellMemRecordVO.setSellMemRecordContent(rs.getString("sell_record_content"));
				sellMemRecordVO.setSellMemRecordTime(rs.getTimestamp("sell_record_time"));
				sellMemRecordVO.setSellMemRecordRead(rs.getInt("sell_record_read"));
			}
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
		return sellMemRecordVO;
	}

	@Override
	public List<SellMemRecordVO> getAll() {
		List<SellMemRecordVO> list = new ArrayList<SellMemRecordVO>();
		SellMemRecordVO sellMemRecordVO = null;

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
				sellMemRecordVO = new SellMemRecordVO();
				sellMemRecordVO.setSellMemRecordId(rs.getString("sell_mem_record_id"));
				sellMemRecordVO.setSellMemId(rs.getString("sell_mem_id"));
				sellMemRecordVO.setSellMemRecordContent(rs.getString("sell_record_content"));
				sellMemRecordVO.setSellMemRecordTime(rs.getTimestamp("sell_record_time"));
				sellMemRecordVO.setSellMemRecordRead(rs.getInt("sell_record_read"));
				list.add(sellMemRecordVO); // Store the row in the list
			}
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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

		SellMemRecordJDBCDAO dao = new SellMemRecordJDBCDAO();

//		 新增
//		SellMemRecordVO sellMemRecordVO1 = new SellMemRecordVO();
//		sellMemRecordVO1.setSellMemRecordId("");
//		sellMemRecordVO1.setSellMemRecordContent("謝謝你愛我");
//		sellMemRecordVO1.setSellMemId("SELL001");
//		sellMemRecordVO1.setSellMemRecordRead(1);
//		dao.insert(sellMemRecordVO1);

		// 修改
//		SellMemRecordVO sellMemRecordVO2 = new SellMemRecordVO();
//		sellMemRecordVO2.setSellMemRecordId("SELR001");
//		sellMemRecordVO2.setSellMemRecordContent("謝謝你愛我");
//		sellMemRecordVO2.setSellMemId("SELL003");
//		sellMemRecordVO2.setSellMemRecordRead(1);
//		dao.update(sellMemRecordVO2);

		// 刪除
//		dao.delete("SELR006");

		// 查詢
//		SellMemRecordVO sellMemRecordVO3 = dao.findByPrimaryKey("SELR005");
//		System.out.print("PKey:"+ sellMemRecordVO3.getSellMemRecordId() + "/");
//		System.out.print(sellMemRecordVO3.getSellMemId() + "/");
//		System.out.print(sellMemRecordVO3.getSellMemRecordContent() + "/");
//		System.out.print(sellMemRecordVO3.getSellMemRecordTime() + "/");
//		System.out.print(sellMemRecordVO3.getSellMemRecordRead() + "/");
//		System.out.println();
//		System.out.println("------------------------------------");

//		// 查詢
		List<SellMemRecordVO> list = dao.getAll();
		for (SellMemRecordVO aSMR : list) {
			System.out.print(aSMR.getSellMemRecordId() + "/");
			System.out.print(aSMR.getSellMemId() + "/");
			System.out.print(aSMR.getSellMemRecordContent() + "/");
			System.out.print(aSMR.getSellMemRecordTime() + "/");
			System.out.print(aSMR.getSellMemRecordRead() + "/");

			System.out.println();
			System.out.println("-------------------------------------");
		}
	}

}
