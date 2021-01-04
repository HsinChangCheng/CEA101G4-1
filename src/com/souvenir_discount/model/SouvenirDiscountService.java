package com.souvenir_discount.model;

import java.sql.Timestamp;
import java.util.List;

public class SouvenirDiscountService {
	private SouvenirDiscountDAO_interface dao;

	public SouvenirDiscountService() {
		dao = new SouvenirDiscountJDBCDAO();
	}

	public SouvenirDiscountVO addSouDis(String sou_dis_name, Timestamp sou_dis_start,Timestamp sou_dis_end,Double sou_dis_status) {
		SouvenirDiscountVO sodVO = new SouvenirDiscountVO();
		sodVO.setSou_dis_name(sou_dis_name);
		sodVO.setSou_dis_start(sou_dis_start);
		sodVO.setSou_dis_end(sou_dis_end);
		sodVO.setSou_dis_status(sou_dis_status);
	

		dao.insert(sodVO);
		return sodVO;

	}

	public SouvenirDiscountVO updateSouDis(String sou_dis_id, String sou_dis_name, Timestamp sou_dis_start,Timestamp sou_dis_end,Double sou_dis_status) {
		SouvenirDiscountVO sodVO = new SouvenirDiscountVO();
		sodVO.setSou_dis_id(sou_dis_id);
		sodVO.setSou_dis_name(sou_dis_name);
		sodVO.setSou_dis_start(sou_dis_start);
		sodVO.setSou_dis_end(sou_dis_end);
		sodVO.setSou_dis_status(sou_dis_status);
		dao.update(sodVO);
		return sodVO;

	}

	public SouvenirDiscountVO getOneSouDis(String sou_dis_id) {
		return dao.findByPrimaryKey(sou_dis_id);
	}

	public void deleteSouDis(String sou_dis_id) {
		dao.delete(sou_dis_id);
	}

	public List<SouvenirDiscountVO> getAll() {
		return dao.getAll();
	}

}
