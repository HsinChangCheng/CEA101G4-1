package com.news.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.model.EmpVO;

import java.sql.Clob;
public class NewsJDBCDAO implements NewsDAO_interface{
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "CEA101G4";
	String passwd = "CEA101G4";
	
	private static final String INSERT_STMT = "INSERT INTO NEWS(NEWS_ID, NEWS_CONTENT, NEWS_DATE) VALUES('NEWS'|| LPAD(NEWS_SEQ.NEXTVAL, 3, '0'), ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM NEWS ORDER BY NEWS_ID";
	private static final String GET_ONE_STMT = "SELECT * FROM NEWS WHERE NEWS_ID = ?";
	private static final String DELETE = "DELETE FROM NEWS WHERE NEWS_ID = ?";
	private static final String UPDATE = "UPDATE NEWS SET NEWS_CONTENT = ?, NEWS_DATE = ? WHERE NEWS_ID = ?";
	
	
	@Override
	public void insert(NewsVO newsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, newsVO.getNews_content());
			pstmt.setTimestamp(2, newsVO.getNews_date());

		

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
	public void update(NewsVO newsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, newsVO.getNews_content());
			pstmt.setTimestamp(2, newsVO.getNews_date());
			pstmt.setString(3, newsVO.getNews_id());
			
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
	public void delete(String news_id) {
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
		NewsVO newsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, news_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				newsVO = new NewsVO();
				newsVO.setNews_id(rs.getString("news_id"));
				newsVO.setNews_content(rs.getString("news_content"));
				newsVO.setNews_date(rs.getTimestamp("news_date"));
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
		return newsVO;
	}
	
	@Override
	public List<NewsVO> getAll() {
		// TODO Auto-generated method stub
		List<NewsVO> list = new ArrayList<NewsVO>();
		NewsVO newsVO = null;

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
				newsVO = new NewsVO();
				newsVO.setNews_id(rs.getString("news_id"));
				newsVO.setNews_content(rs.getString("news_content"));
				newsVO.setNews_date(rs.getTimestamp("news_date"));
				list.add(newsVO); // Store the row in the list
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
		NewsJDBCDAO dao = new NewsJDBCDAO();
		//新增
		NewsVO newsVO1 = new NewsVO();
		newsVO1.setNews_content("123");
		newsVO1.setNews_date(java.sql.Timestamp.valueOf("2020-12-10 22:10:10"));
		dao.insert(newsVO1);
		//查詢
//		List<NewsVO> list = dao.getAll();
//		for(NewsVO aNews : list) {
//			System.out.print(aNews.getNews_id() + ",");
//			System.out.print(aNews.getNews_content() + ",");
//			System.out.println(aNews.getNews_date() + ",");
//		}
		//更新
		NewsVO newsVO2 = new NewsVO();
		newsVO2.setNews_id("NEWS004");
		newsVO2.setNews_content("1231111111111111111");
		newsVO2.setNews_date(java.sql.Timestamp.valueOf("2020-12-12 22:10:10"));
		dao.update(newsVO2);
		//刪除
//		dao.delete("NEWS006");
	}
}