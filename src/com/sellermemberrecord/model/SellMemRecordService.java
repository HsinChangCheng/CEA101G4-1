package com.sellermemberrecord.model;

import java.sql.*;
import java.util.*;

public class SellMemRecordService {
	private SellMemRecordDAO_interface dao;

	public SellMemRecordService() {
		dao = new SellMemRecordDAO();
	}

	public SellMemRecordVO addSellMemRecord(String sellMemId, String sellMemRecordContent, Integer sellMemRecordRead) {

		SellMemRecordVO sellMemRecordVO = new SellMemRecordVO();

		sellMemRecordVO.setSellMemId(sellMemId);
		sellMemRecordVO.setSellMemRecordContent(sellMemRecordContent);
		sellMemRecordVO.setSellMemRecordRead(sellMemRecordRead);
		dao.insert(sellMemRecordVO);

		return sellMemRecordVO;
	}

	public SellMemRecordVO updateSellMemRecord(String sellMemRecordId, String sellMemId, String sellMemRecordContent,
			Timestamp sellMemRecordTime, Integer sellMemRecordRead) {
//		 java.sql.Timestamp replyTime
		SellMemRecordVO sellMemRecordVO = new SellMemRecordVO();

		sellMemRecordVO.setSellMemRecordId(sellMemRecordId);
		sellMemRecordVO.setSellMemId(sellMemId);
		sellMemRecordVO.setSellMemRecordContent(sellMemRecordContent);
		sellMemRecordVO.setSellMemRecordTime(sellMemRecordTime);
		sellMemRecordVO.setSellMemRecordRead(sellMemRecordRead);

		dao.update(sellMemRecordVO);

		return sellMemRecordVO;
	}

	public void deleteSellMemRecord(String sellMemRecordId) {
		dao.delete(sellMemRecordId);
	}

	public SellMemRecordVO getOneSellMemRecord(String sellMemRecordId) {
		return dao.findByPrimaryKey(sellMemRecordId);
	}

	public List<SellMemRecordVO> getAll() {
		return dao.getAll();
	}
}
