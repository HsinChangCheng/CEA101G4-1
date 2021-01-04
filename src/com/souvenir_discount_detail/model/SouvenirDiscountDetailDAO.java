package com.souvenir_discount_detail.model;

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

public class SouvenirDiscountDetailDAO implements SouvenirDiscountDetailDAO_interface{
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CEA101G4DB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	
//	private String sou_id; 
//	private String sou_dis_id; 
//	private Integer sou_price;
	private static final String INSERT_STMT =
			"INSERT INTO SOUVENIR_DISCOUNT_DETAIL(SOU_ID, SOU_DIS_ID, SOU_DIS_PRICE) VALUES (?, ?, ?)";
	private static final String UPDATE = 
			"UPDATE SOUVENIR_DISCOUNT_DETAIL SET SOU_DIS_PRICE=? where SOU_ID=? AND SOU_DIS_ID=?";
	private static final String GET_ONE_STMT = 
			"SELECT SOU_ID, SOU_DIS_ID FROM SOUVENIR_DISCOUNT_DETAIL WHERE SOU_ID=? AND SOU_DIS_ID=?";
	private static final String GET_ALL_STMT = 
			"SELECT SOU_ID, SOU_DIS_ID FROM SOUVENIR_DISCOUNT_DETAIL ORDER BY SOU_ID, SOU_DIS_ID";
	

	@Override
	public void insert(SouvenirDiscountDetailVO soddVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, soddVO.getSou_id());
			pstmt.setString(2, soddVO.getSou_dis_id());
			pstmt.setInt(3, soddVO.getSou_dis_price());


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
	public void update(SouvenirDiscountDetailVO soddVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, soddVO.getSou_dis_price());
			pstmt.setString(2, soddVO.getSou_id());
			pstmt.setString(3, soddVO.getSou_dis_id());

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
	public SouvenirDiscountDetailVO findByPrimaryKey(String sou_id, String sou_dis_id) {

		SouvenirDiscountDetailVO soddVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, sou_id);
			   pstmt.setString(2, sou_dis_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				soddVO = new SouvenirDiscountDetailVO();

				soddVO.setSou_id(rs.getString("sou_id"));
				soddVO.setSou_dis_id(rs.getString("sou_dis_id"));
				soddVO.setSou_dis_price(rs.getInt("sou_dis_price"));
	
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

		return soddVO;
	}

	@Override
	public List<SouvenirDiscountDetailVO> getAll() {
		List<SouvenirDiscountDetailVO> list = new ArrayList<SouvenirDiscountDetailVO>();
		SouvenirDiscountDetailVO soddVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				soddVO = new SouvenirDiscountDetailVO();

				soddVO.setSou_id(rs.getString("sou_id"));
				soddVO.setSou_dis_id(rs.getString("sou_type_id"));
				soddVO.setSou_dis_price(rs.getInt("sou_dis_price"));
				
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
