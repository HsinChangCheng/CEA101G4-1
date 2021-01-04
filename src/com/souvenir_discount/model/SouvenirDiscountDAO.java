package com.souvenir_discount.model;

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


public class SouvenirDiscountDAO implements SouvenirDiscountDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CEA101G4DB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}



	private static final String INSERT_STMT = "INSERT INTO SOUVENIR_DISCOUNT(SOU_DIS_ID, SOU_DIS_NAME, SOU_DIS_START, SOU_DIS_END,SOU_DIS_STATUS)"
			+ " VALUES ('SD' || LPAD(SDIS_SEQ.NEXTVAL, 3, '0'),?,?,?,?)";
	private static final String UPDATE = "UPDATE SOUVENIR_DISCOUNT set SOU_DIS_NAME=?, SOU_DIS_START=?, SOU_DIS_END=?, SOU_DIS_STATUS=? where SOU_ID=?";
	private static final String DELETE = "DELETE FROM SOUVENIR_DISCOUNT where SOU_ID = ?";
	private static final String GET_ONE_STMT = "SELECT SOU_DIS_ID, SOU_DIS_NAME, SOU_DIS_START, SOU_DIS_END,SOU_DIS_STATUS FROM SOUVENIR_DISCOUNT where SOU_DIS_ID = ?";
	private static final String GET_ALL_STMT = "SELECT SOU_DIS_ID, SOU_DIS_NAME, SOU_DIS_START, SOU_DIS_END,SOU_DIS_STATUS FROM SOUVENIR_DISCOUNT order by SOU_DIS_ID";

	@Override
	public void insert(SouvenirDiscountVO sodVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, sodVO.getSou_dis_name());
			pstmt.setTimestamp(2, sodVO.getSou_dis_start());
			pstmt.setTimestamp(3, sodVO.getSou_dis_end());
			pstmt.setDouble(4, sodVO.getSou_dis_status());
			
			

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
	public void update(SouvenirDiscountVO sodVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			SOU_DIS_ID, SOU_DIS_NAME, SOU_DIS_START, SOU_DIS_END,sou_dis_status

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			
			pstmt.setString(1, sodVO.getSou_dis_name());
			pstmt.setTimestamp(2, sodVO.getSou_dis_start());
			pstmt.setTimestamp(3, sodVO.getSou_dis_end());
			pstmt.setDouble(4, sodVO.getSou_dis_status());
			pstmt.setString(5, sodVO.getSou_dis_id());

			pstmt.executeUpdate();

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
	public void delete(String sou_dis_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, sou_dis_id);

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
	public SouvenirDiscountVO findByPrimaryKey(String sou_dis_id) {

		SouvenirDiscountVO sodVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, sou_dis_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				sodVO = new SouvenirDiscountVO();

				
				sodVO.setSou_dis_id(rs.getString("sou_dis_id"));
				sodVO.setSou_dis_name(rs.getString("sou_dis_name"));
				sodVO.setSou_dis_start(rs.getTimestamp("sou_dis_start"));
				sodVO.setSou_dis_end(rs.getTimestamp("sou_dis_end"));
				sodVO.setSou_dis_status(rs.getDouble("sou_dis_status"));
				
				
	
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

		return sodVO;
	}

	@Override
	public List<SouvenirDiscountVO> getAll() {
		List<SouvenirDiscountVO> list = new ArrayList<SouvenirDiscountVO>();
		SouvenirDiscountVO sodVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				sodVO = new SouvenirDiscountVO();
				
				sodVO.setSou_dis_id(rs.getString("sou_dis_id"));
				sodVO.setSou_dis_name(rs.getString("sou_dis_name"));
				sodVO.setSou_dis_start(rs.getTimestamp("sou_dis_start"));
				sodVO.setSou_dis_end(rs.getTimestamp("sou_dis_end"));
				sodVO.setSou_dis_status(rs.getDouble("sou_dis_status"));
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
