package com.authorization.model;

import java.util.List;

public class AuthorizationDAO implements AuthorizationDAO_interface{
	
	private static final String INSERT_STMT = "INSERT INTO AUTHORIZATION(FUNC_ID, FUNC_NAME) VALUES(?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM AUTHORIZATION ORDER BY FUNC_ID";
	private static final String SELECT_BY_PK = "SELECT * FROM AUTHORIZATION WHERE FUNC_ID = ?";
	private static final String DELETE = "DELETE FROM AUTHORIZATION WHERE FUNC_ID = ?";
	private static final String UPDATE = "UPDATE AUTHORIZATION SET FUNC_NAME = ? WHERE FUNC_ID = ?";
	@Override
	public void insert(AuthorizationVO authorizationVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String func_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AuthorizationVO findByPrimaryKey(String func_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(AuthorizationVO authorizationVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AuthorizationVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorizationVO> findBySearch(String authorizationsearch) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
