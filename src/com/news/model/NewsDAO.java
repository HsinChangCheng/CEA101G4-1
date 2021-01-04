package com.news.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

public class NewsDAO implements NewsDAO_interface{
	
	private static DataSource ds = null;
	public NewsDAO(DataSource ds) {
		this.ds = ds;
	}
	
	private static final String INSERT_STMT = "INSERT INTO NEWS(NEWS_ID, NEWS_CONTENT, NEWS_DATE) VALUES(?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM NEWS ORDER BY NEWS_ID";
	private static final String SELECT_BY_PK = "SELECT * FROM NEWS WHERE NEWS_ID = ?";
	private static final String DELETE = "DELETE FROM NEWS WHERE NEWS_ID = ?";
	private static final String UPDATE = "UPDATE NEWS SET NEWS_CONTENT = ? WHERE NEWS_ID = ?";
	@Override
	public void insert(NewsVO newsVO) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String news_id = "";
		String[] pk = {"NEWS_ID"};
		try {
			pstmt = con.prepareStatement(INSERT_STMT,pk);

			pstmt.setString(1, newsVO.getNews_id());
			pstmt.setString(2, newsVO.getNews_content());
			pstmt.setTimestamp(3, newsVO.getNews_date());

		

			pstmt.executeUpdate();
			System.out.println("新增成功 insert method");
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				news_id = rs.getString(1);
			}

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
	public void delete(String news_id) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, news_id);
			
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
	public NewsVO findByPrimaryKey(String news_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(NewsVO newsVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NewsVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NewsVO> findBySearch(String newssearch) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
