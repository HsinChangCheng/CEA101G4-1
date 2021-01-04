package com.souvenir_order_detail.model;

import java.util.List;

public class SouvenirOrderDetailDAO implements SouvenirOrderDetailDAO_interface {
	
	private static final String INSERT_STMT = "INSERT INTO SOUVENIR_ORDER_DETAIL(SOU_ORDER_ID, SOU_ID, SOU_ORDER_AMOUNT, SOU_PRICE) VALUES(?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM SOUVENIR_ORDER_DETAIL ORDER BY SOU_ORDER_ID";
	private static final String SELECT_BY_PK = "SELECT * FROM SOUVENIR_ORDER_DETAIL WHERE SOU_ORDER_ID = ?";
	private static final String DELETE = "DELETE FROM SOUVENIR_ORDER_DETAIL WHERE SOU_ORDER_ID = ?";
	private static final String UPDATE = "UPDATE SOUVENIR_ORDER_DETAIL SET  SOU_ID = ?, SOU_ORDER_AMOUNT = ?,  SOU_PRICE = ? WHERE SOU_ORDER_ID = ?";
	@Override
	public void insert(SouvenirOrderDetailVO souvenir_order_detailVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String sou_order_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SouvenirOrderDetailVO findByPrimaryKey(String sou_order_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SouvenirOrderDetailVO souvenir_order_detailVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SouvenirOrderDetailVO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SouvenirOrderDetailVO> findBySearch(String souvenir_order_detailsearch) {
		// TODO Auto-generated method stub
		return null;
	}

}
