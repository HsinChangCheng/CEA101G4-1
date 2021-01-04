package com.memberrecord.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.*;

public class MemRecordDAO implements MemRecordDAO_interface{
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/JEFF");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
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
		
		public void insert(MemRecordVO memRecordVO) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);
				pstmt.setString(1, memRecordVO.getMemId());
				pstmt.setString(2, memRecordVO.getMemRecordContent());
				pstmt.setInt(3, memRecordVO.getMemRecordRead());
				
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
		public void update(MemRecordVO memRecordVO) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setString(1, memRecordVO.getMemId());
				pstmt.setString(2, memRecordVO.getMemRecordContent());
				pstmt.setInt(3, memRecordVO.getMemRecordRead());
				pstmt.setString(4, memRecordVO.getMemRecordId());
				
				pstmt.executeUpdate();
				
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
				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);
				pstmt.setString(1, memRecordId);
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
		public MemRecordVO findByPrimaryKey(String memRecordId) {
			MemRecordVO memRecordVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = ds.getConnection();
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
				con = ds.getConnection();
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
		
}
