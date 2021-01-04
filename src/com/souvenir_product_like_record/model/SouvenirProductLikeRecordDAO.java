package com.souvenir_product_like_record.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class SouvenirProductLikeRecordDAO implements SouvenirProductLikeRecordDAO_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CEA101G4DB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}



	private static final String INSERT_STMT = "INSERT INTO SOUVENIR_PRODUCT_LIKE_RECORD(SOU_ID, MEM_ID)" + " VALUES (?,?)";
	private static final String DELETE = "DELETE FROM SOUVENIR_PRODUCT_LIKE_RECORD where MEM_ID = ?";
	private static final String GET_ONE_STMT = "SELECT SOU_ID, MEM_ID FROM SOUVENIR_PRODUCT_LIKE_RECORD where SOU_ID = ?";
	private static final String GET_ALL_STMT = "SELECT SOU_ID, MEM_ID FROM SOUVENIR_PRODUCT_LIKE_RECORD order by SOU_ID";

	@Override
	public void insert(SouvenirProductLikeRecordVO souprVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setString(1, souprVO.getMem_id());

			pstmt.executeUpdate();

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
	public void delete(String sou_id, String mem_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, sou_id);
			pstmt.setString(2, mem_id);

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
	public SouvenirProductLikeRecordVO findByPrimaryKey(String sou_id) {

		SouvenirProductLikeRecordVO souprVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, sou_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				souprVO = new SouvenirProductLikeRecordVO();
				souprVO.setSou_id(rs.getString("sou_id"));
				souprVO.setMem_id(rs.getString("mem_id"));
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

		return souprVO;
	}

	@Override
	public List<SouvenirProductLikeRecordVO> getAll() {
		List<SouvenirProductLikeRecordVO> list = new ArrayList<SouvenirProductLikeRecordVO>();
		SouvenirProductLikeRecordVO souprVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				souprVO = new SouvenirProductLikeRecordVO();
				souprVO.setSou_id(rs.getString("sou_id"));
				souprVO.setMem_id(rs.getString("mem_id"));
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
