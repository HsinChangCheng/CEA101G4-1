package com.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO implements MemberDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "CEA101G04";
	String passwd = "CEA101G04";

	private static final String INSERT_STMT = "INSERT INTO MEMBER1(MEM_ID,MEM_JOINTIME, MEM_ACCOUNT, MEM_PWD, MEM_NAME, MEM_BIRTH, MEM_TEL, MEM_ADDRESS, MEM_MAIL, MEM_ID_NUMBER,MEM_ACC_STATUS, MEM_GENDER)"
			+ "VALUES ('MEM' || LPAD(MEM_SEQ.NEXTVAL, 3, '0'),current_TimeStamp, ?, ?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT MEM_ID,MEM_ACCOUNT,MEM_PWD,MEM_NAME, MEM_BIRTH,"
			+ " MEM_TEL, MEM_ADDRESS, MEM_MAIL, MEM_ID_NUMBER,MEM_ACC_STATUS, MEM_GENDER,MEM_JOINTIME FROM MEMBER1";
	private static final String GET_ONE_STMT = "SELECT ACT_TYPE_NAME FROM ACTIVITY_TYPE where ACT_TYPE_ID = ?";
//	private static final String GET_Emps_ByDeptno_STMT = "SELECT empno,ename,job,to_char(hiredate,'yyyy-mm-dd') hiredate,sal,comm,deptno FROM emp2 where deptno = ? order by empno";
//	
//	private static final String DELETE_ACTIVITY_TYPE = "DELETE FROM ACTIVITY_TYPE where deptno = ?";
//	private static final String DELETE_DEPT = "DELETE FROM dept2 where deptno = ?";	

	private static final String UPDATE = "UPDATE MEMBER1 set MEM_PWD=?, MEM_NAME=?, MEM_BIRTH=?"
			+ ", MEM_TEL=?, MEM_ADDRESS=?, MEM_MAIL=?, MEM_ACC_STATUS=?,"
			+ " MEM_GENDER=? where MEM_ID = ?";

	@Override
	public void insert(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memberVO.getMem_account());
			pstmt.setString(2, memberVO.getMem_pwd());
			pstmt.setString(3, memberVO.getMem_name());
			pstmt.setDate(4, memberVO.getMem_birth());
			pstmt.setString(5, memberVO.getMem_tel());
			pstmt.setString(6, memberVO.getMem_address());
			pstmt.setString(7, memberVO.getMem_mail());
			pstmt.setString(8, memberVO.getMem_id_number());
			pstmt.setInt(9, memberVO.getMem_acc_status());
			pstmt.setInt(10, memberVO.getMem_gender());
			
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
	public void update(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, memberVO.getMem_pwd());
			pstmt.setString(2, memberVO.getMem_name());
			pstmt.setDate(3, memberVO.getMem_birth());
			pstmt.setString(4, memberVO.getMem_tel());
			pstmt.setString(5, memberVO.getMem_address());
			pstmt.setString(6, memberVO.getMem_mail());
			pstmt.setInt(7, memberVO.getMem_acc_status());
			pstmt.setInt(8,memberVO.getMem_gender());
			pstmt.setString(9,memberVO.getMem_id());
			
			
			

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public MemberVO findByPrimaryKey(String mem_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
	

			while (rs.next()) {
				memVO = new MemberVO();
				memVO.setMem_id(rs.getString("MEM_ID"));
				memVO.setMem_account(rs.getString("MEM_ACCOUNT"));
				memVO.setMem_pwd(rs.getString("MEM_PWD"));				
				memVO.setMem_name(rs.getString("MEM_NAME"));
				memVO.setMem_birth(rs.getDate("MEM_BIRTH"));
				memVO.setMem_tel(rs.getString("MEM_TEL"));
				memVO.setMem_address(rs.getString("MEM_ADDRESS"));
				memVO.setMem_mail(rs.getString("MEM_MAIL"));
				memVO.setMem_id_number(rs.getString("MEM_ID_NUMBER"));
				memVO.setMem_acc_status(rs.getInt("MEM_ACC_STATUS"));
				memVO.setMem_gender(rs.getInt("MEM_GENDER"));
				memVO.setMem_jointime(rs.getTimestamp("MEM_JOINTIME"));
				
				list.add(memVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	MemberJDBCDAO dao=new MemberJDBCDAO();
	// �s�W ====================================
//	MemberVO memVO = new MemberVO();
//	memVO.setMem_account("TestMemInsert");
//	memVO.setMem_pwd("TestMemInsert");
//	memVO.setMem_name("�|���s�W����");
//	memVO.setMem_birth(java.sql.Date.valueOf("1994-05-08"));
//	memVO.setMem_tel("0955721682");
//	memVO.setMem_address("08�ذ���p�}");
//	memVO.setMem_mail("hoyun5678@gmail.com");
//	memVO.setMem_id_number("A123456789");
//	memVO.setMem_acc_status(1);
//	memVO.setMem_gender(0);
//	
//	dao.insert(memVO);
	//�ק�=====================================
//	
//	MemberVO memVO2=new MemberVO();
//	memVO2.setMem_pwd("updateTest1");
//	memVO2.setMem_name("��אּ�}�ǳ�");
//	memVO2.setMem_birth(java.sql.Date.valueOf("1987-09-05"));
//	memVO2.setMem_tel("07-414141414");
//	memVO2.setMem_address("�ڮa���e���ǳ�");
//	memVO2.setMem_mail("pornhub@gmail.com");
//	memVO2.setMem_acc_status(1);
//	memVO2.setMem_gender(1);
//	memVO2.setMem_id("MEM001");
//	dao.update(memVO2);
	
	//�d�� getall ====================================
	MemberVO memVO3=new MemberVO();
	List<MemberVO>list=dao.getAll();
	for(MemberVO aMem:list) {
		System.out.println(aMem.getMem_id());
		System.out.println(aMem.getMem_account());
		System.out.println(aMem.getMem_pwd());
		System.out.println(aMem.getMem_name());
		System.out.println(aMem.getMem_birth());
		System.out.println(aMem.getMem_tel());
		System.out.println(aMem.getMem_address());
		System.out.println(aMem.getMem_mail());
		System.out.println(aMem.getMem_id_number());
		System.out.println(aMem.getMem_acc_status());
		System.out.println(aMem.getMem_gender());
		System.out.println(aMem.getMem_jointime());
		System.out.println("================================");
		
	}
	
	
	
	
	

	}

	@Override
	public void delete(String mem_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberVO findbyaccount(String mem_account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upDateStatus(MemberVO memVO) {
		// TODO Auto-generated method stub
		
	}


	
}
